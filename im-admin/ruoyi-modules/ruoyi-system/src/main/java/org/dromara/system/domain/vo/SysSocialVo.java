package org.dromara.system.domain.vo;

import io.github.linpeilie.annotations.AutoMapper;
import org.dromara.system.domain.SysSocial;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;


/**
 * 社会化关系视图对象 sys_social
 *
 * @author thiszhc
 */
@AutoMapper(target = SysSocial.class)
public class SysSocialVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 的唯一ID
     */
    private String authId;

    /**
     * 用户来源
     */
    private String source;

    /**
     * 用户的授权令牌
     */
    private String accessToken;

    /**
     * 用户的授权令牌的有效期，部分平台可能没有
     */
    private int expireIn;

    /**
     * 刷新令牌，部分平台可能没有
     */
    private String refreshToken;

    /**
     * 用户的 open id
     */
    private String openId;

    /**
     * 授权的第三方账号
     */
    private String userName;

    /**
     * 授权的第三方昵称
     */
    private String nickName;

    /**
     * 授权的第三方邮箱
     */
    private String email;

    /**
     * 授权的第三方头像地址
     */
    private String avatar;


    /**
     * 平台的授权信息，部分平台可能没有
     */
    private String accessCode;

    /**
     * 用户的 unionid
     */
    private String unionId;

    /**
     * 授予的权限，部分平台可能没有
     */
    private String scope;

    /**
     * 个别平台的授权信息，部分平台可能没有
     */
    private String tokenType;

    /**
     * id token，部分平台可能没有
     */
    private String idToken;

    /**
     * 小米平台用户的附带属性，部分平台可能没有
     */
    private String macAlgorithm;

    /**
     * 小米平台用户的附带属性，部分平台可能没有
     */
    private String macKey;

    /**
     * 用户的授权code，部分平台可能没有
     */
    private String code;

    /**
     * Twitter平台用户的附带属性，部分平台可能没有
     */
    private String oauthToken;

    /**
     * Twitter平台用户的附带属性，部分平台可能没有
     */
    private String oauthTokenSecret;

    /**
     * 创建时间
     */
    private Date createTime;

    public SysSocialVo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public String getMacAlgorithm() {
        return macAlgorithm;
    }

    public void setMacAlgorithm(String macAlgorithm) {
        this.macAlgorithm = macAlgorithm;
    }

    public String getMacKey() {
        return macKey;
    }

    public void setMacKey(String macKey) {
        this.macKey = macKey;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOauthToken() {
        return oauthToken;
    }

    public void setOauthToken(String oauthToken) {
        this.oauthToken = oauthToken;
    }

    public String getOauthTokenSecret() {
        return oauthTokenSecret;
    }

    public void setOauthTokenSecret(String oauthTokenSecret) {
        this.oauthTokenSecret = oauthTokenSecret;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
