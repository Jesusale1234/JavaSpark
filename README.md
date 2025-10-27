# 🛍️ Spark Collectibles API

A RESTful API developed in **Java** using the **Spark Framework**, designed to manage users for an online collectibles store.
This project is part of Rafael’s professional training as a Systems Engineer and serves as the foundation for an e-commerce platform that allows collectors to sell their items online.

---

# 🚀 Project Description
The goal of this project is to provide a web service that enables the management of users and, in future iterations, collectible items as well.
It is built with a lightweight architecture using the Spark Framework, which allows for quick development and deployment of REST APIs.

The current version of the API includes the following features:

Retrieve the list of all users
Retrieve a user by ID
Create, update, and delete users
Validate whether a user exists (OPTIONS method)

---

## 🧠 Technologies Used

 - Java 17 
 - Maven
 - Spark Framework 2.9.4
 - Gson 2.10.1
 - Logback 1.2.11 

## ⚙️ Project Structure
```
spark-collectibles-api/
├── pom.xml # Maven Configuration with dependencies
├── src/
│ └── main/
│ └── java/
│ └── com/
│ └── collectibles/
│ └── store/
│ └── App.java # Main API Code
├── docs/
│ ├── decisions.md # Decisions during the development phase
├── README.md # Detailed instructions on how to execute the program
└── .gitignore
```
---

## 💻 Installation and Running the Application

Follow these steps to set up and run the API locally on your machine.

### 1️⃣ Prerequisites

Before running the project, make sure you have installed:

- [Java JDK 17 or higher](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Apache Maven 3.8+](https://maven.apache.org/)
- (Optional) [Visual Studio Code](https://code.visualstudio.com/) with:
  - **Extension Pack for Java**
  - **Maven for Java**

### 2️⃣ Clone the Repository

```bash
git clone https://github.com/Jesusale1234/JavaSpark.git
cd spark-collectibles-api
```
### 3️⃣ Build the Project
Use Maven to clean any previous files and build the application:

```bash
mvn clean package
```

### 4️⃣ Run the API
Execute the generated JAR file with the following command on the command line or execute App.java in Visual Studio Code:

``` bash
java -cp target/spark-collectibles-api-1.0-SNAPSHOT.jar com.collectibles.store.App
```
Once it starts, you should see logs showing that Spark has initialized.
The server will be available at:
👉 http://localhost:4567

### 5️⃣ Test the API
You can test the endpoints using Postman, Thunder Client, or curl.
Example – GET /users:

```bash
curl http://localhost:4567/users
```
---

## 🧩 Available Endpoints

| Method | URL               | Description                       |
| ------ | ----------------- | ----------------------------------|
| POST   | `/users/:id`      | Create a new order                |
| GET    | `/users`          | Retrieve the list of all users    |
| GET    | `/users/:id`      | Retrieve a specific user by ID    |
| PUT    | `/users/:id`      | Update an existing user           |
| DELETE | `/users/:id`      | Delete a user by ID               |
|OPTIONS | `/users/:id` | Check whether a user with the given ID exists |

---

### 🔍 Example JSON Body for `POST` and `PUT`

```json
{
  "id": 1,
  "name": "Rafael García",
  "email": "rafael.garcia@test.com"
}
```
---

### 📋 Example cURL Commands
Create a new user:

```bash
curl -X POST http://localhost:4567/users/1 \
  -H "Content-Type: application/json" \
  -d '{"id":1,"name":"Rafael","email":"rafael@test.com"}'
```
Retrieve all users:

```bash
curl http://localhost:4567/users
```
Retrieve a specific user:

```bash
curl http://localhost:4567/users/1
```

Update an existing user:

```bash
curl -X PUT http://localhost:4567/users/1 \
  -H "Content-Type: application/json" \
  -d '{"id":1,"name":"Rafael García","email":"rafael.garcia@test.com"}'
```

Check if a user exists:

```bash
curl -X OPTIONS http://localhost:4567/users/1
```

Delete a user:

```bash
curl -X DELETE http://localhost:4567/users/1
```
---

### 🚧 Next Steps
1. Improve testing coverage.	Write unit and integration tests for main routes and logic.
2. Create views and templates that implement the site's functionality
3. Implement a web form to manage item offers
4. Implement filters for the items
5. Develop the logic for real-time price updates

---

## 👥 Credits

**Developed by:** Jesús Alejandro Martínez García - Software Developer. 

---

## License

This project is intended for educational and demonstration purposes, and it is open-source.
You may use or modify this project for personal study or non‑commercial purposes.  
