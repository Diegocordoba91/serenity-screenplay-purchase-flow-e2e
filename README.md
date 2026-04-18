# Serenity BDD — SauceDemo Purchase Flow E2E Test

**Project name:** `serenity-bdd-demo`
**Objective:** Automated E2E test for a complete purchase flow on [saucedemo.com](https://www.saucedemo.com/)
**Test framework:** Serenity BDD with Screenplay Pattern
**Language:** Java 17
**Build tool:** Maven

[![Java](https://img.shields.io/badge/Java-17%2B-ED8B00?style=flat-square&logo=openjdk&logoColor=white)](https://www.oracle.com/java/technologies/downloads/)
[![Maven](https://img.shields.io/badge/Maven-3.8.1%2B-C71A36?style=flat-square&logo=apachemaven&logoColor=white)](https://maven.apache.org/)
[![Serenity BDD](https://img.shields.io/badge/Serenity%20BDD-Screenplay-2E8555?style=flat-square)](https://serenity-bdd.info/)
[![JUnit 5](https://img.shields.io/badge/JUnit-5-25A162?style=flat-square&logo=junit5&logoColor=white)](https://junit.org/junit5/)

---

## 📋 Table of Contents

- [Requirements](#-requirements)
- [Step-by-Step Execution](#-step-by-step-execution)
- [Troubleshooting](#-troubleshooting)
- [Project Structure](#-project-structure)
- [Maven Commands Quick Reference](#-maven-commands-quick-reference)
- [Important Notes](#-important-notes)
- [Contact & Support](#-contact--support)

---

## ✅ Requirements

| # | Requirement | Details |
| :-- | :--- | :--- |
| 1 | **Java Development Kit (JDK) 17+** | Download: <https://www.oracle.com/java/technologies/downloads/> · Verify: `java -version` · *(Java 21 also supported)* |
| 2 | **Apache Maven 3.8.1+** | Download: <https://maven.apache.org/download.cgi> · Verify: `mvn -version` |
| 3 | **Google Chrome Browser** | Required for WebDriver. ChromeDriver is auto-downloaded — no manual setup |
| 4 | **Git** | Download: <https://git-scm.com/> |
| 5 | **IDE *(optional)*** | IntelliJ IDEA Community · VS Code (Java Extension Pack) · Eclipse |

---

## 🚀 Step-by-Step Execution

### Step 1 — Clone the Repository

```bash
git clone https://github.com/YOUR_USERNAME/serenity-bdd-demo.git
cd serenity-bdd-demo
```

> Replace `YOUR_USERNAME` with your GitHub username.

### Step 2 — Verify Prerequisites

From the project directory:

```bash
java -version
mvn -version
```

You should see:

- **Java version:** `17.x.x` or higher *(21.x.x also works)*
- **Maven version:** `3.8.1` or higher

### Step 3 — Download Maven Dependencies

Maven will automatically download every required dependency (Serenity, JUnit 5, AssertJ, …).

```bash
mvn clean install
```

This command:

- Cleans any previous builds (`clean`)
- Downloads all dependencies (`install`)
- Compiles the Java code
- ⏱️ First run may take 2–5 minutes

### Step 4 — Run the Full Test Suite

To run **all** tests and generate the Serenity HTML report:

```bash
mvn verify
```

This command:

- Runs every test file matching `*Test.java` or `*Tests.java`
- Generates a detailed Serenity HTML report
- **Report location:** `target/site/serenity/index.html`

### Step 5 — Run Only the Purchase Flow Test

```bash
mvn test -Dtest=PurchaseFlowTest
```

This will:

- Run only `PurchaseFlowTest.java`
- Open a Chrome browser (non-headless — you'll see it)
- Execute all steps: **login → add products → checkout → confirmation**
- Display test results in the console

### Step 6 — Run a Specific Test Method

```bash
mvn test -Dtest=PurchaseFlowTest#completePurchaseFlowSuccessfully
```

Runs only the `completePurchaseFlowSuccessfully()` method.

### Step 7 — View the Serenity Report

After running `mvn verify`:

1. Navigate to `target/site/serenity/`
2. Open `index.html` in a web browser
3. The report includes:
   - ✅ Test summary (passed / failed)
   - 📝 Detailed steps (Tasks and Questions)
   - 📸 Screenshots (captured on failures or per step)
   - ⏱️ Execution time for each step
   - 🐞 Browser console logs (if errors occurred)

### Step 8 — Run Tests in Headless Mode

By default, Chrome runs with the UI visible. To run headless (no window):

Edit `src/test/resources/serenity.conf`:

```hocon
# Change this line
headless.mode = false
# To this
headless.mode = true
```

Then run tests normally:

```bash
mvn test -Dtest=PurchaseFlowTest
```

### Step 9 — Run Tests with Custom Configuration

The `serenity.conf` file controls:

- 🌐 UI base URL → `ui.base.url`
- 🔐 Test credentials → `ui.standard.user`, `ui.password`
- 🖥️ Chrome driver settings → `webdriver.driver`, `headless.mode`
- 📸 Screenshot behavior → `serenity.take.screenshots`
- 📋 Logging → `serenity.logging`

To change any configuration, edit `src/test/resources/serenity.conf`.

### Step 10 — Clean Build Artifacts

```bash
# Remove all compiled files and build artifacts
mvn clean

# Remove only the target directory
rm -rf target          # Mac / Linux
rmdir /s target        # Windows Command Prompt
```

---

## 🛠️ Troubleshooting

<details>
<summary><strong>❌ "Java not found" or "java version not correct"</strong></summary>

- Ensure **JDK 17+** is installed (not JRE)
- Set `JAVA_HOME` environment variable to the JDK installation path
- Example: `JAVA_HOME=C:\Program Files\Java\jdk-17` (or `jdk-21` if installed)
- After setting `JAVA_HOME`, restart your terminal for changes to take effect

</details>

<details>
<summary><strong>❌ "Maven not found"</strong></summary>

- Ensure **Maven 3.8.1+** is installed
- Add the Maven `bin` folder to the `PATH` environment variable
- Example: `C:\apache-maven-3.8.1\bin`

</details>

<details>
<summary><strong>❌ Tests timeout or hang</strong></summary>

- Increase timeout in `serenity.conf`: `webdriver.wait.for.timeout = 10000`
- Check that `saucedemo.com` is accessible from your network
- Some corporate networks may block the site

</details>

<details>
<summary><strong>❌ "Chrome driver not found"</strong></summary>

- Maven automatically downloads ChromeDriver
- If it fails, run: `mvn webdriver:update-webdriver`
- Manual download: <https://chromedriver.chromium.org/>

</details>

<details>
<summary><strong>❌ "Element not found" errors during test</strong></summary>

- The application structure may have changed
- Verify locators in `src/test/java/com/serenety/pages/` match the current HTML
- Use Chrome DevTools (**F12**) to inspect elements and update selectors

</details>

<details>
<summary><strong>❌ "Cannot read property 'text' of null"</strong></summary>

- A required element wasn't found on the page
- Increase wait times in `serenity.conf`
- Check that all required page elements still use correct selectors

</details>

---

## 📁 Project Structure

```
serenity-bdd-demo/
├── pom.xml                              # Maven configuration (dependencies, plugins)
├── README.md                            # This file (execution instructions)
├── conclusiones.txt                     # Findings and conclusions
├── CLAUDE.md                            # Framework documentation for Claude Code
│
└── src/test/
    ├── java/com/serenety/
    │   ├── actors/
    │   │   └── UiTestBase.java          # Base class for UI tests (lifecycle management)
    │   ├── config/
    │   │   └── ConfigManager.java       # Configuration loader (serenity.conf variables)
    │   ├── pages/
    │   │   ├── LoginPage.java
    │   │   ├── ProductsPage.java
    │   │   ├── CartPage.java
    │   │   ├── CheckoutPage.java
    │   │   ├── CheckoutOverviewPage.java
    │   │   └── OrderConfirmationPage.java
    │   ├── tasks/
    │   │   ├── Login.java
    │   │   ├── NavigateTo.java
    │   │   ├── AddProductToCart.java
    │   │   ├── ViewCart.java
    │   │   ├── ProceedToCheckout.java
    │   │   ├── FillCheckoutForm.java
    │   │   └── FinishPurchase.java
    │   ├── questions/
    │   │   ├── CartItemCount.java
    │   │   ├── OrderConfirmationMessage.java
    │   │   ├── PageTitle.java
    │   │   └── IsProductInCart.java
    │   └── tests/ui/
    │       ├── StageSmokeTest.java      # Basic framework validation
    │       └── PurchaseFlowTest.java    # Main E2E test
    │
    └── resources/
        └── serenity.conf                # Serenity configuration
```

---

## ⚡ Maven Commands Quick Reference

| Command | Description |
| :--- | :--- |
| `mvn clean` | Remove all build artifacts |
| `mvn compile` | Compile Java source code |
| `mvn test` | Run tests |
| `mvn verify` | Run tests + generate reports |
| `mvn install` | Install project to local Maven repository |
| `mvn clean test` | Clean + run tests |
| `mvn clean verify` | Clean + run tests + generate reports |
| `mvn test -Dtest=TestClass` | Run a specific test class |
| `mvn test -Dtest=TestClass#method` | Run a specific test method |
| `mvn -v` | Show Maven version |

---

## 📌 Important Notes

1. **Network requirement** — The tests require internet access to reach <https://www.saucedemo.com/>. Ensure your firewall allows outbound HTTPS connections.
2. **Browser window** — By default, Chrome opens in a visible window. This is intentional — you can watch the test execute in real time. To run headless (no window), edit `serenity.conf`.
3. **Test data** — Test credentials are configured in `serenity.conf`:
   - **Username:** `standard_user`
   - **Password:** `secret_sauce`

   These are dummy credentials provided by the demo site.
4. **Screenshots** — Automatically captured for failed assertions and saved in `target/site/serenity/`. Very useful for debugging.
5. **Concurrent test execution** — By default, tests run sequentially. To run tests in parallel, edit the Surefire plugin configuration in `pom.xml`.
6. **Continuous integration** — These tests can run in CI/CD pipelines (GitHub Actions, Jenkins, GitLab CI, etc.). Use `headless.mode = true` in CI environments where no display is available.

---

## 📞 Contact & Support

For issues or questions about this test automation project:

1. Check the `conclusiones.txt` file for known findings
2. Review the [Troubleshooting](#-troubleshooting) section above
3. Check Serenity BDD documentation: <https://serenity-bdd.info/>
4. Verify your Java/Maven versions match the requirements
5. Ensure `saucedemo.com` is accessible from your location
6. Contact with `Diego Cordoba` email `diegocordobaingeniero@gmail.com`

---

<p align="center">
  <sub>Built with 🎭 Serenity BDD · Screenplay Pattern · Java · Maven</sub>
</p>
