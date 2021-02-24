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
    String myAndroid_dir = project_dir + "/myAndroid/src/main/java/com/watayouxiang/myandroid";

    String myAndroid_md_url = github_url + "/myAndroid/README.md";
    String myAndroid_md_path = project_dir + "/myAndroid/README.md";

    String remoteService_url = github_url + "/remoteService/src/main";

    String myAndroid_activity_url = myAndroid_url + "/activity";
    String myAndroid_animation_url = myAndroid_url + "/animation";
    String myAndroid_handler_url = myAndroid_url + "/handler";
    String myAndroid_others_url = myAndroid_url + "/others";
    String myAndroid_service_url = myAndroid_url + "/service";
    String myAndroid_view_url = myAndroid_url + "/view";

    // ====================================================================================
    // myDocument
    // ====================================================================================

    String myDocument_dir = project_dir + "/myDocument/document";

    String myDocument_md_url = github_url + "/myDocument/README.md";
    String myDocument_md_path = project_dir + "/myDocument/README.md";

    // ====================================================================================
    // myJava
    // ====================================================================================

    String myJava_dir = project_dir + "/myJava/src/main/java/com/watayouxiang/myjava";

    String myJava_md_url = github_url + "/myJava/README.md";
    String myJava_md_path = project_dir + "/myJava/README.md";

    // ====================================================================================
    // myKotlin
    // ====================================================================================

    String myKotlin_dir = project_dir + "/myKotlin/src/main/java/com/watayouxiang/mykotlin";
    String myKotlin_md_path = project_dir + "/mykotlin/README.md";

    // ====================================================================================
    // myKotlin
    // ====================================================================================

    String androidutils_dir = project_dir + "/androidutils/src/main/java/com/watayouxiang/androidutils";
    String androidutils_md_path = project_dir + "/androidutils/README.md";
}
