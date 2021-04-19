package co.za.giantpanda.log_in;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.MenuItem;
import android.view.Menu;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.content.ClipData.Item;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

public class Register extends AppCompatActivity {

  private Context context;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_register);

    context = this;

    Toolbar toolbar =findViewById(R.id.toolbar);
    TextView firstNameTextView = findViewById(R.id.firstName);
    TextView lastNameTextView = findViewById(R.id.lastName);
    TextView pass_TextView = findViewById(R.id.pass_);
    TextView UnameTextView = findViewById(R.id.Uname);
    Button Reg_login = findViewById(R.id.Reg_login);


    setSupportActionBar(toolbar);
    ActionBar actionBar = getSupportActionBar();

    if (actionBar != null) {
      actionBar.setTitle("Register");
      actionBar.setDisplayHomeAsUpEnabled(true);
    }
      //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      //getSupportActionBar().setDisplayShowHomeEnabled(true);

    //
    //public boolean onOptionsItemSelected( MenuItem item) {
    //
    //  if (item.getItemId()==android.R.id.home){
    //      finish();
    //  }
    //      return super.onOptionsItemSelected(item);
    //}


    //startActivity(new Intent( Register.this, MainActivity.class));

    Intent intent = getIntent();

    if (intent.getExtras() != null) {
      String firstName = intent.getStringExtra(MainActivity.FIRST_NAME);
      String lastName = intent.getStringExtra(MainActivity.LAST_NAME);

      firstNameTextView.setText(firstName);
      lastNameTextView.setText(lastName);
    }

    findViewById(R.id.reg_).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        //Toast.makeText(Register.this, ((Button)view).getText().toString() + " ", Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(),
                " First Name: " + firstNameTextView.getText().toString() +
                " Last Name: " + lastNameTextView.getText().toString() +
                " Username: " + UnameTextView.getText().toString() +
                " Password: " + pass_TextView.getText().toString() ,
            Toast.LENGTH_LONG).show();

        //Button button1 = findViewById(R.id.button_1);
        //
        //button1.setOnClickListener(new View.OnClickListener() {
        //  @Override public void onClick(View view) {
        //    Toast.makeText(MainActivity.this, button1.getText().toString() + " is pressed", Toast.LENGTH_SHORT).show();
        //  }
        //});

      }
    });
    Reg_login.setOnClickListener(new View.OnClickListener(){
      @Override public void onClick(View view) {
        Intent intent = new Intent(context, MainActivity.class);
        startActivity(intent);

      }
    });
  }
}