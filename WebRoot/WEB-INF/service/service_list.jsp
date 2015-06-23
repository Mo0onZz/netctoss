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
            //显示角色详细信息
            function goFind(page){
            	$('#List').attr('action','serviceList?page='+page);
            	searchSubmit();
            }
            function searchSubmit(){
            	$('#List').submit();
            }
            function showDetail(flag, a) {
            	
                var detailDiv = a.parentNode.getElementsByTagName("div")[0];
                if (flag) {
                    detailDiv.style.display = "block";
                }
                else
                    detailDiv.style.display = "none";
            }
            //删除
            function deleteAccount(id) {
                var r = window.confirm("确定要删除此业务账号吗？删除后将不能恢复。");
                	var arguments = {};
                	arguments['id'] = id;
                if(deleteData('serviceDelete',arguments)){
                	$('#msg_delete').text("删除成功");
	                document.getElementById("operate_result_info").style.display = "block";
	               
                }else{
                	$('#msg_delete').text('删除失败');
                	  document.getElementById("operate_result_info").style.display = "block";
                }
            }
            //开通或暂停
			  function stopService(id) {
                var r = window.confirm("确定要停止此业务账号\r\n"+id);
               	if(r){
               		var arguments = {};
               		arguments['id'] = id;
               		if(simpleAjax('stopService',arguments)){
               			$('#msg_delete').text(" 暂停成功！");
	                	document.getElementById("operate_result_info").style.display = "block";
               			
               		}else{
               			$('#msg_delete').text("暂停失败！");
               			document.getElementById("operate_result_info").style.display = "block";
               		}
               	
               	}
            }
            function startService(id) {
                var r = window.confirm("确定要开通此业务账号\r\n"+id);
               	if(r){
               		var arguments = {};
               		arguments['id'] = id;
               		if(simpleAjax('startService',arguments)){
               			$('#msg_delete').text(" 开通成功！");
	                	document.getElementById("operate_result_info").style.display = "block";
               			
               		}else{
               			$('#msg_delete').text("开通失败！");
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
            <s:form id="List" action="serviceList" method="post" theme="simple">
                <!--查询-->
                <div class="search_add">                        
                    <div>OS 账号：<s:textfield name="likeConditions.OS_USERNAME" cssClass="width100 text_search" /></div>                            
                    <div>服务器 IP：<s:textfield name="likeConditions.UNIX_HOST" cssClass="width100 text_search" /></div>
                    <div>身份证：<s:textfield name="likeConditions.ACCOUNT_ID" cssClass="text_search" /></div>
                    <div>状态：
                     	   <s:select list="serviceStatus" value="mustConditions.S_STATUS" name="mustConditions.S_STATUS" cssClass="select_search"/>
                    </div>
                    <div><input type="button" value="搜索" class="btn_search" onclick="searchSubmit();"/></div>
                    <input type="button" value="增加" class="btn_add" onclick="location.href='serviceAddForm.action';" />
                </div>  
              </s:form>
                <!--删除的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="../images/close.png" onclick="this.parentNode.style.display='none'; window.location.href='serviceList.action?page=${page}';" />
                    <span id="msg_delete"></span>
                </div>   
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                    <tr>
                        <th class="width50">业务ID</th>
                        <th class="width70">账务账号ID</th>
                        <th class="width150">身份证</th>
                        <th class="width70">姓名</th>
                        <th>OS 账号</th>
                        <th class="width50">状态</th>
                        <th class="width100">服务器 IP</th>
                        <th class="width100">资费</th>                                                        
                        <th class="width200"></th>
                    </tr>
               
                    <s:iterator value="services" >
                    <tr>
                       
                         <td><a href="serviceDetail.action?id=${id} " title="查看明细"><s:property value="id"/></a></td>
                        <td><s:property value="accountId"/></td>
                        <td><s:property value="idcardNo"/></td>
                        <td><s:property value="realName"/></td>
                        <td><s:property value="osUsername"/></td>
                        <td><s:property value="serviceStatus[status]"/></td>
                        <td><s:property value="unixHost"/></td>
                        <td>
                            <a class="summary"  onmouseover="showDetail(true,this);" onmouseout="showDetail(false,this);"><s:property value="costName"/></a>
                            <!--浮动的详细信息-->
                            <div class="detail_info">
                                <s:property value="descr"/>
                            </div>
                        </td>                            
                        <td class="td_modi">
                        	<s:if test="status==1">
	                            <input type="button" value="暂停" class="btn_pause" onclick="stopService(${id});" />
	                            <input type="button" value="修改" class="btn_modify" onclick="location.href='ServiceModifyForm.action?id=${id}';" />
	                            <input type="button" value="删除" class="btn_delete" onclick="deleteAccount(${id});" />
                        	</s:if>
                        	<s:if test="status==2">
                        	</s:if>
                        	<s:if test="status==0">
                        		 <input type="button" value="开通" class="btn_start" onclick="startService(${id});" />
	                            <input type="button" value="修改" class="btn_modify" onclick="location.href='ServiceModifyForm.action?id=${id}';" />
	                            <input type="button" value="删除" class="btn_delete" onclick="deleteAccount(${id});" />
                        	</s:if>
                        </td>
                    </tr>
                 
                  </s:iterator>
                </table>                
                <p>业务说明：<br />
                1、创建即开通，记载创建时间；<br />
                2、暂停后，记载暂停时间；<br />
                3、重新开通后，删除暂停时间；<br />
                4、删除后，记载删除时间，标示为删除，不能再开通、修改、删除；<br />
                5、业务账号不设计修改密码功能，由用户自服务功能实现；<br />
                6、暂停和删除状态的账务账号下属的业务账号不能被开通。</p>
                </div>                    
                <!--分页-->
                
                <div id="pages">
                     <a href="javascript:;" onclick="goFind(1)">首页</a>
                     <s:if test="page>1">
        	       		 <a href="javascript:;" onclick="goFind(${page-1})">上一页</a>
                     </s:if>
					<s:else>
						<a href="javascript:;" >上一页</a>
					</s:else>
        	        <s:iterator begin="1" end="totalpage">
        	        	<s:if test="top==page">
	                   	 	 <a href="#" class="current_page"><s:property value="top"/></a>
        	        	</s:if>
        	        	<s:else >
        	        		 <a href="javascript:;" onclick="goFind(${top})"><s:property value="top"/></a>
        	        	</s:else>
        	        </s:iterator>
                     <s:if test="page<totalpage">
	                     <a href="javascript:;" onclick="goFind(${page+1})">下一页</a>
                     </s:if>
					<s:else>
						<a href="javascript:;" >下一页</a>
					</s:else>
                    <a href="javascript:;" onclick="goFind(${totalpage})">末页</a>
                </div>                    
            
        </div>
        <!--主要区域结束-->
        <div id="footer">
            <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
            <p>版权所有(C)加拿大达内IT培训集团公司 </p>
        </div>
    </body>
    <s:debug></s:debug>
</html>
