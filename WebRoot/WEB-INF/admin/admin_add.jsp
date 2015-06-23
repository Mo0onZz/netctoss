<%@page isELIgnored="false" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>达内－NetCTOSS</title>
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" />
       	<script type="text/javascript" src="../js/jquery-1.4.3.js"></script>
        <script type="text/javascript" src="../js/validate.js"></script>
       	
        <script language="javascript" type="text/javascript">
            //保存成功的提示消息
            function submitForm(){
            	var b = checkForm();
            	alert(b);
            	if(b){
            		$('#saveForm').submit();
            	}
            
            }
            $(function(){
            	var status = "${status}";
            	if(status=="1"){
            		$('#save_result_info').text('保存成功');
            		 showResult();
            	}else if(status=="0"){
            		$('#save_result_info').text('保存失败，存入数据库时出现错误');
            		 showResult();
            	}	
            });
            function checkForm(){
            	var booName = checkName();
            	var booCode = checkAdminCode();
            	var booPassWD = checkPassword();
            	var booTelephone = checkTelephone();
            	var booEmail = checkEmail();
            	var booRole =  checkRole();
            	return booName&&booCode&&booPassWD&&booTelephone&&booEmail&&booRole;
            }
            function checkName(){
            	var b1 = $('#name').mustfill('姓名不能为空',$('#msg_name'));
				var b2 = false;
				if(b1){
					b2 = $('#name').nameRange('必须是20长度以内的汉字、字母、数字的组合',$('#msg_name'));
				}
				var b3 = false;
				if(b2){
					b3 = $('#name').lengthRange(1,20,'必须是20长度以内的汉字、字母、数字的组合',$('#msg_name'));
				}
				return b3 ;
            }
            function checkAdminCode(){
            	var b1 = $('#adminCode').mustfill('管理员账号不能为空',$('#msg_adminCode'));
            	var b2 = false;
            	if(b1){
	            	b2 = $('#adminCode').nameRange('30长度以内的字母、数字和下划线的组合',$('#msg_adminCode'));
            	}
				var b3 = false;
				if(b2){
					b3 = $('#adminCode').lengthRange(1,30,'30长度以内的字母、数字和下划线的组合',$('#msg_adminCode'));
				}
				var b4 = false;
			
				if(b3){
					b4 = $('#adminCode').nameExists('checkAdminCode.action','管理员账号已存在',$('#msg_adminCode'));
				}           
				return b4;
            }
            function checkPassword(){
            	var b1 = $('#password').mustfill('密码不能为空',$('#msg_password'));
            	var b2 =false;
            	if(b1){
	            	b2 = $('#password').nameRange('必须30长度以内的字母、数字和下划线的组合',$('#msg_password'));
            	}
            	var b3 = false;
            	if(b2){
            		b3 = $('#password').lengthRange(1,30,'30长度以内的字母、数字和下划线的组合',$('#msg_password'));
            	}
            	var b4 = false;
            	if(b3){
            		b4 = checkCode1($('#password'),$('#password2'),'两次密码必须相同',$('#msg_password2'));
            	}
            	return b4;
            }
            function checkTelephone(){
           		var b1 = $('#telephone').mustfill('电话号码必须填写',$('#msg_telephone'));
           		var b2 = false;
           		if(b1){
           			b2 = $('#telephone').telephoneRange('正确的电话号码格式：手机或固话',$('#msg_telephone'));
           		}
           		return b2;
            }
            function checkEmail(){
            	var b1 = $('#email').mustfill('email必须填写',$('#msg_email'));
            	var b2 = false;
            	if(b1){
            		b2 = $('#email').emailRange('50长度以内，正确的 email 格式',$('#msg_email'));
            	}
            	return b2;
            }
            function checkRole(){
            	var b1 = $('#role :checkbox').checkboxRange('至少选择一个',$('#msg_role'));
            	return b1;
            }
            
            
            
            
            
            
            function showResult() {
                showResultDiv(true);
                window.setTimeout("showResultDiv(false);", 3000);
            }
            function showResultDiv(flag) {
                var divResult = document.getElementById("save_result_info");
                if (flag)
                    divResult.style.display = "block";
                else
                    divResult.style.display = "none";
            }
        </script>
    </head>
    <body>
        <!--Logo区域开始-->
		<s:include value="../product/menu.jsp"></s:include>        
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">            
            <div id="save_result_info" class="save_success"></div>
            <form id="saveForm" action="adminAdd" method="post" class="main_form">
                    <div class="text_info clearfix"><span>姓名：</span></div>
                    <div class="input_info">
                        <input id="name" name="admin.name" type="text" />
                        <span class="required">*</span>
                        <div id="msg_name" class="validate_msg_long"></div>
                    </div>
                    <div class="text_info clearfix"><span>管理员账号：</span></div>
                    <div class="input_info">
                        <input id="adminCode" name="admin.adminCode" type="text"  />
                        <span class="required">*</span>
                        <div id="msg_adminCode" class="validate_msg_long"></div>
                    </div>
                    <div class="text_info clearfix"><span>密码：</span></div>
                    <div class="input_info">
                        <input id="password" name="admin.password" type="password"  />
                        <span class="required">*</span>
                        <div id="msg_password" class="validate_msg_long error_msg"></div>
                    </div>
                    <div class="text_info clearfix"><span>重复密码：</span></div>
                    <div  class="input_info">
                        <input id="password2" type="password"  />
                        <span class="required">*</span>
                        <div id="msg_password2" class="validate_msg_long error_msg"></div>
                    </div>      
                    <div class="text_info clearfix"><span>电话：</span></div>
                    <div class="input_info">
                        <input id="telephone" name="admin.telephone" type="text" class="width200"/>
                        <span class="required">*</span>
                        <div id="msg_telephone" class="validate_msg_medium error_msg"></div>
                    </div>
                    <div class="text_info clearfix"><span>Email：</span></div>
                    <div class="input_info">
                        <input id="email" name="admin.email" type="text" class="width200"/>
                        <span class="required">*</span>
                        <div id="msg_email" class="validate_msg_medium error_msg"></div>
                    </div>
                    <div class="text_info clearfix"><span>角色：</span></div>
                    <div class="input_info_high">
                        <div class="input_info_scroll">
                            <ul id="role">
                            	<s:iterator value="roles">
	                                <li><input type="checkbox" value="${id }" name="admin.roles" /><s:property value="name"/></li>
                            	
                            	</s:iterator>
                            </ul>
                        </div>
                        <span class="required">*</span>
                        <div id="msg_role" class="validate_msg_tiny error_msg"></div>
                    </div>
                    <div class="button_info clearfix">
                        <input type="button" value="保存" class="btn_save" onclick="submitForm();" />
                        <input type="button" value="取消" class="btn_save" />
                    </div>
                </form>  
        </div>
        <!--主要区域结束-->
        <div id="footer">
            <span>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</span>
            <br />
            <span>版权所有(C)加拿大达内IT培训集团公司 </span>
        </div>
    </body>
</html>
