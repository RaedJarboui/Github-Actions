# GitHub Actions + Docker CI/CD Setup Guide

## Overview

This project demonstrates a complete CI/CD pipeline using:

* GitHub Actions
* Maven
* Java 17
* Docker
* Docker Hub

The workflow automatically:

1. Builds the Maven project
2. Runs tests
3. Creates a Docker image
4. Pushes the Docker image to Docker Hub

---

# Project Workflow

```text
Developer pushes code
        ↓
GitHub Actions workflow starts
        ↓
Ubuntu runner is created
        ↓
Repository is cloned
        ↓
Java 17 is installed
        ↓
Maven build runs
        ↓
Docker image is built
        ↓
Docker image is pushed to Docker Hub
```

---

# Step 1 — Create GitHub Actions Workflow

Create the following file:

```text
.github/workflows/maven.yml
```

## Workflow Content

```yaml
name: Github Actions CI/CD

on:
  push:
    branches: [ "main" ]

  pull_request:
    branches: [ "main" ]

jobs:
  build:

    runs-on: ubuntu-latest

    steps:

    - uses: actions/checkout@v4

    - name: Set up JDK 17
      uses: actions/setup-java@v4
      with:
        java-version: '17'
        distribution: 'temurin'
        cache: maven

    - name: Build with Maven
      run: mvn clean install

    - name: Log in to Docker Hub
      uses: docker/login-action@v3
      with:
        username: ${{ secrets.DOCKER_USERNAME }}
        password: ${{ secrets.DOCKER_PASSWORD }}

    - name: Build Docker image
      run: docker build -t raedjarboui/springboot-api:latest .

    - name: Push Docker image
      run: docker push raedjarboui/springboot-api:latest
```

---

# Step 2 — Create Dockerfile

Create a file named:

```text
Dockerfile
```

## Dockerfile Content

```dockerfile
FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
```

---

# Step 3 — Configure GitHub Secrets

Go to:

```text
Repository Settings
    ↓
Secrets and variables
    ↓
Actions
```

Create the following secrets:

| Secret Name     | Secret Value                      |
| --------------- | --------------------------------- |
| DOCKER_USERNAME | Your Docker Hub username          |
| DOCKER_PASSWORD | Your Docker Hub password or token |

---

# Step 4 — Create Docker Hub Repository

Create a repository on Docker Hub.

Example:

```text
raedjarboui/myapp
```

---

# Step 5 — Push Code

Run:

```bash
git add .
git commit -m "Add CI/CD pipeline"
git push origin main
```

---

# Step 6 — GitHub Actions Execution

After pushing code:

1. Open the repository
2. Click on the "Actions" tab
3. Open the latest workflow execution

You should see:

```text
✓ Set up job
✓ Checkout code
✓ Set up JDK 17
✓ Build with Maven
✓ Log in to Docker Hub
✓ Build Docker image
✓ Push Docker image
✓ Complete job
```

---

# Add Screenshots

## Screenshot 1 — GitHub Actions Workflow

<img width="1861" height="967" alt="image" src="https://github.com/user-attachments/assets/672d2f54-44c5-42be-b0be-07c1488a74cd" />

<img width="1876" height="910" alt="image" src="https://github.com/user-attachments/assets/c2b06f7e-5cde-46b0-b5de-946662f06ec9" />


---

## Screenshot 2 — Docker Hub Repository



<img width="1877" height="958" alt="image" src="https://github.com/user-attachments/assets/09ec26a9-9066-495a-85a7-70823013c0ca" />


<img width="1891" height="908" alt="image" src="https://github.com/user-attachments/assets/a1d97c2a-4b33-415c-b86a-7dbe26ff3755" />


---

## Screenshot 3 — GitHub Secrets


<img width="1887" height="962" alt="image" src="https://github.com/user-attachments/assets/2ab4beaf-2b16-4248-8850-68e04aa0c3b2" />




# Final Result

The project now supports:

* Continuous Integration (CI)
* Continuous Deployment (CD)
* Automated Maven builds
* Automated Docker image creation
* Automated Docker Hub publishing

---

# Technologies Used

* Java 17
* Spring Boot
* Maven
* Docker
* GitHub Actions
* Docker Hub

---

# Useful Commands

## Build locally

```bash
mvn clean install
```

## Build Docker image locally

```bash
docker build -t myapp .
```

## Run Docker container locally

```bash
docker run -p 8080:8080 myapp
```

## Pull image from Docker Hub

```bash
docker pull raedjarboui/myapp:latest
```

---

# Author

Created by Raed Jarboui.
