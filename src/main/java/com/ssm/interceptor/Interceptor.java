package com.ssm.interceptor;

import com.ssm.pojo.Userses;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class Interceptor implements HandlerInterceptor{

    //  适合做限制/黑名单/等等
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
        String requestURI = request.getRequestURI();

        HttpSession session = request.getSession();

        Userses userMes = (Userses)session.getAttribute("userMes");

        if(requestURI.contains("/login") || requestURI.contains("/wxLogin") || requestURI.contains("/index") || userMes != null){
            return true;
        }else{
            response.sendRedirect("/loginPage");
            return false;
        }
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
