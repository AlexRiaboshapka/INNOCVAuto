package config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;
import logger.CustomLogger;

import java.util.logging.Level;

import static global.Global.globalModeDebug;

public class RunnerConfig {
    @Step
    public void setUpConfig(String projectId, String browser, String browserVersion) {
        Configuration.timeout = 20000;
        Configuration.downloadsFolder = "target/downloads";
        Configuration.reportsFolder = "target/screenshots";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "Chrome";
        Configuration.browserVersion = "109";
        Configuration.pageLoadTimeout = 20000;
        if (!globalModeDebug) {
            Configuration.remote = "http://localhost:4444/wd/hub";
            Configuration.browserCapabilities.setCapability("enableVNC", false);
            Configuration.browserCapabilities.setCapability("enableVideo", false);
        }
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));

        //SelenideLogger.addListener("AllureSelenide", new AllureSelenide().enableLogs(LogType.BROWSER, Level.ALL));
        CustomLogger.logger.info("ok");
    }
}
