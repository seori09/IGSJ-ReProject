package ezen.project.IGSJ.member.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ezen.project.IGSJ.member.domain.MemberDTO;
import ezen.project.IGSJ.member.service.MemberService;

@Controller("MemberController")
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/member")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memberService;

	@Autowired
	private BCryptPasswordEncoder passEncoder;

	// 회원가입(POST)
	@PostMapping("/memberSignUp")
	public void signUpMember(@RequestBody MemberDTO memberDTO) throws Exception {

		logger.info("회원가입 Step1 memberDTO ==> {}", memberDTO.toString());

		String inputPass = memberDTO.getUserPwd();

		String pass = passEncoder.encode(inputPass);

		memberDTO.setUserPwd(pass);

		memberService.signUpMember(memberDTO);

	}

	// 로그인
	@PostMapping("/memberLogin")
	@ResponseBody
	public MemberDTO memberLogin(@RequestBody MemberDTO memberDTO) throws Exception {
		
		logger.info("로그인 memberLogin - Controller {}", memberDTO);
		
		 String inputPwd = memberDTO.getUserPwd();
			System.out.println("사용자 입력 비밀번호 =>" + inputPwd); 
		 // DB에있는 비밀번호(bcrypt값이므로 변환이 필요함)  
		 // matches(사용자 입력값, 암호화 비밀번호값) 
		 String realPwd = memberService.getPwd(memberDTO.getUserId()); 
		 	System.out.println("암호화 비밀번호 =>" + realPwd); 
		 
		 boolean passMatch = passEncoder.matches(inputPwd, realPwd);
		 	System.out.println("검증 결과 ==> " + passMatch); 
		 
		 if(passMatch == true) { 
			 memberDTO.setUserPwd(realPwd);
			 return memberService.memberLogin(memberDTO); 
			 
		 } else {
			 
			 return null;
		 }

	} // memberLogin()

	// 회원가입 아이디 중복 체크
	@ResponseBody
	@PostMapping("/idCheck")
	public int memberIdCheck(@RequestBody MemberDTO memberDTO) throws Exception {

		logger.info("회원가입 아이디 중복 체크 memberIdCheck - Controller");

		int result = memberService.memberIdCheck(memberDTO);

		System.out.println("회원가입 중복 여부 => " + result);

		return result;
	}

	// 회원정보 수정 기능 로직
	@ResponseBody
	@PostMapping("/memberModify")
	public void memberModify(@RequestBody MemberDTO memberDTO, HttpSession session) throws Exception {

		logger.info("회원정보 수정 기능 로직, 수정 정보 {}", memberDTO);

		String inputPass = memberDTO.getUserPwd();

		String pass = passEncoder.encode(inputPass);

		memberDTO.setUserPwd(pass);

		memberService.memberModify(memberDTO);

	}

	// 회원 정보 찾기
	@ResponseBody
	@GetMapping("/memberProfile/{userId}")
	public MemberDTO memberProfile(@PathVariable String userId) throws Exception {

		logger.info("회원 정보 찾기 memberProfile - Controller, 회원아이디 {}", userId);

		MemberDTO memberDTO = memberService.memberProfile(userId);

		return memberDTO;
	}

	// 회원 탈퇴
	@ResponseBody
	@PostMapping("/removeMember")
	public int removeMember(@RequestBody MemberDTO memberDTO) throws Exception {

		logger.info("회원 탈퇴 removeMember - Controller");

		int result = memberService.removeMember(memberDTO);

		return result;

	}

	// 회원 수정,삭제 페이지에 들어가기 위한 비밀번호 검증
	@ResponseBody
	@PostMapping("/passVerify")
	public int passVerify(@RequestBody MemberDTO memberDTO) throws Exception {

		logger.info("수정,삭제용 비밀번호 검증 passVerify - Controller {}", memberDTO);
		// 요청자(클라이언트)가 입력한 비밀번호
		String inputPwd = memberDTO.getUserPwd();

		System.out.println("사용자 입력 비밀번호 =>" + inputPwd);
		// DB에있는 비밀번호(bcrypt값이므로 변환이 필요함)
		// matches(사용자 입력값, 암호화 비밀번호값)
		String realPwd = memberService.getPwd(memberDTO.getUserId());

		System.out.println("암호화 비밀번호 =>" + realPwd);
		boolean passMatch = passEncoder.matches(inputPwd, realPwd);
		System.out.println("검증 결과 ==> " + passMatch);
		if (passMatch == true) {

			return 1;

		} else {

			return 0;
		}
	}
}
