package ezen.project.IGSJ.board.service;

import java.util.List;

import ezen.project.IGSJ.board.domain.BoardDTO;

public interface BoardService {
	
	// 공지사항 목록 불러오기
	public List<BoardDTO> getBoardList() throws Exception;
	
	// 공지사항 작성
	public int noticeWrite(BoardDTO boardDTO) throws Exception;
	
	// 공지사항 조회
	public BoardDTO noticeView(int bno) throws Exception;
	
	// 공지사항 수정하기
	public int noticeModify(BoardDTO boardDTO) throws Exception;
	
	// 공지사항 삭제하기
	public int noticeDel(int bno) throws Exception;
	
}
