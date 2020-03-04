//create yjw 2018-09-07
  function yytDES(key,mode,padding,character)
  {
    //加密的私钥
    this.key='1234567890abcdef';
    //加密模式
    this.mode=CryptoJS.mode.ECB;
    //填充方式
    this.padding=CryptoJS.pad.Pkcs7;
    //输出字符方式
    this.character='Base64';
    //加密
    this.encryptByDES=function(message){
      //把私钥转换成16进制的字符串
      var keyHex = CryptoJS.enc.Utf8.parse(this.key);
      //模式为ECB padding为Pkcs7
      var encrypted = CryptoJS.DES.encrypt(message, keyHex, {
          mode: CryptoJS.mode.ECB,
          padding: CryptoJS.pad.Pkcs7
      });
      //加密出来是一个16进制的字符串
      return encrypted.ciphertext.toString();
    }
    //解密
    this.decryptByDESModeEBC=function(ciphertext){
      //把私钥转换成16进制的字符串
      var keyHex = CryptoJS.enc.Utf8.parse(this.key);
      //把需要解密的数据从16进制字符串转换成字符byte数组
      var decrypted = CryptoJS.DES.decrypt({
          //ciphertext: CryptoJS.enc.Hex.parse(ciphertext)//16进制
          ciphertext: CryptoJS.enc.Base64.parse(ciphertext)//64
      }, keyHex, {
          mode: CryptoJS.mode.ECB,
          padding: CryptoJS.pad.Pkcs7
      });
      //以utf-8的形式输出解密过后内容
      var result_value = decrypted.toString(CryptoJS.enc.Utf8);
      return result_value;
    }
  }
  //创建单例类
  var getDESInstance = (function () {
        var instance;
        return function (key,mode,padding,character) {
            if (!instance) {
                instance = new yytDES(key,mode,padding,character);
            }
            return instance;
        }
    })();
  //加载文件
  yytDES.loadscriptstr=function(){
    var scriptArgs = document.getElementById('yytDESScript').getAttribute('data');
    var url="../../../";
    switch (scriptArgs) {
      case "0":
        url="./";
        break;
      case "1":
        url="../";
        break;
      case "2":
        url="../../";
        break;
      case "3":
        url="../../../";
        break;
      default:
    }
    document.write('<script type="text/javascript" src="'+url+'js/des/core.js"></script>');
    document.write('<script type="text/javascript" src="'+url+'js/des/enc-base64.js"></script>');
    document.write('<script type="text/javascript" src="'+url+'js/des/cipher-core.js"></script>');
    document.write('<script type="text/javascript" src="'+url+'js/des/mode-ecb.js"></script>');
    document.write('<script type="text/javascript" src="'+url+'js/des/tripledes.js"></script>');
  }
  yytDES.loadscriptstr();//初始化加载JS文件
