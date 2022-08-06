package com.spring.demo.service;

import com.spring.demo.common.WebConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author beyondmars3
 */
@Slf4j
@Component
public class LoginFilter implements Filter {


    /**
     * 如果 缺少header channel，调转到 /home
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String channel = httpServletRequest.getHeader("channel");
        if (StringUtils.isEmpty(channel) || !WebConst.HEADER_CHANNEL.equals(channel)) {
            log.info("channel:{} is not allow!", channel);
            httpServletRequest.getRequestDispatcher("/").forward(servletRequest, servletResponse);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

}
