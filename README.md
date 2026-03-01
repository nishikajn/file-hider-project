🔐 File Hider System

A secure, console-based Java backend application that allows authenticated users to hide and restore files by storing them inside a MySQL database using LONGBLOB.

🚀 Features

🔑 User Registration & Login

📁 Store files securely as LONGBLOB

♻️ Restore files to original location

🗄️ Database-driven file management

🔌 Robust JDBC connectivity

📦 Structured using Maven

🛠️ Tech Stack

Java

MySQL

JDBC

Maven

File I/O, Streams, OOP, Exception Handling

🗄️ Setup

Create a MySQL database.

Run schema.sql.

Create application.properties inside:

src/main/resources

Example:

db.url=jdbc:mysql://localhost:3306/your_database
db.username=your_username
db.password=your_password



▶️ Run
git clone https://github.com/nishikajn/file-hider-project.git

Open in IntelliJ → Configure DB → Run Main.java.

📂 Structure
src/main/java
├── dao/
├── service/
├── model/
├── views/
└── Main.java

🔮 Future Improvements

Password hashing (BCrypt)

AES file encryption

GUI version (JavaFX)

👩‍💻 Author

Nishika Jain
IT Student 
