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
            function submitForm(){
            	var b = checkForm();
            	if(b){
            		$('#saveService').submit();
            	}
            }
            $(function(){
            	$('#searchLoginName').click(function(){
            
            		var b = {};
            		b['idcardNo']=$('#idcard').val();
            		var data = superAjax('getLonginName',b);
            		if(data.loginName==null){
						$('#msg_idcard').text('没有此身份证号，请重新录入。');          		
            		}else{
            		$('#msg_idcard').text('');  
	            		$('#loginName').val(data.loginName);
    	        		$('#accountId').val(data.accountId);
            		}
            	});
            });
            function checkForm(){
            
            	var arguments = {};
            	arguments['loginName']=$('#loginName').val();
            	var b1 = checkLoginName('checkLoginName',arguments);
            	var b2 = $('#unixHost').ipRange("格式错误",$('#msg_unixHost'));
            	var b3 = false;
            	if(b2){
            		var argulments = {};
            		arguments['ip'] =  $('#unixHost').val();
            		var b3 = simpleAjax('checkIp',arguments);
            		if(!b3){
            			$('#msg_unixHost').text("该unix服务器不存在");
            		}else{
            			$('#msg_unixHost').text("");
            		}
            	}
            	var b4 = $('#osUsername').lengthRange(1,8,"8长度以内的字母、数字和下划线的组合",$('#msg_osUsername'));
            	var b5 = false;
            	if(b4){
            		b5 = $('#osUsername').nameRange("不能含有特殊字符",$('#msg_osUsername'));
            	}
            	var b9 = false;
            	if(b5){
            		var osAndIp = {};
            		osAndIp['osUsername']=$('#osUsername').val();
            		osAndIp['unixHost']=$('#unixHost').val();
            		b9 = simpleAjax('checkOsAndIp',osAndIp);
            		if(b9){
            			$('#msg_osUsername').text('可以使用');
            		}else{
            			$('#msg_osUsername').text('该os账号已存在于这台os账号中,请宠幸录入');
            		}
            		
            	}
            	
            	b6 = $('#password').lengthRange(1,30,"30长度以内的字母、数字和下划线的组合",$('#msg_password'));
            	var b7 = false;
            	if(b6){
            		var b7 = $('#password').nameRange("不能含有特殊字符",$('#msg_password'));
            	}
            	b8 = checkCode1($('#password'),$('#password2'),"两次密码必须相同",$('#msg_password2'));
            	return b1&&b3&&b9&&b7&&b8;
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

            //自动查询账务账号
            function searchAccounts(txtObj) {
                //document.getElementById("a1").innerHTML = txtObj.value;
            }
		function checkLoginName(url,arguments){
			var str = $.param(arguments);
			var boo = false;
			$.ajax({
				url:url,
				data:str,
				type:'post',
				dataType:'json',
				async:false,
				success:function(data){
					if(data!=0){
						$('#msg_loginName').text('可以使用');
						$('#accountId').val(data);
						boo = true;
					}else{
						$('#msg_loginName').text('没有此账务账号，请重新录入。');
					}
				}
			});
			return boo;
		}
		function superAjax(url,arguments){
			var a = {};
			
			var str = $.param(arguments);
			$.ajax({
				url:url,
				data:str,
				type:'post',
				dataType:'json',
				async:false,
				success:function(data){
				a['accountId'] = data.accountId;
				a['loginName'] = data.loginName;
			},
				
			});
			return a;
		}
        </script>
    </head>
    <body>
        <!--Logo区域开始-->
        <s:include value="../product/menu.jsp"></s:include>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">
            <!--保存操作的提示信息-->
            <s:debug></s:debug>
            <div id="save_result_info" class="save_fail">保存失败！192.168.0.23服务器上已经开通过 OS 账号 “mary”。</div>
            <form action="serviceAdd" id="saveService" method="post" class="main_form">
                <!--内容项-->
                <div class="text_info clearfix"><span>身份证：</span></div>
                <div class="input_info">
                    <input type="text" id="idcard" value="查询出的结果写入账务账号" class="width180" />
                    <input type="button" id="searchLoginName" value="查询账务账号" class="btn_search_large" />
                    <span class="required">*</span>
                    <div id="msg_idcard" class="validate_msg_short"></div>
                </div>
                <div class="text_info clearfix"><span>账务账号：</span></div>
                <div class="input_info">
                    <input type="text" id="loginName" value="" onkeyup="searchAccounts(this);" />
                    <input type="hidden" name="service.accountId" id="accountId"/>
                    <span class="required">*</span>
                    <div id="msg_loginName"class="validate_msg_long"></div>
                </div>
                <div class="text_info clearfix"><span>资费类型：</span></div>
                <div class="input_info">
                  <s:select list="costSelect" name="service.costId"/>                  
                </div> 
                <div class="text_info clearfix"><span>服务器 IP：</span></div>
                <div class="input_info">
                    <s:textfield id="unixHost" name="service.unixHost"  />
                    <span class="required">*</span>
                    <div id="msg_unixHost"class="validate_msg_long"></div>
                </div>                   
                <div class="text_info clearfix"><span>登录 OS 账号：</span></div>
                <div class="input_info">
                    <s:textfield id="osUsername"name="service.osUsername"  />
                    <span class="required">*</span>
                    <div id="msg_osUsername"class="validate_msg_long"></div>
                </div>
                <div class="text_info clearfix"><span>密码：</span></div>
                <div class="input_info">
                     <s:password id="password" name="service.loginPassWD"/>
                    <span class="required">*</span>
                    <div id="msg_password" class="validate_msg_long"></div>
                </div>
                <div class="text_info clearfix"><span>重复密码：</span></div>
                <div class="input_info">
                    <input type="password" id="password2" />
                    <span class="required">*</span>
                    <div id="msg_password2" class="validate_msg_long"></div>
                </div>     
                <!--操作按钮-->
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
