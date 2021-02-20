package com.watayouxiang.myandroid;

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
        String remoteService_url = github_url + "/remoteService/src/main";
        String myAndroid_url = github_url + "/app/src/main/java/com/watayouxiang/androidcode";
        String activity_url = myAndroid_url + "/activity";
        String animation_url = myAndroid_url + "/animation";
        String handler_url = myAndroid_url + "/handler";
        String others_url = myAndroid_url + "/others";
        String service_url = myAndroid_url + "/service";
        String view_url = myAndroid_url + "/view";

        String project_dir = System.getProperty("user.dir");
        String md_in_dir = project_dir + "/myAndroid/src/main/java/com/watayouxiang/myandroid";
        String md_out_dir = project_dir + "/myAndroid/README.md";
    }

}
