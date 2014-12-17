function check_reg_valid(){
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
		
		var userpass1=document.getElementById("userpass1").value;
		if(null==userpass1||userpass1.length<1){
			alert('请输入密码！');
			document.getElementById("userpass1").focus();
			return false;
		}
		
		if(userpass!=userpass1){
			alert('两次密码输入不一致，请重新输入！');
			document.getElementById("userpass").focus();
			return false;
		}
		
		var pass_question=document.getElementById("pass_question").value;
		if(null==pass_question||pass_question.length<1){
			alert('请输入密码保护问题！');
			document.getElementById("pass_question").focus();
			return false;
		}
		
		var pass_ques_answer=document.getElementById("pass_ques_answer").value;
		if(null==pass_ques_answer||pass_ques_answer.length<1){
			alert('请输入密码保护问题的答案！');
			document.getElementById("pass_ques_answer").focus();
			return false;
		}
		
		var birthday=document.getElementById("birthday").value;
		if(null==birthday||birthday.length<1){
			alert('请输入出生日期！');
			document.getElementById("birthday").focus();
			return false;
		}
		
		var sex_type_code=document.getElementById("sex_type_code").value;
		if(null==sex_type_code||sex_type_code.length<1){
			alert('请输入你的性别！');
			document.getElementById("sex_type_code").focus();
			return false;
		}
		
		var nick_name=document.getElementById("nick_name").value;
		if(null==nick_name||nick_name.length<1){
			alert('请输入昵称！');
			document.getElementById("nick_name").focus();
			return false;
		}
		
		var ques_email_addr=document.getElementById("ques_email_addr").value;
		if(null==ques_email_addr||ques_email_addr.length<1){
			alert('请输入密保邮箱！');
			document.getElementById("ques_email_addr").focus();
			return false;
		}
		
		var validcodeValue=document.getElementById("validcode").value;
		if(null==validcodeValue||validcodeValue.length!=4){
			alert('请输入正确验证码！');
			document.getElementById("validcode").focus();
			return false;
		}
		
			if(document.getElementById("agree").checked==false){
			alert('服务条款未同意，不能注册哦！');
			document.getElementById("agree").focus();
			return false;
		}		
			
		document.forms[0].submit();	
}

	function reload_valid_image(){
		document.getElementById("validImage").src="validCode.jsp?r="+Math.random();
	}
	
	$(document).ready(function(){
		$("#username").blur(function(){
			$.ajax({
				type:"post",
				url:"checkesernameuniqu.jsp",
				dataType:'json',
				data:'username'+$("#username").val(),
				success:call_back_function		
			});
		});
	});
	
	function call_back_function(json){
		if(json.status==true){
			alert(json.msg);
			$("#username").focus();
		}
	}
	
		