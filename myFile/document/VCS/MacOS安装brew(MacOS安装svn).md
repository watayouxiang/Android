# MacOS安装brew(MacOS安装svn)

> 参考来源：https://blog.csdn.net/mehent/article/details/108180940



## Homebrew介绍

- Homebrew 能干什么? 使用 Homebrew 安装 Apple 没有预装但 你需要的东西。

- Xcode 现在已经不提供svn的命令行工具了，想安装的话，需要先安装 brew。
- Homebrew官方地址: https://brew.sh/index_zh-cn



## 安装brew

安装 brew，建议使用国内镜像。使用国外镜像，会报错。

```
// 安装brew（国内镜像地址）
/bin/zsh -c "$(curl -fsSL https://gitee.com/cunkai/HomebrewCN/raw/master/Homebrew.sh)"

// 安装软件
brew install 软件名

// 卸载软件
brew uninstall 软件名

// 搜索软件
brew search 软件名

// 查看已安装软件列表
brew list

// 查看需要更新的软件
brew outdated

// 更新软件
brew upgrade 软件名

// 更新Homebrew
brew update
```



## 安装svn

成功后，就可以安装svn了。

```
// 安装svn
brew install svn

// 查看版本
svn --version

// 查看路径
which svn
```



