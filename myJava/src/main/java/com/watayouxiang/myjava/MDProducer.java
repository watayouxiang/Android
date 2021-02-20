package com.watayouxiang.myjava;

import com.watayouxiang.demoshell.tool.MdFileData;
import com.watayouxiang.demoshell.tool.MdFileTool;

// README.md 文件生成器
public class MDProducer {

    public static void main(String[] args) {
        new MdFileTool().start(new MdFileData() {
            @Override
            public String getInDirPath() {
                return Const.md_in_dir;
            }

            @Override
            public String getOutFilePath() {
                return Const.md_out_dir;
            }

            @Override
            public String getProjectUrl() {
                return Const.github_url;
            }
        });
    }

    public interface Const {
        String github_url = "https://github.com/watayouxiang/Android/tree/master";

        String project_dir = System.getProperty("user.dir");
        String md_in_dir = project_dir + "/myJava/src/main/java/com/watayouxiang/myjava";
        String md_out_dir = project_dir + "/myJava/README.md";
    }

}
