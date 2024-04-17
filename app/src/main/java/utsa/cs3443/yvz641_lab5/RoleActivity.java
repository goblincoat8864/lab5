package utsa.cs3443.yvz641_lab5;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import utsa.cs3443.yvz641_lab5.model.User;

public class RoleActivity extends AppCompatActivity {
Context context;
User user = new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_role);


            Button a1 = findViewById(R.id.button3);
            Button a2 = findViewById(R.id.button2);
            Button Lo = findViewById(R.id.button4);
            int buttonclicked;
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(RoleActivity.this, ActActivity.class);
                i.putExtra("buttonclicked", 1);
                startActivity(i);
            }
        });
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(RoleActivity.this, ActActivity.class);
                i.putExtra("buttonclicked", 2);
                startActivity(i);
            }
        });
        Lo.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      Intent i = new Intent(RoleActivity.this, MainActivity.class);
                                      // need to revoke credentials before starting main again.
                                      startActivity(i);
                                  }
                              }
        );
        }
    }

