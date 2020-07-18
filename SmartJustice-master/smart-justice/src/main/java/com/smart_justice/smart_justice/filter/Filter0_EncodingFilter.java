package com.smart_justice.smart_justice.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @className: Filter0_EncodingFilter
 * @description: 编码过滤器，注解方式的过滤器通过文件名的排序作为执行顺序
 *               设置响应头，解决跨域
 * @author: ZSZ
 * @date: 2019/10/27 20:27
 */
@WebFilter(filterName = "Filter0_EncodingFilter",urlPatterns = "/*")
public class Filter0_EncodingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        System.out.println(request.getAttribute("type"));
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpRequest.setCharacterEncoding("utf-8");
        httpResponse.setCharacterEncoding("utf-8");
//        httpResponse.setContentType("application/json;charset=UTF-8");

        httpResponse.setHeader("Access-Control-Allow-Origin", httpRequest.getHeader("Origin"));
        httpResponse.setHeader("Access-Control-Allow-Methods", "POST,GET");
        httpResponse.setHeader("Access-Control-Max-Age", "0");
        httpResponse.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,Cookie,token");
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpResponse.setHeader("XDomainRequestAllowed", "1");

        if (httpRequest.getMethod().equals("OPTIONS")) {
            httpResponse.setStatus(HttpServletResponse.SC_OK);
        }

        System.out.println("--------------filter-----------------");
        chain.doFilter(httpRequest,httpResponse);

    }
}
