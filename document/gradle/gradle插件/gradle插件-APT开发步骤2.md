## kapt的使用

> apt只能收集java的注解，如果还要收集kotlin注解的话，需要使用kapt。

- 根目录的 build.gradle 编写

  - ```
    buildscript {
        dependencies {
            // 添加 kotlin 编译插件
            classpath 'org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.72'
        }
    }
    ```

- app module 的 build.gradle 编写

  - ```
    // kotlin 插件
    apply plugin: 'kotlin-android'
    apply plugin: 'kotlin-kapt'
    
    dependencies {
        implementation project(':router-annotations')
        // 搜集 java的注解 和 kotlin的注解
        kapt project(':router-processor')
    }
    ```

  - 