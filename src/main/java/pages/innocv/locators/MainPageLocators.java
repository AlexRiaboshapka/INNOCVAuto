package pages.innocv.locators;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPageLocators {
    public final SelenideElement contactsPage = $(byXpath("//a[@href='/contacto']"));
    public final SelenideElement acceptCookiesButton = $(byId("rcc-confirm-button"));
    public final SelenideElement loadSvg = $(byXpath("//vsg[@class='MuiCircularProgress-svg']"));

}
