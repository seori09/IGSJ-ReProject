package ezen.project.IGSJ.board.controller;

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

import ezen.project.IGSJ.board.domain.BoardDTO;
import ezen.project.IGSJ.board.service.BoardService;

/*
 * 현 패키지의 admin은 jsp 관리자 페이지에서만 적용되는 패키지임, 공지사항 CRUD관련은 여기서 진행 할 예정
*/
@Controller
@CrossOrigin(origins = "http://localhost:8080")
public class BoardController {

	// Console 창에 해당 로그가 찍힘 프로그램 오류 발생 시 어디서 어떤 이유로 오류가 발생하는지 알 수 있음
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired(required = false)
	private BoardService boardService;

	// 공지사항 출력
	@ResponseBody // json으로 데이터를 보낼때 사용
	@RequestMapping(value = "/notice/NoticeList", method = RequestMethod.GET)
	public List<BoardDTO> getBoardList() throws Exception {

		logger.info("vue로 공지사항 보내기");

		List<BoardDTO> noticeList = boardService.getBoardList();

		return noticeList;

	}

	// 공지사항 작성
	@ResponseBody
	@RequestMapping(value = "/notice/NoticeWrite", method = RequestMethod.POST)
	public boolean noticeWrite(@RequestBody BoardDTO boardDTO) throws Exception {

		logger.info("vue 공지사항 작성 CONTROLLER : {}", boardDTO);

		int result = boardService.noticeWrite(boardDTO);

		if (result == 1) {

			return true;

		} else {

			return false;
		}

	}

	// 공지사항 조회, 수정페이지 입장. 수정시에도 로그엔 조회로 뜸 주의할것.
	@ResponseBody
	@RequestMapping(value = "/notice/NoticeView", method = RequestMethod.GET)
	public BoardDTO noticeView(@RequestParam int bno) throws Exception {

		logger.info("vue의 {} 번 공지사항 조회 CONTROLLER", bno);

		return boardService.noticeView(bno);

	}

	// 공지사항 수정
	@ResponseBody
	@RequestMapping(value = "/notice/NoticeModify", method = RequestMethod.POST)
	public boolean noticeModify(@RequestBody BoardDTO boardDTO) throws Exception {

		logger.info("vue의 {} 번 공지사항 수정 실행 CONTROLLER", boardDTO.getBno());

		int result = boardService.noticeModify(boardDTO);

		if (result == 1) {

			return true;

		} else {

			return false;

		}
	}

	// 공지사항 삭제
	@ResponseBody
	@RequestMapping(value = "/notice/NoticeDel/{bno}", method = RequestMethod.POST)
	public boolean noticeDel(@PathVariable int bno) throws Exception {

		logger.info("vue의 {} 번 공지사항 삭제 실행 CONTROLLER", bno);

		int result = boardService.noticeDel(bno);

		if (result == 1) {

			return true;

		} else {

			return false;

		}
	}

}
