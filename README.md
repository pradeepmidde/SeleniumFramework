# Selenium Java Automation Framework

![Selenium Tests](https://github.com/pradeepmidde/SeleniumFramework/actions/workflows/selenium-tests.yml/badge.svg)

A production-ready Selenium test automation framework built with Java, TestNG and Maven — showcasing real-world QA engineering skills.

## Tech Stack

| Tool | Purpose |
|---|---|
| Selenium 4 | Browser automation |
| TestNG 7 | Test runner and assertions |
| Maven | Build and dependency management |
| WebDriverManager | Auto ChromeDriver management |
| ExtentReports 5 | Beautiful HTML test reports |
| Apache POI | Excel data-driven testing |
| Java Faker | Dynamic random test data |
| GitHub Actions | CI/CD pipeline |

## Framework Architecture## Test Coverage

| Test Suite | Tests | Type |
|---|---|---|
| LoginTest | 3 | Functional |
| RegisterTest | 1 | Functional |
| DataDrivenLoginTest | 5 | Data Driven |
| FakerRegistrationTest | 1 | Dynamic Data |
| **Total** | **10** | **All Passing** |

## Key Features

- Page Object Model (POM) design pattern
- ThreadLocal WebDriver for parallel execution
- Data-driven testing with Excel (Apache POI)
- Dynamic test data with Java Faker
- Automatic HTML reports with ExtentReports
- Screenshot capture on test failure
- CI/CD pipeline with GitHub Actions
- Headless Chrome execution in CI environment

## How to Run

```bash
# Clone
git clone https://github.com/pradeepmidde/SeleniumFramework.git
cd SeleniumFramework

# Run all tests
mvn test

# Run headless
mvn test -Dheadless=true
```

## Test Report

ExtentReports HTML report auto-generated at `reports/ExtentReport.html`
Download from GitHub Actions → Artifacts after each pipeline run.

## Author

**Pradeep** — QA Automation Engineer

[![LinkedIn](https://img.shields.io/badge/LinkedIn-Connect-blue)](https://linkedin.com/in/YOUR_LINKEDIN)
[![GitHub](https://img.shields.io/badge/GitHub-Follow-black)](https://github.com/pradeepmidde)