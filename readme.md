## Task description

Design and implement a Spring Boot application that efficiently extracts personal financial data, and subsequently stores the processed data into a remote PostgreSQL database.

## Prerequisites

Before you begin, ensure you have the following installed on your local machine:
Java JDK: This project was developed with Java 17.0.7
This is a Maven project, so you'll need it for dependency management. If you haven't installed Maven, you can follow the instructions here.

## How to run

Navigate to the class SavingAppApplicationTests.java and run it.

NB! Can take a few minutes send the data to the server.

## Important Notes

- The application processes Excel files and uploads their data to a remote PostgreSQL database. The excel file is an edited sample of my own expenses.
- Currently, the front-end configuration expects the back-end services to run LOCALLY. As a result, to access and interact with the web application effectively, both the front-end and the back-end components should be executed on the same machine.

Please ensure that you run the Spring Boot backend locally when using the web application to avoid connectivity issues.

## Comments

Improvements and Reflections

- Hosting Configuration: The current setup, where the back-end application runs locally while the database is hosted remotely, isn't the most efficient for wider public access. Ideally, both the back-end application and the database should be hosted remotely. This ensures that users can access the service seamlessly without needing to run any local instances.
- File Processing: While the application currently processes Excel files, future iterations could support various file formats, enhancing the flexibility and user-friendliness of the service. Ideally, the application should be retrieving the information directly from the bank.
- Security Considerations: Given that we're dealing with personal expenses, it's vital to consider strengthening the security measures. This includes encrypting sensitive data, implementing rigorous authentication and authorization processes, and regular security audits.
