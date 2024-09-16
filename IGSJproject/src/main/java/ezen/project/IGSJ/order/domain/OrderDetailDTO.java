package ezen.project.IGSJ.order.domain;

import java.util.List;

import ezen.project.IGSJ.product.domain.ProductDTO;

public class OrderDetailDTO {

	/*
	 * orderDetailNum int PK orderNum varchar(50) PK pno varchar(200) productCnt int
	 * productPrice int paymentStatus varchar(10)
	 */

	private int orderDetailNum;
	private String orderNum;
	private String pno;
	private int productCnt;
	private int productPrice;
	private String paymentStatus;

	public OrderDetailDTO() {
	}
	// Generate Constructor using Fields (생성자생성)

	public OrderDetailDTO(int orderDetailNum, String orderNum, String pno, int productCnt, int productPrice,
			String paymentStatus) {

		this.orderDetailNum = orderDetailNum;
		this.orderNum = orderNum;
		this.pno = pno;
		this.productCnt = productCnt;
		this.productPrice = productPrice;
		this.paymentStatus = paymentStatus;
	}

	public int getOrderDetailNum() {
		return orderDetailNum;
	}

	public void setOrderDetailNum(int orderDetailNum) {
		this.orderDetailNum = orderDetailNum;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getPno() {
		return pno;
	}

	public void setPno(String pno) {
		this.pno = pno;
	}

	public int getProductCnt() {
		return productCnt;
	}

	public void setProductCnt(int productCnt) {
		this.productCnt = productCnt;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String toString() {
		return "OrderDetailDTO [orderDetailNum=" + orderDetailNum + ", orderNum=" + orderNum + ", pno=" + pno
				+ ", productCnt=" + productCnt + ", productPrice=" + productPrice + ", paymentStatus=" + paymentStatus
				+ "]";
	}

}
