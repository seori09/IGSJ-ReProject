package ezen.project.IGSJ.inquire.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ezen.project.IGSJ.inquire.domain.InquireDTO;
import ezen.project.IGSJ.inquire.service.InquireService;

@Controller
@CrossOrigin(origins = "http://localhost:8080")
public class InquireController {
	
	private static final Logger logger = LoggerFactory.getLogger(InquireController.class);
	
	@Autowired
	private InquireService inquireService;
	
	// 제품 문의 목록
	@ResponseBody 
	@RequestMapping(value = "/inquire/InquireList", method = RequestMethod.GET)
	public List<InquireDTO> inquireList() throws Exception {
		
		logger.info("vue 문의사항 전송");
		
		List<InquireDTO> inpList = inquireService.inquireList();
		
		return inpList;
		
	}
	
	// 제품 문의 조회

	// 제품 문의 작성
	
	// 제품 문의 수정
	
	// 제품 문의 삭제
	
}
