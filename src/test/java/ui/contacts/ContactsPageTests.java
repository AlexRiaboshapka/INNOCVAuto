package ui.contacts;

import common.AbstractBaseTest;
import listener.CustomListener;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class ContactsPageTests extends AbstractBaseTest {
    private final String baseUrl = "https://www.innocv.com/";
    private final int expectedNumberOfTimesFaradayAppears = 2;

    @BeforeMethod
    public void setUp() {
        open(baseUrl);
        sleep(2000);
        mainPageActions.goToContactsPage();
    }

    @Test
    public void checkContactPhoneIsTheSameOnTheLegalPage() {
        String contactPhoneFull = contactsPageActions.getContactPhoneNumber();
        contactPhoneFull = contactPhoneFull.substring(6);
        contactsPageActions.goToLegalPage();
        String legalPhone = legalPageActions.getLegalPageContactPhoneNumber();
        Assert.assertTrue(legalPhone.contains(contactPhoneFull));
    }

    @Test
    public void countHowManyTimesFaradayAppears() {
        Assert.assertEquals(contactsPageActions.countFaradayText(), expectedNumberOfTimesFaradayAppears);
    }

    @Test
    public void checkThatSendFormFieldsAreRequired() {
        contactsPageActions.clickOnSubmitContactButton();
        contactsPageActions.checkIfSubmitFormFieldsAreRequired();
    }

    @Test
    public void checkTheNewsAreUpToDate() {
        contactsPageActions.getTheNewsDatesAndVerifyIfUpToDate();
    }

    @AfterMethod
    public void tearDown() {
        getWebDriver().quit();
    }
}
