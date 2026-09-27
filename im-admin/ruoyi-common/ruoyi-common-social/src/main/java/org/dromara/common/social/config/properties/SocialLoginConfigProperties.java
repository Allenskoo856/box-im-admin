package org.dromara.common.social.config.properties;

import java.util.List;

/**
 * 社交登录配置
 *
 * @author thiszhc
 */
public class SocialLoginConfigProperties {

    /**
     * 应用 ID
     */
    private String clientId;

    /**
     * 应用密钥
     */
    private String clientSecret;

    /**
     * 回调地址
     */
    private String redirectUri;

    /**
     * 是否获取unionId
     */
    private boolean unionId;

    /**
     * Coding 企业名称
     */
    private String codingGroupName;

    /**
     * 支付宝公钥
     */
    private String alipayPublicKey;

    /**
     * 企业微信应用ID
     */
    private String agentId;

    /**
     * stackoverflow api key
     */
    private String stackOverflowKey;

    /**
     * 设备ID
     */
    private String deviceId;

    /**
     * 客户端系统类型
     */
    private String clientOsType;

    /**
     * maxkey 服务器地址
     */
    private String serverUrl;

    /**
     * 请求范围
     */
    private List<String> scopes;


    public SocialLoginConfigProperties() {
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public boolean getUnionId() {
        return unionId;
    }

    public boolean isUnionId() {
        return unionId;
    }

    public void setUnionId(boolean unionId) {
        this.unionId = unionId;
    }

    public String getCodingGroupName() {
        return codingGroupName;
    }

    public void setCodingGroupName(String codingGroupName) {
        this.codingGroupName = codingGroupName;
    }

    public String getAlipayPublicKey() {
        return alipayPublicKey;
    }

    public void setAlipayPublicKey(String alipayPublicKey) {
        this.alipayPublicKey = alipayPublicKey;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getStackOverflowKey() {
        return stackOverflowKey;
    }

    public void setStackOverflowKey(String stackOverflowKey) {
        this.stackOverflowKey = stackOverflowKey;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getClientOsType() {
        return clientOsType;
    }

    public void setClientOsType(String clientOsType) {
        this.clientOsType = clientOsType;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public List<String> getScopes() {
        return scopes;
    }

    public void setScopes(List<String> scopes) {
        this.scopes = scopes;
    }
}
