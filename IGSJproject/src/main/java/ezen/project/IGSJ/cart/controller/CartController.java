package ezen.project.IGSJ.cart.controller;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ezen.project.IGSJ.cart.domain.CartDTO;
import ezen.project.IGSJ.cart.service.CartService;
import ezen.project.IGSJ.product.domain.ProductDTO;

@Controller
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/cart")
public class CartController {

	private static final Logger logger = LoggerFactory.getLogger(CartController.class);
	
	@Autowired
	private CartService cartService;
	
	//장바구니 등록
	@ResponseBody
	@PostMapping("/cartWrite")
	public boolean cartWrite(@RequestBody CartDTO cartDTO) throws Exception{
		
		logger.info("장바구니 등록 cartWrite - Controller {}", cartDTO);
		
		System.out.println("사용자 아이디 ==> " + cartDTO.getUserId());
		
		String rs = RandomStringUtils.randomNumeric(6);
		
		String cartNum = cartDTO.getUserId() + "_" + rs;
		
		cartDTO.setCartNum(cartNum);
		
		int cartWrite  = cartService.cartWrite(cartDTO);
		
		if(cartWrite == 1) {
			
			return true;
			
		} else {
			
			return false;
		}	
	}
	
	// 장바구니 목록
	@ResponseBody
	@GetMapping("/cartList/{userId}")
	public List<CartDTO> cartList(@PathVariable String userId) throws Exception {
		
		logger.info("장바구니 목록 cartList - Controller");
		
		List<CartDTO> cartList = cartService.cartList(userId);
	
		return cartList;
	}

	
	// 장바구니 삭제
	@ResponseBody
	@PostMapping("/cartDelete")
	public boolean cartDelete(@RequestBody CartDTO cartDTO) throws Exception {
		
		logger.info("장바구니 삭제 cartDelete - Controller");
		
		int cartDelete = cartService.cartDelete(cartDTO);
		
		if(cartDelete == 1) {
			
			return true;
			
		} else {
		
			return false;
		}
	}
	
}

















