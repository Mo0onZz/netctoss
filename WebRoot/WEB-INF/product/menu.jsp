<%@page isELIgnored="false" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
 <html>
	 <head>
	  	<link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" /> 
	 	<script type="text/javascript">
	 		$(function(){
	 				var a = "<%=request.getRequestURI()%>";
	 			$('#menu a').each(function(i){
	 				if(a.indexOf($(this).attr('id'))>0){
		 				$(this).removeClass($(this).attr('id')+'off');	
			 			$(this).addClass($(this).attr('id')+'on');
	 				}
	 			});
	 			
	 		});
	 	</script>
	 </head>
	 <body>
	    <div id="header">
	            <img src="../images/logo.png" alt="logo" class="left"/>
	            <a href="#">[退出]</a>            
	        </div>
	        <s:debug></s:debug>
	        <!--Logo区域结束-->
	        <!--导航区域开始-->
	        <div id="navi">                        
	            <ul id="menu">
	                <li><a id="index_" href="/login/main.action" class="index_off"></a></li>
	                <li><a id="role_" href="/netctoss/role/roleList.action" class="role_off"></a></li>
	                <li><a id="admin_" href="/netctoss/admin/adminList.action" class="admin_off"></a></li>
	                <li><a id="fee_" href="/netctoss/cost/costList.action" class="fee_off"></a></li>
	                <li><a id="account_" href="/netctoss/account/AccountListConditions" class="account_off"></a></li>
	                <li><a id="service_" href="/netctoss/service/serviceList.action" class="service_off"></a></li>
	                <li><a id="bill_" href="../bill/bill_list.html" class="bill_off"></a></li>
	                <li><a id="report_" href="../report/report_list.html" class="report_off"></a></li>
	                <li><a id="information_" href="../user/user_info.html" class="information_off"></a></li>
	                <li><a id="passwoed_" href="../user/user_modi_pwd.html" class="password_off"></a></li>
	            </ul>            
	        </div>
	</body>
 </html>