package utsa.cs3443.yvz641_lab5;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import java.util.List;

import utsa.cs3443.yvz641_lab5.model.User;
import utsa.cs3443.yvz641_lab5.model.Role;

public class RoleActivity extends AppCompatActivity {
    private User user;
Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_role);

            Intent intent = getIntent();
            User user = (User) intent.getSerializableExtra("user");

            TextView nameTextView = findViewById(R.id.nameTextView);
            TextView rolesTextView = findViewById(R.id.rolesTextView);

            String name = user.getName();
            nameTextView.setText(name);

            List<Role> roles = user.getRoles();
            StringBuilder rolesText = new StringBuilder();
            for (Role role : roles) {
                rolesText.append(role.getName()).append("\n");
            }
            rolesTextView.setText(rolesText.toString());


            Button a1 = findViewById(R.id.button3);
            Button a2 = findViewById(R.id.button2);
            Button Lo = findViewById(R.id.button4);

        final int[] buttonclicked = new int[1];
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonclicked[0] =1;
                Intent i = new Intent(RoleActivity.this, ActActivity.class);

                String s = "s";
                Intent intent = i.putExtra( s, buttonclicked[0]);
                startActivity(i);
            }
        });
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(RoleActivity.this, ActActivity.class);
                i.putExtra("buttonClicked",2);
                startActivity(i);
            }
        });
        Lo.setOnClickListener( new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      Intent i = new Intent(RoleActivity.this, MainActivity.class);
                                      boolean value = false;

                                      /*if value is false validate becomes false*/
                                      i.putExtra("user", value);
                                      startActivity(i);
                                      finish();
                                  }
                              }
        );
        }
    }

