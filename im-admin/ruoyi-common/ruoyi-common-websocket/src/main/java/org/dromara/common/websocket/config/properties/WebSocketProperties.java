package org.dromara.common.websocket.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * WebSocket 配置项
 *
 * @author zendwang
 */
@ConfigurationProperties("websocket")
public class WebSocketProperties {

    private Boolean enabled;

    /**
     * 路径
     */
    private String path;

    /**
     *  设置访问源地址
     */
    private String allowedOrigins;

    public WebSocketProperties() {
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public Boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAllowedOrigins() {
        return allowedOrigins;
    }

    public void setAllowedOrigins(String allowedOrigins) {
        this.allowedOrigins = allowedOrigins;
    }
}
