package ezen.project.IGSJ.utils.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoggerInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);

	// 컨트롤러 호출 전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		if (logger.isDebugEnabled()) {
			logger.info("=================================로직 로깅 시작=================================");
			logger.info("\t Request URI \t : {}", request.getRequestURI());
			
		}

		return super.preHandle(request, response, handler);
	}

	// 컨트롤러 호출 후
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.info("=================================로직 로깅 끝  =================================");
		}
		super.postHandle(request, response, handler, modelAndView);
	}

}
