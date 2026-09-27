package org.dromara.common.obs.service;

import org.dromara.common.obs.vo.UploadImageVO;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    String uploadFile(MultipartFile file);

    UploadImageVO uploadImage(MultipartFile file, boolean withThumb);

}
