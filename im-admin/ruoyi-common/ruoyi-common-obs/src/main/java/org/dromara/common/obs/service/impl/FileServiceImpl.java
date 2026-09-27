package org.dromara.common.obs.service.impl;

import jakarta.annotation.PostConstruct;
import org.apache.commons.lang3.StringUtils;
import org.dromara.common.core.exception.ServiceException;
import org.dromara.common.obs.client.ObsService;
import org.dromara.common.obs.enums.FileType;
import org.dromara.common.obs.properties.ObsProperties;
import org.dromara.common.obs.service.FileService;
import org.dromara.common.obs.util.FileUtil;
import org.dromara.common.obs.util.ImageUtil;
import org.dromara.common.obs.vo.UploadImageVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 文件上传服务（华为云 OBS）
 *
 * @author Blue
 * @version 1.0
 */
@Service
public class FileServiceImpl implements FileService {

    private static final Logger log = LoggerFactory.getLogger(FileServiceImpl.class);

    private final ObsService obsService;
    private final ObsProperties obsProps;

    public FileServiceImpl(ObsService obsService, ObsProperties obsProps) {
        this.obsService = obsService;
        this.obsProps = obsProps;
    }

    @PostConstruct
    public void init() {
        if (StringUtils.isNotBlank(obsProps.getBucketName())) {
            try {
                if (!obsService.bucketExists(obsProps.getBucketName())) {
                    // 创建bucket
                    obsService.makeBucket(obsProps.getBucketName());
                    // 公开bucket
                    obsService.setBucketPublic(obsProps.getBucketName());
                }
            } catch (Exception e) {
                log.warn("OBS 初始化检测桶失败，请确认AK/SK及网络配置: {}", e.getMessage());
            }
        }
    }

    @Override
    public String uploadFile(MultipartFile file) {
        // 上传
        String fileName = obsService.upload(obsProps.getBucketName(), obsProps.getFilePath(), file);
        if (StringUtils.isEmpty(fileName)) {
            throw new ServiceException("文件上传失败");
        }
        String url = generUrl(FileType.FILE, fileName);
        log.info("文件上传成功,url:{}", url);
        return url;
    }

    @Override
    public UploadImageVO uploadImage(MultipartFile file, boolean withThumb) {
        try {
            // 上传原图
            UploadImageVO vo = new UploadImageVO();
            // 图片格式校验
            if (!FileUtil.isImage(file.getOriginalFilename())) {
                throw new ServiceException("图片格式不合法");
            }
            String fileName = obsService.upload(obsProps.getBucketName(), obsProps.getImagePath(), file);
            if (StringUtils.isEmpty(fileName)) {
                throw new ServiceException("图片上传失败");
            }
            vo.setOriginUrl(generUrl(FileType.IMAGE, fileName));
            // 大于30K的文件需上传缩略图
            if (file.getSize() > 30 * 1024 && withThumb) {
                byte[] imageByte = ImageUtil.compressForScale(file.getBytes(), 30);
                fileName = obsService.upload(obsProps.getBucketName(), obsProps.getImagePath(),
                    file.getOriginalFilename(), imageByte, file.getContentType());
                if (StringUtils.isEmpty(fileName)) {
                    throw new ServiceException("图片上传失败");
                }
            }
            vo.setThumbUrl(generUrl(FileType.IMAGE, fileName));
            log.info("上传图片成功，url:{}", vo.getOriginUrl());
            return vo;
        } catch (IOException e) {
            log.error("上传图片失败，{}", e.getMessage(), e);
            throw new ServiceException("图片上传失败");
        }
    }

    private String generUrl(FileType fileTypeEnum, String fileName) {
        String url = obsProps.getDomain() + "/" + obsProps.getBucketName();
        switch (fileTypeEnum) {
            case FILE:
                url += "/" + obsProps.getFilePath() + "/";
                break;
            case IMAGE:
                url += "/" + obsProps.getImagePath() + "/";
                break;
            case VIDEO:
                url += "/" + obsProps.getVideoPath() + "/";
                break;
            default:
                break;
        }
        url += fileName;
        return url;
    }
}
