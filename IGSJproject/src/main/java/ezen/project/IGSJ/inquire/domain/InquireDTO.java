package ezen.project.IGSJ.inquire.domain;

import java.util.Date;

public class InquireDTO {
	
	private String userId; // 유저아이디
	private int inquireNum; // 제품문의번
	private String pno; // 제품번호
	private String inquireTitle; // 문의제목
	private String inquireContent; // 문의내용
	private Date inquireRegDate; // 문의날짜
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getInquireNum() {
		return inquireNum;
	}
	public void setInquireNum(int inquireNum) {
		this.inquireNum = inquireNum;
	}
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public String getInquireTitle() {
		return inquireTitle;
	}
	public void setInquireTitle(String inquireTitle) {
		this.inquireTitle = inquireTitle;
	}
	public String getInquireContent() {
		return inquireContent;
	}
	public void setInquireContent(String inquireContent) {
		this.inquireContent = inquireContent;
	}
	public Date getInquireRegDate() {
		return inquireRegDate;
	}
	public void setInquireRegDate(Date inquireRegDate) {
		this.inquireRegDate = inquireRegDate;
	}
	
	@Override
	public String toString() {
		return "InquireDTO [userId=" + userId + ", inquireNum=" + inquireNum + ", pno=" + pno + ", inquireTitle="
				+ inquireTitle + ", inquireContent=" + inquireContent + ", inquireRegDate=" + inquireRegDate + "]";
	}
	
	
	
	
}
