package org.dromara.common.web.enums;

import cn.hutool.captcha.generator.CodeGenerator;
import cn.hutool.captcha.generator.RandomGenerator;
import org.dromara.common.web.utils.UnsignedMathGenerator;

/**
 * 验证码类型
 *
 * @author Lion Li
 */
public enum CaptchaType {

    /**
     * 数字
     */
    MATH(UnsignedMathGenerator.class),

    /**
     * 字符
     */
    CHAR(RandomGenerator.class);

    private final Class<? extends CodeGenerator> clazz;

    CaptchaType(Class<? extends CodeGenerator> clazz) {
        this.clazz = clazz;
    }

    public Class<? extends CodeGenerator> getClazz() {
        return this.clazz;
    }
}
