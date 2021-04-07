package com.watayouxiang.androiddemo;

import com.imooc.gradle.router.runtime.Router;
import com.imooc.router.annotations.Destination;
import com.watayouxiang.androiddemo.animation.AnimationDemoActivity;
import com.watayouxiang.androiddemo.handler.HandlerDemoActivity;
import com.watayouxiang.androiddemo.provider.demo.ui.ContentProviderDemoActivity;
import com.watayouxiang.androiddemo.service.ServiceDemoActivity;
import com.watayouxiang.androiddemo.view.ViewDemoActivity;
import com.watayouxiang.demoshell.ListActivity;
import com.watayouxiang.demoshell.ListData;

// 使用自己定义的注解
@Destination(
        url = "router://page-home",
        description = "应用主页"
)
public class MainActivity extends ListActivity {
    @Override
    protected ListData getListData() {
        return new ListData()
                .addActivity(this, AnimationDemoActivity.class)
                .addActivity(this, HandlerDemoActivity.class)
                .addActivity(this, ServiceDemoActivity.class)
                .addActivity(this, ViewDemoActivity.class)
                .addActivity(this, ContentProviderDemoActivity.class)

                .addSection("测试路由框架")
                .addClick("测试打开路由页面", view -> Router.INSTANCE.go(view.getContext(), "router://imooc/profile?name=imooc&message=hello"))
                ;
    }
}
