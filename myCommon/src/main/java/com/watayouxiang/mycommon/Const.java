package com.watayouxiang.mycommon;

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
    // myAndroid
    // ====================================================================================

    String myAndroid_url = github_url + "/myAndroid/src/main/java/com/watayouxiang/myandroid";

    String remoteService_url = github_url + "/remoteService/src/main";

    String myAndroid_activity_url = myAndroid_url + "/activity";
    String myAndroid_animation_url = myAndroid_url + "/animation";
    String myAndroid_handler_url = myAndroid_url + "/handler";
    String myAndroid_others_url = myAndroid_url + "/others";
    String myAndroid_service_url = myAndroid_url + "/service";
    String myAndroid_view_url = myAndroid_url + "/view";

    String myAndroid_dir = project_dir + "/myAndroid/src/main/java/com/watayouxiang/myandroid";
    String myAndroid_MDPath = project_dir + "/myAndroid/README.md";

    // ====================================================================================
    // myDocument
    // ====================================================================================

    String myDocument_dir = project_dir + "/myDocument/document";
    String myDocument_MDPath = project_dir + "/myDocument/README.md";

    // ====================================================================================
    // myJava
    // ====================================================================================

    String myJava_dir = project_dir + "/myJava/src/main/java/com/watayouxiang/myjava";
    String myJava_MDPath = project_dir + "/myJava/README.md";

}
