# 🔐 File Hider System

A secure **console-based Java application** that allows users to hide and restore files by storing them safely inside a **MySQL database using LONGBLOB**.

This project demonstrates practical knowledge of **Java backend development, JDBC connectivity, file handling, and database management**.

---

# 📌 Project Overview

The **File Hider System** enables authenticated users to securely store files in a database instead of keeping them directly on the system. It ensures controlled access through user authentication and allows seamless file restoration when required.

### Focus Areas
- Secure file storage
- Database-driven file management
- Backend logic implementation
- Clean modular architecture

---

# 🚀 Key Features

- 🔑 User Registration & Login System  
- 📁 Store files as **LONGBLOB** in MySQL  
- ♻️ Restore files to their original location  
- 🗄️ Database-driven file management  
- 🧭 Interactive menu-driven console interface  
- 🔌 JDBC connectivity with proper resource handling  
- 📦 Maven-based project structure  

---

# 🏗️ Technical Highlights

- Implemented file storage using **PreparedStatement and binary streams**
- Managed large files using **MySQL LONGBLOB**
- Applied **modular architecture (separation of concerns)**
- Implemented **exception handling for database and file operations**
- Followed **standard Maven project structure**

---

# 🛠️ Tech Stack

- **Language:** Java  
- **Database:** MySQL  
- **Connectivity:** JDBC  
- **Build Tool:** Maven  
- **Concepts Used:** File I/O, Streams, OOP, SQL, Exception Handling  

---

# 🗄️ Database Setup

1. Create a MySQL database.
2. Execute the SQL script from `schema.sql`.
3. Configure database credentials in `application.properties`.

---

# ▶️ How to Run

```bash
git clone https://github.com/nishikajn/file-hider-project.git
```

1. Open the project in **IntelliJ IDEA or Eclipse**
2. Update database credentials
3. Run **Main.java**

---

# 📂 Project Structure

```
src/main/java
├── Main.java
├── UserService.java
├── FileService.java
└── DatabaseConnection.java
```

---

# 🔮 Future Improvements

- 🔐 Password hashing using **BCrypt**
- 🔒 File encryption using **AES**
- 🖥️ GUI version using **JavaFX**
- ☁️ Cloud storage integration

---

# 🎯 Learning Outcomes

- Practical implementation of **JDBC**
- Handling **binary data in relational databases**
- Backend application structuring
- Secure file management logic
- Real-world database-driven application design

---

# 👩‍💻 Author

*Nishika Jain*  
