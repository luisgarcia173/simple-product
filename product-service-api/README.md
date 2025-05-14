# Product Service API
![project version](https://img.shields.io/badge/version-1.0.0-blue.svg)
- **Team:** Luis Garcia
- **Since:** 2025-05-13

**Purpose:** Build a [CRUD] API for managing products.

**Description:** This project serves as a lab to validate the technologies listed below and provide technical insights for future architectural decisions.

Criteria used for building the **API**:
- Test coverage (unit, integration, and overall);
- RESTful API design;
- API Documentation: OpenAPI 3;
- In-memory database: H2;
- Java with JDK 21;
- Spring Boot 3;
- Maven as build tool;
- Cloud hosting: Heroku.

# Project Phases / Roadmap
| Date       | Phase            | Description                                                                 |
|------------|------------------|-----------------------------------------------------------------------------|
| 2025-05-13 | Setup            | Create project skeleton using Spring Boot                                   |
| 2025-05-13 | Setup            | Initialize GitHub repository                                                |
| 2025-05-13 | Setup            | Add Actuator library (Health Check)                                        |
| 2025-05-13 | Setup            | Configure OpenAPI for Swagger generation                                   |
| 2025-05-13 | Development      | Create DTOs to decouple API from DB model                                  |
| 2025-05-13 | Development      | Define endpoints and routes with HTTP code handling                        |
| 2025-05-13 | Development      | Implement custom exceptions                                                |
| 2025-05-13 | Development      | Configure global error handler                                             |
| 2025-05-13 | Setup            | Integrate in-memory H2 database for POC                                    |
| 2025-05-13 | Setup            | Configure JPA persistence layer                                            |
| 2025-05-13 | Setup            | Add paginated queries using Pageable                                       |
| 2025-05-13 | Development      | Create business layer and integrate with repository                        |
| 2025-05-13 | Integration Test | Create Postman payloads for integration testing                            |
| 2025-05-13 | Development      | Write initial unit tests (Controller/Service/Repository)                   |
| 2025-05-13 | Setup            | Add and configure Jacoco for code coverage                                 |
| 2025-05-13 | Setup            | Validate Jacoco reports and metrics                                        |
| 2025-05-13 | Code Review      | Run SonarLint before commits and apply fixes                               |

# Out of Scope (Improvements)
| Date     | Phase     | Description                                                                 |
|----------|-----------|-----------------------------------------------------------------------------|
| Pending  | Improve   | Increase overall test coverage to 90%                                       |
| Pending  | Improve   | Add CPF duplication validator on create/update                              |
| Pending  | Improve   | Add application profiles for dev/hml/prod environments                      |
| Pending  | Improve   | Externalize credentials using environment variables                         |
| Pending  | Improve   | Package application using Docker                                             |
| Pending  | Improve   | Containerize DB and infrastructure dependencies                              |
| Pending  | Improve   | Add transactional logging layer (auditing)                                  |
| Pending  | Improve   | Add system logging layer (errors)                                           |
| Pending  | Improve   | Setup tracing using UniqueId/TraceId + Cloud Sleuth + Jaeger                |
| Pending  | Improve   | Add caching layer for less sensitive queries (Redis)                        |
| Pending  | Improve   | Implement token-based authentication via headers                            |

# Technical Details

## Table of Contents
1. [Project Structure](#project-structure)
2. [Dependencies](#dependencies)
3. [API Health Check](#api-health-check)
4. [Open API](#open-api)
5. [Code Coverage](#code-coverage)

## Project Structure
Simple project structure generated via Spring Initializr, using Spring Boot, WebMVC, and necessary dependencies.

Basic MVC architecture was chosen for fast development and to allow easy future migration to a layered or hexagonal structure.

Initial structure:

![structure](/docs/packagesStructure.png "Packages Structure")

To run the project via CLI: (run springboot)
```bash
mvn spring-boot:run
```

To run the tests via CLI: (run tests and generate coverage report)
```bash
mvn test
```

## Dependencies
```
<!-- Spring Boot -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
</dependency>

<!-- OpenAPI -->
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
</dependency>

<!-- Lombok -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <scope>provided</scope>
</dependency>

<!-- Google Guava -->
<dependency>
    <groupId>com.google.guava</groupId>
    <artifactId>guava</artifactId>
</dependency>

<!-- H2 Database -->
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>

<!-- Testing -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-testcontainers</artifactId>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.testcontainers</groupId>
    <artifactId>junit-jupiter</artifactId>
    <scope>test</scope>
</dependency>

```
## API Health Check
Actuator: http://localhost:8080/actuator/health

![healthcheck](/docs/healthCheck.png "Health Check")

## Open API
Swagger UI: http://localhost:8080/swagger-ui/index.html

API Docs: http://localhost:8080/v3/api-docs

Postman Collection: available in the docs folder (ProductServiceAPI.postman_collection.json)

![swagger](/docs/swagger.png "API Docs")

## Code Coverage
Jacoco is configured to generate code coverage reports at the end of the test phase.

Example report:

![jacocoReport](/docs/jacocoReport.png "Jacoco Report")

Report path after execution:

![jacocoFolder](/docs/jacocoFolder.png "Jacoco Folder")

