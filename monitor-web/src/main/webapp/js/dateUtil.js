/** 20130315 add by 梁华山
 日期函数
 */

//获取当前的时间字符串(yyyyMMddHHmmssSSS)
function getCurTime() {
  var date = new Date();
  var y = date.getFullYear();
  var month = lFillZero(date.getMonth() + 1);//月份需要加1
  var d = lFillZero(date.getDate());
  var h = lFillZero(date.getHours());
  var m = lFillZero(date.getMinutes());
  var s = lFillZero(date.getSeconds());
  var ms = lFillZero2(date.getMilliseconds());
  return y + "" + month + "" + d + "" + h + "" + m + "" + s + "" + ms;
}

//两位数值左边补零
function lFillZero(val) {
  var v1 = val + "";
  if (val < 10) {
    v1 = "0" + val;
  }
  return v1;
}

//三位数值左边补零
function lFillZero2(val) {
  var v1 = val + "";
  if (val < 10) {
    v1 = "00" + val;
  } else if (val < 100) {
    v1 = "0" + val;
  }
  return v1;
}

//获取当前的带分隔符日期字符串(yyyy-MM-dd)
function getSignCurDate(sign) {
  var date = new Date();
  var y = date.getFullYear();
  var month = lFillZero(date.getMonth() + 1);//月份需要加1
  var d = lFillZero(date.getDate());
  return y + sign + month + sign + d;
}

//获取当前的日期字符串(yyyyMMdd)
function getCurDate() {
  return getSignCurDate("");
}

//获取昨天的日期字符串(yyyyMMdd)
function getYesterDay() {
  return getSignYesterDay("");
}

//获取昨天的日期字符串(yyyyMMdd)
function getSignYesterDay(sign) {
  var date = new Date();
  date.setDate(date.getDate() - 1);
  var y = date.getFullYear();
  var month = lFillZero(date.getMonth() + 1);//月份需要加1
  var d = lFillZero(date.getDate());
  return y + sign + month + sign + d;
}

/**
 * 返回的格式和dateTime的格式一样
 * @param dateTime 格式:yyyyMMddHHmmssSSS 或者yyyyMMdd 或者yyyyMMddHHmmss等，年以后的都可缺少
 * @param timeType YEAR, MONTH, DAY_OF_MONTH, HOUR, MINUTE, SECOND, MILLISECOND
 * @param timeType 所需要时间 （YEAR :1, MONTH:2 ,DAY_OF_MONTH:5,DAY_OF_WEEK:7）
 * @param amount 要加减的值，加为正，减为负
 * @return 对应部分加减后的字符串,格式对应 传入dateTime的格式
 */
function datetimeAdd(oldDate, timeType, amount) {
  var date = new Date();
  var len = oldDate.length;
  //设置日期
  if (len > 3) {//有年份
    date.setFullYear(oldDate.substr(0, 4));
  }
  if (len > 5) {//有月份
    date.setMonth(oldDate.substr(4, 2) - 1);//月份需要减1
  }
  if (len > 7) {//有日期
    date.setDate(oldDate.substr(6, 2));
  }
  if (len > 9) {//有小时
    date.setHours(oldDate.substr(8, 2));
  }
  if (len > 11) {//有分钟
    date.setMinutes(oldDate.substr(10, 2));
  }
  if (len > 13) {//有秒钟
    date.setSeconds(oldDate.substr(12, 2));
  }
  if (len > 15) {//有毫秒
    date.setMilliseconds(oldDate.substr(14, 3));
  }
  //日期加减
  if (timeType == "YEAR") {
    date.setFullYear(date.getFullYear() + amount);
  } else if (timeType == "MONTH") {
    date.setMonth(date.getMonth() + amount);
  } else if (timeType == "DAY_OF_MONTH") {
    date.setDate(date.getDate() + amount);
  } else if (timeType == "HOUR") {
    date.setHours(date.getHours() + amount);
  } else if (timeType == "MINUTE") {
    date.setMinutes(date.getMinutes() + amount);
  } else if (timeType == "SECOND") {
    date.setSeconds(date.getSeconds() + amount);
  } else if (timeType == "MILLISECOND") {
    date.setMilliseconds(date.getMilliseconds() + amount);
  }
  //返回日期
  var result = "";
  if (len > 3) {//有年份
    result = date.getFullYear();
  }
  if (len > 5) {//有月份
    result = result + "" + lFillZero(date.getMonth() + 1);//月份需要加1
  }
  if (len > 7) {//有日期
    result = result + "" + lFillZero(date.getDate());
  }
  if (len > 9) {//有小时
    result = result + "" + lFillZero(date.getHours());
  }
  if (len > 11) {//有分钟
    result = result + "" + lFillZero(date.getMinutes());
  }
  if (len > 13) {//有秒钟
    result = result + "" + lFillZero(date.getSeconds());
  }
  if (len > 15) {//有毫秒
    result = result + "" + lFillZero2(date.getMilliseconds());
  }
  return result;
}

/**
 * 返回的格式和dateTime的格式一样
 * @param dateTime 格式:yyyy-MM-dd HH:mm:ss.SSS 或者yyyy-MM-dd 或者yyyy-MM-dd HH:mm:ss等，年以后的都可缺少
 * @param timeType YEAR, MONTH, DAY_OF_MONTH, HOUR, MINUTE, SECOND, MILLISECOND
 * @param amount 要加减的值，加为正，减为负
 * @return 对应部分加减后的字符串,格式对应 传入dateTime的格式
 */
function signDatetimeAdd(oldDate, timeType, amount) {
  var date = new Date();
  var len = oldDate.length;
  var monthstr = '';
  var daystr = '';
  var hourstr = '';
  var minutestr = '';
  var secondstr = '';
  var miscstr = '';
  //设置日期
  if (len > 3) {//有年份
    date.setFullYear(oldDate.substr(0, 4));
  }
  if (len > 5) {//有月份
    monthstr = oldDate.substr(4, 1);
    date.setMonth(oldDate.substr(5, 2) - 1);//月份需要减1
  }
  if (len > 7) {//有日期
    daystr = oldDate.substr(7, 1);
    date.setDate(oldDate.substr(8, 2));
  }
  if (len > 10) {//有小时
    hourstr = oldDate.substr(10, 1);
    date.setHours(oldDate.substr(11, 2));
  }
  if (len > 13) {//有分钟
    minutestr = oldDate.substr(13, 1);
    date.setMinutes(oldDate.substr(14, 2));
  }
  if (len > 16) {//有秒钟
    secondstr = oldDate.substr(16, 1);
    date.setSeconds(oldDate.substr(17, 2));
  }
  if (len > 19) {//有毫秒
    miscstr = oldDate.substr(19, 1);
    date.setMilliseconds(oldDate.substr(20, 3));
  }
  //日期加减
  if (timeType == "YEAR") {
    date.setFullYear(date.getFullYear() + amount);
  } else if (timeType == "MONTH") {
    date.setMonth(date.getMonth() + amount);
  } else if (timeType == "DAY_OF_MONTH") {
    date.setDate(date.getDate() + amount);
  } else if (timeType == "HOUR") {
    date.setHours(date.getHours() + amount);
  } else if (timeType == "MINUTE") {
    date.setMinutes(date.getMinutes() + amount);
  } else if (timeType == "SECOND") {
    date.setSeconds(date.getSeconds() + amount);
  } else if (timeType == "MILLISECOND") {
    date.setMilliseconds(date.getMilliseconds() + amount);
  }
  //返回日期
  var result = "";
  if (len > 3) {//有年份
    result = date.getFullYear();
  }
  if (len > 5) {//有月份
    result = result + "" + monthstr + lFillZero(date.getMonth() + 1);//月份需要加1
  }
  if (len > 7) {//有日期
    result = result + "" + daystr + lFillZero(date.getDate());
  }
  if (len > 10) {//有小时
    result = result + "" + hourstr + lFillZero(date.getHours());
  }
  if (len > 13) {//有分钟
    result = result + "" + minutestr + lFillZero(date.getMinutes());
  }
  if (len > 16) {//有秒钟
    result = result + "" + secondstr + lFillZero(date.getSeconds());
  }
  if (len > 19) {//有毫秒
    result = result + "" + miscstr + lFillZero2(date.getMilliseconds());
  }
  return result;
}

/**
 * 把字段串形的日期去掉分隔符返回
 * @param date (2005-08-23)
 * @return  (20050823)
 */
function dateDeleteSign(date) {
  if (date.trim().length < 10) {
    return date;
  }
  //return date.substr(0,4)+date.substr(5,2)+date.substr(8,2);
  var rs = date.substr(0, 4) + date.substr(5, 2) + date.substr(8, 2);
  if (date.length > 10) {
    rs += date.substr(11, 2);
  }
  return rs;
}
