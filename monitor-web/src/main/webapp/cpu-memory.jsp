<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: gaochuanjun
  Date: 14-5-14
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>进程CPU/Memory监控系统</title>

    <script type="text/javascript" src="js/jquery-1.10.2.js"></script>
    <script src="js/highcharts.js"></script>
    <script src="js/theme/gray.js"></script>

    <script type="text/javascript">
        var tmp1 = '<s:property value="localIp" escape="false"/>';
        var tmp2 = '<s:property value="processName" escape="false"/>';
        var text = tmp1 + '(' + tmp2 + ')——CPU使用率';
        var cpuUsage = eval(<s:property value="cpuUsage" escape="false"/>);
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
                    text: 'CPUUsage (%)'
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
                    name: "CPUUsage",
                    data: cpuUsage
                }
            ]
        };

        $(document).ready(function () {
            chart1 = new Highcharts.Chart(chart1option);
        });
    </script>

    <script type="text/javascript">
        var tmp1 = '<s:property value="localIp" escape="false"/>';
        var tmp2 = '<s:property value="processName" escape="false"/>';
        var text = tmp1 + '(' + tmp2 + ')——内存使用率';
        var memUsage = eval(<s:property value="memUsage" escape="false"/>);
        Highcharts.setOptions({
            global: {
                useUTC: false
            }
        });
        var chart2option = {
            chart: {
                renderTo: 'container1',//画到id为sysThreadChart的div容器里
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
                    margin: '10px 100px 0 0' // center it
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
                    text: 'MEMUsage (MB)'
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
                    name: "MEMUsage",
                    data: memUsage
                }
            ]
        };

        $(document).ready(function () {
            chart2 = new Highcharts.Chart(chart2option);
        });
    </script>

    <script type="text/javascript">
        var tmp = '<s:property value="localIp" escape="false"/>';
        var text = tmp + '——Load Average(CPU负载)';
        var oneMinsProcs = eval(<s:property value="oneMinsProcs" escape="false"/>);
        var fiveMinsProcs = eval(<s:property value="fiveMinsProcs" escape="false"/>);
        var fifteenMinsProcs = eval(<s:property value="fifteenMinsProcs" escape="false"/>);
        Highcharts.setOptions({
            global: {
                useUTC: false
            }
        });
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
                    margin: '10px 100px 0 0' // center it
                }
            },
            //当鼠标经过时的提示设置
            tooltip: {
                valueSuffix: 'numbers per one minute',
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
                    text: '1分钟进程数'
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
                    name: "OneMinsProcs",
                    data: oneMinsProcs
                },
                {
                    name: "FiveMinsProcs",
                    data: fiveMinsProcs
                },
                {
                    name: "FifteenMinsProcs",
                    data: fifteenMinsProcs
                }
            ]
        };

        $(document).ready(function () {
            chart3 = new Highcharts.Chart(chart3option);
        });
    </script>

    <script type="text/javascript">
        var tmp = '<s:property value="localIp" escape="false"/>';
        var text = tmp + '¬——5分钟进程数';
        var fiveMinsProcs = eval(<s:property value="fiveMinsProcs" escape="false"/>);
        Highcharts.setOptions({
            global: {
                useUTC: false
            }
        });
        var chart4option = {
            chart: {
                renderTo: 'container3',
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
                    margin: '10px 100px 0 0' // center it
                }
            },
            //当鼠标经过时的提示设置
            tooltip: {
                valueSuffix: 'numbers per five minute',
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
                    text: '5分钟进程数'
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
                    name: "FiveMinsProcs",
                    data: fiveMinsProcs
                }
            ]
        };

        $(document).ready(function () {
            chart4 = new Highcharts.Chart(chart4option);
        });
    </script>

    <script type="text/javascript">
        var tmp = '<s:property value="localIp" escape="false"/>';
        var text = tmp + '¬——15分钟进程数';
        var fifteenMinsProcs = eval(<s:property value="fifteenMinsProcs" escape="false"/>);
        Highcharts.setOptions({
            global: {
                useUTC: false
            }
        });
        var chart5option = {
            chart: {
                renderTo: 'container4',
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
                    margin: '10px 100px 0 0' // center it
                }
            },
            //当鼠标经过时的提示设置
            tooltip: {
                valueSuffix: 'numbers per fifteen minute',
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
                    text: '15分钟进程数'
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
                    name: "FifteenMinsProcs",
                    data: fifteenMinsProcs
                }
            ]
        };

        $(document).ready(function () {
            chart5 = new Highcharts.Chart(chart5option);
        });
    </script>
</head>
<body>
<a href="index.jsp">返回首页</a>

<div id="container" style="min-width: 400px; height: 400px; margin: 0 auto"></div>
<div id="container1" style="min-width: 400px; height: 400px; margin: 0 auto"></div>
<div id="container2" style="min-width: 400px; height: 400px; margin: 0 auto"></div>
<%--<div id="container3" style="min-width: 400px; height: 400px; margin: 0 auto"></div>--%>
<%--<div id="container4" style="min-width: 400px; height: 400px; margin: 0 auto"></div>--%>
</body>
</html>
