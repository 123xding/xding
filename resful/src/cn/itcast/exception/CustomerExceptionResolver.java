package cn.itcast.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomerExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			Exception exc) {
		//异常信息
		String msg="";
		if(exc instanceof CustomerException){
			msg=exc.getMessage();
		}else{
			msg="系统繁忙，请稍后再试!!";
		}
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("msg", msg);
		modelAndView.setViewName("common/error");
		return modelAndView;
	}

}
