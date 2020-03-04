function getDateFormation(timeStr, formatStr,flag) {
  var arr = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
  var arrtime = timeStr.split(" ");
  var str = arrtime[2];//年
  var strMonth = "";
  var strDate = "";
  if (flag == true){
    str += ".";
  }
  else{
    str += "-";
  }

  for(var i=0;i<arr.length;i++){//月
      if(timeStr.indexOf(arr[i])!=-1){
          strMonth += (i+1)>=10?(i+1):"0"+(i+1);
      }
  }

  str+=strMonth;
  strDate+=strMonth;
  strDate += "-";
  if (flag == true){
    str += ".";
  }
  else{
    str += "-";
  }

  var day=arrtime[1].substring(0,2);
  //处理小于10的日期
  if(day.indexOf(',')!=-1)
  {
    day="0"+day.substring(0,1);
  }
  str+=day;
  strDate+=day;
  //str += arrtime[1].substring(0,2);//日

  if(formatStr == "yyyy-MM-dd"){
      return str;
  }

  if (formatStr == "MM-dd"){
    return strDate;
  }

  str += " ";
  var hh = arrtime[3].substring(0,2);//小时
    hh=arrtime[3].split(":")[0];//修复时间只有一位时转换错误问题
  if(formatStr == "yyyy-MM-dd HH:mm"){//小时分钟
      if(timeStr.indexOf("PM")!=-1){
          str += (parseInt(hh)+12);
          //修复时间只有一位时转换错误问题
          if(parseInt(hh)<10){
            str += arrtime[3].substring(1,5);
          }
          else{
              str += arrtime[3].substring(2,5);
          }
      }else{
          str += arrtime[3].substring(0,5);
      }
  }

  if(formatStr == "yyyy-MM-dd HH:mm:ss"){//小时分钟秒
      if(timeStr.indexOf("PM")!=-1){
          str += (parseInt(hh)+12);
         //修复时间只有一位时转换错误问题
          if(parseInt(hh)<10){
            str += arrtime[3].substring(1,9);
          }
          else{
            str += arrtime[3].substring(2,9);
          }
      }else{
          str += arrtime[3].substring(0,9);
      }
  }
  return str;
}

function isNullOrEmpty(str) {
    if (str === null || str === "" || str == "{}"||str === "undefined"||str === undefined)
        return true;
    else {
        return false
    }
}
/**
 * 日期 转换为 Unix时间戳
 * @param <string> 2014-01-01 20:20:20  日期格式
 * @return <int>        unix时间戳(秒)
 */
function DateToUnix(str){
  var f = str.split(' ', 2);
  var d = (f[0] ? f[0] : '').split('-', 3);
  var t = (f[1] ? f[1] : '').split(':', 3);
  return (new Date(
          parseInt(d[0], 10) || null,
          (parseInt(d[1], 10) || 1) - 1,
          parseInt(d[2], 10) || null,
          parseInt(t[0], 10) || null,
          parseInt(t[1], 10) || null,
          parseInt(t[2], 10) || null
          )).getTime() / 1000;
}
// 计算要显示的时间，一天以内的显示多少时间之前 时间格式为yyyy-MM-dd HH:mm:ss
function generateStamp(time){
  var  dateStr=this.getDateFormation(time, "yyyy-MM-dd HH:mm:ss");
  //转换成yyyy-MM-dd HH:mm:ss
    var showDate = "";
    var timeStamp = parseInt(this.DateToUnix(dateStr));
    var diff = parseInt((Date.parse(new Date())/1000) - timeStamp);
    if (diff < 5) {
        showDate = "1秒前";
    } else if (diff < 60) {
        showDate = diff + "秒前";
    } else if (diff < 3600) {
        showDate = parseInt(diff / 60) + "分钟前";
    } else if (diff < 86400) {
        showDate = parseInt(diff / 3600) + "小时前";
    } else if(diff<(3600*24*30)){
          showDate = parseInt(diff / 86400) + "天前";
    }
    else
    {
        showDate = dateStr.split(" ")[0];
    }
    return showDate;
}

//列表数据加载超时块
function GetTimeOutDiv() {
    var html = "<li class=\"timeout\">";
    html += "<img src=\"../../../image/Loadfailure-picture.png\"  width=\"90\" height=\"118\">";
    html += "<p class=\"t1\">加载失败，稍后再试</p>";
    html += "<p class=\"t2\">别紧张，试试看刷新页面~</p>";
    html += "<button type=\"button\"  class=\"button\" onclick=\"location.reload()\">刷新</button>";
    html += "</li>";
    return html;
}

//列表无数据提示块
function GetEmptyli() {
    var html = "<li class=\"empty\">";
    html += "<img src=\"../../../image/Emptycontent-picture.png\"  width=\"147\" height=\"113\">";
    html += "<p>还没有任何数据呢~</p>";
    html += "</li>";
    return html;
}
//加密
function encryptByDES(message) {
    var des = new getDESInstance(); //加密解码类
    return des.encryptByDES(message);
}
//解密
function decryptByDESModeEBC(ciphertext) {
    var des = new getDESInstance(); //加密解码类
    return des.decryptByDESModeEBC(ciphertext);
}
var baseURL = "../../../";
function downloadapp() {
  //window.open("http://218.87.254.137:19494/sport-api/statics/app/appShare/appShare.html");
  window.open(baseURL+"statics/app/appShare/appShare.html");
}

function ajaxRequest(url, method, bodyParam, callBack) {
    var common_url = baseURL;
    $.ajax({
        type: method,
        url: common_url + url,
        data: bodyParam,
        contentType: "application/json;charset=UTF-8",
        success: function(ret, err){
          callBack(ret,err);
        }
      });
}
