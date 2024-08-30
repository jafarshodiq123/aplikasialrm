package com.example.projek1.Ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.projek1.R;
import com.example.projek1.data.UserDAO;

public class RegisterActivity extends AppCompatActivity {


    private EditText nama , email ,password;
    private UserDAO userDAO;
    private Button simpanRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nama = findViewById(R.id.nama_register);
        email = findViewById(R.id.email_register);
        password= findViewById(R.id.password_register);
        simpanRegister = findViewById(R.id.SimpanRegister);
        userDAO = new UserDAO(this);

        //ketika tombol di pencet
        simpanRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //menyimpa data ke variable dulu
                String Username = nama.getText().toString();
                String Email = email.getText().toString();
                String Password = password.getText().toString();
                long result = userDAO.addUser(Username,Email,Password);

                if (result > 0){
                    Toast.makeText(RegisterActivity.this, "Register Berhasil",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this,LoginActivity.class));//jika sukses akan diarahkan ke login
                }else {
                    Toast.makeText(RegisterActivity.this,"Register gagal",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}