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

       	
        <script type="text/javascript">

            //保存结果的提示
             $(function(){
            	$('#sub_bon').click(function(){
            		
            		var b = validataform();
            		if(b){
		            	$("#saveCost").submit();
            		}
            	});
            });
            function validataform(){
            	var b1 = $('#name').mustfill("资费名称必须填写",$("#mag_validataname"));
            	
            	var b2=false;
            	if(b1){
            		b2=$('#name').lengthRange(0,10,"长度必须在0-50之间",$("#mag_validataname"));
            	}
            	var b3 = false;
            	if(b2){
            	 	b3 = $('#name').nameExists("checkCostName","资费名称已存在",$("#mag_validataname"));
            	}
            	var b4= $('#baseDuration').mustfill("基本时常必须填写",$("#msg_baseDuration"));
            	var b5 = false;
            	if(b4){
            		b5=$('#baseDuration').intRange(0,600,"必须在1-600之间的整数",$("#msg_baseDuration"));
            	}
            	b6=$('#baseCost').mustfill("这东西必须写",$("#msg_baseCost"));
            	var b7 = false;
            	if(b6){
            		b7 = $('#baseCost').doubleRange(0,99999.99,"0-99999.99之间的数值",$("#msg_baseCost"));
            	}
            	b8=$('#unitCost').mustfill("这东西必须写",$("#msg_unitCost"));
            	var b9 = false;
            	if(b8){
            		b9 =  $('#unitCost').doubleRange(0,999.99,"0-999.99之间的数值",$("#msg_unitCost"));
            	}
            	
            	
            	return b3&&b4&&b7&&b9;
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

            //切换资费类型
            function feeTypeChange(type) {
                var inputArray = document.getElementById("main").getElementsByTagName("input");
                if (type == 1) {
                    inputArray[4].readonly = true;
                    inputArray[4].value = "";
                    inputArray[4].className += " readonly";
                    inputArray[5].readonly = false;
                    inputArray[5].className = "width100";
                    inputArray[6].readonly = true;
                    inputArray[6].className += " readonly";
                    inputArray[6].value = "";
                }
                else if (type == 2) {
                    inputArray[4].readonly = false;
                    inputArray[4].className = "width100";
                    inputArray[5].readonly = false;
                    inputArray[5].className = "width100";
                    inputArray[6].readonly = false;
                    inputArray[6].className = "width100";
                }
                else if (type == 3) {
                    inputArray[4].readonly = true;
                    inputArray[4].value = "";
                    inputArray[4].className += " readonly";
                    inputArray[5].readonly = true;
                    inputArray[5].value = "";
                    inputArray[5].className += " readonly";
                    inputArray[6].readonly = false;
                    inputArray[6].className = "width100";
                }
            }
            
$.fn.mustfill=function(msg,obj){
	var text = this.val();
	
	if(text==null||text.length==0){
		$(obj).text(msg);
		return false;
	}else{
		$(obj).text("");
		return true;
	}
};
$.fn.nameExists=function(url,msg,obj){
	var name = this.attr('name');
	var value=this.val();
	var b = false;
	var obj = {};
	obj[name]=value;
	var str = $.param(obj);
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
$.fn.intRange=function(min,max,msg,obj){

	var str = this.val();
	
	var pattern = /^[0-9]\d*$/;
	
	var b = false;
	
	if(pattern.test(str)){
	
		var num = parseInt(str);
		if(num>min&&num<=max){
			b=true;
		}
	}

	if(b){
		
		$(obj).text("");
	}else{
		$(obj).text(msg);
	}
}


$.fn.lengthRange=function(min,max,msg,obj){
	var str = this.val();
	if(str.length>min&&str.length<=max){
			
			$(obj).text("");
			
			return true;
		}else{
			
			$(obj).text(msg);
			return false;
		}
}
$.fn.doubleRange=function(min,max,msg,obj){
	var str = this.val();
	var pattern = /^[1-9]\d*\.\d*|0\d*[1-9]\d*$/;
	var b = false;
	if(pattern.test(str)){
		var num = parseFloat(str);
		if(num>0&&num<99999.99){
			b=true;
		}
	}
	if(b){
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
        <!--Logo区域开始-->
        <s:include value="../product/menu.jsp"></s:include>
        <s:debug></s:debug>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">            
            <div id="save_result_info" class="save_fail">保存失败，资费名称重复！</div>
            <s:form id="saveCost" name="form" action="saveNewCost" method="post" cssClass="main_form" theme="simple">
        
                <div class="text_info clearfix"><span>资费名称：</span></div>
                <div class="input_info">
                	<s:textfield id="name" name="cost.name" cssClass="width300"/>
                    <span class="required">*</span>
                    <div id="mag_validataname" class="validate_msg_short"></div>
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
                	<s:textfield id="baseDuration" name="cost.baseDuration" cssClass="width100"/>
                    
                    <span class="info">小时</span>
                    <span class="required">*</span>
                    <div id="msg_baseDuration"class="validate_msg_long"></div>
                </div>
                <div class="text_info clearfix"><span>基本费用：</span></div>
                <div class="input_info">
                	<s:textfield id="baseCost" name="cost.baseCost"cssClass="width100"/>
                    <span class="info">元</span>
                    <span class="required">*</span>
                    <div id="msg_baseCost" class="validate_msg_long error_msg"></div>
                </div>
                <div class="text_info clearfix"><span>单位费用：</span></div>
                <div class="input_info">
                	<s:textfield id="unitCost" name="cost.unitCost" cssClass="width100"/>
                    <span class="info">元/小时</span>
                    <span class="required">*</span>
                    <div id="msg_unitCost" class="validate_msg_long error_msg"></div>
                </div>
                <div class="text_info clearfix"><span>资费说明：</span></div>
                <div class="input_info_high">
                    <textarea id="descr" name="cost.descr" rows="4" cols="40"><s:property value="cost.descr"/></textarea>
                    <div class="validate_msg_short error_msg">100长度的字母、数字、汉字和下划线的组合</div>
                </div>                    
                <div class="button_info clearfix">
                    <input id="sub_bon" type="button" value="保存" class="btn_save"   />
                    <input type="button" value="取消" class="btn_save" onclick="$('#saveCost').submit();"/>
                    <s:submit value="sdf "></s:submit>
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
