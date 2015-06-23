<%@page isELIgnored="false" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@page import="com.tarena.netctoss.entity.*,java.util.*" %>
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
            function deleteRole(id) {
                var r = window.confirm("确定要删除此角色吗？");
                if(r){
                	var obj = {};
                	obj['id'] = id;
                	var b = deleteData('roleDelete.action',obj);
                	if(b){
                		$('#delete_result').html('删除成功');
                	}else{
                		$('#delete_result').html('删除错误！该角色被使用，不能删除。');
                	}
                document.getElementById("operate_result_info").style.display = "block";
                }
            }
        </script>
    </head>
    <body>
        <!--Logo区域开始-->
        <s:debug></s:debug> 
        <s:include value="../product/menu.jsp"></s:include>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">
            <form action="" method="">
                <!--查询-->
                <div class="search_add">
                    <input type="button" value="增加" class="btn_add" onclick="location.href='roleAddForm.action';" />
                </div>  
                <!--删除的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="../images/close.png" onclick="location.href='roleList.action?page=${page}'" />
                    删除成功！<span id="delete_result"></span>
                </div> <!--删除错误！该角色被使用，不能删除。-->
                <!--数据区域：用表格展示数据-->     
                <div id="data">                      
                    <table id="datalist">
                    	<tr>                           
                            <th>角色 ID</th>
                            <th>角色名称</th>
                            <th class="width600">拥有的权限</th>
                            <th class="td_modi"></th>
                        </tr>  
                  		 <s:iterator value="roles"  var="out1">                 
	                        <tr style="font-size:10pt">
	                            <td><s:property value="id"/></td>
	                            <td><s:property value="name"/></td>
	                            <td>
	                            	<s:property value="top.getPrivilegeNames()"/>
	                            	<!--<s:property value="privilegeNames"/>-->
	                            </td>
	                            <td>
	                                <input type="button" value="修改" class="btn_modify" onclick="location.href='roleDetail.action?id=${id}';"/>
	                                <input type="button" value="删除" class="btn_delete" onclick="deleteRole(${id});" />
	                            </td>
	                        </tr>
                        </s:iterator>   
                    </table>
                </div> 
                <!--分页-->
                <div id="pages">
                	<s:if test="page>1">
	        	        <a href="roleList.action?page=${page-1 }">上一页</a>
                	</s:if>
                	<s:else>
                		上一页
                	</s:else>
                	<s:iterator begin="1" end="totalpage">
                		<s:if test="page==top">
		                    <a href="#" class="current_page">${top }</a>
                		</s:if>
                		<s:else>
	                		<a href="roleList.action?page=${top }" >${top }</a>
                		</s:else>
                	</s:iterator>
                   <s:if test="page<totalpage">
	        	        <a href="roleList.action?page=${page+1 }">下一页</a>
                	</s:if>
                	<s:else>
                		下一页
                	</s:else>
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
