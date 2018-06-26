package in.akra_ubuntu.mcsqlite;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class patient_login extends AppCompatActivity {

    SQLiteDatabase db;
    SQLiteOpenHelper myDb;

    EditText login, password;
    Button login_pat;
    Button RegHere;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_login);

        myDb = new DatabaseHelper(this);
        db = myDb.getReadableDatabase();


        login = findViewById(R.id.loginuser1);
        password = findViewById(R.id.loginpassword1);

        login_pat = findViewById(R.id.loginbutton1);
            log_here1();

        RegHere = findViewById(R.id.registerhere1);
            reg_here1();
    }

    public void log_here1() {
        login_pat.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String id = login.getText().toString();
                        String pass = password.getText().toString();
                        cursor = db.rawQuery(" select * from " + DatabaseHelper.TABLE_NAME1 + " where "+ DatabaseHelper.Pid + " =? and " + DatabaseHelper.Password + " =? ", new String[]{id,pass});
                        if(cursor!=null) {
                            if(cursor.getCount() > 0 ) {
                                cursor.moveToNext();
                                Toast.makeText(getApplicationContext()," Logged in Successfully ! ", Toast.LENGTH_LONG).show();

                                Intent view_detail = new Intent(patient_login.this,view_treatment.class);
                                view_detail.putExtra(Intent.EXTRA_TEXT,id);
                                startActivity(view_detail);
                            }else {
                                Toast.makeText(getApplicationContext()," Error ! ", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                }
        );
    }

    public void reg_here1() {

        RegHere.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent reg_patient = new Intent(patient_login.this,Register.class);
                        startActivity(reg_patient);
                    }
                }
        );
    }

}
