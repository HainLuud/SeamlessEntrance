package cs.ut.ee.seamless_app3;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    private static final int PICKFILE_RESULT_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView addTicket = findViewById(R.id.addTicket);
        addTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chooseFile = new Intent(Intent.ACTION_GET_CONTENT);
                chooseFile.setType("*/*");
                chooseFile = Intent.createChooser(chooseFile, "Choose a file");
                startActivityForResult(chooseFile, PICKFILE_RESULT_CODE);
            }
        });
    }

    @Override

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICKFILE_RESULT_CODE) {
            if (resultCode == -1) {
                findViewById(R.id.ticket_constraint_layout).setVisibility(View.VISIBLE);
                findViewById(R.id.text_add_new).setVisibility(View.INVISIBLE);
                findViewById(R.id.textView7).setVisibility(View.VISIBLE);
                Toast.makeText(this, "Your ticket has been added! Just go to the ticket gate and tap your phone on the scanner", Toast.LENGTH_LONG).show();
            }
        }
    }
}