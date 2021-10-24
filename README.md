# FinalProject
Enterprise organization systems Management  Top companies have become one of the most important resources to operate and manage organizations in the 21st century. It touches every facet of a modern enterprise, from customer service to operations to social media, and security. Over time, technology creates new jobs like mobile application developers, social media and business intelligence analysts, information security specialists, and data architects. Such jobs didn’t exist twenty, or even ten, years ago and here I want to develop a system that integrates business functions across the enterprise, known as Enterprise Systems, which have become the backbone of modern organizations so I want to work on this idea

Design pattern
The four-design pattern which are used are: -

•	Strategy design pattern

In Strategy pattern, a class behavior or its algorithm can be changed at run time. This type of design pattern comes under behavior pattern. We create objects which represent various strategies and a context object whose behavior varies as per its strategy object. The strategy object changes the executing algorithm of the context object. In our Project we have included strategy project to assign memory to Laptops at run time, so that each laptop can be configured dynamically.

	•	Singleton design pattern
The singleton pattern is a mechanism that ensures only one instance of an object exists per application. This pattern can be useful when managing shared resources or providing cross-cutting services, such as logging. A singleton is globally unique for an application, but in Spring, this constraint is relaxed. Instead, Spring restricts a singleton to one object per Spring IoC container. In practice, this means Spring will only create one bean for each type per application context. In our project we are using autowired Annotation which auto wires a singleton instance of Data Repository.
	@Autowired
	DataRespository dataRepository;

	•	Factory Method pattern
The factory method pattern entails a factory class with an abstract method for creating the desired object. Often, we want to create different objects based on a particular context. 
We have used this technique at the root of its Dependency Injection (DI) framework via Spring Framework. Fundamentally, Spring treats a bean container as a factory that produces beans.

	•	Template Method Pattern
In many applications, a significant portion of the code is boilerplate code. For example, when executing a query on a database, the same series of steps must be completed:
Establish a connection
Execute query
Perform cleanup
Close the connection
These steps are an ideal scenario for the template method pattern.
We have used Template Method Pattern via Spring Data JPA and avoided the boilerplate code.
Reflecting the challenges and difficulties 
	•	Difficulties faced in initial setup and configuration of the project, especially database related settings and dependency settings and troubleshooting for the issues.
	•	Verification of the transaction/Functionality- We had to use Postman/other rest client and other online tools for testing and verification of the functionalities.

# Spring Boot MongoDB CRUD example - Restful CRUD API

For more detail, please visit:
> [Spring Boot with MongoDB CRUD example using Spring Data](https://bezkoder.com/spring-boot-mongodb-crud/)

More Practice:
> [Spring Boot MongoDB Pagination & Filter example](https://bezkoder.com/spring-boot-mongodb-pagination/)

> [Spring Boot + GraphQL + MongoDB example](https://bezkoder.com/spring-boot-graphql-mongodb-example-graphql-java/)

Exception Handling:
> [Spring Boot @ControllerAdvice & @ExceptionHandler example](https://bezkoder.com/spring-boot-controlleradvice-exceptionhandler/)

> [@RestControllerAdvice example in Spring Boot](https://bezkoder.com/spring-boot-restcontrolleradvice/)

Security:
> [Spring Boot: JWT Authentication & Authorization with MongoDB](https://bezkoder.com/spring-boot-jwt-auth-mongodb/)

Fullstack:
> [Angular 8 + Spring Boot + MongoDB](https://bezkoder.com/angular-spring-boot-mongodb/)

> [Angular 10 + Spring Boot + MongoDB](https://bezkoder.com/angular-10-spring-boot-mongodb/)

> [Angular 11 + Spring Boot + MongoDB](https://bezkoder.com/angular-11-spring-boot-mongodb/)

> [Vue.js + Spring Boot + MongoDB](https://bezkoder.com/spring-boot-vue-mongodb/)

> [React + Spring Boot + MongoDB](https://bezkoder.com/react-spring-boot-mongodb/)

Run both Back-end & Front-end in one place:
> [Integrate Angular with Spring Boot Rest API](https://bezkoder.com/integrate-angular-spring-boot/)

> [Integrate React.js with Spring Boot Rest API](https://bezkoder.com/integrate-reactjs-spring-boot/)

> [Integrate Vue.js with Spring Boot Rest API](https://bezkoder.com/integrate-vue-spring-boot/)

## Run Spring Boot application
```
mvn spring-boot:run
```



