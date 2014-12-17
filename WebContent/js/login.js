function check_login_valid(){
	var username=document.getElementById("username").value;
		if(null==username||username.length<1){
			alert('请输入用户名！');
			document.getElementById("username").focus();
			return false;
		}
		
		var userpass=document.getElementById("userpass").value;
		if(null==userpass||userpass.length<1){
			alert('请输入密码！');
			document.getElementById("userpass").focus();
			return false;
		}
		
		var validcodeValue=document.getElementById("validcode").value;
		if(null==validcodeValue||validcodeValue.length!=4){
			alert('请输入正确验证码！');
			document.getElementById("validcode").focus();
			return false;
		}	
			
		document.forms[0].submit();	
}

	function reload_valid_image(){
		document.getElementById("validImage").src="validCode.jsp?r="+Math.random();
	}
			