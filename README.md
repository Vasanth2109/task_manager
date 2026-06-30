# Task Manager Application

A full-stack Task Manager application built using Java, Spring Boot, MySQL, HTML, CSS, and JavaScript.

## Features

* Add Tasks
* View Tasks
* Mark Tasks as Completed
* Delete Tasks
* Search Tasks
* Task Statistics (Total, Pending, Completed)

## Tech Stack

### Backend

* Java 21
* Spring Boot
* Spring Data JPA

### Database

* MySQL

### Frontend

* HTML
* CSS
* JavaScript

## REST APIs

| Method | Endpoint        | Description         |
| ------ | --------------- | ------------------- |
| POST   | /api/tasks      | Add Task            |
| GET    | /api/tasks      | Get All Tasks       |
| PUT    | /api/tasks/{id} | Mark Task Completed |
| DELETE | /api/tasks/{id} | Delete Task         |

## Database Schema

Table: tasks

* id
* title
* status
* created_at

## Run Locally

1. Create MySQL database:
   CREATE DATABASE taskdb;

2. Configure application.properties

3. Run:
   mvn spring-boot:run

4. Open:
   http://localhost:8080
