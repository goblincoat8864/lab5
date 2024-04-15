package utsa.cs3443.yvz641_lab5.model;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Act {
    public String actText;
    public int actNumber;
    Context context;
if(actNumber=1)// set by intent of which button is pressed

    {
        try {


            AssetManager assetManager = context.getAssets();
            InputStream file = assetManager.open("Act_1_Scenes");
            BufferedReader reader = new BufferedReader(new InputStreamReader(file));
            new InputStreamReader(file);
            String line;
            while (line = reader.readLine() != null) {
                actText = line;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}