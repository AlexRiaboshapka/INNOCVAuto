package pages.innocv.actions;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import pages.innocv.locators.MainPageLocators;

public class MainPageActions extends MainPageLocators {

    @Step("Go to contacts page")
    public void goToContactsPage() {
        loadSvg.shouldNotBe(Condition.visible);
        acceptCookiesButton.click();
        contactsPage.click();
        loadSvg.shouldNotBe(Condition.visible);
    }

}
