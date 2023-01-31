package ui.contacts;

import common.AbstractBaseTest;
import listener.CustomListener;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

@Listeners(CustomListener.class)
public class ContactsPageTests extends AbstractBaseTest {
    private final String baseUrl = "https://www.innocv.com/";
    private final int expectedNumberOfTimesFaradayAppears = 2;

    @BeforeMethod
    public void setUp() {
        open(baseUrl);
        mainPageActions.goToContactsPage();
    }

    @Test
    public void checkContactPhoneIsTheSameOnTheLegalPage() {
        String contactPhoneFull = contactsPageActions.getContactPhoneNumber();
        contactsPageActions.goToLegalPage();
        String legalPhone = legalPageActions.getLegalPageContactPhoneNumber();
        contactPhoneFull = contactPhoneFull.substring(6);
        Assert.assertTrue(legalPhone.contains(contactPhoneFull));
    }

    @Test
    public void countHowManyTimesFaradayAppears() {
        Assert.assertEquals(contactsPageActions.countFaradayText(), expectedNumberOfTimesFaradayAppears);
    }
}
