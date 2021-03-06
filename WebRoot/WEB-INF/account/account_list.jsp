﻿<%@page isELIgnored="false" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
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
            //删除
            $(function(){
            	$('#goList').click(function(){
            		$('#goFind').submit();
            	});
            });
            function goPage(page){
           
            	$('#goFind').attr('action','AccountListConditions?page='+page);
            	$('#goFind').submit();
            }
            function deleteAccount(id) {
            	 var r = window.confirm("确定要删除此账务账号吗？\r\n删除后将不能恢复，且会删除其下属的所有业务账号。\r\n"+id);
                if(r){
                	$.ajax({
                		url:'deleteAccount?id='+id,
                		type:'get',
                		dataType:'json',
                		async:false,
                		success:function(data){
                			if(data){
                				$("#msg_delete").text('删除成功,并删除旗下属的所有业务账号');
               					document.getElementById("operate_result_info").style.display = "block";
                			}else{
                				$("#msg_delete").text('删除失败');
                				$("#operate_result_info").show();
               
                			}
                		}
                	});
                }
               
            }
            function stopAccount(id){
            
            }
            //开通或暂停
            function stopAccount(id) {
                var r = window.confirm("确定要停止此账务账号吗?会停止其下属所有业务账号\r\n"+id);
               	if(r){
               		var arguments = {};
               		arguments['id'] = id;
               		if(simpleAjax('stopAccount',arguments)){
               			$('#msg_delete').text(" 暂停成功，且已暂停其下属的业务账号！");
	                	document.getElementById("operate_result_info").style.display = "block";
               		}else{
               			$('#msg_delete').text("暂停失败");
               			document.getElementById("operate_result_info").style.display = "block";
               		}
               	
               	}
            }
            function startAccount(id) {
                var r = window.confirm("确定要开通此账务账号吗？\r\n"+id);
               	if(r){
               		var arguments = {};
               		arguments['id'] = id;
               		if(simpleAjax('startAccount',arguments)){
               			$('#msg_delete').text("开通成功，其下属的业务账号需要手动开通！");
	                	document.getElementById("operate_result_info").style.display = "block";
               			
               		}else{
               			$('#msg_delete').text("开通失败");
               			document.getElementById("operate_result_info").style.display = "block";
               		}
               	
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
            <form action="AccountListConditions" id="goFind" method="post">
                <!--查询-->
                <div class="search_add">                        
                    <div>身份证：<s:textfield name="likeConditions.IDCARD_NO" cssClass="text_search" /></div>                            
                    <div>姓名：<s:textfield name="likeConditions.REAL_NAME" cssClass="width70 text_search"  /></div>
                    <div>登录名：<s:textfield name="likeConditions.LOGIN_NAME"  cssClass="text_search" /></div>
                    <div>
                    
                        状态：			<s:select list="AccountStatus" name="likeConditions.STATUS" cssClass="select_search"/>
                     <!--   <select class="select_search">
                            <option>全部</option>
                            <option>开通</option>
                            <option>暂停</option>
                            <option>删除</option>
                        </select> --> 
                    </div>
                    <div><input type="submit" value="搜索" id="#goList" class="btn_search" /></div>
                    <input type="button" value="增加" class="btn_add" onclick="location.href='accountAddForm.action';" />
                </div>  
                <!--删除等的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="../images/close.png" onclick="this.parentNode.style.display='none'; goPage(${page});" />
                    <span id="msg_delete"></span>
                </div>   
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                    <tr>
                        <th>账号ID</th>
                        <th>姓名</th>
                        <th class="width150">身份证</th>
                        <th>登录名</th>
                        <th>状态</th>
                        <th class="width100">创建日期</th>
                        <th class="width150">上次登录时间</th>                                                        
                        <th class="width200"></th>
                    </tr>
           
                    <s:iterator value="accounts">
                    <tr>
                        <td><s:property value="id"/></td>
                        <td><a href="accountDetail.action?id=${id }"><s:property value="realName"/></a></td>
                        <td><s:property value="idcardNo"/></td>
                        <td><s:property value="loginName"/></td>
                        <td><s:property value="accountStatus[status]"/></td>
                        
                        <td><s:date name="createDate" format="yyyy/MM/dd "/></td>
                        <td><s:date name="lastLoginTime" format="yyyy/MM/dd HH:mm:ss"/></td>
                                                    
                        <td class="td_modi">
                        	<s:if test="status==1">
	                            <input type="button" value="暂停" class="btn_pause" onclick="stopAccount(${id});" />
                        		 <input type="button" value="修改" class="btn_modify" onclick="location.href='ModifyAccountForm?id='+${id};" />
                           		<input type="button" value="删除" class="btn_delete" onclick="deleteAccount(${id});" />
                        	</s:if>
                        	<s:elseif test="status==2">
                        	
                        	</s:elseif>
                        	<s:else>
                        		 <input type="button" value="开通" class="btn_start" onclick="startAccount(${id});" />
	                            <input type="button" value="修改" class="btn_modify" onclick="location.href='ModifyAccountForm?id='+${id};" />
                        		<input type="button" value="删除" class="btn_delete" onclick="deleteAccount(${id});" />
                        	</s:else>
                        </td>
                    </tr>
                    </s:iterator>
                    
                </table>
                <p>业务说明：<br />
                1、创建则开通，记载创建时间；<br />
                2、暂停后，记载暂停时间；<br />
                3、重新开通后，删除暂停时间；<br />
                4、删除后，记载删除时间，标示为删除，不能再开通、修改、删除；<br />
                5、暂停账务账号，同时暂停下属的所有业务账号；<br />                
                6、暂停后重新开通账务账号，并不同时开启下属的所有业务账号，需要在业务账号管理中单独开启；<br />
                7、删除账务账号，同时删除下属的所有业务账号。</p>
                <s:debug></s:debug>
                </div>                   
                <!--分页-->
                    <div id="pages">
                    <a href="AccountListConditions?page=1">首页</a>
                    <s:if test="page==1">
                    	上一页
                    </s:if>
                    <s:else>
        	        <a href="AccountListConditions?page=${page-1}">上一页</a>
                    </s:else>
                	<s:iterator begin="1" end="totalpages" >
                		<s:if test="page==top">
		                    <a href="javascript:;"  onclick="goPage(${top});" class="current_page"><s:property value="top"/></a>
                		</s:if>
                		<s:else>
                			<a href="javascript:;" onclick="goPage(${top});"><s:property value="top"/></a>
                		</s:else>
                	</s:iterator>
                	<s:if test="page<totalpages">
        	        <a href="AccountListConditions?page=${page+1}" >下一页</a>
                    </s:if>
                    <s:else>
                    	下一页
                    </s:else>
                    <a href="AccountListConditions?page=${totalpages }">末页</a>
                </div> 
                
                              
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
            <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
            <p>版权所有(C)加拿大达内IT培训集团公司 </p>
        </div>
    </body>
</html>
