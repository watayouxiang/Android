## 1、建立router-annotations注解工程

- 建立 router-annotations 目录

- 添加 build.gradle

  - ```
    // 应用 java 插件
    apply plugin: 'java'
    
    // 设置源码兼容性
    targetCompatibility = JavaVersion.VERSION_1_7
    sourceCompatibility = JavaVersion.VERSION_1_7
    ```

- 创建注解 src/main/java/com.imooc.router.annotations.Destination

  - ```
    /**
     * 说明当前注解可以修饰的元素，此处表示可以用于标记在类上面
     */
    @Target({ElementType.TYPE})
    /**
     * 说明当前注解可以被保留的时间
     */
    @Retention(RetentionPolicy.CLASS)
    public @interface Destination {
        /**
         * 当前页面的url，不能为空
         *
         * @return 页面的url
         */
        String url();
    
        /**
         * 对于当前页面的中文描述
         *
         * @return 例如："个人主页"
         */
        String description();
    }
    ```



## 2、建立router-processor注解处理器工程

- 添加 build.gradle

  - ```
    // 引入java插件，帮助编译代码
    apply plugin: 'java'
    
    dependencies {
        implementation project(':router-annotations')
        
        // 使用google的注解处理器，@AutoService(Processor.class)
        // 会帮助自动创建 META-INF/services/javax.annotation.processing.Processor 文件
        implementation 'com.google.auto.service:auto-service:1.0-rc6'
        annotationProcessor 'com.google.auto.service:auto-service:1.0-rc6'
    }
    ```

- 创建注解处理器 src/main/java/com.imooc.router.processor.DestinationProcessor

  - ```
    /**
     * 告诉 javac 加载注解处理器 DestinationProcessor
     * <p>
     * 会帮助自动创建 META-INF/services/javax.annotation.processing.Processor 文件
     */
    @AutoService(Processor.class)
    public class DestinationProcessor extends AbstractProcessor {
    
        private static final String TAG = "DestinationProcessor";
    
        /**
         * 编译器找到我们关心的注解后，会回调这个方法
         *
         * @param set
         * @param roundEnvironment
         * @return
         */
        @Override
        public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
            // 避免多次调用 process
            if (roundEnvironment.processingOver()) {
                return false;
            }
    
            System.out.println(TAG + " >>> process start ...");
    
            // 获取所有标记了 @Destination 注解的 类的信息
            Set<Element> allDestinationElements = (Set<Element>) roundEnvironment.getElementsAnnotatedWith(Destination.class);
    
            System.out.println(TAG + " >>> all Destination elements count = " + allDestinationElements.size());
    
            // 当未收集到 @Destination 注解的时候，跳过后续流程
            if (allDestinationElements.size() < 1) {
                return false;
            }
    
            // 将要自动生成的类的类名
            String className = "RouterMapping_" + System.currentTimeMillis();
    
            StringBuilder builder = new StringBuilder();
    
            builder.append("package com.watayouxiang.androiddemo.mapping;\n\n");
            builder.append("import java.util.HashMap;\n");
            builder.append("import java.util.Map;\n\n");
            builder.append("public class ").append(className).append(" {\n\n");
            builder.append("    public static Map<String, String> get() {\n");
            builder.append("        Map<String, String> mapping = new HashMap<>();\n\n");
    
    
            // 遍历所有 @Destination 注解信息，挨个获取详细信息
            for (Element element : allDestinationElements) {
    
                final TypeElement typeElement = (TypeElement) element;
    
                // 尝试在当前类上，获取 @Destination 的信息
                final Destination destination = typeElement.getAnnotation(Destination.class);
    
                if (destination == null) continue;
    
                final String url = destination.url();
                final String description = destination.description();
                // 获取注解当前类的全类名
                final String realPath = typeElement.getQualifiedName().toString();
    
                System.out.println(TAG + " >>> url = " + url);
                System.out.println(TAG + " >>> description = " + description);
                System.out.println(TAG + " >>> realPath = " + realPath);
    
                builder.append("        ")
                        .append("mapping.put(")
                        .append("\"" + url + "\"")
                        .append(", ")
                        .append("\"" + realPath + "\"")
                        .append(");\n")
                ;
            }
    
            builder.append("\n");
            builder.append("        return mapping;\n");
            builder.append("    }\n\n");
            builder.append("}\n");
    
            String mappingFullClassName = "com.watayouxiang.androiddemo.mapping." + className;
    
            System.out.println(TAG + " >>> mappingFullClassName = " + mappingFullClassName);
            System.out.println(TAG + " >>> class content = \n" + builder);
    
            // 写入自动生成的类到本地文件中
            try {
                JavaFileObject source = processingEnv.getFiler().createSourceFile(mappingFullClassName);
                Writer writer = source.openWriter();
                writer.write(builder.toString());
                writer.flush();
                writer.close();
            } catch (Exception e) {
                throw new RuntimeException("Error while create file", e);
            }
    
            System.out.println(TAG + " >>> process finish ...");
    
            return false;
        }
    
        /**
         * 告诉编译器，当前处理器支持的注解类型
         *
         * @return
         */
        @Override
        public Set<String> getSupportedAnnotationTypes() {
            return Collections.singleton(
                    Destination.class.getCanonicalName()
            );
        }
    }
    ```



## 3、应用注解

- settings.gradle 添加

  - ```
    include ':router-annotations'
    include ':router-processor'
    ```

- app module 的 build.gradle 添加

  - ```
    dependencies {
        // 依赖自己的注解
        implementation project(':router-annotations')
        // 依赖自己的注解处理器
        annotationProcessor project(':router-processor')
    
        /**
         * 测试注解处理器
         *
         * 异常处理：Mac OS 升级到11.0.1后 ./gradlew :androiddemo:assembleDebug -q 编译项目出错
         * 资源库中找到 Internet Plug-Ins 文件夹，将文件夹名改为 InternetPlug-Ins
         * 参考：https://www.jianshu.com/p/3c1ad32a1def
         *
         * 注意：com.imooc.router.processor.DestinationProcessor 类中的日志，仅在第一次编译时打印.
         *      如果需要再次打印，需要先清楚缓存 ./gradlew clean -q
         *
         * // 1、清除缓存
         * $ ./gradlew clean -q
         *
         * // 2、开始debug编译
         * $ ./gradlew :androiddemo:assembleDebug -q
         *
         * //3、查看生成文件
         * 生成的 RouterMapping_xxx.java 文件在:
         * module 的 build/generated/ap_generated_sources/out/${packagename} 目录下
         */
    }
    ```

