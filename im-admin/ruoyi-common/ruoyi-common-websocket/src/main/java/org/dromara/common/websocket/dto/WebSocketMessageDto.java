package org.dromara.common.websocket.dto;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * 消息的dto
 *
 * @author zendwang
 */
public class WebSocketMessageDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 需要推送到的session key 列表
     */
    private List<Long> sessionKeys;

    /**
     * 需要发送的消息
     */
    private String message;

    public WebSocketMessageDto() {
    }

    public List<Long> getSessionKeys() {
        return sessionKeys;
    }

    public void setSessionKeys(List<Long> sessionKeys) {
        this.sessionKeys = sessionKeys;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
