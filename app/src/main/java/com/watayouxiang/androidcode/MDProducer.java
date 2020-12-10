package com.watayouxiang.androidcode;

import com.watayouxiang.demoshell.tool.MdFileData;
import com.watayouxiang.demoshell.tool.MdFileTool;

// README.md 文件生成器
public class MDProducer {

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
