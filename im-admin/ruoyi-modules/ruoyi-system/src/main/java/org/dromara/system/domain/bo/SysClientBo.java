package org.dromara.system.domain.bo;

import org.dromara.system.domain.SysClient;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.*;

import java.util.List;

/**
 * 授权管理业务对象 sys_client
 *
 * @author Michelle.Chung
 * @date 2023-05-15
 */
@AutoMapper(target = SysClient.class, reverseConvertGenerate = false)
public class SysClientBo extends BaseEntity {

    /**
     * id
     */
    @NotNull(message = "id不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 客户端id
     */
    private String clientId;

    /**
     * 客户端key
     */
    @NotBlank(message = "客户端key不能为空", groups = { AddGroup.class, EditGroup.class })
    private String clientKey;

    /**
     * 客户端秘钥
     */
    @NotBlank(message = "客户端秘钥不能为空", groups = { AddGroup.class, EditGroup.class })
    private String clientSecret;

    /**
     * 授权类型
     */
    @NotNull(message = "授权类型不能为空", groups = { AddGroup.class, EditGroup.class })
    private List<String> grantTypeList;

    /**
     * 授权类型
     */
    private String grantType;

    /**
     * 设备类型
     */
    private String deviceType;

    /**
     * token活跃超时时间
     */
    private Long activeTimeout;

    /**
     * token固定超时时间
     */
    private Long timeout;

    /**
     * 状态（0正常 1停用）
     */
    private String status;



    public SysClientBo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientKey() {
        return clientKey;
    }

    public void setClientKey(String clientKey) {
        this.clientKey = clientKey;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public List<String> getGrantTypeList() {
        return grantTypeList;
    }

    public void setGrantTypeList(List<String> grantTypeList) {
        this.grantTypeList = grantTypeList;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public Long getActiveTimeout() {
        return activeTimeout;
    }

    public void setActiveTimeout(Long activeTimeout) {
        this.activeTimeout = activeTimeout;
    }

    public Long getTimeout() {
        return timeout;
    }

    public void setTimeout(Long timeout) {
        this.timeout = timeout;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SysClientBo that = (SysClientBo) o;
        return java.util.Objects.equals(id, that.id) &&
               java.util.Objects.equals(clientId, that.clientId) &&
               java.util.Objects.equals(clientKey, that.clientKey) &&
               java.util.Objects.equals(clientSecret, that.clientSecret) &&
               java.util.Objects.equals(grantTypeList, that.grantTypeList) &&
               java.util.Objects.equals(grantType, that.grantType) &&
               java.util.Objects.equals(deviceType, that.deviceType) &&
               java.util.Objects.equals(activeTimeout, that.activeTimeout) &&
               java.util.Objects.equals(timeout, that.timeout) &&
               java.util.Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), id, clientId, clientKey, clientSecret, grantTypeList, grantType, deviceType, activeTimeout, timeout, status);
    }
}
