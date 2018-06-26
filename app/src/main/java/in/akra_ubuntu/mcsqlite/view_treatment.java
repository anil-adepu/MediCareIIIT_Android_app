package in.akra_ubuntu.mcsqlite;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class view_treatment extends AppCompatActivity {
    DatabaseHelper myDb;
    Button viewall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_treatment);

    Intent i = getIntent();
    String user = i.getStringExtra(Intent.EXTRA_TEXT);
    //tv.setText(user);

    myDb = new DatabaseHelper(this);
    viewall = findViewById(R.id.viewAllmyData);
        viewmydata(user);
    }

    public void viewmydata(final String user) {
        viewall.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor out = myDb.getPatData(user);
                        if (out.getCount() == 0) {
                            //error message
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
                        show_message("All my Treatment Details :",buffer.toString());
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


}
