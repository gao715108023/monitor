package net.monitor.action;

import com.opensymphony.xwork2.ActionSupport;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author gaochuanjun
 * @since 14-5-16
 */
public class DownloadAction extends ActionSupport {

  private static final long serialVersionUID = 1656950476675155655L;

  private String md5;

  private String filename;

  private String directory;

  public String execute() {

//        if (md5.matches("[\\w&&[^_]]{32}?")) {
//            filename = md5.toLowerCase();
//            return SUCCESS;
//        }

//        return INPUT;
    return SUCCESS;
  }

  public InputStream getInputStream() throws Exception {
    String dir = directory + filename;
    return new FileInputStream(dir);
  }


  public String getMd5() {
    return md5;
  }

  public void setMd5(String md5) {
    this.md5 = md5;
  }

  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public String getDirectory() {
    return directory;
  }

  public void setDirectory(String directory) {
    this.directory = directory;
  }
}