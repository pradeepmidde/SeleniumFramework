# 🚀 Selenium Java Automation Framework

![Selenium Tests](https://github.com/pradeepmidde/SeleniumFramework/actions/workflows/selenium-tests.yml/badge.svg)

A production-ready Selenium Test Automation Framework built using **Java**, **Selenium WebDriver**, **TestNG**, and **Maven**. This framework demonstrates real-world QA automation practices including Page Object Model (POM), Data-Driven Testing, Dynamic Test Data Generation, Extent Reports, and GitHub Actions CI/CD.

---

# 📌 Features

- ✅ Page Object Model (POM) Design Pattern
- ✅ Data-Driven Testing using Excel (Apache POI)
- ✅ Dynamic Test Data Generation using Java Faker
- ✅ Selenium WebDriver Automation
- ✅ TestNG Test Execution
- ✅ ExtentReports HTML Reporting
- ✅ Maven Project Structure
- ✅ WebDriverManager Integration
- ✅ GitHub Actions CI/CD
- ✅ Reusable Utilities
- ✅ Cross Browser Ready
- ✅ Easy Maintenance

---

# 🛠️ Tech Stack

| Tool | Purpose |
|------|----------|
| Java | Programming Language |
| Selenium WebDriver | Browser Automation |
| TestNG | Test Framework |
| Maven | Build Management |
| WebDriverManager | Browser Driver Management |
| Apache POI | Excel Data-Driven Testing |
| Java Faker | Dynamic Test Data |
| ExtentReports | HTML Reporting |
| Git | Version Control |
| GitHub | Repository Hosting |
| GitHub Actions | Continuous Integration |

---

# 📂 Project Structure

```text
SeleniumFramework
│
├── .github
│   └── workflows
│       └── selenium-tests.yml
│
├── reports
│   └── ExtentReport.html
│
├── src
│   ├── main
│   │   └── java
│   │       ├── config
│   │       ├── pages
│   │       └── utils
│   │
│   └── test
│       ├── java
│       │   ├── base
│       │   └── tests
│       │
│       └── resources
│           ├── config.properties
│           ├── LoginData.xlsx
│           └── testng.xml
│
├── pom.xml
├── README.md
└── .gitignore
```

---

# ✅ Test Coverage

| Test Class | Description |
|------------|-------------|
| LoginTest | Valid & Invalid Login Testing |
| RegisterTest | User Registration Testing |
| DataDrivenLoginTest | Excel Data Driven Login Testing |
| FakerRegistrationTest | Dynamic Registration using Java Faker |

### Test Summary

- Total Tests : **10**
- Passed : **10**
- Failed : **0**
- Skipped : **0**

---

# ▶️ Execute the Project

## Clone Repository

```bash
git clone https://github.com/pradeepmidde/SeleniumFramework.git
```

## Go to Project

```bash
cd SeleniumFramework
```

## Run All Tests

```bash
mvn clean test
```

## Run TestNG Suite

```bash
mvn test -DsuiteXmlFile=testng.xml
```

## Run in Headless Mode

```bash
mvn test -Dheadless=true
```

---

# 📊 Test Reports

After execution, Extent Report is generated automatically.

Location:

```text
reports/ExtentReport.html
```

Open the HTML file in any browser to view the execution report.

---

# 🔄 Continuous Integration

GitHub Actions automatically executes the framework whenever code is pushed to the **main** branch.

Pipeline includes:

- Maven Build
- Selenium Test Execution
- HTML Report Generation
- CI Status Badge

---

# 👨‍💻 Author

## Pradeep Midde

QA Automation Engineer

📧 Email  
pradeepmidde6@gmail.com

🔗 LinkedIn  
https://www.linkedin.com/in/pradeepmidde/

💻 GitHub  
https://github.com/pradeepmidde

---

# ⭐ Support

If you found this project useful, please consider giving it a ⭐ on GitHub.

---

## 📜 License

This project is created for learning, portfolio, and interview demonstration purposes.

---

### Happy Testing 🚀