# 加固后的apk重新签名

> 参考：https://blog.csdn.net/snowbeatrain/article/details/105275092



具备java环境，然后运行以下命令：



```
jarsigner -digestalg SHA1 -sigalg MD5withRSA -verbose -keystore /Users/TaoWang/Documents/Code/tiocloud/android/wt_key/tiochat_wt2020.keystore -signedjar /Users/TaoWang/Desktop/tioIm.apk /Users/TaoWang/Desktop/64d23aca358d23a95174afa33e6847ae.20210219173414.apk tiochat_wt2020
```




jarsigner -digestalg SHA1 -sigalg MD5withRSA -tsa -verbose -keystore [你的keystore文件路径] -signedjar [重新签名后生成的apk文件路径] [要加固的apk文件路径] [你的keystore文件别名]

