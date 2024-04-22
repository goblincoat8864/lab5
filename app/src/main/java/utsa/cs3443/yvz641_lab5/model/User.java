package utsa.cs3443.yvz641_lab5.model;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Parcelable;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import utsa.cs3443.yvz641_lab5.RoleActivity;

public class User implements Serializable {
    public String username;
    public String password;

    public String name;
   public List<Role> roles;

    public Context context;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    // public boolean validate(String userinput, String passinput){
    //return  (this.username.equals(userinput)&& this.password.equals(passinput));
    //};

       // Other class members...

       public static User validate(String userinput, String passinput, List<User> userList) {
           for (User user : userList) {
               if (user.getUsername().equals(userinput) && user.getPassword().equals(passinput)) {
                return user;


               }
           }
           return null;
       }


    public User(String username, String password,String name){
        this.username=username;
        this.password = password;
        this.name= name;
        this.roles = new ArrayList<>();
    }



    public static List<User> loadactor(Context context) {
        List<User> userList = new ArrayList<>();
        AssetManager assetManager = context.getAssets();
           try {

            InputStream file = assetManager.open("users.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(",");
                if (split.length >=3) {
                    String username = split[0];
                    String password = split[1];
                    String name = split[2];
                    User user = new User(username, password, name);

                    for (int i = 3; i < split.length; i++) {
                        user.roles.add(new Role(split[i]));
                    }
                    userList.add(user);
                }
                }

            reader.close();
        } catch (IOException e) {
            Log.e("User", "could not read users.csv"+ e.getMessage());

        }
        return userList;

    }}
