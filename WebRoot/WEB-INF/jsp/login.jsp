<%@page isELIgnored="false" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>达内－NetCTOSS</title>
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" /> 
    	<script type="text/javascript" src="../js/jquery-1.4.3.js"></script>
    	<script type="text/javascript" src="../js/validate.js"></script>
    	<script type="text/javascript">
    		$(function(){
    			$('#submitForm').click(function(){
    				var b1 = $('#adminname').mustfill("账号不能为空",$('#msg_name'));
    				var b2 = $('#password').mustfill("密码不能为空",$('#msg_password'));
    				var code1 = $('#code').val();
    				var obj = {}
    				obj['code'] = code1;
    				var b = simpleAjax('checkCode',obj);
    				if(b){
    					$('#msg_code').text("");
    				}else{
    					$('#msg_code').text("验证码错误");
    				}
    				if(b&&b1&&b2){
    					$('#go').submit();
    				}
    			});
    		});
    	</script>
    </head>
   	
    <body class="index">
        <div class="login_box">
        <form id="go" action="login.action" method="post">
            <table>
                <tr>
                    <td class="login_info">账号：</td>
                    <td colspan="2"><input id="adminname" type="text" name="admin.adminCode" class="width150" /></td>
                    <td class="login_error_info"><span id="msg_name" class="required"></span></td>
                </tr>
                <tr>
                    <td class="login_info">密码：</td>
                    <td colspan="2"><input id="password" name="admin.password"  type="password" class="width150" /></td>
                    <td><span class="required" id = "msg_password" ></span></td>
                </tr>
                <tr>
                    <td class="login_info">验证码：</td>
                    <td class="width70"><input id="code" type="text" class="width70" /></td>
                    <td><img src="code.action" onclick="this.src='code?a='+(new Date()).getTime();" alt="验证码" title="点击更换" /></td>  
                    <td><span class="required" id="msg_code"></span></td>              
                </tr>            
                <tr>
                    <td></td>
                    <td class="login_button" colspan="2">
                        <a href="javascript:;" id="submitForm"><img src="../images/login_btn.png" /></a>
                    </td>    
                    <td><span class="required"><s:property value="msg_login"/></span></td>                
                </tr>
            </table>
            </form>
        </div>
    </body>
</html>
