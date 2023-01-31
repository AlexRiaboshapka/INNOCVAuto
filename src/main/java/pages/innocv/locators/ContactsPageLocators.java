package pages.innocv.locators;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ContactsPageLocators {
    public final SelenideElement contactPhoneElement = $(byXpath("//p/span/span[@style='font-size:38px'][1]"));
    public final SelenideElement legalPageLink = $(byXpath("//a[@href='aviso-legal']"));
    public final SelenideElement mainImage = $(byXpath("//div[@class='icons-list']"));
    public final String paragraphWithTextFaraday = "//p[contains(., 'Faraday')]";
}
