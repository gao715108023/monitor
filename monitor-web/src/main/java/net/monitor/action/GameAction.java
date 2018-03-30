package net.monitor.action;

import com.opensymphony.xwork2.ActionSupport;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Arrays;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletResponseAware;

/**
 * @author gaochuanjun
 * @since 14-6-13
 */
public class GameAction extends ActionSupport implements ServletResponseAware {

  private String works;

  private double seed;

  private int k;

  private String hours;

  private String results;

  private HttpServletResponse response;

  public String execute() {
    if (hasActionErrors()) {
      return INPUT;
    }
    initial();
    getTheLastResult();

    response.setContentType("text/html;charset=UTF-8");
    //response.setCharacterEncoding("UTF-8");
    PrintWriter printWriter = null;
    try {
      printWriter = response.getWriter();
      printWriter.print("<script>alert('" + getResults() + "')</script>");
      printWriter.print("<script>window.location.href='game.action'</script>");
      printWriter.flush();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (printWriter != null) {
        printWriter.close();
      }
    }
    return SUCCESS;
  }

  public void validate() {
    if (works == null || works.trim().equals("")) {
      addFieldError("works", "项目数不能为空！");
    } else if (!isNumeric(works)) {
      addFieldError("works", "对不起，项目数只能为数字，不能包含其他字符，谢谢！");
    } else if (Integer.parseInt(works) <= 0) {
      addFieldError("works", "对不起，项目数不能≤0，谢谢！");
    }
    if (hours == null || hours.trim().equals("")) {
      addFieldError("hours", "每周工作小时数不能为空！");
    } else if (!isNumeric(hours)) {
      addFieldError("hours", "对不起，每周工作小时数只能为数字，不能包含其他字符，谢谢！");
    } else if (Double.parseDouble(hours) <= 0) {
      addFieldError("hours", "对不起，每周工作小时数不能≤0，谢谢！");
    }
  }

//    public boolean isNumeric(String str) {
//        for (int i = str.length(); --i >= 0; ) {
//            if (!Character.isDigit(str.charAt(i))) {
//                return false;
//            }
//        }
//        return true;
//    }

  public boolean isNumeric(String str) {
    boolean result;
    try {
      Integer.parseInt(str);
      result = true;
    } catch (NumberFormatException e) {
      result = false;
    }
    return result;
  }

//    public boolean isNumeric(String str) {
//        Pattern pattern = Pattern.compile("-?[0-9]+.?[0-9]+");
//        Matcher isNum = pattern.matcher(str);
//        if (!isNum.matches()) {
//            return false;
//        }
//        return true;
//    }


  private void initial() {
    k = Integer.parseInt(works);
    seed = (Double.parseDouble(hours) / 40.0) * 100;
  }

  private double getRandom(double n) {
    double value = Math.random() * n;
    if (value < 5) {
      value += 5;
    }
//        while (true) {
//            value = Math.random() * n;
//            System.out.println("Just For Test: " + value);
//            if (value >= 5)
//                break;
//        }
    return value;
  }

  private double convert(double f) {
    return new BigDecimal(f).setScale(0, BigDecimal.ROUND_HALF_UP).doubleValue();
  }

  private double[] process() {
    double[] results = new double[k];
    double sum = 0;
    for (int i = 0; i < k - 1; i++) {
      double result = convert(getRandom(seed));
      seed -= result;
      results[i] = result;
      sum += result;
    }

    results[k - 1] = convert(100 - sum);
    return results;
  }

  public void getTheLastResult() {
    boolean flag;
    double[] results;
    // List<Double> resultList = new ArrayList<Double>();
    while (true) {
      flag = true;
      results = process();
      for (int i = 0; i < results.length; i++) {
        if (results[i] <= 0) {
          flag = false;
        }
      }
      if (flag) {
        break;
      }
    }
    Arrays.sort(results);  //进行排序
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < results.length; i++) {
      sb.append(results[i]).append("%").append("\t");
    }
    //sb.deleteCharAt(sb.length() - 1);
    setResults(sb.toString());
    //return results;
  }

  public String getResults() {
    return results;
  }

  public void setResults(String results) {
    this.results = results;
  }

  public String getWorks() {
    return works;
  }

  public void setWorks(String works) {
    this.works = works;
  }

  public String getHours() {
    return hours;
  }

  public void setHours(String hours) {
    this.hours = hours;
  }

  public void setServletResponse(HttpServletResponse httpServletResponse) {
    this.response = httpServletResponse;
  }
}
