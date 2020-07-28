package com.watayouxiang.androidcode;

import com.watayouxiang.demoshell.tool.MdFileData;
import com.watayouxiang.demoshell.tool.MdFileTool;

// README.md 文件生成器
public class MDProducer {

    /**
     * "android工程" 跑不了 "java main 方法" 的解决办法：
     * <p>
     * .idea/gradle.xml：添加
     * <option name="delegatedBuild" value="false" />
     */
    public static void main(String[] args) {
        new MdFileTool().start(new MdFileData() {
            @Override
            public String getInDirPath() {
                return System.getProperty("user.dir") + "/app/src/main/java/com/watayouxiang/androidcode";
            }

            @Override
            public String getOutFilePath() {
                return System.getProperty("user.dir") + "/README.md";
            }

            @Override
            public String getProjectUrl() {
                return "https://github.com/watayouxiang/Android/tree/master";
            }
        });
    }

}
