var chart;
$(function () {
  $(document).ready(function () {
    chart = new Highcharts.Chart({
      chart: {
        renderTo: 'container',
        type: 'line',
        marginRight: 130,
        marginBottom: 80,
        events: {
          load: loadTime
        }
      },
      title: {
        text: '大桥采集数据',
        x: -20
      },
      subtitle: {
        text: '传感器编号: 传感器1',
        x: -20
      },
      xAxis: {
        title: {
          enabled: true,
          text: '时间（小时）'
        },
        max: 23,
        min: 0,
        tickPixelInterval: 50
      },
      yAxis: {
        title: {
          text: '压力 (℃)'
        },
        plotLines: [
          {
            value: 0,
            width: 1,
            color: '#808080'
          }
        ]
      },
      tooltip: {
        formatter: function () {
          return '<b>' + this.series.name + '</b><br/>' +
              this.x + ': ' + this.y + '℃';
        }
      },
      legend: {
        x: -50,
        y: 10,
        enabled: true
      },
      exporting: {
        enabled: false
      },
      plotOptions: {
        line: {
          gapSize: 100
        }
      },
      series: [
        {
          name: '最大值',
          data: getFirstData()
        }
      ]
    });
  });

});