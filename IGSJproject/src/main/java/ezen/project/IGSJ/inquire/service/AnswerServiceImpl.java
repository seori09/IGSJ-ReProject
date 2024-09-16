package ezen.project.IGSJ.inquire.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ezen.project.IGSJ.inquire.dao.AnswerDAO;
import ezen.project.IGSJ.inquire.domain.AnswerDTO;

@Service
public class AnswerServiceImpl implements AnswerService{
	
	private static final Logger logger = LoggerFactory.getLogger(AnswerServiceImpl.class);
	
	@Autowired
	private AnswerDAO answerDAO;
	
	// 답변 내용 불러오기 (문의 내용 종속)
	@Override
	public AnswerDTO answerList(int inquireNum) throws Exception {
		
		logger.info("{}번 문의사항의 답변 불러오기", inquireNum);
		
		return answerDAO.answerList(inquireNum);
	}
	
	// 답변하기
	@Override
	public int answerWrite(AnswerDTO answerDTO) throws Exception {
		
		logger.info("{}번 문의사항에 답변 남기기", answerDTO.getInquireNum());
		
		return answerDAO.answerWrite(answerDTO);
	}
	
	// 답변 갯수 1개 이상이면 빠꾸
	@Override
	public int answerCount(AnswerDTO answerDTO) throws Exception {
		
		logger.info("{}번 문의사항 답변 갯수 체크 SERVICE", answerDTO.getInquireNum());
		
		return answerDAO.answerCount(answerDTO);
	}
}
