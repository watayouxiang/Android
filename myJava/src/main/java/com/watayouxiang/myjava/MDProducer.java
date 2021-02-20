package com.watayouxiang.myjava;

import com.watayouxiang.common.Const;
import com.watayouxiang.demoshell.tool.MdFileData;
import com.watayouxiang.demoshell.tool.MdFileTool;

// README.md 文件生成器
public class MDProducer {

    public static void main(String[] args) {
        new MdFileTool().start(new MdFileData() {
            @Override
            public String getInDirPath() {
                return Const.myJava_inDir;
            }

            @Override
            public String getOutFilePath() {
                return Const.myJava_outFile;
            }

            @Override
            public String getProjectUrl() {
                return Const.github_url;
            }
        });
    }

}