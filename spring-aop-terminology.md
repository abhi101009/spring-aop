# What is Aspect?
Aspect is a class that implements enterprise application concerns that cut across multiple classes.
Ex: If an Enterprise application have concern for Transaction Management for all Dao classes, we can achive this 
by Aspect oriented programming.

We can create a class for any concern using annotation `@Aspect`.

# What is Join point?
Join point is a specific point in a appication such as execution of a method, exception handling, changing in Object variable 
etc.
Spring supports only one Join point that is execution of method.

# What is Advice?
Advice is an action taken for a perticular join point. In terms of programming It is a method that gets executed when 
certain join point with matches pointcut reaches in the application.

In Spring AOP 5 type of advices available 
# 1. `@Before` 
This advice will be execute before join point method execution.

# 2. `@After` 
This advice will be execute after join point finally block execution.

# 3. `@AfterReturning`
This advice will be execute after join point method return value.

# 4. `@AfterThrowing`
This advice will be execute when join point method throws exception.

# 5. `@Around`
This advice is capable to execute crosscut concern after before or even is exception at this advice is responsible to 
invoke join point method.

# What is pointcut?
Pointcut are expressions that matches with the join points to determine wheter advice needs to be executed or not.
If same pointcut is required in multiple advices we can declear it with an empty implementation method and use this method 
along with advice as a expression.

```java
 @Pointcut("execution(public void com.aminfo.dao.*.*(..))")
 public void daoPointcut(){}
 ```
 Or
 ```java
 @Pointcut("within(com.aminfo.dao.*)")
 public void daoDataPointcut(){}
 ```
# What is weaving?
It is a process of linking the Aspect with other advised object.
This can be done by Compile time, load time or at run time. 
Spring AOP uses run time weaving.

# Required dependencies for AOP?
```xml
<dependency>
 <groupid> org.aspectj </groupid>
 <artifactid>aspectjrt </artifactid>
 <version>1.7.4</version>
 <scope>runtime</scope>
</dependency>

```

# How to Enable AspectJ in Spring?
In xml based configuration
define xml namespace as `xmlns:aop="http://www.springframework.org/schema/aop`
& schemaLocation or xsd as `http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-4.0.xsd`

Now enable AspectJ atyle of spring AOP
```xml
<aop:aspectj-autoproxy />
```

In Annotation base configuration
`@EnableAspectJAutoProxy`

 
 
