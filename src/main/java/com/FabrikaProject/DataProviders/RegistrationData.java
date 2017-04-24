package com.FabrikaProject.DataProviders;


import org.testng.annotations.DataProvider;

public class RegistrationData {

    @DataProvider(name = "invalidRegistrationData")
    public Object[][] invalidRegistration(){
        return new Object[][]{
                {"Savva", "Genchevskiy", "savva.genchevskiygmail.com", "19021992qa", "19021992qa", "savva_gench", "invalid email!", "email__error"},
                {"Savva", "Genchevskiy", "savva.genchevskiy+2@gmail.com", "19021992qa", "19021992qq", "savva_gench", "Password fields don't match", "password_two__error"},
                {"", "Genchevskiy", "savva.genchevskiy+2@gmail.com", "19021992qa", "19021992qa", "savva_gench", "Enter from 1 to 128 characters", "first_name__error"},
        };
    }



}
