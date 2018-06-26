package in.akra_ubuntu.mcsqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class treat_new extends AppCompatActivity {

    DatabaseHelper myDb;
    TextView tv;
    EditText pid, treatment_date, slot, diagnosis, editprescription, editremarks;
    Button onclicksubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treat_new);

        myDb = new DatabaseHelper(this);

        Intent i = getIntent();
        String username = i.getStringExtra(Intent.EXTRA_TEXT);
        //tv.setText(username);

        pid = (EditText) findViewById(R.id.editPid);
//        did = (EditText) findViewById(R.id.editMid);
        treatment_date = (EditText) findViewById(R.id.treatmentdate);
        slot = (EditText) findViewById(R.id.treatmentslot);
        diagnosis = (EditText) findViewById(R.id.diagnosis);
        editprescription = (EditText) findViewById(R.id.prescription);
        editremarks = (EditText) findViewById(R.id.remarks);

        onclicksubmit = (Button) findViewById(R.id.submit_treatment);
            submit_details(username);
    }

    public  void submit_details(final String username) {
        onclicksubmit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        boolean is_inserted = myDb.insert_treatment_details(
                                username,
                                pid.getText().toString(),
                                treatment_date.getText().toString(),
                                slot.getText().toString(),
                                diagnosis.getText().toString(),
                                editprescription.getText().toString(),
                                editremarks.getText().toString()
                        );
                        if (is_inserted)
                            Toast.makeText(treat_new.this, "Successful !", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(treat_new.this, "Unsuccessful !", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }


}
