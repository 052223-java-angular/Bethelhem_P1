# P1 - ParkVenture: Discover and Book Exciting Park Experiences

## Introduction

This is a Java-based full stack park events booking web application.A user can explore and register for exciting events happening in various parks, so that they can plan and participate in memorable outdoor experiences. The application will be primarily built using Spring boot and Angular frame works and will utilize a PostgreSQL database to store tasks and user information.

## User Stories

- **As a user**,I want to be able to register an account.
- **As a user**,I want to be able to log in to my account.
- **As a user**, I can browse a list of parks and view their descriptions and locations. 
- **As a user**, I can select a specific park and see the upcoming events happening in that park.. 
- **As a user**, I can view event details such as the event name, date, description, capacity, and any additional information provided. 
- **As a user**, I can select an event and provide the number of attendees I plan to bring. 
- **As a user**, I can view a summary of my booked events and easily access event details, including date, location, and any instructions provided by the park 
- **As a user**, I can review my registration details and proceed to make a secure online payment for the event.. 
- **As a user**, I can cancel or modify my event registration if necessary, within a reasonable timeframe. 
- **As a user**,  I can provide feedback and reviews for events I have attended, sharing my experience and recommendations for other users. 
- **As a user**, I can submit the event registration form, which includes my contact information (name, email, phone number)


## MVP (Minimum Viable Product)

- User registration and login
- Park and Event Listing:Display a list of parks and their basic details (name, location, description).
- Event Details:Allow users to view event details (description, capacity, date, etc.)
- Registration of events:Provide a registration form for users to enter their details and the number of attendees
- Validate registration information and event availability.  
- Provide a user dashboard where users can view their booked events and upcoming events.
- Allow users to cancel or modify their event registrations.
- Implement a secure payment 



## Stretch Goals

- Show upcoming events for each park, including event names and dates.
- Send notifications to users for booking confirmations, event reminders, and updates.

## Tech Stacks

- **Angular**: Frame work to build the user interface of the application.
- **SpringBoot**:Frame work to develop the backend of the application.
- **Java**: The main programming language used for building the application.
- **PostgreSQL**: Used as the database to store user, product, and order data.
- **Maven or Gradle**: Used for managing project dependencies.
- **JUnit**: A testing framework for Java applications, used to ensure our code works as expected.
- **Log4j**: A logging utility for debugging purposes.
- **JDBC (Java Database Connectivity)**: An API for connecting and executing queries on the database.
- **BCrypt**: A Java library for hashing and checking passwords for security.
- **JUnit, Mockito, and PowerMock**: Used for unit and integration testing.
- **Git and GitHub**: Used for version control.

## Requirements

- **Clean Codebase**: All code should be clean and well-documented. The repository should not include any unnecessary files or folders such as the `target/`, `.DS_Store`, etc. All files and directories should be appropriately named and organized.

- **Database Design**: The database should be designed following the principles of the 3rd Normal Form (3NF) to ensure data integrity and efficiency. An Entity Relationship Diagram (ERD) should be included in the documentation.

- **Secure**: All sensitive user data such as passwords must be securely hashed before storing it in the database. The application should not display any sensitive information in error messages.

- **Error Handling**: The application should handle potential errors gracefully and provide clear and helpful error messages to the users.

- **Testing**: The application should have a high test coverage. Unit tests and integration tests should be implemented using JUnit, Mockito, and PowerMock.

- **Version Control**: The application should be developed using a version control system, preferably Git, with regular commits denoting progress.

- **Documentation**: The repository should include a README file with clear instructions on how to run the application. Code should be well-commented to allow for easy understanding and maintenance.

- **Scalable**: The design of the application should be scalable, allowing for easy addition of new features or modifications in the future.

##ERD diagram
![image](https://github.com/052223-java-angular/Bethelhem_P1-Back_End/assets/98676637/4b9660b7-aa64-40f6-971e-90b77ef87422)

