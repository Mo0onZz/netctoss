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
            function showDetail(flag, a) {
                var detailDiv = a.parentNode.getElementsByTagName("div")[0];
                if (flag) {
                    detailDiv.style.display = "block";
                }
                else
                    detailDiv.style.display = "none";
            }
            //重置密码
            function resetPwd() {
                alert("请至少选择一条数据！");
                //document.getElementById("operate_result_info").style.display = "block";
            }
            //删除
            function deleteAdmin() {
                var r = window.confirm("确定要删除此管理员吗？");
                document.getElementById("operate_result_info").style.display = "block";
            }
            //全选
            function selectAdmins(inputObj) {
                var inputArray = document.getElementById("datalist").getElementsByTagName("input");
                for (var i = 1; i < inputArray.length; i++) {
                    if (inputArray[i].type == "checkbox") {
                        inputArray[i].checked = inputObj.checked;
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
            <form action="" method="">
                <!--查询-->
                <div class="search_add">
                    <div>
                        模块：			<s:select list="roles"></s:select>
                        
                    </div>
                    <div>角色：<input type="text" value="" class="text_search width200" /></div>
                    <div><input type="button" value="搜索" class="btn_search"/></div>
                    <input type="button" value="密码重置" class="btn_add" onclick="resetPwd();" />
                    <input type="button" value="增加" class="btn_add" onclick="location.href='admin_add.html';" />
                </div>
                <!--删除和密码重置的操作提示-->
                <div id="operate_result_info" class="operate_fail">
                    <img src="../images/close.png" onclick="this.parentNode.style.display='none';" />
                    <span>删除失败！数据并发错误。</span><!--密码重置失败！数据并发错误。-->
                </div> 
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                        <tr>
                            <th class="th_select_all">
                                <input type="checkbox" onclick="selectAdmins(this);" />
                                <span>全选</span>
                            </th>
                            <th>管理员ID</th>
                            <th>姓名</th>
                            <th>登录名</th>
                            <th>电话</th>
                            <th>电子邮件</th>
                            <th>授权日期</th>
                            <th class="width100">拥有角色</th>
                            <th></th>
                        </tr>                      
                        <tr>
                            <td><input type="checkbox" /></td>
                            <td>1</td>
                            <td>贾强</td>
                            <td>admin</td>
                            <td>13077332357</td>
                            <td>jiaqiang123@qq.com.cn</td>
                            <td>2011-31-12</td>
                            <td>
                                <a class="summary"  onmouseover="showDetail(true,this);" onmouseout="showDetail(false,this);">超级管理员...</a>
                                <!--浮动的详细信息-->
                                <div class="detail_info">
                                    超级管理员，角色管理员，账单管理员，报表管理员，业务账号管理员，账务账号管理员，aa，bb
                                </div>
                            </td>
                            <td class="td_modi">
                                <input type="button" value="修改" class="btn_modify" onclick="location.href='admin_modi.html';" />
                                <input type="button" value="删除" class="btn_delete" onclick="deleteAdmin();" />
                            </td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" /></td>
                            <td>2</td>
                            <td>贾强</td>
                            <td>admin</td>
                            <td>13077332357</td>
                            <td>jiaqiang123@qq.com.cn</td>
                            <td>2011-31-12</td>
                            <td>
                                <a class="summary"  onmouseover="showDetail(true,this);" onmouseout="showDetail(false,this);">超级管理员...</a>
                                <!--浮动的详细信息-->
                                <div class="detail_info">
                                    超级管理员，角色管理员
                                </div>
                            </td>
                            <td class="td_modi">
                                <input type="button" value="修改" class="btn_modify" />
                                <input type="button" value="删除" class="btn_delete" onclick="deleteAdmin();" />
                            </td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" /></td>
                            <td>3</td>
                            <td>贾强</td>
                            <td>admin</td>
                            <td>13077332357</td>
                            <td>jiaqiang123@qq.com.cn</td>
                            <td>2011-31-12</td>
                            <td>
                                <a class="summary"  onmouseover="showDetail(true,this);" onmouseout="showDetail(false,this);">超级管理员...</a>
                                <!--浮动的详细信息-->
                                <div class="detail_info">
                                    超级管理员，角色管理员，账单管理员，报表管理员，业务账号管理员，账务账号管理员
                                </div>
                            </td>
                            <td class="td_modi">
                                <input type="button" value="修改" class="btn_modify" />
                                <input type="button" value="删除" class="btn_delete" />
                            </td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" /></td>
                            <td>4</td>
                            <td>贾强</td>
                            <td>admin</td>
                            <td>13077332357</td>
                            <td>jiaqiang123@qq.com.cn</td>
                            <td>2011-31-12</td>
                            <td>
                                <a class="summary"  onmouseover="showDetail(true,this);" onmouseout="showDetail(false,this);">超级管理员</a>
                                <!--浮动的详细信息-->
                                <div class="detail_info">
                                    超级管理员
                                </div>
                            </td>
                            <td class="td_modi">
                                <input type="button" value="修改" class="btn_modify" />
                                <input type="button" value="删除" class="btn_delete" />
                            </td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" /></td>
                            <td>5</td>
                            <td>贾强</td>
                            <td>admin</td>
                            <td>13077332357</td>
                            <td>jiaqiang123@qq.com.cn</td>
                            <td>2011-31-12</td>
                            <td>超级管理员</td>
                            <td class="td_modi">
                                <input type="button" value="修改" class="btn_modify" />
                                <input type="button" value="删除" class="btn_delete" />
                            </td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" /></td>
                            <td>6</td>
                            <td>贾强</td>
                            <td>admin</td>
                            <td>13077332357</td>
                            <td>jiaqiang123@qq.com.cn</td>
                            <td>2011-31-12</td>
                            <td>超级管理员</td>
                            <td class="td_modi">
                                <input type="button" value="修改" class="btn_modify" />
                                <input type="button" value="删除" class="btn_delete" />
                            </td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" /></td>
                            <td>7</td>
                            <td>贾强</td>
                            <td>admin</td>
                            <td>13077332357</td>
                            <td>jiaqiang123@qq.com.cn</td>
                            <td>2011-31-12</td>
                            <td>超级管理员</td>
                            <td class="td_modi">
                                <input type="button" value="修改" class="btn_modify" />
                                <input type="button" value="删除" class="btn_delete" />
                            </td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" /></td>
                            <td>8</td>
                            <td>贾强</td>
                            <td>admin</td>
                            <td>13077332357</td>
                            <td>jiaqiang123@qq.com.cn</td>
                            <td>2011-31-12</td>
                            <td>超级管理员</td>
                            <td class="td_modi">
                                <input type="button" value="修改" class="btn_modify" />
                                <input type="button" value="删除" class="btn_delete" />
                            </td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" /></td>
                            <td>9</td>
                            <td>贾强</td>
                            <td>admin</td>
                            <td>13077332357</td>
                            <td>jiaqiang123@qq.com.cn</td>
                            <td>2011-31-12</td>
                            <td>超级管理员</td>
                            <td class="td_modi">
                                <input type="button" value="修改" class="btn_modify" />
                                <input type="button" value="删除" class="btn_delete" />
                            </td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" /></td>
                            <td>10</td>
                            <td>贾强</td>
                            <td>admin</td>
                            <td>13077332357</td>
                            <td>jiaqiang123@qq.com.cn</td>
                            <td>2011-31-12</td>
                            <td>超级管理员</td>
                            <td class="td_modi">
                                <input type="button" value="修改" class="btn_modify" />
                                <input type="button" value="删除" class="btn_delete" />
                            </td>
                        </tr>
                    </table>
                </div>
                <!--分页-->
                <div id="pages">
        	        <a href="#">上一页</a>
                    <a href="#" class="current_page">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                    <a href="#">5</a>
                    <a href="#">下一页</a>
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
