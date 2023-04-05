package ezen.project.IGSJ.admin.dao;

import java.util.List;

import ezen.project.IGSJ.address.domain.MemberAddressDTO;
import ezen.project.IGSJ.member.domain.MemberDTO;
import ezen.project.IGSJ.product.domain.ProductDTO;
import ezen.project.IGSJ.productFile.domain.ProductFileDTO;

public interface AdminDAO {
	
	// ***************************************회원***************************************
	// 전체 회원 불러오기
	public List<MemberDTO> getAllUsers(int displayTotalContent, int pageContent, String searchType, String keyword) throws Exception;

	// 검색 결과에 따른 회원 수 출력
	public int searchMember(String searchType, String keyword) throws Exception;

	// 관리자 회원 정보 수정
	public void adminMemberModify(MemberDTO memberDTO, MemberAddressDTO memberAddressDTO) throws Exception;

	// 관리자 회원 선택에 따른 정보 가져오기
	public MemberDTO adminSelectMember(String userId) throws Exception;
	public MemberAddressDTO adminSelectAddress(String userId) throws Exception;

	// 관리자 회원 삭제
	public void adminRemoveMember(String userId) throws Exception;

	// ***************************************상품***************************************
	// 전체 상품 불러오기
	public List<ProductDTO> getProductList(int displayTotalContent, int pageContent, String searchType, String keyword) throws Exception;

	// 검색 결과에 따른 상품 수 출력
	public int searchProduct(String searchType, String keyword) throws Exception;
	
	// 관리자 상품 조회
	public ProductDTO adminProductViewPage(String pno) throws Exception;
	
	// 관리자 상품 수정
	public void adminProductModify(ProductDTO productDTO, ProductFileDTO productFileDTO) throws Exception;
	
	// ***************************************그 외***************************************
	// 관리자, 판매자 로그인
	public MemberDTO managerLogin(MemberDTO memberDTO) throws Exception;
}
