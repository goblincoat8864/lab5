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

import java.util.List;

import utsa.cs3443.yvz641_lab5.model.Role;
import utsa.cs3443.yvz641_lab5.model.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
         Button button = findViewById(R.id.button);
        EditText Userinput = findViewById(R.id.user);
        EditText Passinput = findViewById(R.id.pass);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userinput = Userinput.getText().toString();
                String passinput = Passinput.getText().toString();
                List<User> userList = User.loadactor(getApplicationContext());


                User user = User.validate(userinput, passinput, userList);
                if (user != null) {
                    Intent intent = new Intent(MainActivity.this, RoleActivity.class);
                    intent.putExtra("user", user);
                    startActivity(intent);
                }
                else {

                    Toast.makeText(MainActivity.this, "User not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
