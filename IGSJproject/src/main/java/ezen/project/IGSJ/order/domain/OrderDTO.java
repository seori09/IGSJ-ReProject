package ezen.project.IGSJ.order.domain;

import java.util.Date;

public class OrderDTO {

	private int orderNum;
	private String userId;
	private Date order_date;
	private String postAddress;
	private String detail_address;
	private String recipient;
	private String recipient_phone;

	private String userName;
	private String userPhoneNumber;
	private String address;
	private String detailAddress;
	
	private String storedFileRootName;
	private String product_name;
	private int product_price;
	private int productCnt;
	
	public OrderDTO() {
		// TODO Auto-generated constructor stub
	}

	public OrderDTO(int orderNum, String userId, Date order_date, String postAddress, String detail_address,
			String recipient, String recipient_phone, String userName, String userPhoneNumber, String address,
			String detailAddress, String storedFileRootName, String product_name, int product_price, int productCnt) {
		super();
		this.orderNum = orderNum;
		this.userId = userId;
		this.order_date = order_date;
		this.postAddress = postAddress;
		this.detail_address = detail_address;
		this.recipient = recipient;
		this.recipient_phone = recipient_phone;
		this.userName = userName;
		this.userPhoneNumber = userPhoneNumber;
		this.address = address;
		this.detailAddress = detailAddress;
		this.storedFileRootName = storedFileRootName;
		this.product_name = product_name;
		this.product_price = product_price;
		this.productCnt = productCnt;
	}


	public int getOrderNum() {
		return orderNum;
	}


	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public String getPostAddress() {
		return postAddress;
	}

	public void setPostAddress(String postAddress) {
		this.postAddress = postAddress;
	}

	public String getDetail_address() {
		return detail_address;
	}

	public void setDetail_address(String detail_address) {
		this.detail_address = detail_address;
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


	@Override
	public String toString() {
		return "OrderDTO [orderNum=" + orderNum + ", userId=" + userId + ", order_date=" + order_date + ", postAddress="
				+ postAddress + ", detail_address=" + detail_address + ", recipient=" + recipient + ", recipient_phone="
				+ recipient_phone + ", userName=" + userName + ", userPhoneNumber=" + userPhoneNumber + ", address="
				+ address + ", detailAddress=" + detailAddress + ", storedFileRootName=" + storedFileRootName
				+ ", product_name=" + product_name + ", product_price=" + product_price + ", productCnt=" + productCnt
				+ "]";
	}

}
