package ezen.project.IGSJ.inquire.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ezen.project.IGSJ.inquire.domain.AnswerDTO;
import ezen.project.IGSJ.inquire.service.AnswerService;

@Controller
@CrossOrigin(origins = "http://localhost:8080")
public class AnswerController {
	
	private static final Logger logger = LoggerFactory.getLogger(AnswerController.class);

	@Autowired
	private AnswerService answerService;

	// 답글불러오기
	@ResponseBody
	@RequestMapping(value = "/answer/AnswerList", method = RequestMethod.GET)
	public AnswerDTO answerList(@RequestParam int inquireNum) throws Exception {

		logger.info("vue 답글 불러오기");
		
		// 재국, 예희 : 문의에 대한 답변은 하나만 작성이 가능하게 핢으로 List가 아닌 DTO로 설정.
		AnswerDTO ansList = answerService.answerList(inquireNum);

		return ansList;
	}
	
	// 답글 작성하기
	@ResponseBody
	@RequestMapping(value = "/answer/AnswerWrite", method = RequestMethod.POST)
	public boolean answerWrite(@RequestBody AnswerDTO answerDTO) throws Exception {

		logger.info("답변 작성 CONTROLLER", answerDTO);
		
		int answerCount = answerService.answerCount(answerDTO);
		
		// 재국,예희 : 답변 갯수가 0개면 등록, 아니면 안내메세지 (vue단) 출력.
		if (answerCount == 0) {
			
			answerService.answerWrite(answerDTO);
			
			return true;
			
		} else {
			
			return false;
		}

	}
}
