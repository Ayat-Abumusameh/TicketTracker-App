# Ticket Tracker System

A robust Java-based ticket management system built using Java SE, JPA (EclipseLink), and MySQL. This project follows professional workflow standards, including containerization via Docker and a clean repository structure.

## Tech Stack
- **Language:** Java SE
- **Persistence:** JPA / EclipseLink
- **Database:** MySQL
- **Containerization:** Docker

## How to Build and Run Using Docker
1. Ensure Docker is installed and running on your machine.
2. Build the Docker image:
   ```bash
   docker build -t ticket-tracker-app .

Run the container:
    docker run --rm ticket-tracker-app

Configuration Notes
Make sure your local MySQL server is running and the database ticket_db is created. Update your database credentials in persistence.xml if necessary.

