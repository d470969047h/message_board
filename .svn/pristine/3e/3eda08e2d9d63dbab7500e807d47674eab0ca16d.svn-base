function gotoPage(maxPageNum){
	var pageNumValue=document.getElementById("pageNum").value;
		if(null==pageNumValue||pageNumValue.length<1){
			alert('请正确的页数！');
			document.getElementById("pageNum").focus();
			return false;
		}
		
		if((pageNumValue>maxPageNum)||(pageNumValue<1)){
			alert('请正确的页数！');
			document.getElementById("pageNum").focus();
			return false;
		}
				
		window.location.href="index.jsp?pageNum="+pageNumValue;
		
}
