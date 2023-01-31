PowerMock是一个扩展了其它如EasyMock等mock框架的、功能更加强大的框架。
PowerMock使用一个自定义类加载器和字节码操作来模拟静态方法、构造方法、final类和方法、私有方法、去除静态初始化器等等。


为了引入PowerMock包，需要在pom.xml文件中加入下列maven依赖：

<dependency>
    <groupId>org.powermock</groupId>
    <artifactId>powermock-module-junit4</artifactId>
    <version>2.0.9</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.powermock</groupId>
    <artifactId>powermock-api-mockito2</artifactId>
    <version>2.0.9</version>
    <scope>test</scope>
</dependency>



在SpringMVC项目中，需要在pom.xml文件中加入JUnit的maven依赖：

<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
    <scope>test</scope>
</dependency>


在SpringBoot项目中，需要在pom.xml文件中加入JUnit的maven依赖：

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>


1  mock方法

声明：
T PowerMockito.mock(Class clazz);
用途：可以用于模拟指定类的对象实例。

当模拟非final类（接口、普通类、虚基类）的非final方法时，不必使用@RunWith和@PrepareForTest注解。当模拟final类或final方法时，必须使用@RunWith和@PrepareForTest注解。注解形如：

@RunWith(PowerMockRunner.class)
@PrepareForTest({TargetClass.class})