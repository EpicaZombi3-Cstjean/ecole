package cstjean.mobile.ecole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import cstjean.mobile.ecole.travail.CoursSession;
import cstjean.mobile.ecole.travail.SingletonEcole;

public class AjoutCoursActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_cours);
    }

    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, AjoutCoursActivity.class);
        return intent;
    }
}