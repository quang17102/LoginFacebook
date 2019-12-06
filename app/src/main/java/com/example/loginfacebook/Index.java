package com.example.loginfacebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Index extends AppCompatActivity {
    Button logOut;
    TextView tv;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        logOut = (Button)findViewById(R.id.LogOut);
        tv = (TextView)findViewById(R.id.showInf);

        mAuth = FirebaseAuth.getInstance();
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        Log.d("Hello",currentUser.getDisplayName());
//        Profile profile = Profile.getCurrentProfile();
//        Log.d("Hello",profile.getFirstName());




        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                LoginManager.getInstance().logOut();
                finish();
                startActivity(new Intent(Index.this, MainActivity.class));
                Toast.makeText(Index.this, "Đăng xuất", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
