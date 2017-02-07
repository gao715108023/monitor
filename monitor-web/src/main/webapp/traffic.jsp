<%--
  Created by IntelliJ IDEA.
  User: gaochuanjun
  Date: 14-6-9
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>正在监控服务器的带宽</title>
    <script type="text/javascript" src="js/jquery-1.10.2.js"></script>
    <script src="js/highcharts.js"></script>
    <script src="js/theme/dark-blue.js"></script>
    <script type="text/javascript">
        var tmp = '<s:property value="localIp" escape="false"/>';
        //        alert(tmp);
        var text = tmp + '——流入带宽';
        //        alert(text);
        var receiveTraffic = eval(<s:property value="receiveTraffic" escape="false"/>);
        //        alert(await);
        Highcharts.setOptions({
            global: {
                useUTC: false
            }
        });
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
//                text: 'await【平均每次IO请求等待时间,await < 5ms(正常);5ms <= await < 10ms(中);await >=10ms(严重)】',
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
                    text: 'receiveTraffic(MB)'
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
                    name: "ReceiveTraffic",
                    data: receiveTraffic
                }
            ]
        };

        $(document).ready(function () {
            chart1 = new Highcharts.Chart(chart1option);
        });
    </script>

    <script type="text/javascript">
        var tmp = '<s:property value="localIp" escape="false"/>';
        //        alert(tmp);
        var text = tmp + '——流出带宽';
        //        alert(text);
        var transmitTraffic = eval(<s:property value="transmitTraffic" escape="false"/>);
        //        alert(await);
        Highcharts.setOptions({
            global: {
                useUTC: false
            }
        });
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
//                text: 'await【平均每次IO请求等待时间,await < 5ms(正常);5ms <= await < 10ms(中);await >=10ms(严重)】',
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
                    text: 'transmitTraffic(MB)'
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
                    name: "TransmitTraffic",
                    data: transmitTraffic
                }
            ]
        };

        $(document).ready(function () {
            chart2 = new Highcharts.Chart(chart2option);
        });
    </script>
</head>
<body>
<a href="index.jsp">返回首页</a>

<div id="container" style="min-width: 400px; height: 400px; margin: 0 auto"></div>

<div id="container1" style="min-width: 400px; height: 400px; margin: 0 auto"></div>
</body>
</html>
