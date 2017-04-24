package com.FabrikaProject.Pages;

import com.codeborne.selenide.*;
import com.codeborne.selenide.impl.Waiter;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.confirm;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Configuration.*;


public class ProfilePage {

    public static WebDriver driver;
    public static Waiter waiter = new Waiter();


    public static final String PROFILE_PAGE_URL = baseUrl + "default/user/profile";

    public SelenideElement deleteCheckBox = $(byId("delete_record")),
                    submitButton = $(byXpath("//*/input[@value='Submit']")),
                    firstNameField = $(byName("first_name"));

    public ProfilePage openPage(){
        open(PROFILE_PAGE_URL);
        return this;
    }


    public SuccessDeletingPage deleteProfile(){
        deleteCheckBox.shouldNotBe(Condition.selected);
        deleteCheckBox.click();
        confirm("Are you sure you want to delete this object?");
        //switchTo().alert().accept();
        deleteCheckBox.shouldBe(Condition.selected);
        submitButton.click();
        return new SuccessDeletingPage();
    }






}
