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
	@ResponseBody
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
		
		return memberService.memberLogin(memberDTO);
		
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
	
	//회원 탈퇴
	@ResponseBody
	@PostMapping("/removeMember")
	public int removeMember(@RequestBody MemberDTO memberDTO) throws Exception {
		
		logger.info("회원 탈퇴 removeMember - Controller");
		
		int result = memberService.removeMember(memberDTO);
		
		return result;
		
	}

}
