package com.example.zyuternity.hw3;

import java.util.ArrayList;

/**
 * Created by ZYuTernity on 4/8/2016.
 */
public class EmployeeManager {
    private ArrayList<Employee> arrayList;

    public EmployeeManager(){
        this.arrayList = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployees() {
        return this.arrayList;
    }

    public void addEmployee(Employee e){
        arrayList.add(e);
    }

    private static EmployeeManager inst;

    public static EmployeeManager getInst() {
        if (inst == null) {
            inst = new EmployeeManager();
            return inst;
        }
        return inst;
    }

}
