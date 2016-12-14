/**
 * 2013-03-21
 * 梁华山
 * 公用查询条件脚本
 * 使用此js时必须引用DateUtil.js
 */

var conFocusId = "conTodaySpan";//当前选中的对象id
var focusTopId = "top10Span";//当前选中的对象id

var conditionValue = getCurDate();//当前配置条件的值
var startTopValue = "1";//起始名次
var endTopValue = "10";//结束名次
var userAccountValue = "";//账号
var productValue = "-1";//产品
var provinceValue = encode("全部");//省份

//为日期控制加的清空实现
function clearInputText() {
    $('conCalInput').value = "";
}

//鼠标选中时的样式
function conMouseOver(obj) {
    if (obj.className != 'conSelect') {
        obj.className = "conSelect";
    }
}
//鼠标离开时的样式
function conMouseOut(obj) {
    if (conFocusId != obj.id) {
        obj.className = 'conDefault';
    }
}

//按钮“前10名”点击事件实现的方法
function setTop(obj) {
    $("startTop").value = "1";//设置开始名次
    if (obj.id == 'top10Span') {
        $("endTop").value = "10";//设置结束名次
    } else {
        $("endTop").value = "50";//设置结束名次
    }
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

//选择特定日期
function setSpecialDay(obj) {
    //设置样式
    if (conFocusId != "conCalInput") {
        $(conFocusId).className = 'conDefault';
    }
    conFocusId = obj.id;
    if (conFocusId != "conCalInput") {
        obj.className = 'conSelect';
    }

    //设置查询条件值
    if (conFocusId == "conTodaySpan") {//今天
        conditionValue = getCurDate();
    } else if (conFocusId == "conYesterdaySpan") {//昨天
        conditionValue = getYesterDay();
    } else if (conFocusId == "conTDBYSpan") {//前天
        conditionValue = getCurDate();
        conditionValue = datetimeAdd(conditionValue, 'DAY_OF_MONTH', -2);
    } else if (conFocusId == "conSevenDaysSpan") {//最近7天
        conditionValue = "99991303";
    } else if (conFocusId == "conThirtyDaysSpan") {//最近30天
        conditionValue = "99991304";
    } else if (conFocusId == "conOneYearSpan") {//最近1年
        conditionValue = "99991305";
    } else if (conFocusId == "conThreeYearsSpan") {//最近3年
        conditionValue = "99991306";
    }
    $("conCalInput").value = "";//设置日期值为空
    //showWaiting();//显示等待遮罩
    //submitSearch(conditionValue);//提交查询
    if ("1" == autoSubmit) {
        conSearch();//提交查询
    }
}

function conInputSearch(obj) {
    //设置样式
    if (conFocusId != "conCalInput") {
        $(conFocusId).className = 'conDefault';
    }
    conFocusId = obj.id;

    //setDay(obj,'yyyy-MM-dd');
    var date = obj.value;
    date = dateDeleteSign(date);
    var today = getCurDate();
    var lastDay = datetimeAdd(today, "DAY_OF_MONTH", (dataKeepDays * -1));
    if (date > today || date < lastDay) {
        alert("日期必须在今天及之前的[" + dataKeepDays + "]天以内");
        obj.value = "";
        return;
    }
    conditionValue = date;
    //showWaiting();//显示等待遮罩
    //submitSearch(conditionValue);//提交查询
    if ("1" == autoSubmit) {
        conSearch();//提交查询
    }
}

//选择产品
function setProduct() {
    if ("1" == autoSubmit) {
        conSearch();//提交查询
    }
}

//选择省份
function setProvince() {
    if ("1" == autoSubmit) {
        conSearch();//提交查询
    }
}

function conSearch() {
    //名次
    if (topss == "1") {
        if (!checkTops()) {
            return;
        }
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
    submitSearch(conditionValue);//提交查询
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
