import com.FabrikaProject.DataProviders.RegistrationData;
import com.FabrikaProject.Utilites.TestBase;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.testng.BrowserPerClass;
import com.codeborne.selenide.testng.BrowserPerTest;
import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

@Title("Smoke tests")
@Description("Tests of main website functionality")
@Listeners({ScreenShooter.class, BrowserPerClass.class})
public class SmokeTests extends TestBase {



    /*@Test
    public void test(){
        open("/");
        $(byText("Login")).click();
        $(byId("auth_user_email")).setValue("savva.genchevskiy@gmail.com");
        $(byId("auth_user_password")).setValue("19021992qa").pressEnter();
        $(byText("Logout")).shouldBe(visible);
        $(byId("button")).shouldHave(text("Profile"));
        $(byClassName("flash")).shouldHave(text("Welcome to Selenium course, Savva!" + "\n" + "×"));

    }*/


    @Title("Positive registration")
    @Description("This is a test of registration")
    @Test(priority = 1)
    public void positiveRegistration(){
        registrationPage.openPage().registerTestUser();
        homePage.flash.shouldBe(visible).shouldHave(text(homePage.logged_in_flash_message));
        homePage.profileButton.shouldBe(visible);
    }


    @Title("Negative registration")
    @Description("Description")
    @Test(dataProvider = "invalidRegistrationData", dataProviderClass = RegistrationData.class, priority = 2)
    public void negativeRegistration(String firsName, String lastName, String email,
                                     String password, String confPassword, String nickName,
                                     String errorMessage, String errorId){
        registrationPage.openPage().invalidRegistration(firsName, lastName, email, password, confPassword, nickName);
        registrationPage.errorMessageField.shouldBe(visible).shouldHave(text(errorMessage));
        registrationPage.errorMessageField.shouldHave(attribute("id", errorId));
    }

    @Title("Profile deleting")
    @Description("Description")
    @Test(priority = 3)
    public void deleteProfile(){
        loginPage.openPage().login(registrationPage.email, registrationPage.password);
        homePage.pressProfile();
        profilePage.deleteProfile();
        deletePage.flashBoard.shouldBe(visible).shouldHave(text(deletePage.deletedMessage));
        deletePage.pressHome();
        homePage.flash.shouldBe(visible).shouldHave(text(homePage.not_logged_in_flash_message));
        homePage.registerButton.shouldBe(visible);
    }

    @Title("Positive login")
    @Description("Description")
    @Test(priority = 4)
    public void positiveLogin(){
        loginPage.openPage().login(loginPage.user_email, loginPage.user_password);
        homePage.logoutButton.shouldBe(visible);
        homePage.profileButton.shouldBe(visible);
        homePage.flash.shouldBe(visible).shouldHave(text(homePage.logged_in_flash_message));
    }

    @Title("Post message creation")
    @Description("Description")
    @Test(priority = 5)
    public void createPost(){
        loginPage.openPage().login(loginPage.user_email, loginPage.user_password);
        postPage.openPage().createPost(postPage.new_post_text);
        posts.shouldHaveSize(1).shouldHaveMessage(0, postPage.new_post_text).shouldHaveUserId(0, postPage.userId);
    }


    @Test(priority = 6)
    public void viewPost(){
        loginPage.openPage().login(loginPage.user_email, loginPage.user_password);
        homePage.viewPost(0);
        homePage.postMessageField.shouldBe(visible).shouldHave(text(postPage.new_post_text));
    }


    @Title("Post Message deleting")
    @Description("Description")
    @Test(priority = 7)
    public void deletePost(){
        loginPage.openPage().login(loginPage.user_email, loginPage.user_password);
        homePage.deletePost(0);
        posts.shouldHaveSize(0).shouldNotHaveMessage(postPage.new_post_text);

    }

    @Title("Terms link checking")
    @Description("Checking of the Course Terms page")
    @Test
    public void pressTermsLink(){
        homePage.openPage().pressTerms();
        termsPage.courseDurationField.shouldBe(visible).shouldHave(text(termsPage.courseDurationMessage));
    }

    @Title("About link checking")
    @Description("Checking About Course page")
    @Test
    public void pressAboutLink(){
        homePage.openPage().pressAbout();
        aboutPage.courseTitileField.shouldBe(visible).shouldHave(text(aboutPage.courseTitle));
        aboutPage.courseDescriptionField.shouldBe(visible).shouldHave(text(aboutPage.courseDescription));

    }

    @Title("Description Button checking")
    @Description("Checking of the course description")
    @Test
    public void pressDescriptionButton(){
        homePage.openPage().pressDescripton();
        descriptionPage.descriptionTitleField.shouldBe(visible).shouldHave(text(descriptionPage.descriptionTitle));
    }

    @Title("Contacts link checking")
    @Description("Checking of the contatcs")
    @Test
    public void PresContactsLink(){
        homePage.openPage().pressContats();
        contactsPage.contacts.shouldHaveSize(2);
        contactsTable.shouldHaveContactName(0, "Andrew").shouldHaveLink(0, "skype:andrii.sylchuk?call");
        contactsTable.shouldHaveContactName(1, "Dmitry").shouldHaveLink(1, "skype:vlay19881?call");
    }




}
