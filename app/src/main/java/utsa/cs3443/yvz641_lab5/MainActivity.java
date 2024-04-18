package utsa.cs3443.yvz641_lab5;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import utsa.cs3443.yvz641_lab5.model.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        EditText Userinput = (EditText)findViewById(R.id.user);
        EditText Passinput = (EditText)findViewById(R.id.pass);

        Context context = getApplicationContext();
        User user = new User();
        user.loadactor();


        button.setOnClickListener (new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String userinput = Userinput.getText().toString();
                String passinput = Passinput.getText().toString();
                user.loadactor();
                user.validate(userinput, passinput);
                if (user.validate(userinput, passinput)) {
                    Intent intent = new Intent(MainActivity.this, RoleActivity.class);
                    intent.putExtra("user", true);
                    startActivity(intent);
                } else if (!user.validate(userinput, passinput)) {
                    Toast.makeText(context,"User not found",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}