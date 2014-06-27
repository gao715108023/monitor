package com.gcj.test;

import com.gcj.bean.CPUInfo;

import java.util.Formatter;

/**
 * Created by gaochuanjun on 14-5-12.
 */
public class TestFormatter {

    public static void main(String[] args) {
        Formatter f1 = new Formatter(System.out);

        //2$：取第二个参数
        //-: 指定为左对齐，默认右对齐
        //5：最大输出宽度为20,不够会补空格，实际若超过则全部输出
        //.2：在此表示输出参数2的最大字符数量，如果是浮点数字，则表示小数部分显示的位数
        //s ：表示输入参数是字符串
        f1.format("%2$-5.2s %1$6s", "123", "456233");
        System.out.println("\n");
        f1.format("%1$-4s %2$-3s %3$-3s %4$-3s %5$-3s %6$-3s %7$-3s %8$-3s %9$-3s %10$-3s %11$-3s %12$-3s %13$-3s %14$-3s", "Device:", "rrqm/s", "wrqm/s", "r/s", "w/s", "rkB/s", "wkB/s", "avgrq-sz", "avgqu-sz", "await", "r_await", "w_await", "svctm", "%util");
        System.out.println("\n");
        f1.format("%-16s %5.2f %5.2f %6.2f %6.2f %7.2f %7.2f %6.2f %5.2f %6.2f %5.2f %3.2f", "cciss/c0d0", 0.02, 19.95, 0.06, 5.30, 2.56, 101.03, 38.67, 0.00, 0.36, 2.17, 0.34, 0.10, 0.05);

        System.out.println("\n");
        CPUInfo old = new CPUInfo(0, 0, 0, 0);
        CPUInfo newCPUInfo = new CPUInfo();
        newCPUInfo.setIdle(1212);
        old = newCPUInfo;
        System.out.println(old.getIdle());
        newCPUInfo.setIdle(1213131);
        old = newCPUInfo;
        System.out.println(old.getIdle());


    }
}
