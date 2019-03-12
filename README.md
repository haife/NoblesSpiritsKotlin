##  Kotlin基础
### 2.1.1 Hello,World!


```kotlin
   fun main(args: ArrayList<String>) {
            println("Hellow,World!")
        }
```
- 关键字fun用来声明一个函数
- 参数类型是写在参数名称的后面
- 函数可以写在类的最外面，不需要放在类中
- 数组就是类，Kotlin没有声明数组类型的特殊语法
- println()代替了system.out.println()
- 与许多现代语言一样，可以省略语句后面的分好

### 2.1.2 函数


```kotlin
fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}
```
**注意在Kotlin中，if是有结果值的表达式。它和java中的三目运算符相似：(a > b) a else b**



语句和表达式
   在Kotlin中，if是表达式，而不是语句。语句和表达的区别在于，表达式有值，并且能作为另一个表达式的一部分使用；而语句总是包围着它的代码块中的顶层元素，并且没有自己的返回值。在Java中，所有的控制结构都是语句。而在kotlin中，除了循环（for、while、do/while）以外大多数控制结构都是表达式
   
#### 表达式函数体 
```kotlin
fun max2(a: Int, b: Int) = if (a>b) a else b
```

### 2.1.3 变量

Java中声明变量是以类型开始，这种方式在kotlin中是行不通的。因为许多变量类型是可以省略的。所以在kotlin中声明变量是以关键字开头，然后是名称，最后可以加上类型。也可以省略：


```kotlin
val question = "The Ultimate Question of Life";

val ansewer = 20

```
如果变量没有初始化值，则需要显示的指示它的类型

```kotlin
 val answer: Int
     answer = 20;
```

#### 可变变量和不可变量
- val(来自value) ——不可变量，使用val声明的变量不能在初始化之后在复制，他对应的是java中的final
- var(来自variable) —— 可变变量，这种变量的值可以改变

### 2.1.4 字符串模板


```kotlin
fun main2(args: ArrayList<String>) {
    val name = if (args.size > 0) args[0] else "Kotlin"
    println("name:$name")
}
```
在变量前面加上前缀“$”,如果你需要使用“$”字符，你需要对他转义“\ $x”

### 2.2 类和属性


``` kotlin
class Person(
        val name: String,//val关键字修饰，表示只读属性
        var isMarried: Boolean//var关键字修饰，表示可写属性，有get和set属性
)
```
### 2.3.5 合并类型检查和转换


```kotlin
//表达式类层次结构
interface Expr {
    class Num(val value: Int) : Expr//简单的值对象类，只有一个属性。实现了Expr接口
    class Sum(val left: Expr, val right: Expr) : Expr//Sum的实参可以是任意一个Expr:Num或者另一个Sum

}


**声明类的时候，使用：和后面跟着接口名称来表示实现了这个接口**

Expr接口有两种实现，所以为了计算出表达的结果值,需要尝试两种选项
- 如果表达式是一个值，则直接返回
- 如果是一次求和，则则先计算左右两边表达式的值，在求和 代码如下




fun main(args: Array<String>) {
    println(eval(Expr.Sum(Expr.Sum(Expr.Num(1), Expr.Num(2)),Expr.Num(4))))
}

fun eval(e: Expr): Int {
    if (e is Expr.Num) {
        val n = e as Expr.Num;//显示的转换类型Num是多余的
        return n.value
    }
    if (e is Expr.Sum) {
        return eval(e.left) + eval(e.right)
    }
    throw IllegalArgumentException("Unknow Expression")
}
interface Expr {
    class Num(val value: Int) : Expr
    class Sum(val left: Expr, val right: Expr) : Expr

}
```

### 2.3.6 重构，用“when”代替“if”

使用有返回值的if表达式

```kotlin
fun eval2(e: Expr): Int =
        if (e is Num) {
            e.value
        } else if (e is Sum) {
            eval2(e.left) + eval2(e.right)
        } else {
            throw IllegalArgumentException("Unknow Expression")
        }
```
用when代替if层叠


```kotlin
fun eval3(e: Expr): Int =
        when (e) {
            is Num -> e.value
            is Sum -> eval3(e.left) + eval3(e.right)
            else -> throw IllegalArgumentException("Unknow Expression")
        }
```
### 2.4 迭代事务：while循环和for循环

#### 2.4.1 while循环

kotlin中的while循环和do-while循环和java中的完全一致

```
while(condition){
    
}

```


```
do{
    
}while(condition)
```

#### 2.4.2 迭代数字：区间和数列(类比java中的for循环)
在kotlin中，代替java中for循环。使用到了区间的概念
区间本质上就是两个数值之间的间隔，一个是起始值，一个是结束值。使用..符号来表示区间

```
 val oneToTen: IntRange = 0..10;
```


```
 for (i in 0 until 100) {

  }
```

#### 2.4.3 迭代map

```kotlin
fun main(args: Array<String>) {
  val binaryReps = HashMap<Char, String>()
  for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary

    }

    for ((letter, binery) in binaryReps)
        println("$letter= $binery")
        
}

```
**binaryReps[c] = binary 在这里等价于 binaryReps.put(c,binary)**

#### 2.4.3 in 关键字
- 用于检查字符区间成员
- 用于检查对象（实现Java.lang.Comparable接口的任意类）
- 检查集合

```kotlin
//检查字符区间
fun isLetter(c: Char) = c in 'a'..'z'
fun isNotDigit(c: Char) = c !in '0'..'9' //不在这个0到9区间

fun main(args: Array<String>) {
    println(isLetter('c'))
    println(isNotDigit('c'))
}

```

```kotlin
    println("kotlin" in "java".."scala")   // 是否在"java"和"scala"字符串区间 ,相当于"java"<="kotlin"&& "kotlin" <= "scala"

    println("kotlin" in setOf<String>("java","scala"))  //kotlin 是否在集合中

```

### 2.6 小结

- fun关键字用来声明函数，val和var用来声明不可变量和可变变量
- 字符串模板用来帮你避免烦琐的字符串拼接，在变量名称前面加上 $ 前缀或者 ${} 包围一个表达式
- 值对象类在Kotlin中以简洁的方式表示
- 熟悉if现在是带返回值的表达式
- when表达式类似java中的switch但功能更强大
- 在检查过变量是某种类型后（is）不必显示的转换他的类型
- for、while和do-while循环和java中类似。for循环现在更加方便，特别是当你在迭代map，又或是迭代集合需要下标的时候
- 1..5会创建一个区间，可以使用in或者!in判断在区间内
- kotlin异常处理和java类似，除了Kotlin不要求你声明的函数抛出异常


---

## 3章 函数的定义和调用

#### 3.2 让函数更好的调用

java中每一个集合都有默认的toString()实现，但是它的格式化输出是固定的。例如：
 
```kotlin
 val list = listOf(1, 2, 3)
 println(list)
 >>> [1,2,3]
```
如果你需要用";"分隔并且用括号包围，而不是采用默认的输出格式。需要怎么做。代码如下


```kotlin
}
 fun <T> joinToString(collection: Collection<T>, speartor: String, prefix: String, postfix: String): String {
        val result = StringBuilder(prefix)
        for ((index, element) in collection.withIndex()) {
            if (index > 0) result.append(speartor)
            result.append(element)
        }
        result.append(postfix)
        return result.toString()

    }
    
 fun main(args: Array<String>) {
 val list = listOf(1, 2, 3)
 println(joinToString(list,";","(",")"))
>>> (1;2;3)//输出结果
```
#### 3.2.1 命名参数

上面代码中 **println(joinToString(list,";","(",")"))** 没有什么可读性，如果不去查看函数声明。我们根本不知道参数的用途。在kotlin中可以做的更优雅，按照下面方式调用


```
 joinToString(list,speartor = ";",prefix = "(",postfix = ")")
 // 当调用一个Kotlin函数时，可以显示的表明一些参数的名称，当指明了一个参数的名称时，为避免混淆。后面的参数名称都需要指明
```
#### 3.2.2 默认参数值
```
 //声明带默认参数值的joinToString()
 fun <T> joinToString(collection: Collection<T>,
 speartor: String = ",", 
 prefix: String = "",
 postfix: String = ""): String {
 
 }
 
```
现在可以用所有的参数来调用这个函数
```
fun main(args: Array<String>) {
   val list = listOf(1, 2, 3)
   println(joinToString(list))
   println(joinToString(list,""))
    println(joinToString(list,";",prefix = "(",postfix = ""))
}
>>> (1,2,3)
>>> (123)
>>> (1;2;3
```
**当你从java中调用kotlin函数的时候，必须显示的制定所有参数值，如果需要从java代码中频繁的调用，而且希望他能对java的调用者更加便捷，可以使用@JvmOverloads注解，这个指示编译器生成重载函数**

对于上述joinToString()添加注解
```
@JvmOverloads
fun <T> joinToString(collection: Collection<T>, speartor: String = ",", prefix: String = "(", postfix: String = ")"): String {}
```
在java中调用时，有四种构造方法供你使用

#### 3.2.2 消除静态工具类：顶层函数和属性



```
@file:JvmName("StringFunctions")
package com.haife.app.kotlin.kotlindemo.strings
@JvmOverloads
fun <T> joinToString(collection: Collection<T>, speartor: String = ",", prefix: String = "(", postfix: String = ")"): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(speartor)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()

    fun main(args:Array<String>){
        val list = listOf(1, 2, 3)
        println(joinToString(list))
        println(joinToString(list,";",prefix = "(",postfix = ""))
    }

}
```
- 这个工具方法不用属于任何类，直接放在代码文件的顶层
- @file:JvmName("StringFunctions") -> 注解制定类名，在java中可以 StringFunctions.joinToString(list);调用函数

#### 3.3 拓展函数和属性(给别人的类添加方法)

例如计算一个字符串最后一个字符

```
fun String.lastChar(): Char = this.get(this.length - 1)

>>> println("Kotlin".lastChar())
```
- 接收者类型：你需要拓展的类或者接口的名称(String类)
- 接受者对象：用来调用这个拓展函数的对象(this)

#### 3.3.1 导入和拓展函数
对于你定义的拓展函数，它不会自动的整个项目范围内生效，如果需要使用。需要进行导入。Kotlin允许用和导入类一样的语法来导入单个函数


```
import com.haife.app.kotlin.kotlindemo.strings.lastChar
println("Kotlin".lastChar())
//可以使用*号
import com.haife.app.kotlin.kotlindemo.strings.*

```
可以使用关键字as来修改导入的类或者函数名称

```
import com.haife.app.kotlin.kotlindemo.strings.lastChar as last

println("Kotlin".last())
```


当你在不同的包，有一些重名的函数事，在导入时用as重命名就显得尤为必要，这样就可以在同一个文件中去使用它们。对于一般类和函数可以使用全名来指出这个类或者函数，但对于拓展函数 关键字as是你解决冲突的唯一方式

#### 3.3.3 作为拓展函数的工具函数(改写上面分隔字符串代码)
```
fun <T>Collection<T>.joinToString2(speartor: String = ",", prefix: String = "(", postfix: String = ")"):String{

    val result = StringBuilder(prefix)
    for ((index,element)in this.withIndex()){
        if (index>0) result.append(speartor)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()

}
```

#### 3.3.5 拓展属性

```
val String.lastChar: Char get() = get(this.length - 1)

"Kotlin".lastChar
```

#### 3.4.2 让函数支持任意数量的参数

```
varage:
```
#### 3.5.1 分隔字符串


```
 val str = "12.345-6.A";
 
 println(str.split(".","-"))
 
 >>>[12, 345, 6, A]

```
#### 3.5.2 正则表达式和三重引号字符串

来看一个例子的两种不同的实现，一个使用拓展函数处理字符串，另一个使用正则表达式解析下完文件的整路径获取的目录、文件名、文件拓展名

> /User/yole/kotlin-book/chapter.adoc

先使用String的拓展函数**substringBeforeLast**、**substringAfterLast**讲一个路径分隔为目录、文件名、文件拓展名

```
fun paresPath(path: String) {
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")
    val fileName = fullName.substringBeforeLast(".")
    val extension = path.substringAfterLast(".")
    println("Dir: $directory,Name: $fileName,Extension: $extension")
    
}

>>> println("/User/yole/kotlin-book/chapter.adoc")
Dir: /User/yole/kotlin-book,Name: chapter,Extension: adoc
```
使用正则表达式解析一个目录路径

```
fun paresPath2(path: String) {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)

    if (matchResult != null) {
        val (directory, name, ext) = matchResult.destructured
        println("Dir: $directory,name: $name,ext: $ext")
    }
}
```
在这个例子中，正则表达式写在**三重引号的字符串中**，在这样的字符串中那就不需要对任何字符进行转义

### 3.6 局部函数和拓展

Kotlin提供一种方案：可以再函数中嵌套一些需要提取的函数
下面的例子中setUser函数是将user信息保存到数据库

```
class User(val id: Int, val name: String, val address: String)

 fun saveUser(user: User) {
    if (user.name.isEmpty()) {
        throw IllegalArgumentException("Cant save user ${user.id}:empty Name")
    }
    if (user.address.isEmpty()) {
        throw IllegalArgumentException("Cant save user ${user.name}:empty Address")
    }
    //保存数据到数据库
}
>>> saveUser(User(1, "", ""))
"Exception in thread "main" java.lang.IllegalArgumentException: Cant save user 1:empty Name"
```
如果需要验证的用户字段多了，这样是不好的。现在我们将验证代码放到局部函数中，可以避免重复


```

fun saveUser2(user: User) {

    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw java.lang.IllegalArgumentException("Cant't save ${user.id}: empty $fieldName")
        }
    }
    validate(user.name,"Name")
    validate(user.address,"Address")
}

```
我们还可以继续改进，将验证代码放到User的拓展函数中

```
fun User.validateBeforeSave() {

    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw java.lang.IllegalArgumentException("Cant't save ${this.id}: empty $fieldName")
        }
    }
    validate(this.name, "Name")
    validate(this.address, "Address")
}

fun saveUser3(user: User){
    user.validateBeforeSave()
    //保存到数据库
}
```

### 3.7 小结
- Kotlin没有自己定义集合的类，而是在java集合类的基础上提供了更加丰富的Api
- kotlin可以给函数的参数定义默认值，这样大大降低了重载函数的必要性，而且命名参数让多参数函数的调用更加易读
- kotlin允许更灵活的代码结构：函数和属性都可以在文件中直接声明，不仅仅是在类中作为成员
- Kotlin可以使用扩展函数和属性来扩展任何类的Api，包括在外部库中定义的类，而不需要修改源代码，也没有运行时的开销
- 中缀调用提供了处理单个参数的、类似调用运算符方法的简要语法
- Kotlin为普通字符串和正则表达式都提供了大量的方便字符串处理的函数
- 三重引号的字符串提供了一种简洁的方法，解决了java中需要进行大量的转义和字符串链接的问题
- 局部函数帮助你保持代码的简洁，避免重复



## 4章 类、对象和接口
### 4.1 定义类继承结构
#### 4.1.1 kotlin中的接口
Kotlin中的接口与java8中的相似：他们可以包含抽象方法的定义和非抽象方法的实现，但它们不能不能包含任何的状态


>使用interface来声明一个Kotlin接口


```kotlin

interface Clickable {
    fun click()
 
}
 
```
>实现一个简单接口

```kotlin
class Button : Clickable {

    override fun click() {
        println("I was click")
    }
}
```
Kotlin在类名后面使用 : 来代替java中的extend和implements，和java一样只能继承一个类，实现多个接口

**与java中的@Override类似，override修饰符标注了被重写的父类或者接口的方法和属性。与java不同的是，在Kotlin中使用 *override* 修饰符是强制要求的，这会避免先写出实现方法再添加抽象方法造成的意外重写：你的代码将不能被编译，除非你显示的将这个方法标注为 *override* 或者重命名它**

接口的方法可以有一个默认实现，代码如下
```kotlin

interface Clickable {
    fun click()

    fun showOff() = println("I'm clickable")
    
}
 
```
如果你实现了这个接口，需要为click提供一个实现，可以重新定义showOff的行为，如果你对接口默认实现的感到满意可行，也可以直接忽视它

> 定义另一个实现同样的方法的接口

```kotlin
interface Focusable {
    fun setFocusable(b: Boolean) = println("I ${if (b) "Got" else "Lost"} focus.")
    fun showOff() = println("I'm Focusable")
}
```
如果你在类中同时实现了Clickable和Focusable接口会发生什么？他们每一个都包含了带默认实现的showOff方法；那么类中会使用哪一个实现呢？答案是任何一个都不会使用。取而代之的是，如过你没有显示的实现showOff，你会得到编译错误。Kotlin会强势要求你提供自己的实现

```kotlin

class Button : Clickable, Focusable {
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }


    override fun click() {
        println("I was click")
    }


}

```
Button实现了两个接口，通过调用继承的两个父类型中的实现来实现showOff();Java中的写法Clickable.super.showOff();在Kotlin中基类的名字要放在尖括号: super<Clickable>.showOff()
如果你只需要调用一个继承的实现也可以这样写:

 
```kotlin
override fun showOff()  = super<Clickable>.showOff()
```

**如果你需要在java中实现包含方法体的接口(接口有默认实现)，必须为所有方法，包括在Kotlin中有方法体的方法定义你自己的实现**

#### 重写在基类中定义的成员
#### 4.1.2 open、final和abstract修饰符:默认为final
> 声明一个带一个open方法的open类（这个类是open的，其他类可以继承它）

```kotlin
open class RichButton : Clickable {

    fun disable(){
        //->这个函数默认是final的，不能在子类中重写它
    
        
    }
  
    open fun animate() {
        //->这个函数是open的，可以再子类中重写它
  
    }


    override fun click() {
       //->这个函数重写了一个open函数并且她本身同样是open的
    }

}

```
**注意，如果你重写了一个基类或者接口的成员，那么默认这个成员也是open的，如果你想改变这一行为，阻止你的类的子类重写你的实现，可以显示的将重写的成员标注为final**

>禁止被重写
```kotlin

open class RichButton : Clickable { 

    final override fun click() {

    }

}

```
在这里final要指明是因为如果没有**final**的**override**的默认意味着**open**的，那么就可以被子类重写


修饰符 | 相关成员 | 评注
---|--- | ---
 final | 不能被重写 | 类中的成员默认使用
 open | 可以被重写 | 需要明确的说明
 abstract | 必须被重写 | 只能在抽象类中使用；抽象成员不能有实例
 override | 重写父类或接口的成员 | 如果没有用final声明，重写的成员默认是开放的
 
 #### 4.1.3 可见性修饰符
 
 修饰符 | 类成员 | 顶层声明
---|--- | ---
 public(默认) | 所有地方可见 | 所有地方可见
 internal | 模块中可见 | 模块中可见
 protected | 子类中可见 | ——
 private | 类中可见 | 文件中可见
 
 #### 4.1.4 内部类和嵌套类（默认是嵌套类）
 
 - 嵌套类不持有外部类的引用，内部类持有
 - 声明成为内部类需要inner修饰符
 - Kotlin中默认为嵌套类，不持有外部类的引用
 
 #### 4.1.5 密封类：定义受限的类继承结构

 ```kotlin
 sealed class Expr{
    class Num(val value: Int) : Exp()
    class Sum(val left: Exp, val right: Exp) : Exp()
}
 ```
 sealed关键字声明一个类为密封类，密封类不允许类外存在子类。
 
 ### 4.2 声明一个带非默认构造方法的类
 Kotlin区分了**主构造方法**（通常是主要而且简洁的初始化类的方法，并且在类的外部声明）和**从构造方法**（在类的内部声明）
 
 #### 4.2.1 初始化类：主构造方法和初始化语句块
 
 ```kotlin
 //带一个参数的主构造方法
  class User constructor(nickname: String) {
    val nickname: String

    init {
        this.nickname = nickname
       
    }
}
 ```
 - *constructor*关键字用来开启一个主构造方法或从构造方法的声明
 - *init*关键字用来引入一个**初始化代码语句块**，这种语句块包含在类被创建时执行的代码，并会与主构造方法一起使用，如果你愿意可以再使用多个初始化语句块
 
构造方法的参数也可以像函数一样声明一个默认值

```kotlin
class User(val nickname: String, val isSubscribed: Boolean = false) 
    val user = User("Bob",false)
    val user2 = User("Bob",isSubscribed = false)
    val user3 = User("Bob")
```
**注意** 如果所有的构造方法都有默认值，编译器会产生一个不带任意参数的构造方法来使用所有额默认值

如果你的类具有一个父类，那么主构造方法同样需要初始化父类。可以通过在基类列表的父类引用中提供父类构造方法参数来做到这一点

```kotlin
open class User(val nickname: String = "Bob", val isSubscribed: Boolean = false)

class Twitteruser(nickname: String) : User(nickname, isSubscribed = true) 

```
如果一个基类不具有任何构造方法，那么在子类在继承时必须显示的调用父类的构造方法
```
open class Button

class RadioButton:Button()
```
注意与接口的区别接口是没有构造方法的。
 
#### 4.4.2 构造方法：用不同的方法来初始化父类

```kotlin
open class View {
    constructor(ctx: Context)
    constructor(ctx: Context, attr: Attributes)
}

```

这个类没有声明主构造方法，，但是声明了两个从构造方法。
如果你想拓展这个类，可以声明同样的构造方法：

```kotlin
class MyButton : View {
    //调用父类的构造方法
    constructor(ctx: Context) : super(ctx)
    constructor(ctx: Context, attr: Attributes) : super(ctx, attr)
}
```

就像在java中一样，使用*this()*关键字，使得一个构造方法委托给同一个类中的另一个构造方法，为参数传入默认值。

```kotlin
class MyButton : View {
    constructor(ctx: Context) : this(ctx,MY_STYLE)
    constructor(ctx: Context, attr: Attributes) : super(ctx, attr)
}
```


#### 4.2.3 实现在接口中声明的属性

```kotlin
//TODO:实现在接口中声明的属性
interface User {
    val nickName: String
}

class PrivateUser(override val nickName: String) : User

class SubscribingUser(val email: String) : User {
    override val nickName: String
        get() = email.substringBefore('@')//自定义getter
}

class FaceBookUser(val accountId: String) : User {
    override val nickName: String = getFaceBookName(accountId)//属性初始化
}
```

### 4.3 编译器生成的方法，数据类和类委托
#### 4.3.1 通用对象方法

- toString()
- equals()
- hashCode()

```kotlin
class Client(val name: String, val postalCode: Int) {

     override fun toString(): String {
         return "Client(name='$name', postalCode=$postalCode)"
     }

     override fun equals(other: Any?): Boolean {
         if (this === other) return true
         if (javaClass != other?.javaClass) return false

         other as Client

         if (name != other.name) return false
         if (postalCode != other.postalCode) return false

         return true
     }

     override fun hashCode(): Int {
         var result = name.hashCode()
         result = 31 * result + postalCode
         return result
     }

 }
```

#### 4.3.2 数据类 

**使用data修饰符修饰类，必要的方法会自动生成好**

数据类和不可变型：copy()方法

```
class Client(val name: String, val postalCode: Int) {
    
    fun copy(name: String = this.name, postalCode: Int = this.postalCode) {
         
    }

}

>>>   val client3 = client.copy(postalCode = 124)

```

**类委托：使用by关键字**

```
class DelegatingCollection<T> : Collection<T> {

    private val innerList = arrayListOf<T>()

    override fun contains(element: T): Boolean = innerList.contains(element)

    override fun containsAll(elements: Collection<T>): Boolean = innerList.containsAll(elements)

    override val size: Int
        get() = innerList.size

    override fun isEmpty(): Boolean = innerList.isEmpty();

    override fun iterator(): Iterator<T> = innerList.iterator();
}

```

可以使用by关键字将接口的实现委托到另一个对象

```

//类委托
class DelegatingCollection<T>(innerList: Collection<T> = ArrayList<T>()) : Collection<T> by innerList{
    
}
```

```

class CountSet<T>(val innerSet: MutableCollection<T> = HashSet<T>())
    : MutableCollection<T> by innerSet {//将MutableCollection的实现委托给innerList

    var objectAdded = 0

    override fun add(element: T): Boolean {//不同的委托 提供一个不同的实现
        objectAdded++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {//不同的委托 提供一个不同的实现
        objectAdded += elements.size
        return innerSet.addAll(elements)
    }

}
```

### 4.4 object关键字：将声明一个类与创建一个实例结合起来
objec在kotlin中有多种情况，但都遵循同样的核心理念：这个关键字定义一个类并同事创建一个实例

使用场景：
- 对象声明是定义单例的一种方式
- 伴生对象可以持有工厂方法和其他与这个类相关，但在调用时并不依实例的方法。他们的成员可以通过类名来访问
-对象表达式用来替代java的匿名内部类
#### 4.4.1 对象声明：创建单例

与类一样，一个对象的声明可以包含属性、方法、初始化语句块等声明，唯一不允许的就是构造方法（主构造方法和从构造方法）

**对象声明同样可以集成自类和接口，这通常在你使用的框架需要去实现一个接口，但是接口的实现并不包含任何状态的的时候使用，下面是比较两个对象谁更大的实现**

```
object CaseInsensitiveFileComparator : Comparator<File> {

    override fun compare(o1: File, o2: File): Int {
        return o1.path.compareTo(o2.path, ignoreCase = true);
    }

}

>>> println(CaseInsensitiveFileComparator.compare(File("/File"), File("/file")))

>>>0

```

#### 4.4.2 伴生对象：工厂方法和静态成员的地盘

**companion关键字**

kotlin中不能拥有静态成员；java中的static并不是kotlin中的一部分，作为替代，kotlin依赖包级别（大多数情况下替代java的静态方法）函数和对象声明（在其他情况下替代java的静态方法，同事还包括静态字段）。大多情况下还是推荐顶层函数，但是顶层函数不能访问累的private成员，为解决这个问题，如果你需要在没有类实例的条件下调用但是需要访问类内部的函数。可以将其写成那个类中的对象声明的成员，这种函数的一个例子就是工厂方法

```
class Test2Kotlin private constructor(val nickname2: String) {//将主构造方法标记为private

    companion object {

        fun newSubcribingUser(email: String) = Test2Kotlin(email.substringBefore('@'))
        //通过工厂方法让Facebook账号来创建一个新的用户
        fun newFaceBookUser(accountId: Int) = Test2Kotlin(getFaceBookName(accountId))
        
        
        private fun getFaceBookName(faceBookAccountId: Int): String {
            return faceBookAccountId.toString()
        }
    }

```

工厂方法能够返回声明这个方法的类的子类，你还可以在不需要的时候避免创建子类

#### 4.4.3 作为普通对象使用的伴生对象

伴生对象是一个声明在类中的普通对象，他可以有名字、实现一个接口或者拥有拓展函数、属性等

> 声明一个带有名字的伴生对象

```
class Person(val name: String) {

    companion object Loader {
        fun fromeJson(jsonText: String): Person {
            val gson = Gson()
            return gson.fromJson(jsonText, Person::class.java)
        }
    }
   
}
>>> Person.fromeJson("{name:Bob}")
   
>>> Person.Loader.fromeJson("{name:haife}")
```
如果你省略了伴生对象的名称，那么默认的名字为Companion，这个例子会在伴生对象的拓展时会用到

> 在伴生对象中实现接口

```
interface JSONFactory<T> {
    fun fromJson(jsonText: String): T

}

class Person2(val name: String) {
    //实现接口的伴生对象
    companion object : JSONFactory<Person2> {
        override fun fromJson(jsonText: String): Person2 {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }

}

fun <T> loadFromJSON(factory: JSONFactory<T>): T {
    return factory.fromJson("{name:Haife}")
}

```


## 5章 lambda编程
###  5.1 lambda表达式和成员引用
> lambda的本质就是传递给函数的一小段代码
#### 5.1.3 lambda表达式语法

```
{ x: Int, y: Int -> x + y }
```
```
 val people = listOf(Person(name = "Alice", age = 29), Person(name = "Bob", age = 31))
people.maxBy({ p: Person -> p.age })//1
people.maxBy() { p: Person -> p.age }//2
people.maxBy { it.age }//3

```
- 如果lambda表达式是函数最后一个实参，可以将他放在括号外面 如上代码2处
- 如果lambda表达式是函数唯一的实参，可以省略括号 如上代码3处

> 在lambda中使用函数参数

```
fun printMessageWithPrefix(messages: Collection<String>, prefix: String) {
    messages.forEach { print("$prefix $it") }
}
```

> 在lambda中改变局部变量

```
fun printProblemCounts(response: Collection<String>) {
    var clientErrors = 0
    var serverErrors = 0
    response.forEach {
        if (it.startsWith("4")) {
            clientErrors++
        } else if (it.startsWith("5")) {
            serverErrors++
        }
    }
}
```

**如果lambda被用作事件处理器或者用作在其他异步执行的情况，对局部变量的修改只会在lambda执行的时候发生**

### 5.1.5 成员引用

Kotllin与Java8一样，如果把函数转换成一个值，你就可以传递它。使用 **::** 运算符来转化

```
 val getAge = Person::age(age可以是属性也可以是函数)
```
```
 val getAge2 = { p: Person -> p.age }
```
这两行代码是同样的作用，注意：不管你引用的是函数还是属性，都不要再成员引用的后面加括号。

### 5.2 集合的函数式Api
kotlin中有许多提供操作集合的一些函数库，以及如何使用

#### 5.2.1基础操作：filter和map函数

filter和map函数形成了集合操作的基础，很多集合操作都是借助他们来完成的

**filter函数遍历集合并选出应用给定的lambda表达式后会返回true的那些元素**

```
   val list = listOf(1, 2, 3, 4)
   println(list.filter { it % 2 == 0 })
   >>> [2,4]
```


**map集合对函数中的每一个元素应用给定的函数并把结果收集成一个新的集合**
```
   val list = listOf(1, 2, 3, 4)
    println(list.map { it * it })
   >>> [1, 4, 9, 16]

```

再试用lambda表达式代码看起来简单，但有时候影藏了底层操作的复杂性。要时刻记住自己的代码在干什么。

还可以对map集合应用过滤和变换的函数

```
val number = mapOf(0 to "zero", 1 to "one")
    println(number.filterValues { it == "zero" })
    >>>{0=zero}

```
键和值分别由各自的函数处理。filterkeys 和 mapKeys 来过滤和变化map的键，filterValue 和 mapValue过滤和变换对应的值

#### 5.2.2 “all” "any" "count" 和find：对集合应用的判断式

但你需要检查集合中所有元素是否都符合某种条件（或者他的变种，是否存在符合的元素）。在Kotlin中，它们是通过all和any函数来表达的。count函数检查有多少个元素满足判断式，而find函数是返回第一个满足判断式的值

#### 5.2.3 groupBuy:把列表转化成分组的map

```
  val people = listOf(Person(name = "Alice", age = 29), Person(name = "Bob", age = 31), Person(name = "Hai", age = 31))
  val groupBy: Map<Int, List<Person>> = people.groupBy { it.age }
  println(groupBy)
    >>> {29=[Person(name=Alice, age=29)], 31=[Person(name=Bob, age=31), Person(name=Hai, age=31)]}
```
这个操作结果是一个map，是元素分组依据的键（这里是age）和元素分组（persons）之间的映射

#### 5.2.4 flatMap和flatten：处理嵌套集合中的元素

```
  val people = listOf(Person(name = "Alice", age = 29), Person(name = "Bob", age = 31), Person(name = "Hai", age = 31))
    println(people.flatMap { it.name.toList() }.toSet())
    >>> [A, l, i, c, e, B, o, b, H, a] 
    //没有调用toSet()函数（移除重复元素） 
    >>> [A, l, i, c, e, B, o, b, H, a, i]


```
flatMap处理两件事：首先根据作为实参给定的函数 对集合中的每个元素做变换（映射），然后把多个列表合并成一个列表

注意：当你卡壳在元素的集合不得不合并成一个的时候，你可能回想起flatMap函数。但是当你不需要做任何变换的时候，只需要平铺成一个集合。可以使用flatten函数：listOfLists.flatten

### 5.3 惰性集合操作：序列

Kotlin中惰性结合操作的入口就是Sequence接口。这个接口表示的就是一个可以逐个列举元素的元素序列。Sequence只提供了一个方法，iterator，用来从序列中获取值。

```
   val people = listOf(Person(name = "Alice", age = 29), Person(name = "Bob", age = 31), Person(name = "Hai", age = 31))
    println(people.asSequence().map { it.age * it.age }.filter { it>900 }.toList())
```

#### 5.3.1 执行序列操作：中间和末端操作
序列操作分为两类：中间和末端。一次中间操作返回的是一个序列。如上面代码的map和filter操作，这个新序列知道如何变幻序列的元素。而一次末端操作是返回一个结果。可以是集合、数字、或者从其他集合变换序列中获取的任意对象

中间操作始终是惰性的，如果你没有对应末端操作。对应的中端操作会被延期执行，中断操作只有在获取结果的时候才会被调用

另外值得注意的是，对操作序列来说：所有的操作是按顺序应用在每一个元素上:处理完第一个元素（先映射在过滤 即 先一个元素先执行map在执行filter，而不是等到所有的元素执行玩map在执行filter）然后完成第二个元素的处理。这意味有些元素不会被处理发生变化 比如当find替换上面的map函数来过滤时。

#### 5.3.2 创建序列

上面是通过list集合：调用asSequence()。另一种方式就是通过generateSequence函数
>生成并使用自然数序列

```
 val naturalNumbers = generateSequence(0) { it + 1 }
    val numberTo100 = naturalNumbers.takeWhile { it<100 }
    println(numberTo100.sum())
```
#### 5.4.2 SAM构造方法：显示的吧lambda转化成函数式接口

>*SAM*构造方法是编译器生成的函数，让你执行从lambda到函数式接口的显示转化，例如有一个方法返回的是一个函数式接口，你不能直接返回一个lambda，要用SAM构造方法将其包装起来

```
fun createAllDoneRunnable(): Runnable {
    return Runnable { print("All Done") }
}

>>> createAllDoneRunnable.run()
```

### 5.5 带接受者的lambda：with()和apply()
> 在lambda函数体内可以调用一个不同对象的方法，而且无需借助任何额外限定符；这种能力在java中是找不到。这样的lambda叫做带接受者的lambda

#### 5.5.1 "with"函数

```
fun alphabet():String{
    val stringBuilder = StringBuilder()
    return with(stringBuilder){//指定接受者的值，你会调用他的方法
        for (letter in 'A'..'Z'){
            this.append(letter)//通过显示的this来调用接受者值的方法
        }
        this.append("\n I Know The alphabet" )//可以省略this
        this.toString()//从lambda返回值
    }
}
>>>输出： ABCDEFGHIJKLMNOPQRSTUVWXYZ
 I Know The alphabet
```

with结构看起来像是一种特殊的语法结构，但他实际上是一个接受两个参数的函数，一个是stringbuilder；另一个是一个lambda表达式

with函数把第一个参数转化作为第二个参数传给它lambda的接收者。

with返回值是执行lambda代码的结果，该结果就是lambda中最后一个表达式（的值）。但有时候你想返回的是接受者对象，而不是执行lambda的结果。那就需要用到apply()函数

#### 5.5.2 apply 函数
apply函数几乎和with函数一模一样，唯一的区别是apply始终会返回作为实参传递给他的对象（接受者对象）

```
fun creatViewTithCustomAttributes(context: Context) {
    TextView(context).apply { 
        this.text = "Sample Text"
        this.textSize = 18.0F
        this.setPadding(10,0,0,0)
    }
}
```


### 5.6小结
- lambda允许你把代码块当做参数传递给函数
- Kotlin可以吧lambda放在括号外面传递给函数，而且可以使用it引用单个的lambda参数
- lambda中的代码可以访问和修改包含这个lambda调用的函数中的变量
- 通过在函数名称前加上::，可以创建方法、构造方法以及属性的引用，并应用这些引用代替lambda传递给函数
- 使用像filter、map、all、any、count、find等函数时，大多数公共的集合不需要手动迭代就可以完成。
- 序列允许你合并集合上的多次操作，而不需要创建新的集合来保存中间结果
- 可以把lambda作为实参传递给接受java函数式接口（带单抽象方法的接口，也叫SAM接口，列入runnable）作为形参的方法
- 带接受者的lambda是一种特殊的lambda，可以在这种lambda中访问一个特殊接收对象的的方法
- with标准库函数允许你调用同一个兑现的多个方法，而需要反复写出这个对象的引用。apply函数让你使用构建者风格的API创建和初始化任何对象



## Kotlin的类型系统

### 6.1 可空性
> 可空性是Kotlin类型系统帮助你避免NullPointerException错误的特性

#### 6.1.1 可空类型
> Java和kotlin类型系统之间最重要的一条也可能是最重要的一条的区别是,Kotlin对可空类型的显示的支持，这是一种指出你的程序中哪些变量和属性允许为null的方式，如果一个变量可以为空，那么对这个变量的方法的调用就是不安全的。Kotlin中不允许你这样的调用

> java
```
pubic int strLen(String s){
    return s.length();
}

>>> strLen(null) //在Java中这样是可以执行的，但是会抛出NullPointerException
```

>kotlin

```
fun strLen(s:String) = s.length
>>>  strLen(null)//这样调用在编译器就会被标记错误
```
如果你允许调用这个方法的时候传给它所有可能的实参，包括那些可以为null的实参，那需要显示的在类型名称后面添加"?"来标记它

```
fun strLen2(s:String?) = s?.length?:0
strLen2(null)
```

重申一下，没有"?"的类型表示这种类型的变量不能存储null的引用。这说明所有的常见类型默认都是非空的，除非显示的把他标记为可空。不能把一个可空类型的变量赋值给一个非空类型的变量；也不能传递给非空类型参数的函数

#### 6.1.3 安全调用运算符："?."

> ?. 运算法允许你把一次null检查和一次方法操作合并成一个操作 

**s?.length 等价于 if(s!=null) s.length else null**
注意这个调用的操作结果也是可空的

安全调用还可以处理属性；也可以链接多个安全调用


#### 6.1.4 Elvis运算符："?:"

Kotlin有方便的运算符来替代null的默认值，被称作Elvis运算符

> Elvis运算符接受两个运算数，如果第一个运算数不为空，运算结果就是第一个运算数。反之则返回第二个运算数

```
fun foo(s: String?) {
    val str: String = s ?: ""
}
```
这个例子中个""空字符串代替了null


#### 6.1.5 安全转换："as?"

>as?运算符尝试把值转化成指定的类型，如果值不是合适的类型就返回null
```
//常见的用法和Elvis运算符结合使用
class Person2( val firstName: String, val lastName: String) {

    override fun equals(other: Any?): Boolean {
        val otherPerson:Person2 = other as? Person2 ?: return false
        return otherPerson.firstName == firstName && otherPerson.lastName == lastName
    }
}
>>> val p1 = Person2("Dmitry","Jemerov")
    val p2 = Person2("Dmitry","Jemerov")
    println(p1==p2)
    println(p1.equals(42))

```
#### 6.1.6  非空断言："!!"

> 非空断言是Kotlin提供给你最简单的处理可空类型值的工具，可以把任何值转化成非空类型。如果你对一个null值做非空断言，程序则会抛出NullPointExpection


#### 6.1.7 "let"函数
> let函数让处理可空表达式变得更容易。和安全调用运算符一起，它允许你对表达式求值，检查结果是否为null，并吧结果保存为一个变量

```
fun sendEmail(email: String?) {
    println("SendEmail:$email")
}

 val email: String? = "773938795@qq.com"
    email?.let { sendEmail(it) }
```

let里面的it是非空的，如果email为空，则不会执行lambda

#### 6.1.8 延迟初始化属性
> 声明一个不需要初始化器的非空类型属性

```
private var lateinit mService:MyService 
```

注意 延迟初始化属性的都是var，因为她需要在够着方法外修改值，而val会被编译成在构造方法中初始化的final字段。

#### 6.1.9 可空类型的拓展函数
为可空类型定义拓展函数是一种更强大的处理null值的方式，可以允许接收者null的（拓展函数）调用，并在该函数中处理null，而不是在确保变量不为null之后在调用它的方法。只有拓展函数才能处理这一点，普通成员方法的调用是通过对象的实例来进行分发的，因此当实例为null时，成员方法永远不能被执行

Kotlin标准库中提供了String类的两个拓展函数就说明了这一点isEmpty()和isBank(),第一个函数判断字符串是否为空字符串第二个判断它是否是空的或者它只包含空白字符

```
> 不需要安全调用就可以访问可空类型的拓展
fun verifyUserInput(input: String?) {
    if (input.isNullOrBlank()) {//这里不用安全调用 ?.
        print("Please fill in the required fields")
    }
}
>>> verifyUserInput("")
>>> verifyUserInput(null)
```

```
public  fun String?.isNullOrBlank(): Boolean {
    return this == null || this.isBlank()
}

```
当你为一个可空类型定义拓展函数事 意味者你可以对可空的值调用这个函数，并且函数体中的this可能为null，所以你必须显示的检查，在java中this永远是非空的，因为她的引用是你当前类所在的实例。而在Kotlin中 这并不成立

注意 当你定义自己的拓展函数时，需要考虑该拓展是否需要为可空类型定义。默认情况下，应该把它定义成非空类型的拓展函数。如果发现大部分情况下需要在可空类型上使用这个函数，你可以稍后在做修改。

#### 6.1.10 类型参数的可空性 

Kotlin中所有的泛型类和泛型参数默认都是可空的。任何类型，包括可空类型在内，都可以替换类型参数。在这种情况下，使用类型参数作为类型的声明都允许为nul
，尽管参数类型T并没有用问好(?)结尾

#### 3.1.11 可空性和Java
Kotlin与java的互操作性是非常有用的，但是在Java得了类型系统中是不支持可控性的，那么在当你你混合使用Kotlin和Java时会发生什么？是否会失去所有的安全性？或者每个值都必须检查是否为null？

Java中的@Nullable String被Kotlin当做String？@NotNull String被当做String

如果这些注解不存在会发生什么，这种情况下，Java类型会变成Kotlin中的平台类型

#### 平台类型
> 平台类型就是的本质就是Kotlin不知道可空性信息，既可以把它当做可控类型处理，也可以把它当做非空类型处理，这意味者你需要像Java中一样，对你在这个类型上的操作负全部责任，如果你错误的理解了这个值，使用的时候就会运到NullPointException

Type（java） = (Type?) or (Type) (Koltin) 

在Kotlin中不能声明一个平台类型的变量，这些类型只能来自java代码

#### 继承

当在Kotlin中重写Java方法时，可以把参数和返回类型定义成可空的，也可以选择非空的

注意 在实现Java类或者接口的方法时一定搞清楚它的可空性，因为方法的实现可以在非Kotlin代码中被调用。Kotlin会为你声明的每一个非空参数生成非空断言，如果java传给null 断言会被触发。

### 6.3 集合与数组

#### 6.3.1 可空性和集合

>创建一个可空值的集合

```

fun readNumbers(reader: BufferedReader): List<Int?> {
    val result = ArrayList<Int?>()
    for (line in reader.lineSequence()) {
        try {
            val number = line.toInt()

            result.add(number)
        } catch (e: NumberFormatException) {

            result.add(null)
        }

    }
    return result
}

```
List<Int?> 是一个可持有Int?类型值的列表（可以持有int或者null）。从Kotlin1.1开始可以写成String.toIntOrNull来简化上面代码。
**注意，变量自己类型的可空性和用作类型参数的类型的可空性是有区别的**

List<Int?> 这种情况下，列表本省始终不为空，但列表中的每个值可能为空
List<Int>? 可能包含空引用而不是列表实例，单列表中的每个实例都是非空的
在另一种上下文中，你可能需要声明一个变量持有可控的列表，并且包含可空的数字，Kotlin中的写法是List<Int?>?
> 使用可控集合

```
fun addValidNumbers(numbers: List<Int?>) {
    var sumOfValidNumbers = 0
    var invalidNumbers = 0
    for (number in numbers) {
        println("number: $number")
        if (number != null) {
            sumOfValidNumbers += number
        } else {
            invalidNumbers++
        }
    }
    println("Sum Of validNumbers $sumOfValidNumbers")
    println("invalidNumbers $invalidNumbers")
}
>>> 43
>>> 1
```
遍历一个包含可空值的集合并过滤null值是一种很常见的操作，因此Kotlin提供了一个标准库函数filterNotNull来完成它，这里大大简化上述的代码

#### 6.3.2 只读集合和可变集合

>MutableCollection集成了Collection并添加了修改集合内容的方法
```
graph LR
MutableCollection-->Collection
```
MutableCollection  | Collection
---|---
add() | size()
remove() | iterator
clear() | contains

使用集合接口时需要牢记的一点是**只读集合不一定是不可变的**，如果你使用的变量拥有一个只读接口类型，它可能只是同一个集合的众多引用中一个，任何其他的引用都可能拥有一个可变类型接口

> 两个不同的引用，一个只读、一个引用 指向同一个集合对象

```
graph LR
list:List-->a/b/c
mutableList:MutableList-->a/b/c(集合)

```
如果你调用了这样的方法，这会导致concurrentModification错误和其他一些问题。因此必须了解只读集合并不总是线程安全的

### 6.3.3 Kotlin集合和Java

> 集合创建函数


集合类型 | 只读 | 可变
---|--- |---
List | listOf | mutableListOf、arraylistOf
Set | setOf | mutableSetOf、hashSetOf、linkSetOf
Map | mapOf | mutableMapOf、hashMapOf、linkMapOf

#### 6.3.5 对象和基本数据类型的数组

```
fun main(args: Array<String>) {
    for (i in args.indices) {
        print("Argument $i is : ${args[i]}")
    }
}
```
要在Kotlin中定义数组，有以下方法供你选择

- arrayOf函数创建一个数组，它包含的元素是指定为该函数的实参
- arrayOfNulls创建一个给定大小的数组，包含的是null元素。当然它只能用来创建包含元素类型可空的数组
- Array 构造方法接受数组的大小和一个Lambda表达式

> 创建字符数组
```
    val letters: Array<String> = Array(26) { i -> ('a' + i).toString() }
    println(letters.joinToString("")
```

为了表示基本数据类型的数组，Kotlin提供了若干独立的类，每一种基本数据类型都对应一个，例如Int类型对应IntArray char对应CharArray boolean对应BooleanArray

### 6.4 小结
- Kotlin对可空类型的支持，可以帮助我们在编译期，检测出潜在NullPointException错误
- Kotlin提供了像安全调用(?.) Elvis运算符(?:)、非空断言(!!)以及let函数这样的函数来简洁处理可空类型
- as?安全转化运算符提供了一种简单的方式来转化成一个类型，以及处理当它拥有不同类型的情况
- Java中的类型在Kotlin中被称之为平台类型，允许开发者们将他当做可空或则非空来处理
- Any是所有其他类型的超类型，类似于Java中的Object，而Unit类比于Void
- 不会正常终止的函数使用Nothing类型来作为返回类型
- Kotlin使用标准Java集合类，并通过区分只读和可变集合来增强它们
- 当你在Kotlin中继承或者实现Java类或者Java接口时，你需要仔细考虑参数的可空性和可变性
## 7章.运算符重载及其他约定


```
本章内容包括

1 运算符重载
2 约定：支持各种运算的特殊命名函数
3 委托属性

```
#### 7.1 重载算术运算符

#### 7.1.1 重载二元算术运算符

```
/**
 * 定义一个plus运算符 
 */
data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
}
```
**注意 如何使用operator关键字声明plus函数，用于重载运算符的所有函数都必须用此关键字声明，在使用了operator关键字声明了plus函数后，你就可以使用“+”号来求和，就会调用plus函数**

>除了把这个运算符声明成成员函数以外，还可以声明为拓展函数


```
//TODO 定义一个plus运算符 拓展函数写法
operator fun Point.plus(other: Point): Point {

    return Point(x + other.x, y + other.y)
}
```

> 可重载的二元算术运算符


表达式 | 函数名
---|---
a * b | times
a / b | div
a % b | mod
a + b | plus
a - b | minus

### 7.1.2 重载复合赋值运算符

> 通常情况下，在你定义plus运算符的时候，Kotlin不止支持+号 也支持+= -=，像这样的运算符我么称之为复合赋值运算符

在一些情况下 +=运算可以修改使用它的变量所引用的对象，但不会重新分配引用，将一个元素添加到可变集合就是一个很好的例子


```
  val number = ArrayList<Int>()
    number += 42
    println(number[0])
    >>> 42
```
如果你定义了一个名字为plusAssign的函数，Kotlin会在你调用+=的时候用到它，其他二元运算符也有命名相似的函数。入timesAssign、minusAssign

Kotlin标准库为可变集合定义了plusAssign函数

```
public inline operator fun <T> MutableCollection<in T>.plusAssign(element: T) {
    this.add(element)
}
```

**当你在代码中调用+=时，理论上plus和plusAssign都有可能被调用，如果这种情况下，两个函数都有定义且适用，编译器会报错。一种方案就是替换运算符为普通函数调用，另一种就是用val替代var。这样plusAssign就不再适用，但一般来说，最好是在设计新类的时候不要同时定义这两个函数**

Kotlin支持集合的这两种方法，+和-总是返回一个新的集合。+=和-=运算符用于可变集合时，总是在修改它们。而它们在用作只读集合的时候会返回一个修改过的副本，这意味在只有在只读集合被声明称var的时候，才能使用+=和-=

### 7.3 集合与区间的约定

#### 7.3.1 通过下标来访问元素: "get"与"set"
我们都知道在Kotlin中可以通过类似Java访问数组的方式来访问map中的元素或修改它

> val value = map[key]

> mutable[key] = value

那我们也可以为自定义类添加类似的方法

>实现get约定 

```
operator fun Point.get(index: Int) {
    when(index){
        0->x
        1->y
        else
            -> throw IndexOutOfBoundsException()
    }
}
```


```
 val point = Point(3,4)
    point[1]
```

#### 7.3.2 实现in约定

> 写法与get函数类似，对应的函数名称为“contains” 。a in c -> c contains a

**in 右边的对象会调用contains函数，in左边的对象会被作为函数参数**

#### 7.3.3 实现rangTo约定

创建区间操作 start..end -> start.rangTo(end)

**rangTo函数返回了一个区间，你可以为自己的类定义这个运算符。但当你的类实现了Comparable接口，那就不需要了。你可以通过Kotlin标准库创建一个任意可比较的区间**

#### 在for循环中使用“iterator”的预定

在Kotlin中，我们知道在for循环中也可以使用in运算符，和用作区间检查一样。但是在这种情况下它的含义是不同的：它是被用来执行迭代。这意味着for（x in list）{} 将会被转化成list.iterator()的调用。然后就像和Java一样，在上面重复调用hasNext()和next()
请注意，在Kotlin中，这也属于一种约定，那么就意味着iterator()函数也可以被定义成拓展函数,这就解释为什么可以遍历一个常规java字符串：标准库已经为CharSequence定义了一个iterator方法，而她是String的父类

```
public operator fun CharSequence.iterator(): CharIterator = object : CharIterator() 

```
### 7.4 解构声明和组件函数

>解构声明 这个功能允许你展开单个复合值，并使用它来初始化多个单独的变量

```
    val point = Point(3, 4)
    val (x, y) = point
    print(x)
    print(y)
```
> 对于数据类（data class） 编译器会为每一个在主构造方法中声明的属性定义一个componentN函数，如果是非数据类，你可以按照下面代码的方式手动添加

```
class Point(val x: Int, val y: Int) {
    operator fun component1() = x
    operator fun component2() = y
   

}
```

**请注意，标准库只允许你用此语法来访问一个对象的前五个元素**

#### 7.4.1 解构声明和循环

> 用解构声明来遍历map集合

```

fun printEntries(map: Map<String, String>) {
    for ((key, value) in map) {
        println("$key -> $value")
    }
}
```

### 7.5 重用属性访问的逻辑：委托属性

> 委托是一种设计模式，操作的对象不用自己执行，而是把工作委托给另一个辅助对象


#### 7.5.1 委托属性的基本操作

#### 7.5.2 使用委托属性：惰性初始化和"by lazy()"

> 惰性初始化是一种常见的模式，只有在第一次访问该属性的时候，才根据需求创建对象的一部分

## 7.6 小结

- Kotlin允许使用对应名称的函数名来冲在一些标准的数学运算，但是不能定义自己的运算符

- 比较运算符映射的是 "equals()"和 "compareTo()"
- 通过自定义get、set和contains函数，可以让你自己的类与Kotlin的集合一样通过[]、和in运算符
- 可以通过约定来创建区间，以及迭代集合和数组
- 解构声明和可以用来展开单个对象用来初始化多个变量，这可以方便的重函数总返回多个值，他们可以自动处理数据类，或者自己定义的componentN来支持
- 委托属性可以用来重用逻辑、这些逻辑用来如何存储、初始化、访问和修改属性值。
- lazy()函数提供了一种实现惰性初始化的简单方法

## 8章.高阶函数:lambda作为形参和返回值


```
本章内容
1 函数类型
2 高阶函数及其在组织代码中的应用
3 内联函数
4 非局部返回和标签
5 匿名函数
```

### 8.1 高阶函数

> 高阶函数就是将另一个函作为形参和返回值的函数，在Kotlin中函数可以用函数引用和lambda来表示。因此，任何以函数或者lambda表达式作为函数参数的函数，都可以称之为高阶函数

#### 8.1.1 函数类型

为了声明一个以lambda作为实参的函数，你需要知道如何声明对应形参的类型。我们来看会个简单的例子


```
val sum = { x:Int,y:Int -> x+y}
val action = { println(42) }
```
在这个例子中，编译器推导出sum和action这两个变量具有函数类型。

> 变量的显示类型声明

```
//TODO:有两个Int型参数和Int型返回值的函数 
val sum: (Int ,Int) -> Int = { x,y-> x+y}
//TODO:没有参数和返回值的函数
val action:()-> Unit = { println(42) }
```

在声明一个普通函数时，Unit是可以省略的，但是一个函数类型声明总是需要一个显示的返回类型，这种情况下Unit是不能省略的

就像其他与法一样，函数类型的返回值也可以标记为可空类型


```
var canReturnNull :(Int,Int) -> Int? = { null }
```

也可以定义一个函数类型可空的变量，为了表示是本来那个本身可空，而不是返回值可空，需要用括号将整个函数类型包裹



```
var canReturnNull : ((Int,Int) -> Int)? = { null }
```

#### 8.1.2 调用作为参数的函数
知道了怎么申明一个告诫函数，现在我们来讨论如何去实现它，下面是一个filter函数声明


```
fun String.filter(predicate: (Char)->Boolean):String
```
- String : 接受这类型
- predicate：参数类型
- ((Char) - > Boolean)：函数类型参数
- (Char)：作为参数传递的函数的参数类型
- Boolean：作为参数传递的函数的返回类型

filter 函数以一个判断试作为参数。判断式的类型是一个函数，以字符作为参数并返回boolean类型的值。如果要让传递给判断式的字符出现在最终返回的字符串中，判断式需要返回ture，否则为false，以下是这个方法的实现


```kotlin
fun String.filter(predicate: (Char) -> Boolean): String {
    var stringButter = StringBuffer()
    for (index in 0 until this.length) {
        var element = get(index)
        if (predicate(element)) stringButter.append(element)
    }
    return stringButter.toString()
}
```

#### 8.1.4 函数类型的默认参数值和null值

> 给函数类型的参数指定默认值

```kotlin
fun <T> Collection<T>.jointToString(separator: String = ", ", prefix: String = "[", postfix: String = "]", transfrom: (T) -> String = { it.toString() }): String {
    val result = StringBuilder(prefix)
    println(result)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(transfrom(element))
    }
    result.append(postfix)
    return result.toString()
}
```
> 使用函可空的参数


```kotlin
fun <T> Collection<T>.jointToString2(separator: String = ", ", prefix: String = "[", postfix: String = "]", transfrom: ((T) -> String)? = null): String {
    val result = StringBuilder(prefix)
    println(result)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(transfrom?.invoke(element) ?: element.toString())
    }
    result.append(postfix)
    return result.toString()
}
```

当参数类型可空的时候，你不能直接调用作为参数传递进来的函数，这样编译器会报错，需要显示的检查null：


```
fun foo (callback: (() -> Unit)?){
    if(callback!=null){
        
    }
}
```
或者有一个更简单的版本，kotlin中函数类型是一个包含了invoke的接口方法的具体实现，作为一个方法，invoke可以通过安全调用语法被调用callback?.invoke()

#### 8.1.5 返回函数的函数

#### 8.1.6 通过lambda去除重复代码

### 8.2 内联函数：消除Lambda带来的运行开销

因为lambda表达式在运行时会被编译成匿名类，也就是表示每次调用一次lambda就会创建一个额外的类

> 当一个函数被声明成inline时，他的函数体是内联的，函数体会被直接替换到函数被调用的地方


### 8.3 高阶函数中的控制流

#### 8.3.1 lambda中返回语句：从一个封闭的函数返回

```在传递给forEach的lambda中调用return，这里是安全的

fun lookForAlice(people: List<Person>) {
    people.forEach {
        if (it.name == "Alice") {
            println("Found!")
            return
        }
    }
    println("Alice is not Found")
}

```
注意，如果你在lambda中调用return关键字，它会重你调用lambda的函数中返回，而不是从lambda中返回。这样的语句叫非局部返回，因为他不是从一个比包含return的代码块更大的代码块中返回的


```
@kotlin.internal.HidesMembers
public inline fun <T> Iterable<T>.forEach(action: (T) -> Unit): Unit {
    for (element in this) action(element)

```

需要注意的是，*只有在以lambda作为参数的函数是内联函数时*才能从外层的函数中返回，所以上面的forEach是安全的

#### 8.3.2 从lambda中返回：使用标签返回
也可以在lambda中使用局部返回。lambda中的局部返回和for循环的break表达式类似，它会终止lambda的执行，并接着从调用lambda中向下执行

>用一个标签实现局部返回


```
fun lookForAlice(people: List<Person>) {
    people.forEach label@{
        if (it.name == "Alice") {
            println("Found!")
            return@label
        }
    }
    println("Alice is not Found")
}
```
另一种方式是可以使用函数名作为标签


```
fun lookForAlice(people: List<Person>) {
    people.forEach {
        if (it.name == "Alice") {
            println("Found!")
            return@forEach
        }
    }
    println("Alice is not Found")
}

```

如果你显示的指定了lambda表达式标签，再用函数名返回是无效的，一个lambda表达式的标签数量最多一个

#### 8.3.3 匿名函数：默认使用局部返回

如果一个lambda中包含多个返回语句会变得非常笨重，解决方案就是用匿名函数来替换

> 在匿名函数中使用return


```

fun lookForAlice(people: List<Person>) {
    people.forEach(fun(person) {
        if (person.name == "Alice") return// "return指向最近的函数：fun（person）匿名函数"
        println("${person.name} is not alice")
    })
}
```
在匿名函数中，不带标签的return表达式会从匿名函数返回，而不是包含匿名函数的函数返回。这条规则很简单：return从最近的使用fun关键字声明的函数中返回

### 小结

- 函数类型可以让你声明一个持有函数引用的变量、参数或者函数返回值
- 高阶函数以其他函数作为参数或者返回值。可以使用函数类型作为参数值或者返回值来创建这样的函数
- 内联函数被编译后，他的字节码连同传递给他的lambda字节码都会被插入到调用函数的代码中
- 高阶函数促进了一个组件内不同部分的代码重用
- 内联函数可以让你使用非局部返回—在lambda中包含函数返回的返回表达式






