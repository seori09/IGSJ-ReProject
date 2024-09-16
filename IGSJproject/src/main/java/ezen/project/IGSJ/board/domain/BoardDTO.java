package ezen.project.IGSJ.board.domain;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class BoardDTO {

//	bno	int
//	writer	varchar(20)
//	title	varchar(50)
//	content	text
//	reg_date	datetime

	private int bno;
	private String writer;
	private String title;
	private String content;
	private Date reg_date;


	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;

	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {

		return "BoardDTO [bno=" + bno + ", writer=" + writer + ", title=" + title + ", content=" + content + ", reg_date=" + reg_date + "]";

	}

}
