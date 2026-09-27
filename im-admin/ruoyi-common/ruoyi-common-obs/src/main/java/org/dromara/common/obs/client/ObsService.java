package org.dromara.common.obs.client;

import cn.hutool.core.util.IdUtil;
import com.obs.services.ObsClient;
import com.obs.services.exception.ObsException;
import com.obs.services.model.AccessControlList;
import com.obs.services.model.ObjectMetadata;
import com.obs.services.model.PutObjectRequest;
import org.apache.commons.lang3.StringUtils;
import org.dromara.common.core.utils.DateUtils;
import org.dromara.common.obs.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * 华为云 OBS 存储服务
 *
 * @author Blue
 * @version 1.0
 */
@Component
public class ObsService {

    private static final Logger log = LoggerFactory.getLogger(ObsService.class);

    @Autowired(required = false)
    private ObsClient obsClient;

    public ObsService() {
    }

    public ObsService(ObsClient obsClient) {
        this.obsClient = obsClient;
    }

    /**
     * 查看存储bucket是否存在
     *
     * @param bucketName 桶名称
     * @return boolean
     */
    public Boolean bucketExists(String bucketName) {
        if (obsClient == null) {
            log.warn("ObsClient 未初始化，跳过 bucketExists 检测");
            return false;
        }
        try {
            return obsClient.headBucket(bucketName);
        } catch (ObsException e) {
            if (e.getResponseCode() == 404) {
                return false;
            }
            log.error("查询OBS bucket失败, status: {}, code: {}", e.getResponseCode(), e.getErrorCode(), e);
            return false;
        } catch (Exception e) {
            log.error("查询OBS bucket失败", e);
            return false;
        }
    }

    /**
     * 创建存储bucket
     *
     * @param bucketName 桶名称
     */
    public void makeBucket(String bucketName) {
        if (obsClient == null) {
            return;
        }
        try {
            obsClient.createBucket(bucketName);
        } catch (Exception e) {
            log.error("创建OBS bucket失败,", e);
        }
    }

    /**
     * 设置bucket权限为public-read
     *
     * @param bucketName 桶名称
     */
    public void setBucketPublic(String bucketName) {
        if (obsClient == null) {
            return;
        }
        try {
            obsClient.setBucketAcl(bucketName, AccessControlList.REST_CANNED_PUBLIC_READ);
        } catch (Exception e) {
            log.error("设置OBS bucket公开权限失败,", e);
        }
    }

    /**
     * 文件上传 (MultipartFile)
     *
     * @param bucketName bucket名称
     * @param path       路径
     * @param file       文件
     * @return objectName
     */
    public String upload(String bucketName, String path, MultipartFile file) {
        if (obsClient == null) {
            throw new RuntimeException("ObsClient 未初始化，无法上传文件");
        }
        String originalFilename = file.getOriginalFilename();
        if (StringUtils.isBlank(originalFilename)) {
            throw new RuntimeException("文件名不能为空");
        }
        String fileName = IdUtil.getSnowflakeNextIdStr() + "." + FileUtil.getFileExtension(originalFilename);
        String objectName = DateUtils.dateTimeNow(DateUtils.YYYYMMDD) + "/" + fileName;
        String objectKey = path + "/" + objectName;
        try (InputStream stream = file.getInputStream()) {
            PutObjectRequest request = new PutObjectRequest(bucketName, objectKey, stream);
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(file.getContentType());
            metadata.setContentLength(file.getSize());
            request.setMetadata(metadata);
            obsClient.putObject(request);
        } catch (Exception e) {
            log.error("上传文件到OBS失败,", e);
            return null;
        }
        return objectName;
    }

    /**
     * 文件上传 (byte[])
     *
     * @param bucketName  bucket名称
     * @param path        路径
     * @param name        文件名
     * @param fileByte    文件内容
     * @param contentType contentType
     * @return objectName
     */
    public String upload(String bucketName, String path, String name, byte[] fileByte, String contentType) {
        if (obsClient == null) {
            throw new RuntimeException("ObsClient 未初始化，无法上传文件");
        }
        String fileName = IdUtil.getSnowflakeNextIdStr() + "." + FileUtil.getFileExtension(name);
        String objectName = DateUtils.dateTimeNow(DateUtils.YYYYMMDD) + "/" + fileName;
        String objectKey = path + "/" + objectName;
        try (InputStream stream = new ByteArrayInputStream(fileByte)) {
            PutObjectRequest request = new PutObjectRequest(bucketName, objectKey, stream);
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(contentType);
            metadata.setContentLength((long) fileByte.length);
            request.setMetadata(metadata);
            obsClient.putObject(request);
        } catch (Exception e) {
            log.error("上传文件到OBS失败,", e);
            return null;
        }
        return objectName;
    }

    /**
     * 删除文件
     *
     * @param bucketName bucket名称
     * @param path       路径
     * @param fileName   文件名
     * @return true/false
     */
    public boolean remove(String bucketName, String path, String fileName) {
        if (obsClient == null) {
            return false;
        }
        try {
            obsClient.deleteObject(bucketName, path + "/" + fileName);
            return true;
        } catch (Exception e) {
            log.error("删除OBS文件失败,", e);
            return false;
        }
    }

    /**
     * 判断文件是否存在
     *
     * @param bucketName bucket名称
     * @param path       路径
     * @param fileName   文件名
     * @return boolean
     */
    public Boolean isExist(String bucketName, String path, String fileName) {
        if (obsClient == null) {
            return false;
        }
        try {
            return obsClient.doesObjectExist(bucketName, path + "/" + fileName);
        } catch (Exception e) {
            log.error("检查OBS文件是否存在失败,", e);
            return false;
        }
    }
}
