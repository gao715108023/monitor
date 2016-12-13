package net.monitor.display;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class JFreeChartTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DefaultPieDataset dpd = new DefaultPieDataset(); // 建立一个默认的饼图
        dpd.setValue("manager", 25); // 输入数据
        dpd.setValue("Marketer", 25);
        dpd.setValue("developer", 45);
        dpd.setValue("other staffs", 10);

        JFreeChart chart = ChartFactory.createPieChart("A company who organize the data graph", dpd, true, true, false);
        // 可以查具体的API文档,第一个参数是标题，第二个参数是一个数据集，第三个参数表示是否显示Legend，第四个参数表示是否显示提示，第五个参数表示图中是否存在URL

        ChartFrame chartFrame = new ChartFrame("A company who organize the data graph", chart);
        // chart要放在Java容器组件中，ChartFrame继承自java的Jframe类。该第一个参数的数据是放在窗口左上角的，不是正中间的标题。
        chartFrame.pack(); // 以合适的大小展现图形
        chartFrame.setVisible(true);// 图形是否可见
    }
}
