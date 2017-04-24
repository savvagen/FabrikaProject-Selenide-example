package com.FabrikaProject.Pages.ContactsPage;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.$$;

public class ContactsTable {

    public ElementsCollection contacts = $$("table tbody tr");


    public ContactsTable shouldHaveContactName(int index, String contactName){
        contacts.get(index).$("td h2").shouldHave(Condition.text(contactName));
        return this;
    }

    public ContactsTable shouldHaveLink(int index, String link){
        contacts.get(index).$("td a").shouldHave(Condition.attribute("href", link));
        return this;
    }


}
