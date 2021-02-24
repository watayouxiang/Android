package com.watayouxiang.mykotlin._06_advancedfunctions

import java.io.File

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/10/12
 *     desc   :
 *
 *     案例： 用Kotlin实现Html语言
 *
 *     DSL 领域特定语言：
 *          比如：SQL、Gradle
 *     编程语言：
 *          比如：Groovy、Scala、Kotlin
 *
 * </pre>
 */
fun main() {
    val htmlContent = html {
        head {
            "meta" { "charset"("UTF-8") }
        }
        body {
            "div" {
                "style"(
                    """
                    width: 200px; 
                    height: 200px; 
                    line-height: 200px; 
                    background-color: #C9394A;
                    text-align: center
                    """.trimIndent()
                )
                "span" {
                    "style"(
                        """
                        color: white;
                        font-family: Microsoft YaHei
                        """.trimIndent()
                    )
                    +"Hello HTML DSL!!"
                }
            }
        }
    }.render()

    File("Kotlin.html").writeText(htmlContent)
}

// 输出html的接口实现
interface Node {
    // 渲染
    fun render(): String
}

// 字符节点类
class StringNode(val content: String) : Node {
    override fun render(): String {
        return content
    }
}

// 括号节点类
class BlockNode(val name: String) : Node {
    val children = ArrayList<Node>()
    val properties = HashMap<String, Any>()

    override fun render(): String {
        return """
            <$name ${properties.map { "${it.key}='${it.value}'" }.joinToString(" ")}>
            ${children.joinToString("") { it.render() }}
            </$name>
            """
    }

    // 运算符重载，参数是一个节点
    operator fun String.invoke(block: BlockNode.() -> Unit): BlockNode {
        val node = BlockNode(this)
        node.block()
        this@BlockNode.children += node
        return node
    }

    // 运算符重载，参数是Any类型
    operator fun String.invoke(value: Any) {
        this@BlockNode.properties[this] = value
    }

    // 字符串节点
    operator fun String.unaryPlus() {
        this@BlockNode.children += StringNode(this)
    }
}

// html 函数
fun html(block: BlockNode.() -> Unit): BlockNode {
    val html = BlockNode("html")
    html.block()
    return html
}

// head 函数
fun BlockNode.head(block: BlockNode.() -> Unit): BlockNode {
    val head = BlockNode("head")
    head.block()
    this.children += head
    return head
}

// body 函数
fun BlockNode.body(block: BlockNode.() -> Unit): BlockNode {
    val head = BlockNode("body")
    head.block()
    this.children += head
    return head
}