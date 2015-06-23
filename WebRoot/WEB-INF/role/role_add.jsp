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
            //保存成功的提示消息
            $(function(){
            	getResult();
            });
            function submitForm(){
            	var b = checkForm();
            	if(b){
            		$('#saveForm').submit();
            	}
            }
            function showResult() {
                showResultDiv(true);
                window.setTimeout("showResultDiv(false);", 3000);
            }
            function getResult(){
            	var ok = "${ok}"
            	if(ok=="0"){
					$('#save_result_info').html("保存成功");
					showResult();
            	}else if(ok=="1"){
            		$('#save_result_info').html("保存失败，角色名称重复！");
            		showResultDiv(true);
            	}
            }
            function showResultDiv(flag) {
                var divResult = document.getElementById("save_result_info");
                if (flag)
                    divResult.style.display = "block";
                else
                    divResult.style.display = "none";
            }
          	function checkForm(){
          		var b1 = $('#name').mustfill('角色名称不能为空',$('#msg_name'));
          		var b2 = false;
          		if(b1){
          			b2 =  $('#name').nameRange('不能为空，且为20长度的字母、数字和汉字的组合',$('#msg_name'));
				}
				var b3 = $('#privilege li input').selectLowRange('至少选择一项',$('#msg_privilege'));
				return b2&&b3;
          	}
$.fn.selectLowRange=function(msg,obj){
	var b = false;
	$(this).each(function(){
		if($(this).attr('checked')==true){
			b = true;
		}
	});
	if(b){
		$(obj).text("");
	}else{
		$(obj).text(msg);
	}
	return b;
}
          	
        </script>
    </head>
    <body>
        <!--Logo区域开始-->
        <s:include value="../product/menu.jsp"></s:include>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">            
            <!--保存操作后的提示信息：成功或者失败-->
            <div id="save_result_info" class="save_success"></div><!--保存失败，角色名称重复！-->
            <form action="roleAdd" id="saveForm" method="post" class="main_form">
                <div class="text_info clearfix"><span>角色名称：</span></div>
                <div class="input_info">
                    <input type="text" id="name" name="role.name" class="width200" />
                    <span class="required">*</span>
                    <div id="msg_name" class="validate_msg_medium"></div>
                </div>                    
                <div class="text_info clearfix"><span>设置权限：</span></div>
                <div class="input_info_high">
                <s:debug></s:debug>
                    <div class="input_info_scroll">
                        <ul id="privilege">
                        	<s:iterator value="privileges">
                            	<li><input type="checkbox" name="role.roleIds" value="${id}"/>${name }</li>
                            </s:iterator>
                   
                        </ul>
                    </div>
                    <span class="required">*</span>
                    <div id="msg_privilege" class="validate_msg_tiny"></div>
                </div>
                <div class="button_info clearfix">
                    <input type="button" value="保存" class="btn_save" onclick="submitForm();" />
                    <input type="button" value="取消" class="btn_save" onclick="location.href='roleList.action'"/>
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
