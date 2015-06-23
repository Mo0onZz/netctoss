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
            //保存成功的提示信息
            
            $(function(){
            	stringToDate('#idcardNo','#birthDAte');
            	$('#submitAccount').click(function(){
            		var b = checkForm();
            		if(b){
            			$('#saveAccount').submit();
            		}
            	});
            });
            function checkForm(){
            	//验证名字
            	var b1 = $('#realName').mustfill("必须填写",$('#msg_realName'));
            	var b2 = false;
            	if(b1){
	            	var b2 = $('#realName').nameRange("20长度以内的汉字、字母和数字的组合",$('#msg_realName'));
            	}
				var b3 = false;
            	if(b2){
	            	var b3 = $('#realName').lengthRange(0,20,"30长度以内的字母、数字和下划线的组合",$('#msg_realName'));
            	
            	}
            	//验证电话
            	var b4 =  $('#telephone').mustfill("必须填写","#msg_telephone");
            	var b5 = false;
            	if(b4){
	            	var b5 = $('#telephone').telephoneRange("正确的电话号码格式：手机或固话",$('#msg_telephone'));
            	}
            	var bp6 = false;
            	if($('#chkModiPwd').attr('checked')==false){
            		$('#oldpassword1').val("");
            		$('#newLoginPassWord1').val("");
            		$('#newLoginPassWord2').val("");
            		bp6 =true;
            	}else{
            		var bp0 = $('#oldpassword1').mustfill("如果选中修改密码选项,则必须填写修改内容",$('#msg_oldpassword1'));
            		var bp1 = false;
            		if(bp0){
	            		bp1 = $('#oldpassword1').nameRange("30长度以内的字母、数字和下划线的组合",$('#msg_oldpassword1'));
            		}
            		var bp2 = false;
            		if(bp1){
            			var bp2 = $('#oldpassword1').lengthRange(0,30,"30长度以内的字母、数字和下划线的组合",$('#msg_oldpassword1'));
            		}
            		
            		var bp3 = false;
            		if(bp2){
            			var bp3 =checkCode1($('#oldpassword1'),$('#oldpassword2'),"密码错误" ,"#msg_oldpassword1");
            			
            		}
            		if(!b3){showResultDiv(bp3)}
            		var bp4 = false;
            		if(bp3){
            			var bp4 = $('#newLoginPassWord1').nameRange("30长度以内的字母、数字和下划线的组合",$("#msg_newLoginPassWord1"));
            			
            		}
            		
            		var bp5 = false;
            		if(bp4){
            			var bp5 = $('#newLoginPassWord1').lengthRange(0,30,"30长度以内的字母、数字和下划线的组合",$('#msg_newLoginPassWord1'));
            		}
            		
            		if(bp5){
            			bp6 = checkCode1($('#newLoginPassWord1'),$('#newLoginPassWord2'),"两次密码必须相同",$('#msg_newLoginPassWord2'));
    				}
            	}
            	var bemail = false;
    			if($('#email').val()==null||$('#email').val()==0){
    				bemail = true;
    			}else{
	    			var bemailPattern = $('#email').emailRange("50长度以内，合法的 Email 格式",$('#msg_email'));
	    			var bemailRange = false;
	    			if(bemailPattern){
		    			var bemailRange = $('#email').lengthRange(0,50,"50长度以内，合法的 Email 格式",$('#msg_email'));
	    			}
    				bemail = beailRange;
    			}
    			var baddress = false;
    			if($('#mailAddress').val()==null||$('#mailAddress').val()==0){
    				baddress = true;
    			}else{
    				
    				var ba1 = $('#mailAddress').nameRange("30长度以内的字母、数字和下划线的组合",$("#msg_mailAddress"));
    				var ba2 = false;
    				if(ba1){
    					ba2 = $('#mailAddress').lengthRange(0,50,"50长度以内，合法的 Email 格式",$('#msg_mailAddress'));
    				}
    				baddress = ba2;
    			}
    			var bzipCode = false;
    			if($('#zipCode').val()==null||$('#zipCode').val().length==0){
    				bzipCode = true;
    			}else{
	    			bzipCode =$('#zipCode').intRange(100000,600000,"6位数字",$('#msg_zipCode'));
    			}
    			var bQq = false;
    			if($('#Qq').val()==null||$('#Qq').val().length==0){
    				bQq = true;
    			}else{
	    			bQq =$('#Qq').intRange(10000,1000000000000,"5-13位数字",$('#msg_Qq'));
    			}
    			return bp6&&b3&&bemail&&baddress&&bzipCode&&bQq;
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
            //显示修改密码的信息项
            function showPwd(chkObj) {
                if (chkObj.checked)
                    document.getElementById("divPwds").style.display = "block";
                else
                    document.getElementById("divPwds").style.display = "none";
            }
        </script>
    </head>
    <body>
        <!--Logo区域开始-->
       <s:include value="../product/menu.jsp"></s:include>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">  
            <!--保存成功或者失败的提示消息-->
            <div id="save_result_info" class="save_fail">保存失败，旧密码错误！</div>
            <s:form id="saveAccount"theme="simple" action="ModifyAccount" method="post"  cssClass="main_form">
          
                    <!--必填项-->
                    <div class="text_info clearfix"><span>账务账号ID：</span></div>
                    <div class="input_info">
                        <s:textfield id="accountId" name="account.id" readonly="true" cssClass="readonly" />
                    </div>
                    <div class="text_info clearfix"><span>姓名：</span></div>
                    <div class="input_info">
                        <s:textfield id="realName"name="account.realName"  />
                        <span class="required">*</span>
                        <div id="msg_realName" class="validate_msg_long"></div>
                    </div>
                    <div class="text_info clearfix"><span>身份证：</span></div>
                    <div class="input_info">
                        <s:textfield id="idcardNo" name="account.idcardNo" readonly="true" cssClass="readonly" />
                    </div>
                    <div class="text_info clearfix"><span>登录账号：</span></div>
                    <div class="input_info">
                    <s:textfield id="loginName" name="account.loginName"  readonly="true" cssClass="readonly"/>
                        <div class="change_pwd">
                            <input id="chkModiPwd" type="checkbox" onclick="showPwd(this);" />
                            <label for="chkModiPwd">修改密码</label>
                        </div>
                    </div>
                    <!--修改密码部分-->
                    <div id="divPwds">
                        <div class="text_info clearfix"><span>旧密码：</span></div>
                        <div class="input_info">
                            <input type="password"  id="oldpassword1"/><input id="oldpassword2" type="hidden" value="${account.loginPassWD}"/>
                            <span class="required">*</span>			  
                            <div id="msg_oldpassword1" class="validate_msg_long"></div>
                        </div>
                        <div class="text_info clearfix"><span>新密码：</span></div>
                        <div class="input_info">
                            <input type="password" id="newLoginPassWord1" name="account.loginPassWD"/>
                            <span class="required">*</span>
                            <div id="msg_newLoginPassWord1" class="validate_msg_long" ></div>
                        </div>
                        <div class="text_info clearfix"><span>重复新密码：</span></div>
                        <div class="input_info">
                            <input type="password" id="newLoginPassWord2" />
                            <span class="required">*</span>
                            <div id="msg_newLoginPassWord2" class="validate_msg_long"></div>
                        </div>  
                    </div>                   
                    <div class="text_info clearfix"><span>电话：</span></div>
                    <div class="input_info">
                        <s:textfield id="telephone" name="account.telephone" cssClass="width200"/>
                        <span class="required">*</span>
                        <div id="msg_telephone"class="validate_msg_medium error_msg"></div>
                    </div>
                    <div class="text_info clearfix"><span>推荐人身份证号码：</span></div>
                    <div class="input_info">
                        <s:textfield id="recommenderIdcardNo" name="recommenderIdcardNo" value="等会儿再写"/>
                        <div id="msg_recommenderIdcardNo"class="validate_msg_long error_msgs">正确的身份证号码格式</div>
                    </div>
                    <div class="text_info clearfix"><span>生日：</span></div>
                    <div class="input_info">
                        <s:textfield id="birthDAte" readonly="true" cssClass="readonly" />
                    </div>
                    <div class="text_info clearfix"><span>Email：</span></div>
                    <div class="input_info">
                        <s:textfield id="email" name="account.email" cssClass="width200"/>
                        <div id="msg_email" class="validate_msg_medium"></div>
                    </div> 
                    <div class="text_info clearfix"><span>职业：</span></div>
                    <div class="input_info">
                        <s:select list="zhiye" value="account.occUpation"/>                 
                    </div>
                    <div class="text_info clearfix"><span>性别：</span></div>
                    <div class="input_info fee_type">
                    	<s:radio list="sex" name="account.gender"></s:radio>
                    </div> 
                    <div class="text_info clearfix"><span>通信地址：</span></div>
                    <div class="input_info">
                        <s:textfield id="mailAddress" name="account.mailAddress" cssClass="width350"/>
                        <div id="msg_mailAddress" class="validate_msg_tiny"></div>
                    </div> 
                    <div class="text_info clearfix"><span>邮编：</span></div>
                    <div class="input_info">
                        <s:textfield name="account.zipCode" id="zipCode"/>
                        <div id="msg_zipCode" class="validate_msg_long"></div>
                    </div> 
                    <div  class="text_info clearfix"><span>QQ：</span></div>
                    <div class="input_info">
                        <s:textfield id="Qq" name="account.Qq"/>
                        <div id="msg_Qq" class="validate_msg_long"></div>
                    </div>                
                    <!--操作按钮-->
                    <div class="button_info clearfix">
                        <input type="button" value="保存" class="btn_save" id="submitAccount" />
                        <input type="button" value="取消" class="btn_save" />
                    </div>
     
                </s:form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
            <span>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</span>
            <br />
            <span>版权所有(C)加拿大达内IT培训集团公司 </span>
        </div>
    </body>
</html>
