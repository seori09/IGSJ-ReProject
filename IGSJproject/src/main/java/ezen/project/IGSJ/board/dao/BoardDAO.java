package ezen.project.IGSJ.board.dao;

import java.util.List;

import ezen.project.IGSJ.board.domain.BoardDTO;

public interface BoardDAO {
	
	// 공지사항 리스트 가져오기
	public List<BoardDTO> getBoardList() throws Exception;
	
	// 공지사항 등록하기
	public int noticeWrite(BoardDTO boardDTO) throws Exception;
	
	// 공지사항 조회하기
	public BoardDTO noticeView(int bno) throws Exception;
	
	// 공지사항 수정하기
	public int noticeModify(BoardDTO boardDTO) throws Exception;
	
	// 공지사항 삭제하기
	public int noticeDel(int bno) throws Exception;
}
