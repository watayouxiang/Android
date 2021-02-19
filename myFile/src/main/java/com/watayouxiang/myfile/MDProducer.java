package com.watayouxiang.myfile;

import com.watayouxiang.demoshell.tool.MdFileData;
import com.watayouxiang.demoshell.tool.MdFileTool;

// README.md 文件生成器
public class MDProducer {

    public static void main(String[] args) {
        new MdFileTool().start(new MdFileData() {
            @Override
            public String getInDirPath() {
                return Const.app_java_dir;
            }

            @Override
            public String getOutFilePath() {
                return Const.project_dir + "/myFile/README.md";
            }

            @Override
            public String getProjectUrl() {
                return Const.github_url;
            }
        });
    }

}
