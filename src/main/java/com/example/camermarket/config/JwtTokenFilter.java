package com.example.camermarket.config;

import com.example.camermarket.entities.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Component
public class JwtTokenFilter extends OncePerRequestFilter {
   private final  JwtTokenUtil jwtTokenUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        if (!hasAuthorizationBearer(request)){
            filterChain.doFilter(request, response);

            return;
        }
        String token = getAccessToken(request);

        if(!jwtTokenUtil.validateAccessToken(token= token)){
            filterChain.doFilter(request,response);
        }
        setAuthenticationContext(token,request);
        filterChain.doFilter(request,response);
    }

    private String getAccessToken(HttpServletRequest request) {
        var header  = request.getHeader("Authorization");
        return   header.split(" ")[1].trim();
    }

    private  void  setAuthenticationContext(String token, HttpServletRequest request){

        UserDetails userDetails =  getUserDetails(token);

        var  authentication =  new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
        authentication.setDetails( new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private  boolean hasAuthorizationBearer(HttpServletRequest  request){
        String header  = request.getHeader("Authorization");

        if(header == null  || ObjectUtils.isEmpty(header)  ||  !header.startsWith("Bearer")){
            return  false;
        }
        return  true;
    }

    private   UserDetails getUserDetails (String token){
        User user = new User();
        String[]  subject = jwtTokenUtil.getSubject(token).split(",");
        user.setId(Long.parseLong(subject[0]));
        user.setEmail(subject[1]);
        return  user;
    }
}
