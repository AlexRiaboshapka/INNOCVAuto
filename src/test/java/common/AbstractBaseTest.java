package common;

import config.RunnerConfig;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.innocv.actions.ContactsPageActions;
import pages.innocv.actions.LegalPageActions;
import pages.innocv.actions.MainPageActions;


public class AbstractBaseTest {
    public RunnerConfig config = new RunnerConfig();
    public MainPageActions mainPageActions = new MainPageActions();
    public ContactsPageActions contactsPageActions = new ContactsPageActions();
    public LegalPageActions legalPageActions = new LegalPageActions();

    @BeforeClass
    @Parameters({"projectId", "Browser", "browserVersion"})
    public void setUp(@Optional("2") String projectId,
                      @Optional("Chrome") String Browser,
                      @Optional("109") String browserVersion) {
        config.setUpConfig(projectId, Browser, browserVersion);
    }
}
