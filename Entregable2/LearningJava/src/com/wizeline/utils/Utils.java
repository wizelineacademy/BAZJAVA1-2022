package com.wizeline.utils;

import com.wizeline.ENUMS.AccountType;
import com.wizeline.ENUMS.Country;
import com.wizeline.ENUMS.UserType;
import com.wizeline.Entities.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Utils {

    public static long randomAccountNumber(){
        return new Random().nextLong();
    }

    public static double randomBalance(){
        return new Random().doubles(1000,9000).limit(1).findFirst().getAsDouble();
    }

    public static AccountType pickRandomAccountType(){
        AccountType[] accountTypes = AccountType.values();
        return accountTypes[new Random().nextInt(accountTypes.length)];
    }
    public static UserType pickRandomUserType(){
        UserType[] userTypes = UserType.values();
        return userTypes[new Random().nextInt(userTypes.length)];
    }

    public static String randomInt(){
        return String.valueOf(new Random().ints(1,10).findFirst().getAsInt());
    }

    public static String getCountry(Country country){
        Map<Country,String> countries =new HashMap<>();
        countries.put(Country.US,"United States");
        countries.put(Country.MX,"Mexico");
        countries.put(Country.FR,"France");
        return countries.get(country);
    }

    public static String getString(String value){
        if(value != null){
            return value;
        }
        return "";
    }

    public static boolean validateNullValue(String value){
        if(value != null){
            return true;
        }
        return false;
    }
}
