package ezen.project.IGSJ.cart.dao;

import java.util.List;

import ezen.project.IGSJ.cart.domain.CartDTO;

public interface CartDAO {

	// 장바구니 등록
	public int cartWrite(List<CartDTO> cartDTO) throws Exception;

	// 장바구니 중복 확인
	public int cartSelect(CartDTO cartDTO) throws Exception;

	// 장바구니 중복 수량 추가
	public int cartUpdate(CartDTO cartDTO) throws Exception;

	// 장바구니 목록
	public List<CartDTO> cartList(String userId) throws Exception;

	// 장바구니 삭제
	public int cartDelete(CartDTO cartDTO) throws Exception;

	// 장바구니 수량 수정
	public int modifyCart(CartDTO cartDTO) throws Exception;
}
