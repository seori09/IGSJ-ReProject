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
		if (productUrlLocation.includes("/admin/productDetail")) {
			
			// ck에디터 readonly 속성 적용
			toolbarElement.style.display = 'none';

			editor.enableReadOnlyMode('#product_description');
			
			console.log(productUrlLocation);

		}

	})
	.catch(error => {
		console.error(error);
	});