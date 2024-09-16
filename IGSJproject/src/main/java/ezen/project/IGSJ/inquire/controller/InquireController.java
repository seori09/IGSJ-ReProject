package ezen.project.IGSJ.inquire.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ezen.project.IGSJ.inquire.domain.InquireDTO;
import ezen.project.IGSJ.inquire.service.InquireService;

@Controller
@CrossOrigin(origins = "http://localhost:8080")
public class InquireController {

	private static final Logger logger = LoggerFactory.getLogger(InquireController.class);

	@Autowired
	private InquireService inquireService;

	// 제품 문의
	@ResponseBody
	@RequestMapping(value = "/inquire/InquireList", method = RequestMethod.GET)
	public List<InquireDTO> inquireList() throws Exception {

		logger.info("vue 문의사항 목록 불러오기");

		List<InquireDTO> inpList = inquireService.inquireList();

		return inpList;

	}

	// 제품 문의 작성
	@ResponseBody
	@RequestMapping(value = "/inquire/InquireWrite", method = RequestMethod.POST)
	public boolean inquireWrite(@RequestBody InquireDTO inquireDTO) throws Exception {

		logger.info("제품문의 작성", inquireDTO);

		int result = inquireService.inquireWrite(inquireDTO);

		if (result == 1) {

			return true;

		} else {

			return false;

		}

	}

	// 제품문의 조회, 수정페이지 입장. 수정시에도 로그엔 조회로 뜸 주의할것.
	@ResponseBody
	@RequestMapping(value = "/inquire/InquireView", method = RequestMethod.GET)
	public InquireDTO inquireView(@RequestParam int inquireNum) throws Exception {

		logger.info("vue의 {} 번 문의 조회 CONTROLLER", inquireNum);

		return inquireService.inquireView(inquireNum);

	}

	// 제품문의 수정
	@ResponseBody
	@RequestMapping(value = "/inquire/InquireModify", method = RequestMethod.POST)
	public boolean inquireUpdate(@RequestBody InquireDTO inquireDTO) throws Exception {

		logger.info("vue의 {} 번 문의사항 수정 실행 CONTROLLER", inquireDTO.getInquireNum());

		int result = inquireService.inquireUpdate(inquireDTO);

		if (result == 1) {

			return true;

		} else {

			return false;

		}
	}

	// 제품문의 삭제
	@ResponseBody
	@RequestMapping(value = "/inquire/InquireDelete/{inquireNum}", method = RequestMethod.POST)
	public boolean inquireDelete(@PathVariable int inquireNum) throws Exception {

		logger.info("vue의 {} 번 문의사항 삭제 실행 CONTROLLER", inquireNum);

		int result = inquireService.inquireDelete(inquireNum);

		if (result == 1) {

			return true;

		} else {

			return false;

		}

	}

}
