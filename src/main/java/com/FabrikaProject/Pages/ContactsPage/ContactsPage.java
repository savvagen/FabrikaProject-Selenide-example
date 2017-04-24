package com.FabrikaProject.Pages.ContactsPage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Configuration.*;

public class ContactsPage {

    public static final String CONTACTS_PAGE_URL = baseUrl + "/test_1/default/contact";


    public ElementsCollection contacts = $$("table tbody tr");


   /* public ContactsPage shouldHaveContactName(int index, String contactName){
        contacts.get(index).$(byXpath("//td[1]/h2")).shouldHave(Condition.text(contactName));
        return this;
    }

    public ContactsPage */







    public ContactsPage openaPage(){
        open(CONTACTS_PAGE_URL);
        return this;
    }


}
