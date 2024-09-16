package ezen.project.IGSJ.inquire.service;

import java.util.List;

import ezen.project.IGSJ.inquire.domain.InquireDTO;

public interface InquireService {
	
	// 제품 문의 목록
	public List<InquireDTO> inquireList() throws Exception;
	
	// 제품 문의 작성
	public int inquireWrite(InquireDTO inquireDTO) throws Exception;

	// 제품 문의 조회
	public InquireDTO inquireView(int inquireNum) throws Exception;
	
	// 제품 문의 수정
	public int inquireUpdate(InquireDTO inquireDTO) throws Exception;
	
	// 제품 문의 삭제
	public int inquireDelete(int inquireNum) throws Exception;

	
}
