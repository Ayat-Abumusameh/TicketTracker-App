# Ticket Tracker System

A robust Java-based ticket management system built using Java SE, JPA (EclipseLink), and MySQL. This project follows professional workflow standards, including containerization via Docker and a clean repository structure.

## Tech Stack
- **Language:** Java SE
- **Persistence:** JPA / EclipseLink
- **Database:** MySQL
- **Containerization:** Docker

## Project Structure
- `src/` - Core Java source code (Entity models, DAOs, and main application logic).
- `docs/` - Technical notes and screenshots demonstrating application execution and database operations.
- `Dockerfile` - Container configuration file for building and running the project in an isolated environment.
- `.gitignore` & `.dockerignore` - Exclusion rules for clean repository and build management.

## How to Get Started (Cloning the Repository)
To run this project on any local machine without setting up local Java environments:

1. Clone the repository:
   git clone https://github.com/AyatAbumusameh/TicketTracker-App.git

2. Navigate into the project directory:
   cd TicketTracker-App

## How to Build and Run Using Docker
1. Ensure Docker Desktop is installed and running on your machine.

2. Build the Docker image:
   docker build -t ticket-tracker-app .

3. Run the container:
   docker run --rm ticket-tracker-app

## Configuration Notes
Make sure your local MySQL server is running and the database ticket_db is created. Update your database credentials in src/META-INF/persistence.xml if necessary.