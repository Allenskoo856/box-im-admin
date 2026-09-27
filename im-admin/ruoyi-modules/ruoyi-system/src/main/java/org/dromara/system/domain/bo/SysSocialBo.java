package org.dromara.system.domain.bo;

import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.tenant.core.TenantEntity;
import org.dromara.system.domain.SysSocial;

/**
 * 社会化关系业务对象 sys_social
 *
 * @author Lion Li
 */
@AutoMapper(target = SysSocial.class, reverseConvertGenerate = false)
public class SysSocialBo extends TenantEntity {

    /**
     * 主键
     */
    @NotNull(message = "主键不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 认证唯一ID
     */
    @NotBlank(message = "认证唯一ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private String authId;

    /**
     * 用户来源
     */
    @NotBlank(message = "用户来源不能为空", groups = { AddGroup.class, EditGroup.class })
    private String source;

    /**
     * 用户的授权令牌
     */
    @NotBlank(message = "用户的授权令牌不能为空", groups = { AddGroup.class, EditGroup.class })
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
     * 平台唯一id
     */
    private String openId;

    /**
     * 用户的 ID
     */
    @NotBlank(message = "用户的ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long userId;

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




    public SysSocialBo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SysSocialBo that = (SysSocialBo) o;
        return java.util.Objects.equals(id, that.id) &&
               java.util.Objects.equals(authId, that.authId) &&
               java.util.Objects.equals(source, that.source) &&
               java.util.Objects.equals(accessToken, that.accessToken) &&
               java.util.Objects.equals(expireIn, that.expireIn) &&
               java.util.Objects.equals(refreshToken, that.refreshToken) &&
               java.util.Objects.equals(openId, that.openId) &&
               java.util.Objects.equals(userId, that.userId) &&
               java.util.Objects.equals(accessCode, that.accessCode) &&
               java.util.Objects.equals(unionId, that.unionId) &&
               java.util.Objects.equals(scope, that.scope) &&
               java.util.Objects.equals(userName, that.userName) &&
               java.util.Objects.equals(nickName, that.nickName) &&
               java.util.Objects.equals(email, that.email) &&
               java.util.Objects.equals(avatar, that.avatar) &&
               java.util.Objects.equals(tokenType, that.tokenType) &&
               java.util.Objects.equals(idToken, that.idToken) &&
               java.util.Objects.equals(macAlgorithm, that.macAlgorithm) &&
               java.util.Objects.equals(macKey, that.macKey) &&
               java.util.Objects.equals(code, that.code) &&
               java.util.Objects.equals(oauthToken, that.oauthToken) &&
               java.util.Objects.equals(oauthTokenSecret, that.oauthTokenSecret);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), id, authId, source, accessToken, expireIn, refreshToken, openId, userId, accessCode, unionId, scope, userName, nickName, email, avatar, tokenType, idToken, macAlgorithm, macKey, code, oauthToken, oauthTokenSecret);
    }
}
