package com.guoxi.springdevice.provider;

import com.guoxi.springdevice.mybatis.entity.UserEntity;
import com.guoxi.springdevice.service.UserLoginServiceImpl;
import com.guoxi.springdevice.token.JwtLoginToken;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * 用户角色校验具体实现
 *
 * @author  guoxi@tg-hd.com
 * @since 2022/6/15 16:03
 *
 */
@RequiredArgsConstructor
public class JwtAuthenticationProvider implements AuthenticationProvider {

    private final UserDetailsService userDetailsService;
//    private final UserLoginServiceImpl userLoginService;
    private final PasswordEncoder passwordEncoder;



    /**
     * 鉴权具体逻辑
     *
     * @param authentication
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UserDetails userDetails = userDetailsService.loadUserByUsername(authentication.getName());
        //转换authentication 认证时会先调用support方法,受支持才会调用,所以能强转
        JwtLoginToken jwtLoginToken = (JwtLoginToken) authentication;
        defaultCheck(userDetails);
        // 用户名密码校验 具体逻辑
        additionalAuthenticationChecks(userDetails, jwtLoginToken);
        //构造已认证的authentication
        JwtLoginToken authenticatedToken = new JwtLoginToken(userDetails, jwtLoginToken.getCredentials(), userDetails.getAuthorities());
        authenticatedToken.setDetails(jwtLoginToken.getDetails());
        return authenticatedToken;
    }

    /**
     * 是否支持当前类
     *
     * @param authentication
     * @return
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return (JwtLoginToken.class
                .isAssignableFrom(authentication));
    }

    /**
     * 一些默认信息的检查
     *
     * @param user
     */
    private void defaultCheck(UserDetails user) {
        if (!user.isAccountNonLocked()) {
            throw new LockedException("User account is locked");
        }

        if (!user.isEnabled()) {
            throw new DisabledException("User is disabled");
        }

        if (!user.isAccountNonExpired()) {
            throw new AccountExpiredException("User account has expired");
        }
    }

    /**
     * 检查密码是否正确
     *
     * @param userDetails
     * @param authentication
     * @throws AuthenticationException
     */
    private void additionalAuthenticationChecks(UserDetails userDetails, JwtLoginToken authentication) throws AuthenticationException {
        if (authentication.getCredentials() == null) {
            throw new BadCredentialsException("Bad credentials");
        }
        String presentedPassword = authentication.getCredentials().toString();
        if (!passwordEncoder.matches(presentedPassword, userDetails.getPassword())) {
            throw new BadCredentialsException("Bad credentials");
        }
    }

}
