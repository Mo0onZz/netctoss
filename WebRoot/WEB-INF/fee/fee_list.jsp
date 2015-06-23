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
            //排序按钮的点击事件
            function sort(btnObj) {
                if (btnObj.className == "sort_desc")
                    btnObj.className = "sort_asc";
                else
                    btnObj.className = "sort_desc";
            }

            //启用
            function startFee() {
                var r = window.confirm("确定要启用此资费吗？资费启用后将不能修改和删除。");
                document.getElementById("operate_result_info").style.display = "block";
            }
            //删除
            function deleteCost(id) {
                var r = window.confirm("确定要删除此资费吗？");
                if(r){
               		$.ajax({
               			url:'deleteCost?id='+id,
               			type:'get',
               			dataType:'json',
               			success:function(data){
               			alert(data);
               				if(data){
               				$('#msg_delete').text("删除成功");
                document.getElementById("operate_result_info").style.display = "block";
               				}else{
               				$('#msg_delete').text("删除失败");
          		document.getElementById("operate_result_info").style.display = "block";
               				}
               			}
               		});
                
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
            <form action="" method="">
                <!--排序-->
                <div class="search_add">
                    <div>
                        <input type="button" value="月租" class="sort_asc" onclick="sort(this);" />
                        <input type="button" value="基费" class="sort_asc" onclick="sort(this);" />
                        <input type="button" value="时长" class="sort_asc" onclick="sort(this);" />
                    </div>
                    <input type="button" value="增加" class="btn_add" onclick="location.href='addCostFormAction';" />
                </div> 
                <!--启用操作的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="../images/close.png" onclick="this.parentNode.style.display='none';" />
                    <span id="msg_delete"></span>
                </div>    
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                        <tr>
                            <th>资费ID</th>
                            <th class="width100">资费名称</th>
                            <th>基本时长</th>
                            <th>基本费用</th>
                            <th>单位费用</th>
                            <th>创建时间</th>
                            <th>开通时间</th>
                            <th class="width50">状态</th>
                            <th class="width200"></th>
                        </tr>  
                        <s:iterator value="costs">
                        
                                           
	                        <tr>
	                            <td><s:property value="id"/></td>
	                            <td><a href="costDetail.action?id=${id }&pages=${pages}"><s:property value="name"/></a></td>
	                            <td><s:property value="baseDuration"/></td>
	                            <td><s:property value="baseCost"/></td>
	                            <td><s:property value="unitCost"/></td>
	                            <td><s:date name="creaTime" format="yyyy/MM/dd HH:mm:ss"/></td>
	                            <td><s:date name="startTime" format="yyyy/MM/dd HH:mm:ss"/></td>
	                            <td><s:property value="costStatus[status]"/></td>
	                            <td>                                
	                                <input type="button" value="启用" class="btn_start" onclick="startFee();" />
	                                <input type="button" value="修改" class="btn_modify" onclick="location.href='modifyForm.action?id=${id}';" />
	                                <input type="button"  value="删除" class="btn_delete" onclick="deleteCost(${id});" />
	                            </td>
	                        </tr>
                        </s:iterator> 
                    </table>
                    <p>业务说明：<br />
                    1、创建资费时，状态为暂停，记载创建时间；<br />
                    2、暂停状态下，可修改，可删除；<br />
                    3、开通后，记载开通时间，且开通后不能修改、不能再停用、也不能删除；<br />
                    4、业务账号修改资费时，在下月底统一触发，修改其关联的资费ID（此触发动作由程序处理）
                    </p>
                </div>
                <!--分页-->
        
                <div id="pages">
        	        <a href="">上一页</a>
                	<s:iterator begin="1" end="totalpage">
                		<s:if test="pages==top">
                		<a href="costList.action?pages=${top }" class="current_page"><s:property value="top"/></a>
                		</s:if>
                		<s:else>
	                		<a href="costList.action?pages=${top }" ><s:property value="top"/></a>
                		</s:else>
                	</s:iterator>
                    <a href="">下一页</a>
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
