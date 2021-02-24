package com.watayouxiang.mycommon;

import com.watayouxiang.demoshell.tool.MdFileData;
import com.watayouxiang.demoshell.tool.MdFileTool;

// README.md 文件生成器
public class MDAndroidUtils {

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
                return Const.androidutils_dir;
            }

            @Override
            public String getOutFilePath() {
                return Const.androidutils_md_path;
            }

            @Override
            public String getProjectUrl() {
                return Const.github_url;
            }
        });
    }

}
