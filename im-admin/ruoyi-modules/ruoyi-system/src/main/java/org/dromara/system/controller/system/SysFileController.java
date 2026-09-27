package org.dromara.system.controller.system;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.dromara.common.core.domain.R;
import org.dromara.common.obs.service.FileService;
import org.dromara.common.obs.vo.UploadImageVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/system")
@Tag(name = "文件上传")
public class SysFileController {

    private static final Logger log = LoggerFactory.getLogger(SysFileController.class);

    private final FileService fileService;

    public SysFileController(FileService fileService) {
        this.fileService = fileService;
    }

    @Operation(summary = "上传图片", description = "上传图片,上传后返回原图和缩略图的url")
    @PostMapping("/image/upload")
    public R<UploadImageVO> uploadImage(@RequestParam("file") MultipartFile file, @RequestParam(defaultValue = "false") Boolean withThumb) {
        return R.ok(fileService.uploadImage(file, withThumb));
    }

    @Operation(summary = "上传文件", description = "上传文件，上传后返回文件url")
    @PostMapping("/file/upload")
    public R<String> uploadFile(@RequestParam("file") MultipartFile file) {
        return R.ok(fileService.uploadFile(file));
    }
}