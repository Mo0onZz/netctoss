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
            	
            	if(checkForm()){
            		$('#saveMofify').submit();
            	}
            }
            function checkForm(){
            	return checkCost($('#costId'),$('#oldCostId'),"请修改资费类型，或者取消修改操作。",$('#msg_costId'));
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
function checkCost(obj1,obj2,msg,obj){
	var code1 = $(obj1).val();
	var code2 = $(obj2).val();
	if(code1==code2){
		$(obj).text(msg);
		return false;
	}else{
		$(obj).text("");
		return true;
	}
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
            <div id="save_result_info" class="save_fail">资费修改失败！数据并发错误。</div>
            <form action="serviceModify" id="saveMofify" method="post" class="main_form">
                <!--必填项-->
                <div class="text_info clearfix"><span>业务账号ID：</span></div>
                <div class="input_info">
                    <input type="text" name="service.id" value="${service.id }" readonly class="readonly" />
                </div>
                <div class="text_info clearfix"><span>OS 账号：</span></div>
                <div class="input_info">
                    <input type="text" name="service.osUsername" value="${service.osUsername }" readonly class="readonly" />
                </div>
                <div class="text_info clearfix"><span>服务器 IP：</span></div>
                <div class="input_info">
                    <input type="text" name="service.unixHost" value="${service.unixHost }" readonly class="readonly" />
                </div>
                <div class="text_info clearfix"><span>资费类型：</span></div>
                <div class="input_info">
                	<s:select id="costId" name="service.costId" list="costSelect" value="service.costId"/>
                  <!--   <select class="width150">
                        <option>包 20 小时</option>
                        <option>包 40 小时</option>
                        <option>包 60 小时</option>
                        <option>包月</option>
                    </select> -->
                    <div id="msg_costId" class="validate_msg_long"></div>    
                    <input type="hidden" id="oldCostId" value="${service.costId}"/>                  
                </div>
                <!--操作按钮-->
                <div class="button_info clearfix">
                    <input type="button" value="保存" class="btn_save" onclick="submitForm();" />
                    <input type="button" value="取消" class="btn_save" onclick="window.location.href='serviceList.action';"/>
                </div>
				<input type="hidden" value="dsfsdf"/>
				<s:hidden name="sdfsdf" value="sdf"/>
                
                <p>业务说明：<br />
                1、修改资费后，点击保存，并未真正修改数据库中的数据；<br />
                2、提交操作到消息队列；<br />
                3、每月月底由程序自动完成业务所关联的资费；</p>
                
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
