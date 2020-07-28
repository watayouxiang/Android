package com.watayouxiang.androidcode;

import com.watayouxiang.demoshell.tool.MdFileData;
import com.watayouxiang.demoshell.tool.MdFileTool;

public class AndroidMD {

    /**
     * main方法运行不起来解决办法：
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
                return System.getProperty("user.dir") + "/app/README.md";
            }

            @Override
            public String getProjectUrl() {
                return "https://github.com/watayouxiang/AndroidCode/tree/master";
            }
        });
    }

}
