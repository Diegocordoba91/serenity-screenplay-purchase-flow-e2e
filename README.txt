================================================================================
SERENITY BDD - SAUCEDEMO PURCHASE FLOW E2E TEST
================================================================================

PROJECT NAME: serenity-bdd-demo
OBJECTIVE: Automated E2E test (Exercise 1) for a complete purchase flow on saucedemo.com
TEST FRAMEWORK: Serenity BDD with Screenplay Pattern
LANGUAGE: Java 17
BUILD TOOL: Maven

================================================================================
REQUIREMENTS
================================================================================

1. Java Development Kit (JDK) 17 or higher
   - Download from: https://www.oracle.com/java/technologies/downloads/
   - Verify installation: java -version
   - Note: Java 21 is also supported

2. Apache Maven 3.8.1 or higher
   - Download from: https://maven.apache.org/download.cgi
   - Verify installation: mvn -version

3. Google Chrome Browser (required for WebDriver)
   - ChromeDriver is auto-downloaded by Maven, no manual setup needed

4. Git (for cloning the repository)
   - Download from: https://git-scm.com/

5. IDE (Optional but recommended):
   - IntelliJ IDEA Community Edition (free)
   - Visual Studio Code with Java extensions
   - Eclipse IDE

================================================================================
STEP-BY-STEP EXECUTION INSTRUCTIONS
================================================================================

STEP 1: Clone the Repository
--------------------------------
Open your terminal/command prompt and run:

  git clone https://github.com/YOUR_USERNAME/serenity-bdd-demo.git
  cd serenity-bdd-demo

Replace YOUR_USERNAME with your GitHub username.


STEP 2: Verify Prerequisites
--------------------------------
In the project directory, verify Java and Maven are installed:

  java -version
  mvn -version

Output should show:
  - Java version: 17.x.x or higher (21.x.x also works)
  - Maven version: 3.8.1 or higher


STEP 3: Download Maven Dependencies
--------------------------------
Maven will automatically download all required dependencies (Serenity, JUnit 5, AssertJ, etc.).

Run:
  mvn clean install

This command:
  - Cleans any previous builds (clean)
  - Downloads all dependencies (install)
  - Compiles the Java code
  - First time may take 2-5 minutes as it downloads dependencies

STEP 4: Run the Full Test Suite
--------------------------------
To run all tests and generate the Serenity HTML report:

  mvn verify

This command:
  - Runs all test files (*Test.java and *Tests.java)
  - Generates a detailed Serenity HTML report
  - Report location: target/site/serenity/index.html


STEP 5: Run Only the Purchase Flow Test
--------------------------------
To run just the purchase flow E2E test:

  mvn test -Dtest=PurchaseFlowTest

This will:
  - Run only PurchaseFlowTest.java
  - Open a Chrome browser (non-headless, you'll see it)
  - Execute all steps: login → add products → checkout → confirmation
  - Display test results in the console


STEP 6: Run a Specific Test Method
--------------------------------
To run only one test method within the test class:

  mvn test -Dtest=PurchaseFlowTest#completePurchaseFlowSuccessfully

This runs only the completePurchaseFlowSuccessfully() test method.


STEP 7: View the Serenity Report
--------------------------------
After running tests with 'mvn verify', open the report:

  1. Navigate to: target/site/serenity/
  2. Open the file: index.html in a web browser
  3. The report includes:
     - Test summary (passed/failed)
     - Detailed test steps (Tasks and Questions)
     - Screenshots (captured on failures or for each step)
     - Execution time for each step
     - Browser console logs (if errors occurred)


STEP 8: Run Tests in Headless Mode
--------------------------------
By default, Chrome runs with the UI visible. To run in headless mode (no browser window):

Edit src/test/resources/serenity.conf:
  Change:   headless.mode = false
  To:       headless.mode = true

Then run tests normally:
  mvn test -Dtest=PurchaseFlowTest


STEP 9: Run Tests with Custom Configuration
--------------------------------
The serenity.conf file controls:
  - UI base URL: ui.base.url
  - Test credentials: ui.standard.user, ui.password
  - Chrome driver settings: webdriver.driver, headless.mode
  - Screenshot behavior: serenity.take.screenshots
  - Logging: serenity.logging

To change any configuration, edit src/test/resources/serenity.conf


STEP 10: Clean Build Artifacts
--------------------------------
To remove all compiled files and build artifacts:

  mvn clean

To remove only the target directory:

  rm -rf target  (Mac/Linux)
  rmdir /s target  (Windows Command Prompt)


================================================================================
TROUBLESHOOTING
================================================================================

Issue: "Java not found" or "java version not correct"
Solution:
  - Ensure JDK 17+ is installed (not JRE)
  - Set JAVA_HOME environment variable to JDK installation path
  - Example: JAVA_HOME=C:\Program Files\Java\jdk-17 (or jdk-21 if installed)
  - After setting JAVA_HOME, restart your terminal for changes to take effect

Issue: "Maven not found"
Solution:
  - Ensure Maven 3.8.1+ is installed
  - Add Maven bin folder to PATH environment variable
  - Example: C:\apache-maven-3.8.1\bin

Issue: Tests timeout or hang
Solution:
  - Increase timeout in serenity.conf: webdriver.wait.for.timeout = 10000
  - Check if saucedemo.com is accessible from your network
  - Some corporate networks may block the site

Issue: "Chrome driver not found"
Solution:
  - Maven automatically downloads ChromeDriver
  - If it fails, run: mvn webdriver:update-webdriver
  - Manual download: https://chromedriver.chromium.org/

Issue: "Element not found" errors during test
Solution:
  - The application structure may have changed
  - Verify locators in src/test/java/com/serenety/pages/ match current HTML
  - Use Chrome DevTools (F12) to inspect elements and update selectors

Issue: "Cannot read property 'text' of null"
Solution:
  - A required element wasn't found on the page
  - Increase wait times in serenity.conf
  - Check that all required page elements are still using correct selectors


================================================================================
PROJECT STRUCTURE
================================================================================

serenity-bdd-demo/
├── pom.xml                          Maven configuration (dependencies, plugins)
├── README.txt                       This file (execution instructions)
├── conclusiones.txt                 Findings and conclusions
├── CLAUDE.md                        Framework documentation for Claude Code
│
└── src/test/
    ├── java/com/serenety/
    │   ├── actors/
    │   │   └── UiTestBase.java      Base class for UI tests (lifecycle management)
    │   ├── config/
    │   │   └── ConfigManager.java   Configuration loader (serenity.conf variables)
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
    │       ├── StageSmokeTest.java   (Basic framework validation)
    │       └── PurchaseFlowTest.java (Main E2E test)
    │
    └── resources/
        └── serenity.conf            Serenity configuration


================================================================================
MAVEN COMMANDS QUICK REFERENCE
================================================================================

mvn clean                      Remove all build artifacts
mvn compile                    Compile Java source code
mvn test                       Run tests
mvn verify                     Run tests + generate reports
mvn install                    Install project to local Maven repository
mvn clean test                 Clean + run tests
mvn clean verify               Clean + run tests + generate reports
mvn test -Dtest=TestClass     Run specific test class
mvn test -Dtest=TestClass#method  Run specific test method
mvn -v                         Show Maven version


================================================================================
IMPORTANT NOTES
================================================================================

1. NETWORK REQUIREMENT:
   The tests require internet access to reach https://www.saucedemo.com/
   Ensure your firewall allows outbound HTTPS connections.

2. BROWSER WINDOW:
   By default, Chrome opens in a visible window. This is intentional—you can watch
   the test execute in real-time. To run headless (no window), edit serenity.conf.

3. TEST DATA:
   Test credentials are configured in serenity.conf:
   - Username: standard_user
   - Password: secret_sauce
   These are dummy credentials provided by the demo site.

4. SCREENSHOTS:
   Screenshots are automatically captured for failed assertions and saved in:
   target/site/serenity/
   Very useful for debugging failed tests.

5. CONCURRENT TEST EXECUTION:
   By default, tests run sequentially. To run tests in parallel:
   Edit pom.xml in the surefire plugin configuration.

6. CONTINUOUS INTEGRATION:
   These tests can run in CI/CD pipelines (GitHub Actions, Jenkins, GitLab CI, etc.).
   Use headless.mode = true for CI environments where no display is available.


================================================================================
CONTACT & SUPPORT
================================================================================

For issues or questions about this test automation project:

1. Check the conclusiones.txt file for known findings
2. Review the troubleshooting section above
3. Check Serenity BDD documentation: https://serenity-bdd.info/
4. Verify your Java/Maven versions match requirements
5. Ensure saucedemo.com is accessible from your location


================================================================================
END OF README
================================================================================
