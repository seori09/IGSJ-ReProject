package ezen.project.IGSJ.utils.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import ezen.project.IGSJ.member.domain.MemberDTO;

public class AdminInterceptor extends HandlerInterceptorAdapter{
	
	 @Override
	 public boolean preHandle(HttpServletRequest req,
	    HttpServletResponse res, Object obj) throws Exception {
	  
	  HttpSession session = req.getSession();
	  MemberDTO member = (MemberDTO)session.getAttribute("member");
	  
	  if(member == null || member.getUserVerify() != 128) {
	   res.sendRedirect("/");
	   return false;
	  }
	  
	  return true;
	 }
	
	
}
