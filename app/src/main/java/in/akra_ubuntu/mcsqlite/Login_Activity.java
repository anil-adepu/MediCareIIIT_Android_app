package in.akra_ubuntu.mcsqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login_Activity extends AppCompatActivity {

    Button PatLog, DocLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);

       PatLog = findViewById(R.id.PatLogin);
       login_pat();

       DocLog = findViewById(R.id.DocLogin);
       login_doc();
    }

    public void login_pat() {
        PatLog.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v1) {
                        Intent launch_patient = new Intent(Login_Activity.this,patient_login.class);
                        startActivity(launch_patient);
                    }
                }
        );
    }

    public void login_doc() {
        DocLog.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v2) {
                        Intent launch_doctor = new Intent(Login_Activity.this,Doctor_login.class);
                        startActivity(launch_doctor);
                    }
                }
        );
    }


}




