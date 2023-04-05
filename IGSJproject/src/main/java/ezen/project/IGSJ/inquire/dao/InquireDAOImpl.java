package ezen.project.IGSJ.inquire.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ezen.project.IGSJ.inquire.domain.InquireDTO;

@Repository
public class InquireDAOImpl implements InquireDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(InquireDAOImpl.class);
	
	private static final String NAME_SPACE = "mappers.inquireMapper";
	
	@Autowired
	private SqlSession sqlSession;

	// 제품 문의 목록
	@Override
	public List<InquireDTO> inquireList() throws Exception {
		
		logger.info("제품 문의 목록 - DAO");
		
		return sqlSession.selectList(NAME_SPACE + ".inquireList");
	}

	// 제품 문의 조회
	@Override
	public InquireDTO inquireView(int inquireNum) throws Exception {

		logger.info("제품 문의 조회 - DAO");

		return sqlSession.selectOne(NAME_SPACE + ".inquireView", inquireNum);
	}

	// 제품 문의 작성
	@Override
	public void inquireWrite(InquireDTO inquireDTO) throws Exception {

		logger.info("제품 문의 작성 - DAO");
		
		sqlSession.insert(NAME_SPACE + ".inquireWrite", inquireDTO);
		
	}

	// 제품 문의 수정
	@Override
	public void inquireUpdate(InquireDTO inquireDTO) throws Exception {

		logger.info("제품 문의 수정 - DAO");
		
		sqlSession.update(NAME_SPACE + ".inquireUpdate", inquireDTO);
	}

	// 제품 문의 삭제
	@Override
	public void inquireDelete(int inquireNum) throws Exception {
		
		logger.info("제품 문의 삭제 - DAO");
		
		sqlSession.delete(NAME_SPACE + ".inquireDelete", inquireNum);
	}
	

}
