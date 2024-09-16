package ezen.project.IGSJ.utils.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import ezen.project.IGSJ.member.domain.MemberDTO;

// 관리자 인터셉터.
public class AdminInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {
		
		// 세션에 저장되어 있는 현재 로그인한 회원의 정보를 받아낸다.
		HttpSession session = req.getSession();
		
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		
		// 회원이 로그인 되어있지 않거나, 인증번호가 128이 아니라면 반려시킨다.
		if (member == null || member.getUserVerify() != 128) {
			res.sendRedirect("/");
			return false;
		}

		return true;
	}

}
