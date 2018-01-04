package cn.itcast.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
       
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		//在执行controller之前执行
		//获得session中的用户
		HttpSession session = request.getSession();
		Object user = session.getAttribute(session.getId());
		if(user!=null){
			//如果登陆了就放行
			return true;
		}else{
			//返回到登陆页面
			response.sendRedirect(request.getContextPath()+"/user/toLogin");
		}
		return false;
	}

}
