package ezen.project.IGSJ.inquire.domain;

import java.util.Date;

public class AnswerDTO {
	
	private int ansNum; // 응답번호
	private int inquireNum; // 제품문의번호
	private String ansTitle; // 응답제목
	private String ansContent; // 응답내용
	private Date ansRegDate; // 응답일자
	
	public int getAnsNum() {
		return ansNum;
	}
	public void setAnsNum(int ansNum) {
		this.ansNum = ansNum;
	}
	public int getInquireNum() {
		return inquireNum;
	}
	public void setInquireNum(int inquireNum) {
		this.inquireNum = inquireNum;
	}
	public String getAnsTitle() {
		return ansTitle;
	}
	public void setAnsTitle(String ansTitle) {
		this.ansTitle = ansTitle;
	}
	public String getAnsContent() {
		return ansContent;
	}
	public void setAnsContent(String ansContent) {
		this.ansContent = ansContent;
	}
	public Date getAnsRegDate() {
		return ansRegDate;
	}
	public void setAnsRegDate(Date ansRegDate) {
		this.ansRegDate = ansRegDate;
	}
	
	@Override
	public String toString() {
		return "AnswerDTO [ansNum=" + ansNum + ", inquireNum=" + inquireNum + ", ansTitle=" + ansTitle + ", ansContent="
				+ ansContent + ", ansRegDate=" + ansRegDate + "]";
	}
	
	
	
}
