package com.shanlin.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="token")
public class Token implements Serializable {
    @Id
    @GeneratedValue
    private Long tokenId;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "app_id")
    private Long appId;
    @Column(name = "token")
    private String token;
   /* @Column(name = "address")
    private Long createTime;
    @Column(name = "address")
    private Long expireTime;
    @Column(name = "address")
    private Integer flag;
    */
    private static final long serialVersionUID = 1L;
    public Long getTokenId() {
        return tokenId;
    }
    public void setTokenId(Long tokenId) {
        this.tokenId = tokenId;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getAppId() {
        return appId;
    }
    public void setAppId(Long appId) {
        this.appId = appId;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }
   /* public Long getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
    public Long getExpireTime() {
        return expireTime;
    }
    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }
    public Integer getFlag() {
        return flag;
    }
    public void setFlag(Integer flag) {
        this.flag = flag;
    }*/

}