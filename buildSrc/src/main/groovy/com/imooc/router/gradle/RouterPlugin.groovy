package com.imooc.router.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

class RouterPlugin implements Plugin<Project> {
    // 实现apply方法，注入插件的逻辑
    @Override
    void apply(Project project) {

        // 1、自动帮助用户传递路径参数到注解处理器中
        // 2、实现旧的构建产物的自动清理
        // 3、在 javac 任务后，汇总生成文档
        //
        //     kapt {
        //        arguments {
        //            arg("root_project_dir", rootProject.projectDir.absolutePath)
        //        }
        //    }

        if (project.extensions.findByName("kapt") != null) {
            project.extensions.findByName("kapt").arguments {
                arg("root_project_dir", project.rootProject.projectDir.absolutePath)
            }
        }

        println("i am from RouterPlugin, apply from ${project.name}")

        // 创建 Extension
        project.getExtensions().create("router", RouterExtension)

        // 获取 Extension
        project.afterEvaluate {
            RouterExtension extension = project["router"]
            println("用户设置的 wikiDir 路径：${extension.wikiDir}")
        }
    }
}