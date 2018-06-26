package in.akra_ubuntu.mcsqlite;

import android.content.Intent;
import android.database.Cursor;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class edit_treatment extends AppCompatActivity {
    DatabaseHelper myDb;
    TextView tv;
    Button new_pat, viewdata ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_treatment);

        //ImageView image = (Image)
        myDb = new DatabaseHelper(this);

        Intent i = getIntent();
        String username = i.getStringExtra(Intent.EXTRA_TEXT);
        //tv.setText(username);

        viewdata = findViewById(R.id.ViewAllPatData);
            ViewAllData(username);

        new_pat = findViewById(R.id.treatnewpat2);
            treat_new_pat(username);
    }

    public void ViewAllData(final String userid) {
        viewdata.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor out = myDb.getDocAttendedData(userid);
                        if (out.getCount() == 0) {
                            //error mess
                            show_message("Error","No Data Found !");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (out.moveToNext()) {
                            buffer.append("Pid :\t\t" + out.getString(0) + "\n");
                            buffer.append("Did :\t\t" + out.getString(1) + "\n");
                            buffer.append("Treatment_date :\t\t" + out.getString(2) + "\n");
                            buffer.append("Slot :\t\t" + out.getString(3) + "\n");
                            buffer.append("Diagnosis :\t\t" + out.getString(4) + "\n");
                            buffer.append("Prescription :\t\t" + out.getString(5) + "\n");
                            buffer.append("Remarks :\t\t" + out.getString(6) + "\n\n\n");
                        }
                        //show all data
                        show_message("Details of all the patients",buffer.toString());
                    }
                }
        );
    }

    public void show_message( String Title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(Title);
        builder.setMessage(Message);
        builder.show();
    }

    public void treat_new_pat(final String userid) {
        new_pat.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent new_patient = new Intent(edit_treatment.this,treat_new.class);
                        new_patient.putExtra(Intent.EXTRA_TEXT,userid);
                        startActivity(new_patient);
                    }
                }
        );
    }

}
