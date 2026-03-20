# Client Financial Info Service

## Overview

This is a full-stack application for capturing client investment details including personal information, financial goals, and beneficiary details.

## Features

* Dynamic form using Metawidget
* Input validation on frontend
* REST API using Spring Boot
* Data persistence using H2 database
* Backend deployed on Railway

## Tech Stack

* Java 17
* Spring Boot
* HTML, CSS, JavaScript
* Metawidget
* H2 Database
* Railway (deployment)

## How to Run Locally

### Backend

1. Clone the repository
2. Run:
   mvn spring-boot:run
3. Access API:
   http://localhost:8080/api/clients

### Frontend

1. Open `index.html` in browser
2. Submit form

## Deployed API

https://client-financial-info-service-production.up.railway.app/api/clients

## Notes

* Change API URL in `app.js` if running locally vs deployed
* H2 database is in-memory (data resets on restart)

## Author

Sherin George
