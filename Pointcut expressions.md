### Some examples of common pointcut expressions are given below.
the execution of any public method:

`execution(public * *(..))`

the execution of any method with a name beginning with "set":

`execution(* set*(..))`

the execution of any method defined by the AccountService interface:

`execution(* com.xyz.service.AccountService.*(..))`

The execution of any method defined in the service package:

`execution(* com.xyz.service.*.*(..))`

the execution of any method defined in the service package or a sub-package:

`execution(* com.xyz.service..*.*(..))`

any join point (method execution only in Spring AOP) within the service package:

`within(com.xyz.service.*)`

any join point (method execution only in Spring AOP) within the service package or a sub-package:

`within(com.xyz.service..*)`

any join point (method execution only in Spring AOP) where the proxy implements the AccountService interface:

`this(com.xyz.service.AccountService)`

**this** is more commonly used in a binding form :- see the following section on advice for how to make the proxy object available in the advice body.

any join point (method execution only in Spring AOP) where the target object implements the AccountService interface:

`target(com.xyz.service.AccountService)`

**target** is more commonly used in a binding form :- see the following section on advice for how to make the target object available in the advice body.

any join point (method execution only in Spring AOP) which takes a single parameter, and where the argument passed at runtime is Serializable:

`args(java.io.Serializable)`

**args** is more commonly used in a binding form :- see the following section on advice for how to make the method arguments available in the advice body.
Note that the pointcut given in this example is different to execution(* *(java.io.Serializable)): the args version matches if the argument passed at runtime is Serializable, the execution version matches if the method signature declares a single parameter of type Serializable.

any join point (method execution only in Spring AOP) where the target object has an @Transactional annotation:

`@target(org.springframework.transaction.annotation.Transactional)`

**@target** can also be used in a binding form :- see the following section on advice for how to make the annotation object available in the advice body.

any join point (method execution only in Spring AOP) where the declared type of the target object has an @Transactional annotation:

`@within(org.springframework.transaction.annotation.Transactional)`

**@within** can also be used in a binding form :- see the following section on advice for how to make the annotation object available in the advice body.

any join point (method execution only in Spring AOP) where the executing method has an @Transactional annotation:

`@annotation(org.springframework.transaction.annotation.Transactional)`

**@annotation** can also be used in a binding form :- see the following section on advice for how to make the annotation object available in the advice body.

any join point (method execution only in Spring AOP) which takes a single parameter, and where the runtime type of the argument passed has the @Classified annotation:

`@args(com.xyz.security.Classified)`

**@args** can also be used in a binding form :- see the following section on advice for how to make the annotation object(s) available in the advice body.
