package ezen.project.IGSJ.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ezen.project.IGSJ.board.domain.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	private static final String NAME_SPACE = "mappers.boardMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	// 공지사항 목록 불러오기
	@Override
	public List<BoardDTO> getBoardList() throws Exception {
		
		logger.info("공지사항 리스트 가져오기 vue - DAO");
		
		return sqlSession.selectList(NAME_SPACE + ".getBoardList");
	}
	
	// 공지사항 등록하기
	@Override
	public int noticeWrite(BoardDTO boardDTO) throws Exception {
		
		logger.info("vue에서 넘어온 데이터 공지사항 등록하기 DAO : {}", boardDTO);
		
		int result = sqlSession.insert(NAME_SPACE + ".noticeWrite", boardDTO);

		return result;
	}
	
	// 공지사항 조회하기
	@Override
	public BoardDTO noticeView(int bno) throws Exception {
		
		logger.info("vue - {} 번 게시글 조회하기 DAO", bno);
		
		return sqlSession.selectOne(NAME_SPACE + ".noticeView", bno);
	}
	
	// 공지사항 수정하기
	@Override
	public int noticeModify(BoardDTO boardDTO) throws Exception {
		
		logger.info("{}번 공지사항 수정 DAO", boardDTO.getBno());
		
		return sqlSession.update(NAME_SPACE + ".noticeModify", boardDTO);
	}
	
	// 공지사항 삭제하기
	@Override
	public int noticeDel(int bno) throws Exception {
		
		logger.info("{}번 공지사항 삭제 DAO", bno);
		
		return sqlSession.delete(NAME_SPACE + ".noticeDel", bno);
	}
}
