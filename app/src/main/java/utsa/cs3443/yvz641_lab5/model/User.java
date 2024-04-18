package utsa.cs3443.yvz641_lab5.model;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class User {
    public String username;
    public String password;

    public String name;
    public String role1;
    public String role2;

    public Context context;
    public boolean validate(String userinput, String passinput){
    return  (this.username.equals(userinput)&& this.password.equals(passinput));
    };

    public void loadactor() {
        try {
            AssetManager assetManager = context.getAssets();
            InputStream file = assetManager.open("users.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(file));
            new InputStreamReader(file);
            String line;
            while ((line = reader.readLine())!= null) {
                String[] tokens;
                String[] split = (line.split(","));
                username = split[0];
                password = split[1];
                name = split[2];
                role1 = split[3];
                if (role1.endsWith(" ")) {
                    role2 = null;
                } else {
                    role2 = split[4];
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
