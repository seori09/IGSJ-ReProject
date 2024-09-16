package ezen.project.IGSJ.member.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ezen.project.IGSJ.member.domain.MemberDTO;
import ezen.project.IGSJ.member.domain.OAuthToken;
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

		if (passMatch == true) {
			memberDTO.setUserPwd(realPwd);
			return memberService.memberLogin(memberDTO);

		} else {

			return null;
		}

	} // memberLogin()
	
	// 카카오API 활용한 로그인 구현
	@GetMapping("/kakao-login")
	@ResponseBody
	public MemberDTO KakaoLogin(@RequestParam String code) throws Exception {
		// 1. 발급된 인가코드로 Access_Token 생성
		RestTemplate rt = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		params.add("redirect_uri", "http://localhost:8086/member/KAKAOlogin");
		params.add("code", code);

		HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(params, headers);
		ResponseEntity<String> response = rt.exchange("https://kauth.kakao.com/oauth/token", HttpMethod.POST, kakaoTokenRequest, String.class);

		// 2. 생성된 Access_Token으로 사용자 정보 추출
		ObjectMapper objectMapper = new ObjectMapper();
		OAuthToken oauthToken = null;

		try {
			oauthToken = objectMapper.readValue(response.getBody(), OAuthToken.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		RestTemplate rt2 = new RestTemplate();

		HttpHeaders headers2 = new HttpHeaders();
		headers2.add("Authorization", "Bearer " + oauthToken.getAccess_token());
		headers2.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest2 = new HttpEntity<>(headers2);
		ResponseEntity<String> response2 = rt2.exchange("https://kapi.kakao.com/v2/user/me", HttpMethod.POST, kakaoTokenRequest2, String.class);

		// 3. 추출된 사용자 정보 가공
		JSONParser parser               = new JSONParser();
		JSONObject jsonObject           = (JSONObject) parser.parse(response2.getBody());
		String     propertiesObject     = jsonObject.get("properties").toString();
		JSONObject nameObj              = (JSONObject) parser.parse(propertiesObject);
		String     kakao_accountObject  = jsonObject.get("kakao_account").toString();
		JSONObject kakao_accountObj     = (JSONObject) parser.parse(kakao_accountObject);

		String userId                   = jsonObject.get("id").toString();
		String userPwd                  = jsonObject.get("id").toString();
		String userName                 = nameObj.get("nickname").toString();
		String userPhoneNumber          = "000-0000-0000";
		String userEmail                = kakao_accountObj.get("email").toString();
		String userJoinDateStr          = Instant.parse((CharSequence) jsonObject.get("connected_at")).atOffset( ZoneOffset.UTC )
				                          .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		java.util.Date userJoinDateUtil = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(userJoinDateStr);
		Date userJoinDateSql            = new Date(userJoinDateUtil.getTime());
		int    userVerify               = 0;
		String userBirth                = "0000-00-00";

//		System.out.println("userId          : " + userId);
//		System.out.println("userPwd         : " + userPwd);
//		System.out.println("userName        : " + userName);
//		System.out.println("userPhoneNumber : " + userPhoneNumber);
//		System.out.println("userEmail       : " + userEmail);
//		System.out.println("userJoinDate    : " + userJoinDateSql.toString());
//		System.out.println("userVerify      : " + userVerify);
//		System.out.println("userBirth       : " + userBirth);

		// 4. DB로 정보 전송(회원가입/로그인 로직 실행)
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setUserId(userId);
		memberDTO.setUserPwd(userPwd);
		memberDTO.setUserPhoneNumber(userPhoneNumber);
		memberDTO.setUserName(userName);
		memberDTO.setUserEmail(userEmail);
		memberDTO.setUserJoinDate(userJoinDateSql);
		memberDTO.setUserVerify(userVerify);
		memberDTO.setUserBirth(userBirth);

	    return memberService.KakaoLogin(memberDTO);
	} // KakaoLogin()

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
