package pages.innocv.actions;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import logger.CustomLogger;
import org.testng.asserts.SoftAssert;
import pages.innocv.locators.ContactsPageLocators;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
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
        contactsInfo.shouldBe(exist);
        $(byXpath(newsDate)).shouldBe(exist);
        List<SelenideElement> amountOfFaradayText = $$(byXpath(paragraphWithTextFaraday));
        CustomLogger.logger.info(amountOfFaradayText.size());
        CustomLogger.logger.info(amountOfFaradayText);
        getAndAttachScreenshot();
        return amountOfFaradayText.size();

    }

    @Step
    public void getTheNewsDatesAndVerifyIfUpToDate() {
        mainImage.shouldBe(exist);
        $(byXpath(newsDate)).shouldBe(exist);
        SoftAssert softassert = new SoftAssert();
        List<SelenideElement> newsDatesElements = $$(byXpath(newsDate));
        for (SelenideElement newsDateElement : newsDatesElements) {
            String date = newsDateElement.getText();
            if (ifDateIsUpToDate(date)) {
                softassert.assertTrue(true, "Test failed the date is not up to date: " + date);
                CustomLogger.logger.info("Date is up to date: " + date);

            } else {
                CustomLogger.logger.info("Date is not up to date: " + date);
                softassert.assertTrue(false, "Test failed the date is not up to date: " + date);
            }
        }
        getAndAttachScreenshot();
        softassert.assertAll();

    }

    private boolean ifDateIsUpToDate(String date) {
        LocalDate currentDate = LocalDate.now();
        LocalDate dateLimit = (currentDate.minusMonths(2));
        LocalDate newsDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        boolean dateValid = false;
        if (newsDate.isAfter(dateLimit)) {
            dateValid = true;
        }
        return dateValid;
    }

    public void clickOnSubmitContactButton() {
        submitContactFormButton.click();
    }

    public boolean checkIfFieldIsRequired(SelenideElement element) {
        return element.getAttribute("aria-invalid").equals("true");
    }

    public void checkIfSubmitFormFieldsAreRequired() {
        SoftAssert softassert = new SoftAssert();
        softassert.assertTrue(checkIfFieldIsRequired(nameInputField), "Name field is not required");
        softassert.assertTrue(checkIfFieldIsRequired(lastnameInputField), "Lastname field is not required");
        softassert.assertTrue(checkIfFieldIsRequired(emailInputField), "Email field is not required");
        softassert.assertTrue(checkIfFieldIsRequired(phoneInputField), "Phone field is not required");
        softassert.assertTrue(checkIfFieldIsRequired(textInputField), "Text field is not required");
        getAndAttachScreenshot();
        softassert.assertAll();
    }
}
