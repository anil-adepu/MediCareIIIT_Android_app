package in.akra_ubuntu.mcsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    DatabaseHelper myDb;

    EditText editUsername, editMobNumber, edithostelname, editdob, editgender, editFullName, editPassword, editage, editroom, editweight, editblood;
    Button buttonreg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        myDb = new DatabaseHelper(this);

        editFullName = (EditText) findViewById(R.id.editTextFullName);
        editUsername = (EditText) findViewById(R.id.editTextUsername);
        editgender = (EditText) findViewById(R.id.editGender);
        editweight = (EditText) findViewById(R.id.editWeight);
        editage = (EditText) findViewById(R.id.editAge);
        editdob = (EditText) findViewById(R.id.editDOB);
        editblood = (EditText) findViewById(R.id.editBlood);
        editMobNumber = (EditText) findViewById(R.id.editMobileNumber);
        edithostelname = (EditText) findViewById(R.id.editHostelName);
        editroom = (EditText) findViewById(R.id.editRoom);
        editPassword = (EditText) findViewById(R.id.editTextPassword);

        buttonreg = (Button) findViewById(R.id.buttonRegister);
        register_pat();
    }

    public void register_pat() {
        buttonreg.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean is_inserted = myDb.insert_pat(
                                editFullName.getText().toString(),
                                editUsername.getText().toString(),
                                editgender.getText().toString(),
                                editweight.getText().toString(),
                                editage.getText().toString(),
                                editdob.getText().toString(),
                                editblood.getText().toString(),
                                editMobNumber.getText().toString(),
                                edithostelname.getText().toString(),
                                editroom.getText().toString(),
                                editPassword.getText().toString()

                        );

                        if (is_inserted)
                            Toast.makeText(Register.this, "Registered successfully!", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Register.this, "Patient not registered!", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }



}










