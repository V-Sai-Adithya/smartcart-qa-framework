# SmartCart QA Automation Framework

This project is a modular test automation framework designed to validate core e-commerce flows on [AutomationExercise](https://automationexercise.com/). It is built using industry-standard tools and patterns including Selenium WebDriver, TestNG, Cucumber (BDD), and the Page Object Model (POM).

---

## ✅ Features Covered

- User Login
- Product Search
- Add to Cart (Planned)
- Contact Us Form (Planned)
- End-to-End Checkout Flow (Planned)

---

## 🧰 Tech Stack

| Layer | Tool |
|-------|------|
| Language | Java |
| Automation | Selenium WebDriver |
| Test Runner | TestNG |
| BDD Layer | Cucumber |
| Build Tool | Maven |
| Design Pattern | Page Object Model (POM) |
| CI/CD Ready | GitHub Integration (Git-based structure) |

---

## 📂 Project Structure

smartcart-qa-framework/
├── src/
│ ├── main/
│ │ └── java/ # Page classes (POM)
│ ├── test/
│ │ └── java/
│ │ ├── stepdefs/ # Cucumber step definitions
│ │ ├── runners/ # TestNG+Cucumber runners
│ │ └── tests/ # Additional test classes (if any)
│ └── resources/
│ └── features/ # Cucumber feature files
├── pom.xml
└── README.md

yaml
Copy
Edit

---

## 🚀 How to Run Tests

Make sure you have **Maven** and **Java 11+** installed.

```bash
# Clean project and execute tests
mvn clean test
You can also run individual tests or tags using TestNG or Cucumber options.

📝 Sample Cucumber Scenario
gherkin
Copy
Edit
Feature: Login functionality

  Scenario: Login with valid credentials
    Given user is on the login page
    When user logs in with "testuser@example.com" and "password123"
    Then user should see the logged-in home page
📌 Future Enhancements
Add detailed ExtentReports or Allure for reporting

Expand feature coverage (Register, Checkout, Order History)

Integrate with GitHub Actions or Jenkins for CI/CD

Add support for cross-browser execution

👤 Author
Vangapally Sai Adithya
Automation Test Engineer | Java | Selenium | API | BDD
🔗 LinkedIn
🔗 GitHub

⚠️ This is a personal project built for educational and demo purposes. Not affiliated with AutomationExercise.com.

yaml
Copy
Edit

---

Would you like:
- 📸 Badges added (build, tools, license)?
- 🎨 A light logo/banner for the repo?
- 🧪 A test report template (HTML/Cucumber)?

Let me know — your repo is nearly **portfolio-perfect**!