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
            //保存结果的提示
            function checkForm(){
            	
            	var b1 = $('#name').mustfill("没写呢没写呢没写呢呢",$('#msg_costName'));
            	var b2 = false;
            	if(b1){
            		b2=$('#name').lengthRange(0,50,"50长度的字母、数字、汉字和下划线的组合",$('#msg_costName'));
            	}
            	var b3 = false;
            	if(b2){
            			
            		if($('#name').val()!=$('#oldname').val()){
	            		b3=$('#name').nameExists("checkCostName","重了",$('#msg_costName'));
            		}else{
            			b3=true;
            		}
            	}
            	b4=$('#baseDuration').mustfill("不能为空",$('#msg_baseDuration'));
            	var b5=false;
            	if(b4){
            		b5=$('#baseDuration').intRange(1,600,"1-600之间的整数",$('#msg_baseDuration'));
            	}
            	
            	var b6 = $('#baseCost').mustfill("不能为空",$('#msg_baseCost'));
            	var b7 = false;
            	if(b6){
            		b7 = $('#baseCost').doubleRange(0,99999.99,"0-99999.99之间的数值",$("#msg_baseCost"));
            	}
            	
            	var b8 =  $('#baseCost').mustfill("不能为空",$('#msg_baseCost'));
            	var b9 = false;
            	if(b8){
            		b9 = $('#unitCost').doubleRange(0,99999.99,"0-99999.99之间的数值",$('#msg_unitCost'));
            	}
            	return b3&&b4&&b7&&b9;
            	
            
            }
            $(function(){
            	$('#saveForm').click(function(){
            		var b = checkForm();
            		if(b){
            			$('#costForm').submit();
            			$('#save_result_info').text("保存成功");
            			showResult();
            		}else{
            			$('#save_result_info').text("保存失败");
            			showResult();
            		}
            	});
            });
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

            //切换资费类型
            function feeTypeChange(type) {
                var inputArray = document.getElementById("main").getElementsByTagName("input");
                if (type == 1) {
                    inputArray[5].readonly = true;
                    inputArray[5].value = "";
                    inputArray[5].className += " readonly";
                    inputArray[6].readonly = false;
                    inputArray[6].className = "width100";
                    inputArray[7].readonly = true;
                    inputArray[7].className += " readonly";
                    inputArray[7].value = "";
                }
                else if (type == 2) {
                    inputArray[5].readonly = false;
                    inputArray[5].className = "width100";
                    inputArray[6].readonly = false;
                    inputArray[6].className = "width100";
                    inputArray[7].readonly = false;
                    inputArray[7].className = "width100";
                }
                else if (type == 3) {
                    inputArray[5].readonly = true;
                    inputArray[5].value = "";
                    inputArray[5].className += " readonly";
                    inputArray[6].readonly = true;
                    inputArray[6].value = "";
                    inputArray[6].className += " readonly";
                    inputArray[7].readonly = false;
                    inputArray[7].className = "width100";
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
            <div id="save_result_info" class="save_success">保存成功！</div>
            <s:form id="costForm" action="modifyCost" method="post" cssClass="main_form" theme="simple">
                <div class="text_info clearfix"><span>资费ID：</span></div>
                <div class="input_info"><s:textfield name="cost.id" cssClass="readonly" readonly="true" /></div>
                <div class="text_info clearfix"><span>资费名称：</span></div>
                <div class="input_info">
                    <s:textfield  id="name" name="cost.name" cssClass="width300" /><input type="hidden" id="oldname" value="${cost.name }" />
                    <span class="required">*</span>
                    <div id="msg_costName" class="validate_msg_short"></div>
                </div>
                <div class="text_info clearfix"><span>资费类型：</span></div>
                <div class="input_info fee_type">
                    <input type="radio" name="radFeeType" id="monthly" onclick="feeTypeChange(1);" />
                    <label for="monthly">包月</label>
                    <input type="radio" name="radFeeType" checked="checked" id="package" onclick="feeTypeChange(2);" />
                    <label for="package">套餐</label>
                    <input type="radio" name="radFeeType" id="timeBased" onclick="feeTypeChange(3);" />
                    <label for="timeBased">计时</label>
                </div>
                <div class="text_info clearfix"><span>基本时长：</span></div>
                <div class="input_info">
                    <s:textfield id="baseDuration" name="cost.baseDuration" cssClass="width100" />
                    <span class="info">小时</span>
                    <span class="required">*</span>
                    <div id="msg_baseDuration" class="validate_msg_long"></div>
                </div>
                <div class="text_info clearfix"><span>基本费用：</span></div>
                <div class="input_info">
                    <s:textfield id="baseCost" name="cost.baseCost" cssClass="width100" />
                    <span class="info">元</span>
                    <span class="required">*</span>
                    <div id="msg_baseCost" class="validate_msg_long"></div>
                </div>
                <div class="text_info clearfix"><span>单位费用：</span></div>
                <div class="input_info">
                    <s:textfield id="unitCost" name="cost.unitCost"  cssClass="width100" />
                    <span class="info">元/小时</span>
                    <span class="required">*</span>
                    <div id="msg_unitCost" class="validate_msg_long"></div>
                </div>   
                <div class="text_info clearfix"><span>资费说明：</span></div>
                <div class="input_info_high">
                    <s:textarea cssClass="width300 height70" name="cost.descr">
                    </s:textarea>
                    <div class="validate_msg_short">100长度的字母、数字、汉字和下划线的组合</div>
                </div>                    
                <div class="button_info clearfix">
                    <input type="button" value="保存" class="btn_save"  id="saveForm" />
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
