var path = require("path");

module.exports = {
    //入口文件
    entry: "./src/webpack/main.js",
    output: {
        //输出路径
        path: path.resolve(__dirname,"./dist"),
        filename: "bundle.js"
    }
}