package com.example.zyuternity.hw3;

import java.io.Serializable;

/**
 * Created by ZYuTernity on 4/8/2016.
 */
public class Employee implements Serializable {
    private static final long serialVersionUID =0L;
    String name;
    String birthDay;
    String birthPlace;
    String gender;
    public Employee (String eName, String eBirthDay, String eBirthPlace, String egender){
        name = eName;
        birthDay = eBirthDay;
        birthPlace = eBirthPlace;
        gender = egender;
    }

    public String getName() {
        return name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public String getGender() {
        return gender;
    }
}
