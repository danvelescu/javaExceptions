package com.company.costomEx;

import com.company.Person;

public class InvalidPerson extends Exception {
    public String InvalidAge(Person p) {
        return "Hey " + p.getName() + ", you are to young";
    }

    public String InvalidCertification(Person person) {
        return "You dont have certification";
    }

    public String dontHaveJavaLevel(Person p){
        return "You dont have  good knolage java  "+
                "your level is: "+p.getJavaLevel();
    }
    public String dontHaveLevelEnglish(Person p){
        return "You dont have good language knolage "+
                "your level is: "+p.getEnglishLevel();
    }
    public String dontHaveCompatibility(Person p){
        return "Oh now you going to go work in MacD your compability is " + p.getCompatibility() +"%";
    }
}
