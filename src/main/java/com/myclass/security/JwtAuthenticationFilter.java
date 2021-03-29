package com.myclass.security;

import com.myclass.dto.UserDto;
import com.myclass.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class JwtAuthenticationFilter extends OncePerRequestFilter {


    @Autowired
    private  JwtTokenProvider tokenProvider;
    @Autowired
    private  CustomUserDetailService customUserDetailService;
    @Value("${shop.app.header_string}")
    private String headerString;
    @Value("${shop.app.token_prefix}")
    private String tokenPrefix;
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwt = getJwtFromRequest(httpServletRequest);
            if(StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)){
                Long userId= tokenProvider.getUserIdFromJWT(jwt);
                UserDto userDetails = customUserDetailService.loadUserById(userId);
                UsernamePasswordAuthenticationToken authenticationToken =new UsernamePasswordAuthenticationToken(
                        userDetails, null,userDetails.getAuthorities()
                );
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }catch (Exception e){
            logger.error("Could not set user authentication in security context", e);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
    private String getJwtFromRequest(HttpServletRequest request){
        String bearToken = request.getHeader(headerString);
        if(StringUtils.hasText(bearToken) && bearToken.startsWith(tokenPrefix)){
            return bearToken.substring(7, bearToken.length());
        }
        return null;
    }
}
