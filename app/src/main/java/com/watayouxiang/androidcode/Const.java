package com.watayouxiang.androidcode;

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2021/02/19
 *     desc   :
 * </pre>
 */
public interface Const {

    String github_url = "https://github.com/watayouxiang/Android/tree/master";
    String app_java_url = github_url + "/app/src/main/java/com/watayouxiang/androidcode";
    String remoteService_main_url = github_url + "/remoteService/src/main";

    String project_dir = System.getProperty("user.dir");
    String app_java_dir = project_dir + "/app/src/main/java/com/watayouxiang/androidcode";

    String activity_url = app_java_url + "/activity";
    String animation_url = app_java_url + "/animation";
    String handler_url = app_java_url + "/handler";
    String others_url = app_java_url + "/others";
    String service_url = app_java_url + "/service";
    String view_url = app_java_url + "/view";

}
