<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Welcome</title>
    <script language="javascript" type="text/javascript" src="js/time/WdatePicker.js"></script>
    <link rel="stylesheet" href="css/fontstyle.css" />
    <s:head theme="xhtml" />
</head>

<body>
<%--<h2>Howdy, <s:property value="username"/>...!</h2>--%>
<div class="body">

    <br />

    <s:form action="download">
        请先下载监控程序，并根据ReadMe文档进行安装：<s:a
            href="download.action?filename=resource_monitor-1.1.tar.gz">resource_monitor-1.1.tar.gz</s:a>
    </s:form>

    <br />

    或者阅读如下教程进行安装：<s:a href="help.jsp" target="_blank">使用教程</s:a>

    <br />
    <s:a href="game.jsp" target="_blank">随机生成每个项目的工作量(仅供懒人使用)</s:a>


    <s:form action="data">

        <%--<s:radio list="${'0':'1','1':'1'}" name="flag" value="0"></s:radio>--%>
        <table width="60%" class="body">
                <%--<tr>--%>
                <%--<th align="left" height="10px"><s:radio--%>
                <%--list="#{'1' : '磁盘的I/O&nbsp;&nbsp;&nbsp;', '2' : 'CPU和内存使用情况&nbsp;&nbsp;&nbsp;', '3' : '网络带宽&nbsp;&nbsp;&nbsp;', '4' : '端口的客户端连接数&nbsp;&nbsp;&nbsp;'}"--%>
                <%--name="flag" value="2"--%>
                <%--label="请选择需要查看的资源（单选）"></s:radio></th>--%>

                <%--</tr>--%>
            <tr>
                <th align="left" height="10px">
                    <s:select name="flag"
                              list="#{'1':'磁盘的I/O','2':'进程的CPU和内存使用情况','3':'网络带宽','4':'端口的客户端连接数','5':'服务器的进程的CPU和内存使用情况'}"
                              label="请选择需要查看的资源（单选）" headerKey="5"
                              headerValue="请选择需要显示的资源"></s:select>
                </th>
            </tr>
            <tr>
                <th align="left" height="10px">
                    <s:textfield name="localIp" label="Ip地址(IP地址查看方式：ifconfig) " value="10.173.210.40" />
                        <%--<s:fielderror cssStyle="color: red">--%>
                        <%--<s:param>localIp</s:param>--%>
                        <%--</s:fielderror>--%>
                </th>
            </tr>

            <tr>
                <th align="left" height="10px"><s:textfield name="begin" label="查询起始时间" onchange="calculate('m')"
                                                            onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
                                                            value="2016-12-25 09:55:03" /></th>
            </tr>
            <tr>
                <th align="left" height="10px"><s:textfield name="end" label="查询结束时间" onchange="calculate('m')"
                                                            onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
                                                            value="2016-12-30 09:55:03" /></th>
            </tr>
            <tr>
                <th align="left" height="10px"><s:textfield name="diskname"
                                                            label="磁盘名称(磁盘名称查询方式：cat /proc/diskstats)"
                                                            value="vda" /></th>
            </tr>
            <tr>
                <th align="left" height="10px"><s:textfield name="processId"
                                                            label="进程ID(进程ID查看方式：ps -ef|grep process-name) "
                                                            value="0" /></th>
            </tr>
            <tr>
                <th align="left" height="10px"><s:textfield name="processName" label="程序的名称（可以填写任意名称）"
                                                            value="tomcat" /></th>
            </tr>
            <tr>
                <th align="left" height="10px"><s:textfield name="port" label="端口号" value="80" /></th>
            </tr>
            <tr>
                <th align="left" height="10px"><s:submit value="查询" style="width:40px,height:40" align="center" /></th>
            </tr>
        </table>


        <%--<s:textfield name="end" label="查询结束时间"/>--%>

    </s:form>
</div>
</body>
</html>