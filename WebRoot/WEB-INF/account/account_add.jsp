<%@page isELIgnored="false" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>

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
             	
				$('#submitForm').click(function(){
					if(checkForm()){
						$('#saveAccount').submit();
					}
				});
            });
            function checkForm(){
   				var b1 = true;
            	$('#realName,#idcardNo,#loginName,#loginPassWord,#telephone').each(function(i){
            		b1 = $(this).mustfill2("必须填写");
            	});
            	var b15 = false;
            	if(b1){
	            	var b15 = $('#realName').nameRange("20长度以内的汉字、字母和数字的组合",$('#msg_realName'));
            	}
            	var b2 = false;
            	if(b15){
	            	b2 = $('#realName').lengthRange(0,20,"30长度以内的字母、数字和下划线的组合",$('#msg_realName'));
            	}
            	var b8 = false;
            	if(b2){
            	//验证用户名
	            	var b7 = $('#telephone').telephoneRange("正确的电话号码格式：手机或固话",$('#msg_telephone'));
	            	var b3 = $('#idcardNo').idcardRange("正确的身份证号码格式",$('#msg_idcardNo'));
	            	var b4 = $('#loginName').nameRange("30长度以内的字母、数字和下划线的组合",$('#msg_loginName'));
	            	var b5 = $('#loginPassWord').nameRange("30长度以内的字母、数字和下划线的组合",$('#msg_loginPassWord'));
            		if(b3){stringToDate();}
            		b8 = b7&&b3&&b4&&b5;
            	}
            	var b12 = false;
            	if(b8){
            		var b13 = $('#loginName').nameExists("checkLoginName","登录名重复",$('#msg_loginName'));
            		var b14 = $('#idcardNo').nameExists("checkIdcardExists","该身份证已经注册过",$('#msg_idcardNo'));
            		b12 = b13&&b14;
            	}
            	
            	var b9 =false;
            	if(b12){
            		var b10 = $('#loginPassWord').lengthRange(0,30,"30长度以内的字母、数字和下划线的组合",$('#msg_loginPassWord'));
	            	var b11 = $('#loginName').lengthRange(0,30,"30长度以内的字母、数字和下划线的组合",$('#msg_loginName'));
            		b9 = b10&&b11;
            	}
				var b6 = false;
            	if(b9){
            		var b6 = checkCode1($('#loginPassWord'),$('#loginPassWord2'),"两次密码必须相同" ,"#msg_loginPassWord2");
            	}
    /*------------------------------------------可选--------------------------------------------------------*/        	
            	//recommenderId
            	
            	var brec = false;
            	if($('#recommenderId').val()==null||$('#recommenderId').val().length==0){
            		brec = true;
            	}else{
            		brec = $('#recommenderId').idcardRange("错误的身份证号码格式",$('#msg_recommenderId'));
            	}
            	//birthdate
            	//
            	//email
            	var bemail = false;
    			if($('#email').val()==null||$('#email').val()==0){
    				bemail = true;
    			}else{
	    			var bemailPattern = $('#email').emailRange("50长度以内，合法的 Email 格式",$('#msg_email'));
	    			var bemailRange = false;
	    			if(bemailPattern){
		    			var bemailRange = $('#email').lengthRange(0,50,"50长度以内，合法的 Email 格式",$('#msg_email'));
	    			}
    				bemail = bemailRange;
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
    			return b6&&bemail&&baddress&&bzipCode&&bQq;
         } 
    function stringToDate(){
          var str = $('#idcardNo').val();
          var year = str.substring(6,10);
          var month = str.substring(10,12);
          var day = str.substring(12,14);
          var date = new Date(year,day,month);
          var a = date2str(date,'yyyy-MM-dd');
          $('#birthDate').val(a);
   }  	
   function checkCode1(obj1,obj2,msg,obj){
	var code1 = $(obj1).val();
	var code2 = $(obj2).val();
	if(code1==code2){
		$(obj).text("");
		return true;
	}else{
		$(obj).text(msg);
		return false;
	}
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
            //显示选填的信息项
            function showOptionalInfo(imgObj) {
            	
                var div = document.getElementById("optionalInfo");
                if (div.className == "hide") {
                    div.className = "show";
                    imgObj.src = "../images/hide.png";
                }
                else {
                    div.className = "hide";
                    imgObj.src = "../images/show.png";
                }
            }
    $.fn.mustfill2=function(msg){
		var text = this.val();
		if(text==null||text.length==0){
			$('#msg_'+$(this).attr('id')).text(msg);
			return false;
		}else{
			$('#msg_'+$(this).attr('id')).text("");
			return true;
		}
	};
	$.fn.nameRange=function(msg,obj){
		var pattern = /^(?!_)(?!.*?_$)[a-zA-Z0-9_\u4e00-\u9fa5]+$/ ; 
		if(pattern.test(this.val())){
			$(obj).text("");
			return true;
		}else{
			$(obj).text(msg);
			return false;
		}
	};
	$.fn.idcardRange=function(msg,obj){
		var pattern = /(^\d{15}$)|(^\d{17}([0-9]|X)$)/; 
		if(pattern.test(this.val())){
			$(obj).text("");
			return true;
		}else{
			$(obj).text(msg);
			return false;
		}
	}
	$.fn.lengthRange=function(min,max,msg,obj){
		var str1 = this.val();
		if(str1.length>min&&str1.length<=max){
			$(obj).text("");
			return true;
		}else{
			$(obj).text(msg);
			return false;
		}
	};
	$.fn.telephoneRange=function(msg,obj){
		var pattern = /^(\(\d{3,4}\)|\d{3,4}-|\s)?\d{7,14}$/; 
		if(pattern.test(this.val())){
			$(obj).text("");
			return true;
		}else{
			$(obj).text(msg);
			return false;
		}
	}
	$.fn.nameExists=function(url,msg,obj){
		var name = this.attr('name');
		var value=this.val();
		var b = false;
		var obj1 = {};
		obj1[name]=value;
		var str = $.param(obj1);
		$.ajax({
			url:url,
			data:str,
			type:'post',
			dataType:'json',
			async:false,
			success:function(data){
			 if(data){
			 	b=true;
			 	$(obj).text("");
			 }else{
			 	$(obj).text(msg);
			 }
			}
		});
		return b;
	};
	
	$.fn.emailRange=function(msg,obj){
		var pattern =  /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
		if(pattern.test(this.val())){
			$(obj).text("");
			return true;
		}else{
			$(obj).text(msg);
			return false;
		}
	}         	
        </script>
    </head>
    <body>
    	<s:include value="../product/menu.jsp"></s:include>
        <!--Logo区域开始-->
       
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">       
            <!--保存成功或者失败的提示消息-->     
            <div id="save_result_info" class="save_fail">保存失败，该身份证已经开通过账务账号！</div>
            <s:form theme="simple" action="saveAccount" method="post" id="saveAccount" cssClass="main_form">
            
                <!--必填项-->
                <div class="text_info clearfix"><span>姓名：</span></div>
                <div class="input_info">
                    <s:textfield id="realName" name="account.realName" />
                    <span class="required">*</span>
                    <div  class="validate_msg_long" id="msg_realName"></div>
                </div>
                <div class="text_info clearfix"><span>身份证：</span></div>
                <div class="input_info">
                    <s:textfield id="idcardNo" name="account.idcardNo"  />
                    <span class="required">*</span>
                    <div class="validate_msg_long" id="msg_idcardNo"></div>
                </div>
                <div class="text_info clearfix"><span>登录账号：</span></div>
                <div class="input_info">
                    <s:textfield id="loginName" name="account.loginName"  />
                    <span class="required">*</span>
                    <div class="validate_msg_long" id="msg_loginName"></div>
                </div>
                <div class="text_info clearfix"><span>密码：</span></div>
                <div class="input_info">
                    <s:password id="loginPassWord" name="account.loginPassWD"/>
                    <span class="required">*</span>
                    <div class="validate_msg_long" id="msg_loginPassWord"></div>
                </div>
                <div class="text_info clearfix"><span>重复密码：</span></div>
                <div class="input_info">
                    <s:password id="loginPassWord2"  />
                    <span class="required">*</span>
                    <div class="validate_msg_long" id="msg_loginPassWord2"></div>
                </div>     
                <div class="text_info clearfix"><span>电话：</span></div>
                <div class="input_info">
                    <s:textfield id="telephone" name="account.telephone" cssClass="width200"/>
                    <span class="required">*</span>
                    <div id="msg_telephone" class="validate_msg_medium"></div>
                </div>                
                <!--可选项-->
                <div class="text_info clearfix"><span>可选项：</span></div>
<!-- -------------------------------------------可选--------------------------------------------------- -->
                <div class="input_info">
                    <img src="../images/show.png" alt="展开" onclick="showOptionalInfo(this);" />
                </div>
                <div id="optionalInfo" class="hide">
                    <div class="text_info clearfix"><span>推荐人身份证号码：</span></div>
                    <div class="input_info">
                        <s:textfield id="recommenderId" name="recommenderId"/>
                        <div id="msg_recommenderId" class="validate_msg_long"></div>
                    </div>
                    <div class="text_info clearfix"><span>生日：</span></div>
                    <div class="input_info">
                        <input type="text" id="birthDate" name="account.birthDate" readonly class="readonly" />
                    </div>
                    <div class="text_info clearfix"><span>Email：</span></div>
                    <div class="input_info">
                        <s:textfield id="email" cssClass="width350"/>
                        <div id="msg_email" class="validate_msg_tiny"></div>
                    </div> 
                    <div class="text_info clearfix"><span>职业：</span></div>
                    <div class="input_info">
                       <s:select list="zhiye" name="account.occUpation"/>                  
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
                        <s:textfield id="zipCode" name="account.zipCode"/>
                        <div id="msg_zipCode"class="validate_msg_long"></div>
                    </div> 
                    <div class="text_info clearfix"><span>QQ：</span></div>
                    <div class="input_info">
                        <s:textfield id="Qq" name="account.Qq"/>
                        <div id="msg_Qq" class="validate_msg_long"></div>
                    </div>                
                </div>
                <!--操作按钮-->
                <div class="button_info clearfix">
                    <input type="button" value="保存" class="btn_save" id="submitForm" />
                    <input type="button" value="取消" class="btn_save" />
                </div>
            </form>
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
