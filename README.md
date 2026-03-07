🔐 File Hider System

A secure console-based Java application that allows users to hide and restore files by storing them safely inside a MySQL database using LONGBLOB.
This project demonstrates practical knowledge of Java backend development, JDBC connectivity, file handling, and database management.

📌 Project Overview

The File Hider System enables authenticated users to securely store files in a database instead of keeping them directly on the system.
It provides controlled access through user authentication and allows easy restoration of stored files.

Focus Areas

Secure file storage

Database-driven file management

Backend logic implementation

Clean modular architecture

🚀 Key Features

🔑 User Registration & Login system

📁 Store files as LONGBLOB in MySQL

♻️ Restore files to original location

🗄️ Database-driven file management

🧭 Interactive menu-driven console interface

🔌 JDBC connectivity with proper resource handling

📦 Maven-based project structure

🏗️ Technical Highlights

Implemented file storage using PreparedStatement and binary streams

Managed large files using MySQL LONGBLOB

Applied modular architecture (separation of concerns)

Implemented exception handling for database and file operations

Organized project using standard Maven structure

🛠️ Tech Stack

Language: Java

Database: MySQL

Connectivity: JDBC

Build Tool: Maven

Concepts: File I/O, Streams, OOP, SQL, Exception Handling

🗄️ Database Setup

Create a MySQL database.

Run the SQL script provided in schema.sql.

Configure database credentials in application.properties.

▶️ How to Run
git clone https://github.com/nishikajn/file-hider-project.git

Open the project in IntelliJ IDEA or Eclipse

Update database credentials

Run Main.java

📂 Project Structure
src/main/java
├── Main.java
├── UserService.java
├── FileService.java
└── DatabaseConnection.java
🔮 Future Improvements

🔐 Password hashing using BCrypt

🔒 File encryption using AES

🖥️ GUI version using JavaFX

☁️ Cloud storage integration

🎯 Learning Outcomes

Practical implementation of JDBC

Handling binary data in relational databases

Backend application structuring

Secure file management logic

Database-driven application development

👩‍💻 Author

Nishika Jain
