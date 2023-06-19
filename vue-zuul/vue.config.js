const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave:false, /*关闭语法检查*/
  devServer:{
    port: 7000
  },
  chainWebpack: config => {
    config.module
      .rule('scss')
      .use('sass-loader')
      .tap(options => {
        options = options || {}
        options.includePaths = ['src/styles']
        return options
      })
  }


})
