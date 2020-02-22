package JunctionX.HealthX;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private final String logTag = "HealthX";

    SharedPreferences preferences;

    private List<Project> projects = new ArrayList<>();;

    private void  SafeToLocalStorage() {

        String projectString = "";
        for (Project project : projects) {
            projectString += project.getSafeString();
        }

        preferences.edit().putString("projects", projectString).commit();
    }

    private void LoadLocalStorage() {

        String projectsInput = preferences.getString("projects", "");
        for (String projectString : projectsInput.split(";")) {
            projects.add(new Project(projectString));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        //Add a project manually if you dont have one already
        //projects.add(new Project(0, "Tomato"));
        //SafeToLocalStorage();

        LoadLocalStorage();
        Log.i(logTag, projects.toString());

        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SafeToLocalStorage();
    }
}
