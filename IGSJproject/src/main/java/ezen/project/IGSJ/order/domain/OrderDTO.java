package ezen.project.IGSJ.order.domain;



import java.sql.Date;
import java.util.List;

import ezen.project.IGSJ.product.domain.ProductDTO;

public class OrderDTO {

	//MemberDTO
	private String userId;
	private String userName;
	private String userPhoneNumber;
	private String postAddress;
	private String address;
	private String detailAddress;
	
	//ProductDTO
	private String pno;
	private String storedFileRootName;
	private String product_name;
	private int product_price;
	private int productCnt;
	private List<ProductDTO> productList; 
	
	//OrderDTO
	private String orderNum;
	private Date order_date;
	private String post_address;
	private String detail_address;
	private String detail_address2;
	private String recipient;
	private String recipient_phone;
	
	//PaymentDTO
	private	String paySet;
	private String payCompany;
	private int payMoney;
	private Date payRegDate;
	private String payBank;
	
	private String paymentStatus;
	
	public OrderDTO() {
		// TODO Auto-generated constructor stub
	}

	
	public OrderDTO(String userId, String userName, String userPhoneNumber, String postAddress, String address,
			String detailAddress, String pno, String storedFileRootName, String product_name, int product_price,
			int productCnt, List<ProductDTO> productList, String orderNum, Date order_date, String post_address,
			String detail_address, String detail_address2, String recipient, String recipient_phone, String paySet,
			String payCompany, int payMoney, Date payRegDate, String payBank, String paymentStatus) {
		this.userId = userId;
		this.userName = userName;
		this.userPhoneNumber = userPhoneNumber;
		this.postAddress = postAddress;
		this.address = address;
		this.detailAddress = detailAddress;
		this.pno = pno;
		this.storedFileRootName = storedFileRootName;
		this.product_name = product_name;
		this.product_price = product_price;
		this.productCnt = productCnt;
		this.productList = productList;
		this.orderNum = orderNum;
		this.order_date = order_date;
		this.post_address = post_address;
		this.detail_address = detail_address;
		this.detail_address2 = detail_address2;
		this.recipient = recipient;
		this.recipient_phone = recipient_phone;
		this.paySet = paySet;
		this.payCompany = payCompany;
		this.payMoney = payMoney;
		this.payRegDate = payRegDate;
		this.payBank = payBank;
		this.paymentStatus = paymentStatus;
	}


	public String getPostAddress() {
		return postAddress;
	}

	public void setPostAddress(String postAddress) {
		this.postAddress = postAddress;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public String getPno() {
		return pno;
	}

	public void setPno(String pno) {
		this.pno = pno;
	}

	public String getStoredFileRootName() {
		return storedFileRootName;
	}

	public void setStoredFileRootName(String storedFileRootName) {
		this.storedFileRootName = storedFileRootName;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public int getProductCnt() {
		return productCnt;
	}

	public void setProductCnt(int productCnt) {
		this.productCnt = productCnt;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public String getPost_address() {
		return post_address;
	}

	public void setPost_address(String post_address) {
		this.post_address = post_address;
	}

	public String getDetail_address() {
		return detail_address;
	}

	public void setDetail_address(String detail_address) {
		this.detail_address = detail_address;
	}

	public String getDetail_address2() {
		return detail_address2;
	}

	public void setDetail_address2(String detail_address2) {
		this.detail_address2 = detail_address2;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getRecipient_phone() {
		return recipient_phone;
	}

	public void setRecipient_phone(String recipient_phone) {
		this.recipient_phone = recipient_phone;
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

	public List<ProductDTO> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductDTO> productList) {
		this.productList = productList;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}


	@Override
	public String toString() {
		return "OrderDTO [userId=" + userId + ", userName=" + userName + ", userPhoneNumber=" + userPhoneNumber
				+ ", postAddress=" + postAddress + ", address=" + address + ", detailAddress=" + detailAddress
				+ ", pno=" + pno + ", storedFileRootName=" + storedFileRootName + ", product_name=" + product_name
				+ ", product_price=" + product_price + ", productCnt=" + productCnt + ", productList=" + productList
				+ ", orderNum=" + orderNum + ", order_date=" + order_date + ", post_address=" + post_address
				+ ", detail_address=" + detail_address + ", detail_address2=" + detail_address2 + ", recipient="
				+ recipient + ", recipient_phone=" + recipient_phone + ", paySet=" + paySet + ", payCompany="
				+ payCompany + ", payMoney=" + payMoney + ", payRegDate=" + payRegDate + ", payBank=" + payBank
				+ ", paymentStatus=" + paymentStatus + "]";
	}
	
}
