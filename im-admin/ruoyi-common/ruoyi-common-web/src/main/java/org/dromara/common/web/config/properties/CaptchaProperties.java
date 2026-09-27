package org.dromara.common.web.config.properties;

import org.dromara.common.web.enums.CaptchaCategory;
import org.dromara.common.web.enums.CaptchaType;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 验证码 配置属性
 *
 * @author Lion Li
 */
@ConfigurationProperties(prefix = "captcha")
public class CaptchaProperties {

    private Boolean enable;

    /**
     * 验证码类型
     */
    private CaptchaType type;

    /**
     * 验证码类别
     */
    private CaptchaCategory category;

    /**
     * 数字验证码位数
     */
    private Integer numberLength;

    /**
     * 字符验证码长度
     */
    private Integer charLength;

    public CaptchaProperties() {
    }

    public Boolean getEnable() {
        return enable;
    }

    public Boolean isEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public CaptchaType getType() {
        return type;
    }

    public void setType(CaptchaType type) {
        this.type = type;
    }

    public CaptchaCategory getCategory() {
        return category;
    }

    public void setCategory(CaptchaCategory category) {
        this.category = category;
    }

    public Integer getNumberLength() {
        return numberLength;
    }

    public void setNumberLength(Integer numberLength) {
        this.numberLength = numberLength;
    }

    public Integer getCharLength() {
        return charLength;
    }

    public void setCharLength(Integer charLength) {
        this.charLength = charLength;
    }
}
