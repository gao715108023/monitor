package net.monitor.utils;

public class Constants {

    public static int OS;

    public static String mysql_driver = "com.mysql.jdbc.Driver";

    public static String configFilePath = "/opt/elasticsearch_test/infoconfig.properties";
    // public static String configFilePath = "infoconfig.properties";

    private String mysql_IPAddress;

    private String mysql_user;

    private String mysql_password;

    private String mysql_databaseName;

    private String users;

    private String collectTime;

    private String url;

    private String interval_time;

    private String pidPath;

    public void getConfigInfo() {

        String configFilePath = "/opt/elasticsearch_test/infoconfig.properties";

        ConfigUtils config = new ConfigUtils(configFilePath);

        this.mysql_IPAddress = config.getString("mysql_IPAddress");

        this.mysql_user = config.getString("mysql_user");

        this.mysql_password = config.getString("mysql_password");

        this.mysql_databaseName = config.getString("mysql_databaseName");

        this.url = "jdbc:mysql://" + mysql_IPAddress + ":3306/" + mysql_databaseName;
    }

    public void getAllConfigInfo() {

        String configFilePath = "infoconfig.properties";

        ConfigUtils config = new ConfigUtils(configFilePath);

        this.mysql_IPAddress = config.getString("mysql_IPAddress");

        this.mysql_user = config.getString("mysql_user");

        this.mysql_password = config.getString("mysql_password");

        this.mysql_databaseName = config.getString("mysql_databaseName");

        this.url = "jdbc:mysql://" + mysql_IPAddress + ":3306/" + mysql_databaseName;

        this.users = config.getString("users");

        this.collectTime = config.getString("collect_time");

        this.pidPath = config.getString("pidPath");

        this.interval_time = config.getString("interval_time");
    }

    public String getMysql_IPAddress() {
        return mysql_IPAddress;
    }

    public void setMysql_IPAddress(String mysql_IPAddress) {
        this.mysql_IPAddress = mysql_IPAddress;
    }

    public String getMysql_user() {
        return mysql_user;
    }

    public void setMysql_user(String mysql_user) {
        this.mysql_user = mysql_user;
    }

    public String getMysql_password() {
        return mysql_password;
    }

    public void setMysql_password(String mysql_password) {
        this.mysql_password = mysql_password;
    }

    public String getMysql_databaseName() {
        return mysql_databaseName;
    }

    public void setMysql_databaseName(String mysql_databaseName) {
        this.mysql_databaseName = mysql_databaseName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getInterval_time() {
        return interval_time;
    }

    public void setInterval_time(String interval_time) {
        this.interval_time = interval_time;
    }

    public String getPidPath() {
        return pidPath;
    }

    public void setPidPath(String pidPath) {
        this.pidPath = pidPath;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public String getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(String collectTime) {
        this.collectTime = collectTime;
    }

}
