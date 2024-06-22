# API Testing with REST Assured

Automated API tests of an e-commerce application built using **REST Assured**.

## Prerequisites

Install the following prerequisites:

1. [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://openjdk.org/)
2. [Node.js](https://nodejs.org/en/)
3. [PostgreSQL](https://www.postgresql.org/download/)
4. [Visual Studio Code](https://code.visualstudio.com/download) with two extensions installed: **Language Support for Java(TM) by Red Hat** and **Maven for Java**.
* [Language Support for Java(TM) by Red Hat](https://marketplace.visualstudio.com/items?itemName=redhat.java) provides Java language support for Visual Studio Code.
* [Maven for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-maven) provides a project explorer and shortcuts to execute Maven commands, improving the user experience for Java developers who use Maven.

## System Under Test (SUT)

The system under test (SUT) is this [e-commerce application](https://github.com/mgrybel/ecommerce-website) built using **Spring Boot 3** and **React 18**.

To run tests in this project, you must first install and run the SUT. Follow [these steps](https://github.com/mgrybel/ecommerce-website/blob/master/README.md).

## Download the project

1. Clone this repository or download the ZIP file and unzip the project.
2. Open the project in Visual Studio Code.

## Installation

From the **root** directory, run:

```bash
mvn compile
```

## Run tests

From the **root** directory, run:

```bash
mvn test
```

## Generate the Allure report

From the **root** directory, run:

```bash
mvn allure:serve
```
