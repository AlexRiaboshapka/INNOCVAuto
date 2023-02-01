# Java Test the start
Used Technologies:
- Java 
- Maven
- TestNG
- Selenide
- Allure report
- Selenoid (Selenium Grid)
- Google Sheets API for Data Driven Testing
- Gitgub Actions for execution
- Gitgub Pages to store the results
Project execution:
# For local execution you need to:
- Clone the project
- Install Java 17
- Install Maven
- Optional install Allure: https://docs.qameta.io/allure/#_installing_a_commandline
- Update set globalModeDebug = true in src/main/java/global/Global.java
# Local execution in the Selenoid Grid:
- Perform the steps for local execution
- Install Docker
- Install Selenoid: https://aerokube.com/selenoid/latest/
- Run Selenoid: ./cm selenoid start
- Run Selenoid UI: ./cm selenoid-ui start
- Run tests: mvn clean test
- # Remote execution in Github Actions