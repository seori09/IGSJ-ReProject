package ezen.project.IGSJ.cart.dao;

import java.util.List;

import ezen.project.IGSJ.cart.domain.CartDTO;
import ezen.project.IGSJ.product.domain.ProductDTO;

public interface CartDAO {

	//장바구니 등록
	public int cartWrite(CartDTO cartDTO) throws Exception;
	
	//장바구니 목록
	public List<CartDTO> cartList(String userId) throws Exception;
	
	//장바구니 삭제
	public int cartDelete(CartDTO cartDTO) throws Exception;
}
