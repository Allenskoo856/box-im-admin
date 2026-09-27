package org.dromara.common.obs.vo;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "图片上传VO")
public class UploadImageVO {

    @Schema(description = "原图")
    private String originUrl;

    @Schema(description = "缩略图")
    private String thumbUrl;

    public UploadImageVO() {
    }

    public UploadImageVO(String originUrl, String thumbUrl) {
        this.originUrl = originUrl;
        this.thumbUrl = thumbUrl;
    }

    public String getOriginUrl() {
        return originUrl;
    }

    public void setOriginUrl(String originUrl) {
        this.originUrl = originUrl;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }
}
