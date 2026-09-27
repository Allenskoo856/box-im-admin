package org.dromara.im.enums;

/**
 * @author: Blue
 * @date: 2024-09-06
 * @version: 1.0
 */
public enum ImSmPushStatus {

    /**
     * 待发送
     */
    WAIT_SEND(1),
    /**
     * 发送中
     */
    SENDING(2),
    /**
     * 已取消
     */
    SENDED(3),
    /**
     * 已取消
     */
    CANCEL(4);

    private final Integer value;

    ImSmPushStatus(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
