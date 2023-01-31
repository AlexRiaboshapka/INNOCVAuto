package pages.innocv.actions;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import logger.CustomLogger;
import pages.innocv.locators.ContactsPageLocators;

import java.util.List;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$$;
import static helper.CommonSteps.getAndAttachScreenshot;

public class ContactsPageActions extends ContactsPageLocators {

    @Step
    public String getContactPhoneNumber() {
        String text = contactPhoneElement.getText();
        CustomLogger.logger.info("Contact phone number: " + text);
        getAndAttachScreenshot();
        return text;
    }

    @Step
    public void goToLegalPage() {
        legalPageLink.click();
    }

    @Step
    public int countFaradayText() {
        mainImage.shouldBe(exist);
        List<SelenideElement> amountOfFaradayText = $$(byXpath(paragraphWithTextFaraday));
        CustomLogger.logger.info(amountOfFaradayText.size());
        CustomLogger.logger.info(amountOfFaradayText);
        return amountOfFaradayText.size();

    }
}
