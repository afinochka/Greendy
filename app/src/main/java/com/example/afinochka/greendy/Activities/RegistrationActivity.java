package com.example.afinochka.greendy.Activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.afinochka.greendy.Objects.User;
import com.example.afinochka.greendy.R;
import com.example.afinochka.greendy.Services.Validation;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {

    EditText name, email, password, number, birthday;
    Button registration;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registation);

        registration = (Button) findViewById(R.id.registration);
        registration.setOnClickListener(this);

        name = (EditText) findViewById(R.id.name);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);

        number = (EditText) findViewById(R.id.number);
        number.setOnClickListener(this);

        birthday = (EditText) findViewById(R.id.birthday);
        birthday.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.registration:
                if(isValidate())
                    startActivity();
                break;
            case R.id.birthday:
                openDatePicker();
                break;
            case R.id.number:
                formatNumber();
                break;
        }
    }

    private void formatNumber(){
        if("".equals(String.valueOf(number.getText())))
            number.append("+375 ");

    }

    private void startActivity() {
        Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
        intent.putExtra("Name", user.getName());
        intent.putExtra("Email", user.getEmail());
        startActivity(intent);
    }

    private void openDatePicker() {

        Calendar mCurrentDate = Calendar.getInstance();
        int mYear = mCurrentDate.get(Calendar.YEAR);
        int mMonth = mCurrentDate.get(Calendar.MONTH);
        int mDay = mCurrentDate.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog mDatePicker = new DatePickerDialog(RegistrationActivity.this,
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker datepicker, int year, int month, int day) {
                    String date = day + " - " + month + " - " + year;
                    birthday.setText(date);
            }
        }, mYear, mMonth, mDay);
        mDatePicker.setTitle("Выберите дату");
        mDatePicker.show();
    }

    private boolean isValidate(){

        String mName = String.valueOf(name.getText());
        String mEmail = String.valueOf(email.getText());
        String mPassword = String.valueOf(password.getText());
        String mNumber = String.valueOf(number.getText());
        String mBirthday = String.valueOf(birthday.getText());

        if(!Validation.isValidName(mName)){
            name.setError("Некорректные данные");
        }else if(!Validation.isValidEmail(mEmail)){
            email.setError("Некорректные данные");
        }else if(!Validation.isValidPassword(mPassword)){
            password.setError("Некорректные данные");
        }else if(!Validation.isValidNumber(mNumber)){
            number.setError("Некорректные данные");
        }else {
            user = new User(mName, mEmail, mPassword, mNumber, mBirthday);
            return true;
        }

        return false;
    }
}
