# 🧭 SDLC — Software Development Lifecycle (Java)

This project is a modular Java workspace for exploring multiple stages of the software development lifecycle:

- Object-Oriented Design
- Algorithmic problem-solving
- REST API testing (Dropbox)
- UI automation testing (Job Title Management)

---

> ⚠️ **Important Notice:**  
> Each module contains its own `Main.java` or test suite. To avoid execution conflicts and classpath issues, please **checkout the appropriate Git branch** before working with a specific module:
>
> - `Java_tasks`
> - `OOP`
> - `WebAPI`
> - `WebUI`

---

## 📂 Project Structure

```
sdlc/
└── src/
└── main/
└── java/
└── com/
└── BrovkoD/
└── modules/
├── algorithms/
│ ├── Main.java
│ └── tasks/
│ ├── Task1.java
│ ├── Task2.java
│ ├── Task3.java
│ ├── Task4.java
│ ├── Task5.java
│ └── extra/
│ ├── ExtraTask1.java
│ └── ExtraTask2.java
├── oop/
│ ├── Main.java
│ └── storage/
│ ├── DataStorage.java
│ ├── Removable.java
│ ├── local/
│ │ ├── Client.java
│ │ └── LocalDataStorage.java
│ └── web/
│ ├── Server.java
│ └── WebDataStorage.java
├── testWebApi/
│ └── test/
│ ├── java/
│ │ ├── RunCucumberTest.java
│ │ └── api/
│ │ ├── GenericAPI.java
│ │ └── dropbox/
│ │ ├── DropboxAPI.java
│ │ └── DropboxFileManagementTest.java
│ └── resources/
│ ├── config.properties
│ └── cucumber/
│ └── DropboxFileManagement.feature
└── testWebUi/
└── test/
├── java/
│ ├── hellocucumber/
│ │ └── JobTitleManagementTest.java
│ └── pages/
│ ├── AddJobTitlePage.java
│ ├── AdminPage.java
│ ├── DeletePopup.java
│ ├── HomePage.java
│ ├── JobTitlesPage.java
│ ├── LoginPage.java
│ └── Page.java
└── resources/
└── hellocucumber/
└── SeleniumHomeTask.feature
```

---

## 🧩 Modules

### 🧠 `algorithms/`

Implements real algorithmic tasks:

- Extract integers from a mixed list
- Identify the first non-repeating letter
- Calculate a number’s digital root
- Count integer pairs with a target sum (loop & streams)
- Sort formatted names

📄 Entry: `Main.java`

---

### 🧱 `oop/`

Demonstrates OOP via a mock client-server structure:

- `Client` (local storage interaction)
- `Server` (remote storage interaction)

📄 Entry: `Main.java`

---

### 🌐 `testWebApi/` — Dropbox API Testing

- Cucumber-based test suite targeting **Dropbox REST API**
- Uses:
  - `RunCucumberTest.java` as a JUnit test runner
  - Allure plugin for reporting
- Feature files and step definitions live in the `api/` package

📄 Entry: `RunCucumberTest.java`

---

### 🖱 `testWebUi/` — Job Title Management Automation

- Automates a web-based admin interface using **Selenium**
- Uses **Page Object Model (POM)** structure:
  - `LoginPage`, `HomePage`, `AdminPage`, `JobTitlesPage`, etc.
- Tests written in **Cucumber step definitions**
- Tested flow: login → navigate → add job title → delete

📄 Entry: `JobTitleManagementTest.java`  
🧪 WebDriver: `FirefoxDriver` used with implicit wait

---

## 📦 Tech Stack

- Java 17+
- JUnit 5
- Cucumber
- Maven
- Selenium WebDriver
- Allure Reports
