package com.company;

import com.company.costomEx.InvalidPerson;

import java.util.Scanner;

public class Person {
    private int javaLevel; // 1 to 10
    private String name;
    private int age; // 1
    private int englishLevel;     // 1 to 10
    private boolean haveOcaOracleCertificate; // 5
    private float compatibility = 0;

    public Person(String name, int age, int englishLevel, boolean haveOcaOracleCertificate) {
        this.name = name;
        this.age = age;
        this.englishLevel = englishLevel;
        this.haveOcaOracleCertificate = haveOcaOracleCertificate;
        javaLevel = 0;
    }

    private void checkAge() throws InvalidPerson {
        if (this.age < 18) {
            throw new InvalidPerson();
        } else {
            compatibility++;
        }
    }


    private void checkCertification() throws InvalidPerson {
        if (this.haveOcaOracleCertificate) {
            compatibility += 5;
        } else throw new InvalidPerson();
    }

    public void check() {
        try {
            System.out.println("Scaning age");
            checkAge();
            try {
                System.out.println("Scaning Certificate");
                checkCertification();
                try {
                    checkJavaLevel();
                    try {
                        System.out.println("Scaning English ");
                        checkEnglish();
                        try {
                            System.out.println("Calculate Compatibility");
                            checkCompatimility();
                        } catch (InvalidPerson invalidPerson) {
                            invalidPerson.dontHaveCompatibility(this);
                        }
                    } catch (InvalidPerson p) {
                        p.dontHaveLevelEnglish(this);
                    }
                } catch (InvalidPerson p) {
                    System.out.println(p.dontHaveJavaLevel(this));
                }
            } catch (InvalidPerson m) {
                System.out.println("Exception: " + m.InvalidCertification(this));
                try {
                    checkJavaLevel();
                    try {
                        System.out.println("Scaning English ");
                        checkEnglish();
                        try {
                            System.out.println("Calculate Compatibility");
                            checkCompatimility();
                        } catch (InvalidPerson invalidPerson) {
                            invalidPerson.dontHaveCompatibility(this);
                        }
                    } catch (InvalidPerson p) {
                        p.dontHaveLevelEnglish(this);
                    }
                } catch (InvalidPerson p) {
                    System.out.println(p.dontHaveJavaLevel(this));
                }
            }
        } catch (InvalidPerson m) {
            System.out.println("Exception: " + m.InvalidAge(this));
        }


    }


    private void checkCompatimility() throws InvalidPerson {
        compatibility = (compatibility * 100) / 26;
        if (compatibility > 60) {
            System.out.println("Congratulations you are accepted your compability is " + compatibility + "%");
        } else throw new InvalidPerson();
    }

    private void checkEnglish() throws InvalidPerson {
        if (this.englishLevel > 5)
            compatibility += englishLevel;
        else throw new InvalidPerson();
    }


    void checkJavaLevel() throws InvalidPerson {
        System.out.println("Hey i have one small test for you");
        System.out.println("Who is your best friend ?");
        Scanner in = new Scanner(System.in);
        String answer = in.nextLine();
        if (true) {//answer.equals("Indian youtuber")
            javaLevel += 2;
            System.out.println("Corect");
        }
        System.out.println("Who is James Gosling ?");
        answer = in.nextLine();
        if (answer.equals("Godfather")) {
            javaLevel += 2;
            System.out.println("Corect");
        }
        System.out.println("What is C#?");
        answer = in.nextLine();
        if (answer.equals("Minecraft code blocks")) {
            javaLevel += 2;
            System.out.println("Corect");
        }
        System.out.println("You have another friends ?");
        answer = in.nextLine();
        if (true) {//answer.equals("Spring")
            javaLevel += 4;
            System.out.println("Corect");
        }
        if (javaLevel < 6)
            throw new InvalidPerson();
        else compatibility += javaLevel;
    }

    public int getJavaLevel() {
        return javaLevel;
    }

    public String getName() {
        return name;
    }
    public int getEnglishLevel() {
        return englishLevel;
    }
    public float getCompatibility() {
        return compatibility;
    }


}
