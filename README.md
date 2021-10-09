<h1 align="center">ex-clean-spring-kt</h1>
<p align="center">
  <img alt="spring" src="https://img.shields.io/badge/%E2%9D%A4-Spring-success">
    
  <img alt="kotlin" src="https://img.shields.io/badge/%E2%9D%A4-Kotlin-success">
    
  <img alt="java version" src="https://img.shields.io/badge/java-8-informational">

  <a href="https://github.com/CorreiaEduardo/ex-clean-spring-kt/issues">
    <img alt="Repository issues" src="https://img.shields.io/github/issues/CorreiaEduardo/ex-clean-spring-kt">
  </a>
  
  <a href="https://github.com/CorreiaEduardo/nlw-ecoleta/commits/main">
    <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/CorreiaEduardo/ex-clean-spring-kt">
  </a>

  <img alt="License" src="https://img.shields.io/badge/license-MIT-critical">
</p>

### 💻 About the project
<hr/>
en-US:
This project aims to illustrate a clean-architecture-based implementation of a spring service using kotlin. To achieve that, it has two main modules, `domain` that rule the domain world with contracts definition and business logic implementation, and `api` that is a spring application that implement some of the domain contracts and consumes its business logics.
<br>
<br>
pt-BR:
Este projeto tem como objetivo ilustrar uma implementação baseada em arquitetura limpa de um serviço Spring usando kotlin. Para isto, o projeto possui dois módulos principais, `domain` que governa o mundo do domínio, com definição de contratos e implementação de lógica de negócios, e `api` que é uma aplicação spring que implementa alguns dos contratos de domínio e consome suas lógicas de negócio.


### 🔖 Extras
<hr/>

- Base RabbitMQ producer/consumer structure with example;
- Complete docker-compose file;
- SwaggerUI configuration.

### 🚀 Guide
<hr/>

1.  **Preparing environment**
    - Ensure a `jdk 1.8.0` or `jre 1.8.0` installation;
    - Use docker along docker-compose file to run the needed infraestructure, or install/point to a running mysql server and RabbitMQ broker;
    - Clone project with ``git clone https://github.com/CorreiaEduardo/ex-clean-spring-kt.git``

2.  **Run project**
    - Just run main function in `AppStarter.kt` or `bootRun` gradle task with:
    ```sh
    gradle bootRun
    ```

### 📝 License
<hr/>

This project is under MIT license. See [LICENSE](LICENSE.md) file for further details.
