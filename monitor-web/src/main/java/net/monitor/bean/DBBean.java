package net.monitor.bean;

/**
 * @author gaochuanjun
 * @since 14-6-12
 */
public class DBBean {

    private String url;

    private String user;

    private String pwd;

    public DBBean(String url, String user, String pwd) {
        this.url = url;
        this.user = user;
        this.pwd = pwd;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPwd() {
        return pwd;
    }
}
