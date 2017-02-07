/**
 * 2013-03-21
 * 梁华山
 * 公用查询条件2脚本
 * 使用此js时必须引用DateUtil.js
 */

var focusDtId = "todaySpan";//当前选中的对象id
var focusTopId = "top10Span";//当前选中的对象id

var startDtValue = getCurDate();//起始日期
var endDtValue = getCurDate();//结束日期
var startTopValue = "1";//起始名次
var endTopValue = "10";//结束名次
var userAccountValue = "";//账号
var productValue = "-1";//产品
var provinceValue = encode("全部");//省份

//为日期控制加的清空实现
function clearInputText() {

}

//鼠标选中时的样式
function conMouseOver(obj) {
    if (obj.className != 'conSelect') {
        obj.className = "conSelect";
    }
}
//鼠标离开时的样式
function conMouseOut(obj) {
    if (focusDtId != obj.id && focusTopId != obj.id) {
        obj.className = 'conDefault';
    }
}

//选择特定日期
function setSpecialDay(obj) {
    setDayFocus(obj.id);//选中日期
    var st = '';
    var en = getSignCurDate("-");
    //设置查询条件值
    if (focusDtId == "todaySpan") {//今天
        st = en;
    } else if (focusDtId == "yesterdaySpan") {//昨天
        st = getSignYesterDay("-");
        en = st;
    } else if (focusDtId == "conTDBYSpan") {//前天
        st = signDatetimeAdd(en, 'DAY_OF_MONTH', -2);
        en = st;
    } else if (focusDtId == "conSevenDaysSpan") {//最近7天
        st = signDatetimeAdd(en, 'DAY_OF_MONTH', -6);
    } else if (focusDtId == "conThirtyDaysSpan") {//最近30天
        st = signDatetimeAdd(en, 'MONTH', -1);
        st = signDatetimeAdd(st, 'DAY_OF_MONTH', 1);
    } else if (focusDtId == "conOneYearSpan") {//最近1年
        st = signDatetimeAdd(en, 'YEAR', -1);
        st = signDatetimeAdd(st, 'DAY_OF_MONTH', 1);
    } else if (focusDtId == "conThreeYearsSpan") {//最近3年
        st = signDatetimeAdd(en, 'YEAR', -3);
        st = signDatetimeAdd(st, 'DAY_OF_MONTH', 1);
    }
    if (dateformat == 'yyyy-MM-dd hh') {
        st += " 00";
        en += " 23";
    }
    $("startDt").value = st;//设置开始日期
    $("endDt").value = en;//设置结束日期
    if ("1" == autoSubmit) {
        conSearch2();//提交查询
    }
}
//设置选中的样式
function setDayFocus2(newFocusId) {
    setDayFocus(newFocusId);
    if ("1" == autoSubmit) {
        conSearch2();//提交查询
    }
}

//设置选中的样式
function setDayFocus(newFocusId) {
    if (focusDtId == "todaySpan" || focusDtId == "yesterdaySpan"
        || focusDtId == "conSevenDaysSpan" || focusDtId == "conThirtyDaysSpan"
        || focusDtId == "conOneYearSpan" || focusDtId == "conThreeYearsSpan") {
        $(focusDtId).className = 'conDefault';
    }
    //alert("$('"+focusDtId+"').className="+$(focusDtId).className);
    focusDtId = newFocusId;
    if (focusDtId == "todaySpan" || focusDtId == "yesterdaySpan"
        || focusDtId == "conSevenDaysSpan" || focusDtId == "conThirtyDaysSpan"
        || focusDtId == "conOneYearSpan" || focusDtId == "conThreeYearsSpan") {
        $(focusDtId).className = 'conSelect';
    }
    //alert("$('"+focusDtId+"').className="+$(focusDtId).className);
}

//检查日期是否合法
function checkDt() {
    //赋值
    startDtValue = dateTDeleteSign($("startDt").value) * 1;
    endDtValue = dateTDeleteSign($("endDt").value) * 1;
    //开始大于结束，交换数据
    if (startDtValue > endDtValue) {
        var temp = $("startDt").value;
        $("startDt").value = $("endDt").value;
        $("endDt").value = temp;
        temp = startDtValue;
        startDtValue = endDtValue;
        endDtValue = temp;
    }
    var today = getCurDate();
    var lastDay = datetimeAdd(today, "DAY_OF_MONTH", betweenDays);
    if (dateformat == 'yyyy-MM-dd hh') {
        today += "23";
        lastDay += "00";
    }
    //alert("startDtValue="+ startDtValue+" endDtValue="+endDtValue+
    //	"\n lastDay="+lastDay+" today="+today);
    if (startDtValue < lastDay || endDtValue > today) {
        alert("时间必须在今天及之前的[" + betweenDays * -1 + "]天以内");
        obj.value = "";
        return false;
    }
    return true;
}

//按钮“前10名”点击事件实现的方法
function setTop10(obj) {
    $("startTop").value = "1";//设置开始名次
    $("endTop").value = "10";//设置结束名次\
    setTopFocus(obj.id);
}

//按钮“前50名”点击事件实现的方法
function setTop50(obj) {
    var nowDate = getSignYesterDay("-");
    $("startTop").value = "1";//设置开始名次
    $("endTop").value = "50";//设置结束名次
    setTopFocus(obj.id);
}

//设置选中的样式
function setTopFocus(newFocusId) {
    if (focusTopId == "top10Span" || focusTopId == "top50Span") {
        $(focusTopId).className = 'conDefault';
    }
    focusTopId = newFocusId;
    if (focusTopId == "top10Span" || focusTopId == "top50Span") {
        $(focusTopId).className = 'conSelect';
    }
}

//检查名次是否正确
function checkTops() {
    if (isNull($("startTop").value)) {
        alert("起始名次不可空白！");
        $("startTop").focus();
        return false;
    }
    if (isNull($("endTop").value)) {
        alert("结束名次不可空白！");
        $("endTop").focus();
        return false;
    }

    if (!isPositiveInteger($("startTop").value)) {
        alert("起始名次不是有效的正整数！");
        $("startTop").focus();
        return false;
    }
    if (!isPositiveInteger($("endTop").value)) {
        alert("结束名次不是有效的正整数！");
        $("endTop").focus();
        return false;
    }
    //alert('$("startTop").value='+$("startTop").value+' $("endTop").value='+$("endTop").value);
    //开始大于结束，交换数据
    if ($("startTop").value * 1 > $("endTop").value * 1) {
        var temp = $("startTop").value;
        $("startTop").value = $("endTop").value;
        $("endTop").value = temp;
    }
    //赋值
    startTopValue = $("startTop").value;//起始名次
    endTopValue = $("endTop").value;//结束名次
    return true;
}

//选择产品
function setProduct() {
    if ("1" == autoSubmit) {
        conSearch2();//提交查询
    }
}

//选择省份
function setProvince() {
    if ("1" == autoSubmit) {
        conSearch2();//提交查询
    }
}

//查询提交
function conSearch2() {
    if (topss == "1") {
        if (!checkTops()) {
            return;
        }
    }
    if (!checkDt()) {
        return;
    }
    if (userAccounts == "1") {
        userAccountValue = $("userAccount").value
        if (isNull(userAccountValue)) {
            alert("账号不可空白！");
            $("userAccount").focus();
            return false;
        }
    }
    if (product == "1") {//产品
        productValue = $("product").value;
    }
    if (province == "1") {//省份
        provinceValue = encode($("province").value);
    }
    showWaiting();//显示等待遮罩
    submitSearch();//提交查询
}
//显示等待遮罩
function showWaiting() {
    obj = $("progressMsg");//显示覆盖页面的DIV
    obj.style.height = document.body.clientHeight;
    obj.style.width = document.body.clientWidth;
    obj.style.display = "";
}

//隐藏等待遮罩
function hidenWaiting() {
    obj = $("progressMsg");//显示覆盖页面的DIV
    obj.style.height = "0px";
    obj.style.width = "0px";
    obj.style.display = "none";
}

function dateTDeleteSign(date) {
    var rs = date.substr(0, 4) + date.substr(5, 2) + date.substr(8, 2);
    if (date.length > 10) {
        rs += date.substr(11, 2);
    }
    return rs;
}
