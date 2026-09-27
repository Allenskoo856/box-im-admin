package org.dromara.common.social.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Social 配置属性
 *
 * @author thiszhc
 */
@Component
@ConfigurationProperties(prefix = "justauth")
public class SocialProperties {

    /**
     * 授权类型
     */
    private Map<String, SocialLoginConfigProperties> type;


    public SocialProperties() {
    }

    public Map<String, SocialLoginConfigProperties> getType() {
        return type;
    }

    public void setType(Map<String, SocialLoginConfigProperties> type) {
        this.type = type;
    }
}
