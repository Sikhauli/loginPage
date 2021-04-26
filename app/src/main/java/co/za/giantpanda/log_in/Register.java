package co.za.giantpanda.log_in;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Register extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        context = this;

        //you don't use underscores(_) on Java when naming a field/variable/methods/class
        //Rename variable like pass_TextView to correct naming standard eg: passwordTextView
        //Use full word no shortcuts or abbreviations, UnameTextView should be usernameTextView
        Toolbar toolbar = findViewById(R.id.toolbar);
        EditText firstNameTextView = findViewById(R.id.firstName); //Type is EditText not TextView
        EditText  lastNameTextView = findViewById(R.id.lastName);//Type is EditText not TextView
        EditText  pass_TextView = findViewById(R.id.pass_); //Type is EditText not TextView
        EditText  UnameTextView = findViewById(R.id.Uname); //Type is EditText not TextView
        Button Reg_login = findViewById(R.id.Reg_login);

        //Read this: https://source.android.com/setup/contribute/code-style#follow-field-naming-conventions
        //And this: https://dzone.com/articles/best-practices-variable-and

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setTitle("Register");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);


        Intent intent = getIntent();

        if (intent.getExtras() != null) {
            String firstName = intent.getStringExtra(MainActivity.FIRST_NAME);
            String lastName = intent.getStringExtra(MainActivity.LAST_NAME);

            firstNameTextView.setText(firstName);
            lastNameTextView.setText(lastName);
        }

        //I also used lambda, learn and get used to it.
        findViewById(R.id.reg_).setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(),
                    " First Name: " + firstNameTextView.getText().toString() +
                            " Last Name: " + lastNameTextView.getText().toString() +
                            " Username: " + UnameTextView.getText().toString() +
                            " Password: " + pass_TextView.getText().toString(),
                    Toast.LENGTH_LONG).show();
        });

        //Lambda here too
        Reg_login.setOnClickListener(view -> {
            Intent intent1 = new Intent(context, MainActivity.class);
            startActivity(intent1);
        });
    }

    //This overridden method handle up button
    //This how you override method, before you put this method inside onCreate method, you don't do that
    //You don't create/put method inside another method
    //Go learn about overriding, overloading, etc here: https://raygun.com/blog/oop-concepts-java/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}