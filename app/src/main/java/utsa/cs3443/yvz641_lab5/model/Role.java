package utsa.cs3443.yvz641_lab5.model;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Role implements Serializable {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    public Role(String name) {
        this.name = name;
    }
    public static List<Role> loadRole(Context context) {
        List<Role> roleList = new ArrayList<>();
        AssetManager assetManager = context.getAssets();
        try {
            InputStream file = assetManager.open("users.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(",");
                if (split.length >= 3) {
                    for (int i = 3; i < split.length; i++) {
                        if (split.length > i) {
                            roleList.add(new Role(split[i]));
                        }
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            Log.e("Role", "Error loading roles: " + e.getMessage());
        }
        return roleList;
    }

}