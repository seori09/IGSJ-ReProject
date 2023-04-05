package ezen.project.IGSJ.inquire.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ezen.project.IGSJ.inquire.dao.InquireDAO;
import ezen.project.IGSJ.inquire.domain.InquireDTO;

@Service
public class InquireServiceImpl implements InquireService {
	
	private static final Logger logger = LoggerFactory.getLogger(InquireServiceImpl.class);
	
	@Autowired
	private InquireDAO inquireDAO;
	
	// 상품 문의 목록
	@Override
	public List<InquireDTO> inquireList() throws Exception {
		
		logger.info("상품 문의 목록 - Service");
		
		return inquireDAO.inquireList();
	}

	// 상품 문의 조회 
	@Override
	public InquireDTO inquireView(int inquireNum) throws Exception {

		logger.info("상품 문의 조회 - Service");
		
		return inquireDAO.inquireView(inquireNum);
	}

	// 상품 문의 작성 
	@Override
	public void inquireWrite(InquireDTO inquireDTO) throws Exception {
		
		logger.info("상품 문의 작성 - Service");
		
		inquireDAO.inquireWrite(inquireDTO);

	}

	// 상품 문의 수정 
	@Override
	public void inquireUpdate(InquireDTO inquireDTO) throws Exception {

		logger.info("상품 문의 수정 - Service");

		inquireDAO.inquireUpdate(inquireDTO);
	}

	// 상품 문의 삭제 
	@Override
	public void inquireDelete(int inquireNum) throws Exception {

		logger.info("상품 문의 삭제 - Service");
		
		inquireDAO.inquireDelete(inquireNum);
	}
	
}
