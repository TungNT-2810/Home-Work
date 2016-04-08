package com.example.zyuternity.hw3;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8, txt9, txt10;
    Button buttonAdd;
    EmployeeManager employeeManager;
    ArrayList<Employee> arrayList;
    Employee e;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        employeeManager = EmployeeManager.getInst();
        arrayList = employeeManager.getEmployees();
        getFormWidgets();
        viewEmployee();
    }

    public void getFormWidgets(){
        txt1 = (TextView) findViewById(R.id.txt1);
        txt2 = (TextView) findViewById(R.id.txt2);
        txt3 = (TextView) findViewById(R.id.txt3);
        txt4 = (TextView) findViewById(R.id.txt4);
        txt5 = (TextView) findViewById(R.id.txt5);
        txt6 = (TextView) findViewById(R.id.txt6);
        txt7 = (TextView) findViewById(R.id.txt7);
        txt8 = (TextView) findViewById(R.id.txt8);
        txt9 = (TextView) findViewById(R.id.txt9);
        txt10 = (TextView) findViewById(R.id.txt10);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(this);
    }


    public void viewEmployee() {
        if (arrayList.size() == 0) {
            txt1.setText("Empty!");
            return;
        }
        if (arrayList.size() >= 1 && (e = arrayList.get(0)) != null) {
            txt1.setText("Name: " + e.getName() + "\n BirthDay: " + e.getBirthDay() + "\n BirthPlace: " + e.getBirthPlace() + "\n Gender: " + e.getGender());
        }
        if (arrayList.size() >= 2 && (e = arrayList.get(1)) != null) {
            txt2.setText("Name: " + e.getName() + "\n BirthDay: " + e.getBirthDay() + "\n BirthPlace: " + e.getBirthPlace() + "\n Gender: " + e.getGender());
        }
        if (arrayList.size() >= 3 && (e = arrayList.get(2)) != null) {
            txt3.setText("Name: " + e.getName() + "\n BirthDay: " + e.getBirthDay() + "\n BirthPlace: " + e.getBirthPlace() + "\n Gender: " + e.getGender());
        }
        if (arrayList.size() >= 4 && (e = arrayList.get(3)) != null) {
            txt4.setText("Name: " + e.getName() + "\n BirthDay: " + e.getBirthDay() + "\n BirthPlace: " + e.getBirthPlace() + "\n Gender: " + e.getGender());
        }
        if (arrayList.size() >= 5 && (e = arrayList.get(4)) != null) {
            txt5.setText("Name: " + e.getName() + "\n BirthDay: " + e.getBirthDay() + "\n BirthPlace: " + e.getBirthPlace() + "\n Gender: " + e.getGender());
        }
        if (arrayList.size() >= 6 && (e = arrayList.get(5)) != null) {
            txt6.setText("Name: " + e.getName() + "\n BirthDay: " + e.getBirthDay() + "\n BirthPlace: " + e.getBirthPlace() + "\n Gender: " + e.getGender());
        }
        if (arrayList.size() >= 7 && (e = arrayList.get(6)) != null) {
            txt7.setText("Name: " + e.getName() + "\n BirthDay: " + e.getBirthDay() + "\n BirthPlace: " + e.getBirthPlace() + "\n Gender: " + e.getGender());
        }
        if (arrayList.size() >= 8 && (e = arrayList.get(7)) != null) {
            txt8.setText("Name: " + e.getName() + "\n BirthDay: " + e.getBirthDay() + "\n BirthPlace: " + e.getBirthPlace() + "\n Gender: " + e.getGender());
        }
        if (arrayList.size() >= 9 && (e = arrayList.get(8)) != null) {
            txt9.setText("Name: " + e.getName() + "\n BirthDay: " + e.getBirthDay() + "\n BirthPlace: " + e.getBirthPlace() + "\n Gender: " + e.getGender());
        }
        if (arrayList.size() >= 10 && (e = arrayList.get(9)) != null) {
            txt10.setText("Name: " + e.getName() + "\n BirthDay: " + e.getBirthDay() + "\n BirthPlace: " + e.getBirthPlace() + "\n Gender: " + e.getGender());
        }
    }


    public void addEmployee(){
        Intent t = new Intent(MainActivity.this, AddEmployee.class);
        startActivity(t);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonAdd:
                addEmployee();
                break;
        }
    }
}
