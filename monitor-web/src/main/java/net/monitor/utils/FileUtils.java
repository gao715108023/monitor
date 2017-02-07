package net.monitor.utils;

/**
 * @author gaochuanjun
 * @since 14-7-22
 */
public class FileUtils {

    public static void getPath() {
        String path = null;
        String currentPath = System.getProperty("user.dir");
        System.out.println(currentPath);
        if (currentPath.contains("\\")) {
            path = currentPath + "\\conf\\test.xml";
        } else if (currentPath.contains("/")) {
            path = currentPath + "/conf/test.xml";
        }
        System.out.println(path);
        //System.out.println(FileUtils.class.getResource("/")); //Class文件所在路径
    }

    public static void main(String[] args) {
        getPath();
    }
}