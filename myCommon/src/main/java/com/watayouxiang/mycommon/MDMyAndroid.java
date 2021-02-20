package com.watayouxiang.mycommon;

import com.watayouxiang.demoshell.tool.MdFileData;
import com.watayouxiang.demoshell.tool.MdFileTool;

// README.md 文件生成器
public class MDMyAndroid {

    public static void main(String[] args) {
        new MdFileTool().start(new MdFileData() {
            @Override
            public String getInDirPath() {
                return Const.myAndroid_dir;
            }

            @Override
            public String getOutFilePath() {
                return Const.myAndroid_MDPath;
            }

            @Override
            public String getProjectUrl() {
                return Const.github_url;
            }
        });
    }

}
