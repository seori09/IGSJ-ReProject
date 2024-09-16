package ezen.project.IGSJ.utils.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import ezen.project.IGSJ.member.domain.MemberDTO;

public class SellerInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {
		
		// 세션에 저장되어있는 현재 로그인한 회원정보를 불러와 판매자를 검증
		HttpSession session = req.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		
		// 판매자가 아닐시 접속하는 url에 대해 반려처리
		if (member == null || member.getUserVerify() != 5) {
			res.sendRedirect("/");
			return false;
		}

		return true;
	}
}
