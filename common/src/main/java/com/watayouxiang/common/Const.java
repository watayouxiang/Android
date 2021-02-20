package com.watayouxiang.common;

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2021/02/20
 *     desc   :
 * </pre>
 */
public interface Const {
    String github_url = "https://github.com/watayouxiang/Android/tree/master";
    String project_dir = System.getProperty("user.dir");

    // ====================================================================================
    // remoteService
    // ====================================================================================

    String remoteService_url = github_url + "/remoteService/src/main";

    // ====================================================================================
    // myAndroid
    // ====================================================================================
    String myAndroid_url = github_url + "/myAndroid/src/main/java/com/watayouxiang/myandroid";

    String activity_url = myAndroid_url + "/activity";
    String animation_url = myAndroid_url + "/animation";
    String handler_url = myAndroid_url + "/handler";
    String others_url = myAndroid_url + "/others";
    String service_url = myAndroid_url + "/service";
    String view_url = myAndroid_url + "/view";

    String myAndroid_inDir = project_dir + "/myAndroid/src/main/java/com/watayouxiang/myandroid";
    String myAndroid_outFile = project_dir + "/myAndroid/README.md";

    // ====================================================================================
    // myDocument
    // ====================================================================================

    String myDocument_inDir = project_dir + "/myDocument/document";
    String myDocument_outFile = project_dir + "/myDocument/README.md";

    // ====================================================================================
    // myJava
    // ====================================================================================

    String myJava_inDir = project_dir + "/myJava/src/main/java/com/watayouxiang/myjava";
    String myJava_outFile = project_dir + "/myJava/README.md";
}
