package org.dromara.common.obs.enums;

public enum FileType {

    /**
     * 文件
     */
    FILE(0, "文件"),
    /**
     * 图片
     */
    IMAGE(1, "图片"),
    /**
     * 视频
     */
    VIDEO(2, "视频"),
    /**
     * 声音
     */
    AUDIO(3, "声音");

    private final Integer code;
    private final String desc;

    FileType(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer code() {
        return this.code;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }
}
