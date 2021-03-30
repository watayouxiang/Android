package com.watayouxiang.mykotlin._04_types

import com.watayouxiang.mykotlin._04_types.eg.Repository
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.io.File

interface GitHubApi {
    @GET("/repos/{owner}/{repo}")
    fun getRepository(@Path("owner") owner: String, @Path("repo") repo: String): Call<Repository>
}

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/7/10
 *     desc   : 使用 Retrofit 发送网络请求
 * </pre>
 */
fun main() {
    val gitHubApi = Retrofit.Builder().baseUrl("https://api.github.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(GitHubApi::class.java)

    val response = gitHubApi.getRepository("JetBrains", "Kotlin").execute()

    val repository = response.body()

    if (repository == null) {
        println("Error! ${response.code()} - ${response.message()}")
    } else {
        println(repository.name)
        println(repository.owner.login)
        println(repository.stargazers_count)
        println(repository.forks_count)
        println(repository.html_url)

        // 将数据保存成文件
        // 调用 File 的拓展方法
        File("Kotlin.html").writeText(
            """
            <!DOCTYPE html>
            <html>
            <head>
                <meta charset="UTF-8">
                <title>${repository.owner.login} - ${repository.name}</title>
            </head>
            <body>
                <h1><a href='${repository.html_url}'>${repository.owner.login} - ${repository.name}</a></h1>
                <p>${repository.description}</p>
                <p>Stars: ${repository.stargazers_count}</p>
                <p>Forks: ${repository.forks_count}</p>
            </body>
            </html>
        """.trimIndent()
        )
    }
}