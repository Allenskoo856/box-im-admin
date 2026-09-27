package org.dromara.common.core.domain.event;

import java.io.Serial;
import java.io.Serializable;

/**
 * 流程办理监听
 *
 * @author may
 */

public class ProcessTaskEvent implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 流程定义key
     */
    private String key;

    /**
     * 审批节点key
     */
    private String taskDefinitionKey;

    /**
     * 任务id
     */
    private String taskId;

    /**
     * 业务id
     */
    private String businessKey;


    public ProcessTaskEvent() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTaskDefinitionKey() {
        return taskDefinitionKey;
    }

    public void setTaskDefinitionKey(String taskDefinitionKey) {
        this.taskDefinitionKey = taskDefinitionKey;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }
}
