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
    </head>
    <body>
        <!--Logo区域开始-->
       	<s:include value="../product/menu.jsp"></s:include>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">            
            <form action="" method="" class="main_form">
                <!--必填项-->
                <div class="text_info clearfix"><span>业务账号ID：</span></div>
                <div class="input_info"><s:textfield name="serviceLine.id" readonly="true" cssClass="readonly" /></div>
                <div class="text_info clearfix"><span>账务账号ID：</span></div>
                <div class="input_info"><s:textfield name="serviceLine.accountId" readonly="true" cssClass="readonly" /></div>
                <div class="text_info clearfix"><span>客户姓名：</span></div>
                <div class="input_info"><s:textfield name="serviceLine.realName" readonly="true" cssClass="readonly" /></div>
                <div class="text_info clearfix"><span>身份证号码：</span></div>
                <div class="input_info"><s:textfield name="serviceLine.idcardNo" readonly="true" cssClass="readonly" /></div>
                <div class="text_info clearfix"><span>服务器 IP：</span></div>
                <div class="input_info"><s:textfield name="serviceLine.unixHost" readonly="true" cssClass="readonly" /></div>
                <div class="text_info clearfix"><span>OS 账号：</span></div>
                <div class="input_info"><s:textfield name="serviceLine.osUsername" readonly="true" cssClass="readonly" /></div>
                <div class="text_info clearfix"><span>状态：</span></div>
                <div class="input_info">
                	<s:select list="serviceStatus" name="serviceLine.status" disabled="true"></s:select>
                </div>
                <div class="text_info clearfix"><span>开通时间：</span></div>
                <div class="input_info"><s:textfield name="serviceLine.createDate" readonly="true" cssClass="readonly" /></div>
                <div class="text_info clearfix"><span>资费 ID：</span></div>
                <div class="input_info"><s:textfield name="serviceLine.costId" readonly="true" cssClass="readonly" /></div>
                <div class="text_info clearfix"><span>资费名称：</span></div>
                <div class="input_info"><s:textfield name="serviceLine.costName" readonly="true" cssClass="readonly" /></div>
                <div class="text_info clearfix"><span>资费说明：</span></div>
                <div class="input_info_high">
                	<s:textarea cssClass="width300 height70 readonly" readonly="true" name="serviceLine.descr"></s:textarea>
                </div>  
                <!--操作按钮-->
                <div class="button_info clearfix">
                    <input type="button" value="返回" class="btn_save" onclick="location.href='service_list.html';" />
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
