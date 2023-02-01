package pages.innocv.locators;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ContactsPageLocators {
    public final SelenideElement contactPhoneElement = $(byXpath("//p/span/span[@style='font-size:38px'][1]"));
    public final SelenideElement legalPageLink = $(byXpath("//a[@href='aviso-legal']"));
    public final SelenideElement mainImage = $(byXpath("//div[@class='icons-list']"));
    public final SelenideElement nameInputField = $(byXpath("(//input[@type='text'])[1]"));
    public final SelenideElement lastnameInputField = $(byXpath("(//input[@type='text'])[2]"));
    public final SelenideElement emailInputField = $(byXpath("//input[@type='email']"));
    public final SelenideElement phoneInputField = $(byXpath("//input[@type='tel']"));
    public final SelenideElement textInputField = $(byXpath("//div/textarea[@rows='10']"));
    public final SelenideElement contactsInfo = $(byXpath("//div[@class='visit']"));
    public final String paragraphWithTextFaraday = "//p[contains(., 'Faraday')]";
    public final String paragraphWithTextCalle = "//p[contains(., 'Calle')]";
    public final String newsDate = "//p[contains(., 'nuevo')]/following-sibling::*";
    public final SelenideElement submitContactFormButton =
            $(byXpath("//span[@class='MuiButton-label'][contains(., 'Enviar formulario')]"));
}