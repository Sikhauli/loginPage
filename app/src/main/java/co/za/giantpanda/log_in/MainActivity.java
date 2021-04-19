package co.za.giantpanda.log_in;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Context context;

    public final static String FIRST_NAME = "NAME";
    public final static String LAST_NAME = "SURNAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        // Learn Android studio shortcuts here: https://developer.android.com/studio/intro/keyboard-shortcuts
        //

        Toolbar toolbar = findViewById(R.id.toolbar);
        Button loginButton = findViewById(R.id.loginButton);
        Button registerButton = findViewById(R.id.registerButton);
        TextView loginUsername = findViewById(R.id.loginUsername);
        TextView loginPassword = findViewById(R.id.loginPassword);

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.login));
        }

        //This called lambda. Go check it: https://www.w3schools.com/java/java_lambda.asp
        registerButton.setOnClickListener(view -> {
            Intent intent = new Intent(context, Register.class);
            intent.putExtra(FIRST_NAME, "Rofhiwa");
            intent.putExtra(LAST_NAME, "Sikhauli");
            startActivity(intent);
        });

        //I used lambda here as well
        loginButton.setOnClickListener(view -> Toast.makeText(getApplicationContext(),
                " First Name: " + loginUsername.getText().toString() +
                        " Password: " + loginPassword.getText().toString(),
                Toast.LENGTH_LONG).show());
    }
}