# 切入点表达式
```markdown
语法：
            访问修饰符          返回值类型（必填）     包和类                    方法（必填）            异常
 execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern)  throws-pattern?) 

```

### 示例
```markdown
 切入点表达式：
第一：语法
            访问修饰符          返回值类型（必填）     包和类               方法（必填）
execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern) throws-pattern?)
第二：作用对符合切入点表达式的类，会自动生成代理对象。
第三：应用
1.最全的写法
拦截返回void，指定类的指定方法，参数必须有两个：int、String
execution(public void com.sunny.service.Impl.AccountServiceImpl.save(int,java.lang.String))
2.省略访问修饰符，返回值任意的指定类的save方法，无参数
execution(*  com.sunny.service.Impl.AccountServiceImpl.save())
3.拦截com包下所有的类、以及其子包下所有的类的save（）方法
execution(void  com..*.save())  包名与类名或方法名称都可以使用*
4.拦截save（）方法/拦截所有方法
execution(* save())  拦截save（）
execution(* *())     拦截所有方法
5.不拦截save（）方法
!execution(* save())
not execution(* save())  注意not前面要有空格
6.拦截save（）方法或者update（）方法
execution(* save()) || execution(* update()))
execution(* save()) or execution(* update()))
7.拦截所有方法，参数任意，但必须有参数
execution(* *(*))
8.拦截所有方法，参数任意，参数可有可无
execution(* *(..))
9.对IOC容器中以Service结尾的类，生成代理对象
bean(*Service)
10.最常用
execution(* com.sunny..*ServiceImpl.*(..))
表示com.sunny包及其子包下所有的以ServiceImpl结尾的类生成代理对象

```