package ezen.project.IGSJ.order.domain;

import java.util.Date;

public class PaymentDTO {

	private int paymentNum;
	private int orderDetailNum;
	private String paySet;
	private String payCompany;
	private int payMoney;
	private Date payRegDate;
	private String payBank;

	
	public PaymentDTO() {

	}

	public PaymentDTO(int paymentNum, int orderDetailNum, String paySet, String payCompany, int payMoney,
			Date payRegDate, String payBank) {
		this.paymentNum = paymentNum;
		this.orderDetailNum = orderDetailNum;
		this.paySet = paySet;
		this.payCompany = payCompany;
		this.payMoney = payMoney;
		this.payRegDate = payRegDate;
		this.payBank = payBank;
	}

	public int getPaymentNum() {
		return paymentNum;
	}

	public void setPaymentNum(int paymentNum) {
		this.paymentNum = paymentNum;
	}

	public int getOrderDetailNum() {
		return orderDetailNum;
	}

	public void setOrderDetailNum(int orderDetailNum) {
		this.orderDetailNum = orderDetailNum;
	}

	public String getPaySet() {
		return paySet;
	}

	public void setPaySet(String paySet) {
		this.paySet = paySet;
	}

	public String getPayCompany() {
		return payCompany;
	}

	public void setPayCompany(String payCompany) {
		this.payCompany = payCompany;
	}

	public int getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(int payMoney) {
		this.payMoney = payMoney;
	}

	public Date getPayRegDate() {
		return payRegDate;
	}

	public void setPayRegDate(Date payRegDate) {
		this.payRegDate = payRegDate;
	}

	public String getPayBank() {
		return payBank;
	}

	public void setPayBank(String payBank) {
		this.payBank = payBank;
	}

	@Override
	public String toString() {
		return "PaymentDTO [paymentNum=" + paymentNum + ", orderDetailNum=" + orderDetailNum + ", paySet=" + paySet
				+ ", payCompany=" + payCompany + ", payMoney=" + payMoney + ", payRegDate=" + payRegDate + ", payBank="
				+ payBank + "]";
	}
	
	
}
