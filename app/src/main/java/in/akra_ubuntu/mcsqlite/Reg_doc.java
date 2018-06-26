package in.akra_ubuntu.mcsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Reg_doc extends AppCompatActivity {

    DatabaseHelper db;

    EditText fullname, username, specialisation, shift_type, mobile_no, sex, age, password;
    Button RegDoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_doc);

        db = new DatabaseHelper(this);

        fullname = (EditText) findViewById(R.id.editTextName);
        username = (EditText) findViewById(R.id.editusername);
        specialisation = (EditText) findViewById(R.id.specialization);
        shift_type = (EditText) findViewById(R.id.editshift);
        mobile_no = (EditText) findViewById(R.id.editMobileNumber2);
        sex = (EditText) findViewById(R.id.editgender2);
        age = (EditText) findViewById(R.id.editAge2);
        password = (EditText) findViewById(R.id.editTextPassword2);

        RegDoc = (Button) findViewById(R.id.buttonRegister2);
        register_doc();
    }


    public void register_doc() {
        RegDoc.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean is_inserted = db.insert_doc(fullname.getText().toString(),
                                username.getText().toString(),
                                specialisation.getText().toString(),
                                shift_type.getText().toString(),
                                mobile_no.getText().toString(),
                                sex.getText().toString(),
                                age.getText().toString(),
                                password.getText().toString()
                        );

                        if (is_inserted == true)
                            Toast.makeText(Reg_doc.this, "Registered successfully", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Reg_doc.this, "Doctor not registered", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }



}
