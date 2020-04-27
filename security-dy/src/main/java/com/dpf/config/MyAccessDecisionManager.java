package com.dpf.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;


@Component
public class MyAccessDecisionManager implements AccessDecisionManager {

    /**
     *  判定是否拥有权限的决策方法
     * @param authentication    当前登录用户的信息
     * @param o                 包含客户端发起的请求的requset信息,可转换为 HttpServletRequest request = ((FilterInvocation) o).getHttpRequest();
     * @param collection        过滤器传过来的许可角色
     * @throws AccessDeniedException
     * @throws InsufficientAuthenticationException
     */
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        for (ConfigAttribute attribute : collection) {
            if ("ROLE_login".equals(attribute.getAttribute())) {

                //如果是游客
                if (authentication instanceof AnonymousAuthenticationToken) {
                    throw new AccessDeniedException("非法请求!");
                } else {
                    //当前请求需要的权限
                    return;
                }
            }

            //当前登录用户所具有的权限
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                //如果说当前登录用户所具有的权限有跟数据库当前用户权限匹配，那么放行
                if (authority.getAuthority().equals(attribute.getAttribute())) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("非法请求!");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
