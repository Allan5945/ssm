package com.ssm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Interceptor implements HandlerInterceptor{

    //  适合做限制/黑名单/等等
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
	    String user_mes = (String) request.getAttribute("user_mes");
        String requestURI = request.getRequestURI();

        if(requestURI.contains("/login")){
            return true;
        };
	    if(request.getAttribute("user_mes") != null){
            return  true;
        }else{
            System.out.println(request.getContextPath());
//            response.sendRedirect(request.getContextPath() + "/");
        };
        return false;
	};
	//主要判断登录等等
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
//        System.out.println("方法前 1");
    }
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
//		System.out.println("页面渲染后 1");

	}
}
