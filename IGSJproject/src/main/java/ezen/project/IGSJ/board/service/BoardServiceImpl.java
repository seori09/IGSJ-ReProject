package ezen.project.IGSJ.board.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ezen.project.IGSJ.board.dao.BoardDAO;
import ezen.project.IGSJ.board.domain.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService{
	
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Autowired
	private BoardDAO boardDAO;
	
	// 공지사항 목록 불러오기
	@Override
	public List<BoardDTO> getBoardList() throws Exception {
		
		logger.info("공지사항 리스트 가져오기 vue - service");
		
		return boardDAO.getBoardList();
	}
	
	// 공지사항 작성
	@Override
	public int noticeWrite(BoardDTO boardDTO) throws Exception {
		
		logger.info("vue에서 넘어온 데이터 공지사항 등록하기 SERVICE : {}", boardDTO);
		
		int result = boardDAO.noticeWrite(boardDTO);
		
		return result;
	}
	
	// 공지사항 조회
	@Override
	public BoardDTO noticeView(int bno) throws Exception {
		
		logger.info("vue에서 넘어온 {} 번 게시글 조회 SERVICE", bno);
		
		return boardDAO.noticeView(bno);
	}
	
	// 공지사항 수정하기
	@Override
	public int noticeModify(BoardDTO boardDTO) throws Exception {
		
		logger.info("{} 번 공지사항 수정 SERVICE", boardDTO.getBno());
		
		return boardDAO.noticeModify(boardDTO);
	}
	
	// 공지사항 삭제하기
	@Override
	public int noticeDel(int bno) throws Exception {
		
		logger.info("{} 번 공지사항 삭제 SERVICE", bno);
		
		return boardDAO.noticeDel(bno);
	}
}
