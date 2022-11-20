const form = {
	fileUploadPopup(e) {
		const el = e.currentTarget;
		
		/**
			이미지 첨부:  게시글 gid + _images
			파일 첨부  : 게시글 gid + _attached
		 */
		let gid = document.querySelector("input[name='gid']").value;
		let url = "../../file/upload?gid=";
		if (el.classList.contains("image")) { // 이미지 첨부 
			url += `${gid}_images&imageOnly=true`;
		} else { // 일반 첨부 파일
			url += `${gid}_attached`;
		}
		
		layer.open(url, "파일 업로드", 360, 500, true);
	}
};


// 파일 업로드 완료시 호출되는 콜백 함수
function fileUploadCallback(data) {
	if (!data.isSuccess && data.message) { // 오류시에는 진행 X
		return;
	}
	const tpl = document.getElementById("fileTpl").innerHTML;
	const domParser = new DOMParser();
	for (const file of data) {
		
		let targetName = "file_list";
		if (file.gid.indexOf("images") != -1) { // 이미지 첨부
			const img = `<img src='${file.fileUrl}' style="max-width: 700px">`;
			CKEDITOR.instances.content.insertHtml(img);
			targetName = "file_image_list";
		} 
		
		let attachFilesEl = document.getElementById(targetName);
		let html = tpl;
		html = html.replace(/<%=id%>/g, file.id)
						.replace(/<%=fileName%>/g, file.fileName);
		
		const dom = domParser.parseFromString(html, "text/html");
		const liEl = dom.querySelector("li");
		attachFilesEl.append(liEl);
	}
	
	layer.close(); // 파일 업로드 1개가 끝나면 레이어 닫기
}

window.addEventListener("DOMContentLoaded", function() {
	CKEDITOR.replace("content");
	CKEDITOR.config.height=350;
	
	/** 파일 첨부 버튼 클릭시 S */
	const attachFileEls = document.getElementsByClassName("attach_file");
	for (const el of attachFileEls) {
		el.addEventListener("click", form.fileUploadPopup);
	}
	/** 파일 첨부 버튼 클릭시 E */
});