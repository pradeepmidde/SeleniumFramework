package com.automation.utils;

import com.github.javafaker.Faker;

public class FakerUtils {

    private static Faker faker = new Faker();

    public static String getFirstName() {
        return faker.name().firstName();
    }

    public static String getLastName() {
        return faker.name().lastName();
    }

    public static String getAddress() {
        return faker.address().streetAddress();
    }

    public static String getCity() {
        return faker.address().city();
    }

    public static String getState() {
        return faker.address().stateAbbr();
    }

    public static String getZipCode() {
        return faker.address().zipCode().substring(0, 5);
    }

    public static String getPhoneNumber() {
        return faker.numerify("##########");
    }

    public static String getSSN() {
        return faker.numerify("###-##-####");
    }

    public static String getUsername() {
        return faker.name().username().replace(".", "_") 
            + System.currentTimeMillis() % 10000;
    }

    public static String getPassword() {
        return "Test@" + faker.numerify("####");
    }
}