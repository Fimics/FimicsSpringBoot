var path = require("path");

module.exports = {
    //入口文件
    entry: "./src/webpack/main.js",
    output: {
        //输出路径
        path: path.resolve(__dirname,"./dist"),
        filename: "bundle.js"
    },

    module: {
        rules: [
            {
                test: /\.css$/,
                //css 文件用下面的转换器转换
                //根据群id和用户id获取群成员信息
                use: ["style-loader","css-loader"]
            }
        ]
    }

}