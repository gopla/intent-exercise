package id.ac.polinema.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import id.ac.polinema.intentexercise.Model.User;

public class RegisterActivity extends AppCompatActivity {
    private EditText txtFullName, txtEmail, txtPassword, txtConPassword, txtHomepage, txtAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtFullName = findViewById(R.id.text_fullname);
        txtEmail = findViewById(R.id.text_email);
        txtPassword = findViewById(R.id.text_password);
        txtConPassword = findViewById(R.id.text_confirm_password);
        txtHomepage = findViewById(R.id.text_homepage);
        txtAbout = findViewById(R.id.text_about);
    }

    public void submitForm(View view) {
        String fullName = txtFullName.getText().toString();
        String email =txtEmail.getText().toString();
        String password = txtPassword.getText().toString();
        String conPass = txtConPassword.getText().toString();
        String homepage = txtHomepage.getText().toString();
        String about = txtAbout.getText().toString();

        boolean validate = !fullName.isEmpty() && !email.isEmpty() && !homepage.isEmpty() && !about.isEmpty();

        if (conPass.equals(password)){
            if (validate){
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                User user = new User(fullName, email, password, homepage, about);
                Intent i = new Intent(this, ProfileActivity.class);
                i.putExtra("data",user);
                startActivity(i);
            }else {
                Toast.makeText(this, "Fill all data!", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Password doesn't match!", Toast.LENGTH_SHORT).show();
        }
    }
}
