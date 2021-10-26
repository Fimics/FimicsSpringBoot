//import http
var http = require("http")
var url = require("url")
//创建并监听web 服务器
http.createServer(function (request,response) {
    response.writeHead(200,{"Content-Type":"text/plain"});
    //send data
    // response.end("hello nodejs http")

    // for (var i=0;i<10;i++){
    //     response.write(i+ "  ->hello nodjs \n")
    // }

    /**
     * 解析请求地址
     * 1.请求地址
     * 2.true ->使用query解析到一个对象，默认为false
     */
    var params = url.parse(request.url,true).query;
    for (var key in params){
        response.write(key +" = "+params[key])
        response.write("\n")
    }

    response.end("")
}).listen(8888)

console.log("服务吕运行在 http://127.0.0.1:8888")