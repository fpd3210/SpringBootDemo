package com.dpf.bean;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author dpf
 * @create 2020-04-11 20:46
 * @email 446933040@qq.com
 */
public class MyUser implements UserDetails {


     @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    /**
     * 密码
     * @return
     */
    @Override
    public String getPassword() {
        return null;
    }

    /**
     * 用户名
     * @return
     */
    @Override
    public String getUsername() {
        return null;
    }

    /**
     * 账户是否过期，过期无法验证 true没有
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 用户是否锁定，锁定的用户无法进行身份认证 true 没有
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 是否已过期的凭据(密码)，过期的凭据防止认证  true 没有
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 用户是否被禁用
     * @return
     */
    @Override
    public boolean isEnabled() {
        return false;
    }
}
