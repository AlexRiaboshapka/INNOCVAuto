package pages.innocv.actions;

import io.qameta.allure.Step;
import logger.CustomLogger;
import pages.innocv.locators.LegalPageLocators;

import static helper.CommonSteps.getAndAttachScreenshot;

public class LegalPageActions extends LegalPageLocators {
    @Step
    public String getLegalPageContactPhoneNumber() {
        String text = legalPageContactPhoneText.getText();
        CustomLogger.logger.info("Legal page contact phone number: " + text);
        getAndAttachScreenshot();
        return text;
    }
}
