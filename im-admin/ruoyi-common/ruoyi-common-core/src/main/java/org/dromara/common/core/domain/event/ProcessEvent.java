package org.dromara.common.core.domain.event;

import java.io.Serial;
import java.io.Serializable;

/**
 * 总体流程监听
 *
 * @author may
 */

public class ProcessEvent implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 流程定义key
     */
    private String key;

    /**
     * 业务id
     */
    private String businessKey;

    /**
     * 状态
     */
    private String status;

    /**
     * 当为true时为申请人节点办理
     */
    private boolean submit;



    public ProcessEvent() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean getSubmit() {
        return submit;
    }

    public boolean isSubmit() {
        return submit;
    }

    public void setSubmit(boolean submit) {
        this.submit = submit;
    }
}
