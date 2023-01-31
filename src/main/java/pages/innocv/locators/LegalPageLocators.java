package pages.innocv.locators;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LegalPageLocators {
    public final SelenideElement legalPageContactPhoneText =
            $(byXpath("//p/span/span[@style='font-size:12.0pt'][contains(., 'Teléfono')]"));
}
