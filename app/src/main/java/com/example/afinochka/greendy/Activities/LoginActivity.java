package com.example.afinochka.greendy.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.example.afinochka.greendy.R;
import com.example.afinochka.greendy.Services.Validation;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText email, password;
    Button login, registration;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(this);

        registration = (Button) findViewById(R.id.registration);
        registration.setOnClickListener(this);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.registration:
                startActivity(RegistrationActivity.class);
                break;
            case R.id.login:
                startActivity(MainActivity.class);
                finish();
                break;
            default:
                break;
        }
    }

    private void startActivity(Class activity){
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }


}
