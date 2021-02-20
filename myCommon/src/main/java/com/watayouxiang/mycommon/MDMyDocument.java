package com.watayouxiang.mycommon;

import com.watayouxiang.demoshell.tool.MdFileData;
import com.watayouxiang.demoshell.tool.MdFileTool;

// README.md 文件生成器
public class MDMyDocument {

    public static void main(String[] args) {
        new MdFileTool().start(new MdFileData() {
            @Override
            public String getInDirPath() {
                return Const.myDocument_dir;
            }

            @Override
            public String getOutFilePath() {
                return Const.myDocument_md_path;
            }

            @Override
            public String getProjectUrl() {
                return Const.github_url;
            }
        });
    }

}
