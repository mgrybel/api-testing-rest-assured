# API Testing with REST Assured

Automated API tests of an e-commerce application built using **REST Assured**.

## Table of Contents

- [Prerequisites](#prerequisites)
- [System Under Test (SUT)](#system-under-test-sut)
- [Download the project](#download-the-project)
- [Installation](#installation)
- [Run tests](#run-tests)
- [Generate the Allure report](#generate-the-allure-report)

## Prerequisites

Install the following prerequisites:

1. [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://openjdk.org/)
2. [Node.js](https://nodejs.org/en/)
3. [PostgreSQL](https://www.postgresql.org/download/)
4. [Visual Studio Code](https://code.visualstudio.com/download) with two extensions installed:
- [Language Support for Java(TM) by Red Hat](https://marketplace.visualstudio.com/items?itemName=redhat.java)
- [Maven for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-maven)
<br /><br />
You can also use [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) or [Eclipse](https://eclipseide.org/).

## System Under Test (SUT)

The system under test (SUT) is this [e-commerce application](https://github.com/mgrybel/ecommerce-website) built using **Spring Boot 3** and **React 18**, which uses a **PostgreSQL** database to store data.

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
