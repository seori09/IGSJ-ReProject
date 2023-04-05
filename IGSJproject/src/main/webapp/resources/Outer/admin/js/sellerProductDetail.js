//ck에디터 적용
var myEditor;
ClassicEditor
	.create(document.querySelector('#product_description'), {

		removePlugins: ['Heading'],
		language: "ko"

	})
	.then(editor => {
		
		// 현재 페이지 위치
		let productUrlLocation = window.location.href;
		
		// ck에디터 툴바 선택
		const toolbarElement = editor.ui.view.toolbar.element;
		
		// 현재 페이지 위치에 따라서 ck에디터 보여지는게 달라짐
		if (productUrlLocation.includes("/seller/productDetail")) {
			
			// ck에디터 readonly 속성 적용
			toolbarElement.style.display = 'none';

			editor.enableReadOnlyMode('#product_description');
			
			console.log(productUrlLocation);

		}

	})
	.catch(error => {
		console.error(error);
	});

// 상품 삭제	
function RemoveProduct(pno) {
	
	let removeYN = confirm("상품을 삭제하시겠습니까?");
	
	if(removeYN){
			
		
		$.ajax({
			url : "/seller/removeProduct",
			type : "post",
			data : {
				"pno" : pno
			},
			dataType : "json",
			success : function(result){
				if(result == true){
	
					alert("상품 삭제가 완료되었습니다.");	
					location.href = "/seller/productlist?pageNum=1";
					
				}			
			},
			error : function(error){
				
				alert("알 수 없는 오류로 상품 삭제에 실패하였습니다.");
				

			}
		})
		
		
	} else {
		alert("상품 삭제가 취소되었습니다.");
		
		return false;
	}
}