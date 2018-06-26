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

public class Doctor_login extends AppCompatActivity {

    SQLiteOpenHelper myDb;
    SQLiteDatabase db;

    EditText login2, password2;
    Button login_doc;
    Button RegHere2;

    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_login);

        myDb = new DatabaseHelper(this);
        db = myDb.getReadableDatabase();

        login2 = findViewById(R.id.loginuser2);
        password2 = findViewById(R.id.loginpassword2);

        login_doc = findViewById(R.id.loginbutton2);
            log_here2();

        RegHere2 = findViewById(R.id.reghere2);
            reg_here2();
    }


    public void log_here2() {
        login_doc.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String id = login2.getText().toString();
                        String pass = password2.getText().toString();
                        cursor = db.rawQuery(" select * from " + DatabaseHelper.TABLE_NAME2 + " where "+ DatabaseHelper.colm_1 + " =? and " + DatabaseHelper.colm_2 + " =? ", new String[]{id,pass});
                        if(cursor!=null) {
                            if(cursor.getCount() > 0 ) {
                                cursor.moveToNext();
                                Toast.makeText(getApplicationContext()," Logged in Successfully!", Toast.LENGTH_LONG).show();

                                Intent edit_detail = new Intent(Doctor_login.this,edit_treatment.class);
                                edit_detail.putExtra(Intent.EXTRA_TEXT,id);
                                startActivity(edit_detail);
                            }else {
                                Toast.makeText(getApplicationContext()," Error! ", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                }
        );



    }

    public void reg_here2() {

        RegHere2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent reg_doctor = new Intent(Doctor_login.this,Reg_doc.class);
                        startActivity(reg_doctor);
                    }
                }
        );
    }

}
