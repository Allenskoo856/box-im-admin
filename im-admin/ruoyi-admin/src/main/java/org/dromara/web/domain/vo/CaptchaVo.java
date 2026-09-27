package org.dromara.web.domain.vo;

/**
 * 验证码信息
 *
 * @author Michelle.Chung
 */
public class CaptchaVo {

    /**
     * 是否开启验证码
     */
    private Boolean captchaEnabled = true;

    private String uuid;

    /**
     * 验证码图片
     */
    private String img;


    public CaptchaVo() {
    }

    public Boolean getCaptchaEnabled() {
        return captchaEnabled;
    }

    public Boolean isCaptchaEnabled() {
        return captchaEnabled;
    }

    public void setCaptchaEnabled(Boolean captchaEnabled) {
        this.captchaEnabled = captchaEnabled;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
