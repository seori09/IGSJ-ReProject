package ezen.project.IGSJ.member.dao;

import ezen.project.IGSJ.member.domain.MemberDTO;

public interface MemberDAO {

	// 회원가입 로직
	public void signUpMember(MemberDTO memberDTO) throws Exception;

	// 로그인 기능 구현
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception;

	// 카카오API 활용 로그인 : 1. 가입되어 있는지 확인(MemberDTO에 저장되어 있는 회원인지 확인)
	public MemberDTO KakaoSignedMemberCheck(MemberDTO memberDTO) throws Exception;

	// 카카오API 활용 로그인 : 3. 가입이 안되어 있으면 회원가입(MemberDTO에 회원 정보 저장)하고, 이어서 바로 로그인 실행
	public MemberDTO KakaoSignUp(MemberDTO memberDTO) throws Exception;

	// 회원가입 아이디 중복 체크
	public int memberIdCheck(MemberDTO memberDTO) throws Exception;

	// 회원정보 수정 로직
	public void memberModify(MemberDTO memberDTO) throws Exception;

	// 회원정보 찾기
	public MemberDTO memberProfile(String userId) throws Exception;

	// 회원 탈퇴
	public int removeMember(MemberDTO memberDTO) throws Exception;

	// 회원 탈퇴에 필요한 비밀번호 찾기
	public String getPwd(String userId) throws Exception;
}
