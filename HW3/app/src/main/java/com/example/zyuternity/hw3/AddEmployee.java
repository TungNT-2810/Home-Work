package com.example.zyuternity.hw3;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddEmployee extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, View.OnClickListener {

    EditText txtName;
    TextView txtBirthDay;
    Spinner spinnerBirthPlace;
    RadioGroup radioGroupGender;
    RadioButton radioButtonMale, radioButtonFemale, radioButtonNA;
    Button buttonConfirm;
    Calendar calendar;
    EmployeeManager employeeManager;
    int day, month, nam;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);
        employeeManager = EmployeeManager.getInst();
        getFormWidgets();
        setDay();
        setSpinner();
    }

    public void getFormWidgets() {
        txtName = (EditText) findViewById(R.id.txtName);
        txtBirthDay = (TextView) findViewById(R.id.txtBirthDay);
        spinnerBirthPlace = (Spinner) findViewById(R.id.spinnerBirthPlace);
        radioGroupGender = (RadioGroup) findViewById(R.id.radioGroupGender);
        radioButtonFemale = (RadioButton) findViewById(R.id.radioButtonFeMale);
        radioButtonMale = (RadioButton) findViewById(R.id.radioButtonMale);
        radioButtonNA = (RadioButton) findViewById(R.id.radioButtonNA);
        buttonConfirm = (Button) findViewById(R.id.buttonConfirm);
        calendar = Calendar.getInstance();
        buttonConfirm.setOnClickListener(this);
        txtBirthDay.setOnClickListener(this);
    }

    public void setDay(){
        day = calendar.get(Calendar.DAY_OF_WEEK);
        month = calendar.get(Calendar.MONTH);
        nam = calendar.get(Calendar.YEAR);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == 1) {
            return new DatePickerDialog(this, this, nam, month, day);
        }
        return null;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        month = monthOfYear;
        day = dayOfMonth;
        nam = year;
        String txt = dayOfMonth + "/" + (monthOfYear+1) + "/" + year;
        txtBirthDay.setText(txt);

    }

    public void setSpinner(){
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.birthPlace, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerBirthPlace.setAdapter(adapter);
    }

    public boolean checkField(){
        if(txtName.getText() == null || txtName.getText().equals("")){
            return false;
        }else if(txtBirthDay.getText()==null || txtBirthDay.getText().equals("")){
            return false;
        }
        return true;
    }

    public void addEmployee(){
        String name = txtName.getText().toString();
        String birthDay = txtBirthDay.getText().toString();
        String birthPlace = spinnerBirthPlace.getSelectedItem().toString();
        String gender = "";
        if(radioButtonMale.isChecked()) gender="Male";
        else if(radioButtonFemale.isChecked()) gender="Female";
        else if(radioButtonNA.isChecked()) gender="N/A";
        Employee e = new Employee(name, birthDay, birthPlace, gender);
        employeeManager.addEmployee(e);
        Toast.makeText(AddEmployee.this, "New Employee is Added", Toast.LENGTH_SHORT).show();
        Intent t = new Intent(AddEmployee.this, MainActivity.class);
        startActivity(t);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonConfirm:
                if(checkField()){
                    addEmployee();
                    break;
                }else Toast.makeText(AddEmployee.this, "Field can not be empty", Toast.LENGTH_SHORT).show();

            case R.id.txtBirthDay:
                showDialog(1);
                break;
        }
    }
}