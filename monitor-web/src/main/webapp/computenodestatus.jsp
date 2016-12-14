<%--
  Created by IntelliJ IDEA.
  User: gaochuanjun
  Date: 14-6-18
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>服务器的资源监控</title>

    <script type="text/javascript" src="js/jquery-1.10.2.js"></script>
    <script src="js/highcharts.js"></script>
    <script src="js/theme/gray.js"></script>

    <script type="text/javascript">
        var tmp = '<s:property value="ip" escape="false"/>';
        var text = tmp + '——CPU使用详情';
        var totalTime = eval(<s:property value="totalTime" escape="false"/>);
        var userTime = eval(<s:property value="userTime" escape="false"/>);
        var niceTime = eval(<s:property value="niceTime" escape="false"/>);
        var systemTime = eval(<s:property value="systemTime" escape="false"/>);
        var iowaitTime = eval(<s:property value="iowaitTime" escape="false"/>);
        var idleTime = eval(<s:property value="idleTime" escape="false"/>);
        //    Highcharts.setOptions({
        //        global: {
        //            useUTC: false
        //        }
        //    });
        Highcharts.setOptions(Highcharts.theme);
        var chart1option = {
            chart: {
                renderTo: 'container',
                type: 'line',
                marginRight: 130,
                marginBottom: 25
            },
            credits: {
                enabled: false
            },
            title: {
                text: text,
                style: {
                    margin: '10px 100px 0 0'
                }
            },
            //当鼠标经过时的提示设置
            tooltip: {
                valueSuffix: '%',
                borderRadius: 0
            },
            plotOptions: {
                series: {
                    marker: {
                        radius: 0,
                        states: {
                            //鼠标移动至数据点所显示的样式
                            hover: {
                                fillColor: '#808080',//数据点颜色值
                                radius: 5
                                //点半径大小
                            }
                        }
                    }
                }
            },

            xAxis: {
                type: "datetime",//时间轴要加上这个type，默认是linear
                maxPadding: 0.05,
                minPadding: 0.05,
                //tickInterval : 1 * 60 * 1000 *1,//两天画一个x刻度
                //或者150px画一个x刻度，如果跟上面那个一起设置了，则以最大的间隔为准
                tickPixelInterval: 150,
                tickWidth: 5,//刻度的宽度
                //lineColor : '#990000',//自定义刻度颜色
                lineWidth: 3,//自定义x轴宽度
                //gridLineWidth : 1,//默认是0，即在图上没有纵轴间隔线
                //自定义x刻度上显示的时间格式，根据间隔大小，以下面预设的小时/分钟/日的格式来显示
                global: {
                    useUTC: false
                },
                dateTimeLabelFormats: {

                    second: '%H:%M:%S',
                    minute: '%e. %b %H:%M',
                    hour: '%b/%e %H:%M',
                    day: '%e日/%b',
                    week: '%e. %b',
                    month: '%b %y',
                    year: '%Y'
                }
            },
            //设置y坐标轴
            yAxis: {
                title: {
                    text: 'CPU (%)'
                },
                plotLines: [
                    {
                        value: 0,
                        width: 1,
                        color: '#808080'
                    }
                ]
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'top',
                x: -10,
                y: 100,
                borderWidth: 0
            },
            series: [
                {
                    name: "TotalTime",
                    data: totalTime
                },
                {
                    name: "UserTime",
                    data: userTime
                },
                {
                    name: "NiceTime",
                    data: niceTime
                },
                {
                    name: "SystemTime",
                    data: systemTime
                },
                {
                    name: "IowaitTime",
                    data: iowaitTime
                },
                {
                    name: "IdleTime",
                    data: idleTime
                }
            ]
        };

        $(document).ready(function () {
            chart1 = new Highcharts.Chart(chart1option);
        });
    </script>

    <script type="text/javascript">
        var tmp = '<s:property value="ip" escape="false"/>';
        var text = tmp + '——内存使用详情';
        var totalMemory = eval(<s:property value="totalMemory" escape="false"/>);
        var usedMemory = eval(<s:property value="usedMemory" escape="false"/>);
        var idleMemory = eval(<s:property value="idleMemory" escape="false"/>);
        //    Highcharts.setOptions({
        //        global: {
        //            useUTC: false
        //        }
        //    });
        Highcharts.setOptions(Highcharts.theme);
        var chart2option = {
            chart: {
                renderTo: 'container1',
                type: 'line',
                marginRight: 130,
                marginBottom: 25
            },
            credits: {
                enabled: false
            },
            title: {
                text: text,
                style: {
                    margin: '10px 100px 0 0'
                }
            },
            //当鼠标经过时的提示设置
            tooltip: {
                valueSuffix: 'MB',
                borderRadius: 0
            },
            plotOptions: {
                series: {
                    marker: {
                        radius: 0,
                        states: {
                            //鼠标移动至数据点所显示的样式
                            hover: {
                                fillColor: '#808080',//数据点颜色值
                                radius: 5
                                //点半径大小
                            }
                        }
                    }
                }
            },

            xAxis: {
                type: "datetime",//时间轴要加上这个type，默认是linear
                maxPadding: 0.05,
                minPadding: 0.05,
                //tickInterval : 1 * 60 * 1000 *1,//两天画一个x刻度
                //或者150px画一个x刻度，如果跟上面那个一起设置了，则以最大的间隔为准
                tickPixelInterval: 150,
                tickWidth: 5,//刻度的宽度
                //lineColor : '#990000',//自定义刻度颜色
                lineWidth: 3,//自定义x轴宽度
                //gridLineWidth : 1,//默认是0，即在图上没有纵轴间隔线
                //自定义x刻度上显示的时间格式，根据间隔大小，以下面预设的小时/分钟/日的格式来显示
                global: {
                    useUTC: false
                },
                dateTimeLabelFormats: {

                    second: '%H:%M:%S',
                    minute: '%e. %b %H:%M',
                    hour: '%b/%e %H:%M',
                    day: '%e日/%b',
                    week: '%e. %b',
                    month: '%b %y',
                    year: '%Y'
                }
            },
            //设置y坐标轴
            yAxis: {
                title: {
                    text: 'Memory (MB)'
                },
                plotLines: [
                    {
                        value: 0,
                        width: 1,
                        color: '#808080'
                    }
                ]
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'top',
                x: -10,
                y: 100,
                borderWidth: 0
            },
            series: [
                {
                    name: "TotalMemory",
                    data: totalMemory
                },
                {
                    name: "UsedMemory",
                    data: usedMemory
                },
                {
                    name: "IdleMemory",
                    data: idleMemory
                }
            ]
        };

        $(document).ready(function () {
            chart2 = new Highcharts.Chart(chart2option);
        });
    </script>

    <script type="text/javascript">
        var tmp = '<s:property value="ip" escape="false"/>';
        var text = tmp + '——交换区（Swap）使用详情';
        var swapSize = eval(<s:property value="swapSize" escape="false"/>);
        var usedSwap = eval(<s:property value="usedSwap" escape="false"/>);
        var idleSwap = eval(<s:property value="idleSwap" escape="false"/>);
        //    Highcharts.setOptions({
        //        global: {
        //            useUTC: false
        //        }
        //    });
        Highcharts.setOptions(Highcharts.theme);
        var chart3option = {
            chart: {
                renderTo: 'container2',
                type: 'line',
                marginRight: 130,
                marginBottom: 25
            },
            credits: {
                enabled: false
            },
            title: {
                text: text,
                style: {
                    margin: '10px 100px 0 0'
                }
            },
            //当鼠标经过时的提示设置
            tooltip: {
                valueSuffix: 'MB',
                borderRadius: 0
            },
            plotOptions: {
                series: {
                    marker: {
                        radius: 0,
                        states: {
                            //鼠标移动至数据点所显示的样式
                            hover: {
                                fillColor: '#808080',//数据点颜色值
                                radius: 5
                                //点半径大小
                            }
                        }
                    }
                }
            },

            xAxis: {
                type: "datetime",//时间轴要加上这个type，默认是linear
                maxPadding: 0.05,
                minPadding: 0.05,
                //tickInterval : 1 * 60 * 1000 *1,//两天画一个x刻度
                //或者150px画一个x刻度，如果跟上面那个一起设置了，则以最大的间隔为准
                tickPixelInterval: 150,
                tickWidth: 5,//刻度的宽度
                //lineColor : '#990000',//自定义刻度颜色
                lineWidth: 3,//自定义x轴宽度
                //gridLineWidth : 1,//默认是0，即在图上没有纵轴间隔线
                //自定义x刻度上显示的时间格式，根据间隔大小，以下面预设的小时/分钟/日的格式来显示
                global: {
                    useUTC: false
                },
                dateTimeLabelFormats: {

                    second: '%H:%M:%S',
                    minute: '%e. %b %H:%M',
                    hour: '%b/%e %H:%M',
                    day: '%e日/%b',
                    week: '%e. %b',
                    month: '%b %y',
                    year: '%Y'
                }
            },
            //设置y坐标轴
            yAxis: {
                title: {
                    text: 'Swap (MB)'
                },
                plotLines: [
                    {
                        value: 0,
                        width: 1,
                        color: '#808080'
                    }
                ]
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'top',
                x: -10,
                y: 100,
                borderWidth: 0
            },
            series: [
                {
                    name: "SwapSize",
                    data: swapSize
                },
                {
                    name: "UsedSwap",
                    data: usedSwap
                },
                {
                    name: "IdleSwap",
                    data: idleSwap
                }
            ]
        };

        $(document).ready(function () {
            chart3 = new Highcharts.Chart(chart3option);
        });
    </script>
</head>
<body>
<a href="index.jsp">返回首页</a>

<div id="container" style="min-width: 400px; height: 400px; margin: 0 auto"></div>
<div id="container1" style="min-width: 400px; height: 400px; margin: 0 auto"></div>
<div id="container2" style="min-width: 400px; height: 400px; margin: 0 auto"></div>
</body>
</html>
