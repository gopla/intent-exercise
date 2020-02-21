package id.ac.polinema.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import id.ac.polinema.intentexercise.Model.User;

public class ProfileActivity extends AppCompatActivity {

    private TextView tvAbout, tvFullName, tvEmail, tvHomepage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvAbout = findViewById(R.id.label_about);
        tvFullName = findViewById(R.id.label_fullname);
        tvEmail = findViewById(R.id.label_email);
        tvHomepage = findViewById(R.id.label_homepage);

        Bundle extras = getIntent().getExtras();
        User user = extras.getParcelable("data");
        if (extras != null){
            tvAbout.setText(user.getAbout());
            tvFullName.setText(user.getFullName());
            tvEmail.setText(user.getEmail());
            tvHomepage.setText(user.getHomepage());
        }
    }

    public void openALink(View view) {
        Uri uri = Uri.parse("http://" + tvHomepage.getText().toString() + "/");
        Intent i = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(i);
    }
}
