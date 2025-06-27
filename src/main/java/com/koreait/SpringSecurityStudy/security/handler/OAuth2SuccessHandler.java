package com.koreait.SpringSecurityStudy.security.handler;

import com.koreait.SpringSecurityStudy.entity.OAuth2User;
import com.koreait.SpringSecurityStudy.repository.OAuth2UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private OAuth2UserRepository oAuth2UserRepository;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //OAuth2User 정보 가져오기
        DefaultOAuth2User defaultOAuth2User = (DefaultOAuth2User) authentication.getPrincipal();
        String provider = defaultOAuth2User.getAttribute("provider");
        String providerUserId = defaultOAuth2User.getAttribute("id");
        String email = defaultOAuth2User.getAttribute("email");

        //provider, providerUserId 이미 연동된 사용자 정보가 있는지 DB 조회
        OAuth2User oAuth2User = oAuth2UserRepository.getOAuth2UserByProviderAndProviderUserId(provider, providerUserId);
    }
}
