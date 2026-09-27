package org.dromara.common.web.enums;

import cn.hutool.captcha.AbstractCaptcha;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.captcha.ShearCaptcha;

/**
 * 验证码类别
 *
 * @author Lion Li
 */
public enum CaptchaCategory {

    /**
     * 线段干扰
     */
    LINE(LineCaptcha.class),

    /**
     * 圆圈干扰
     */
    CIRCLE(CircleCaptcha.class),

    /**
     * 扭曲干扰
     */
    SHEAR(ShearCaptcha.class);

    private final Class<? extends AbstractCaptcha> clazz;

    CaptchaCategory(Class<? extends AbstractCaptcha> clazz) {
        this.clazz = clazz;
    }

    public Class<? extends AbstractCaptcha> getClazz() {
        return this.clazz;
    }
}
