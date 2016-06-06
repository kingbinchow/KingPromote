cordova.define("custompluginId", function(require, exports, module) {

var exec = require('cordova/exec');
var myFunc = function(){};

// arg1：成功回调
// arg2：失败回调
// arg3：将要调用类配置的标识
// arg4：调用的原生方法名
// arg5：参数，json格式
myFunc.prototype.startActivityJs=function(text) {
    exec(null, null, "custom", "startActivityJs", [text]);
};
var showt = new myFunc();
module.exports = showt;
});