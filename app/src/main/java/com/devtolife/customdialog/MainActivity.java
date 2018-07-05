package com.devtolife.customdialog;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Handler mHandler = new Handler();
    static int j = 0;
    Button btnStartDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartDialog = (Button) findViewById(R.id.button_start_dialog);
        btnStartDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                j = 0;
                mHandler.removeCallbacks(timeUpdaterRunnable);
                mHandler.postDelayed(timeUpdaterRunnable, 0);

            }
        });
    }

    private final Runnable timeUpdaterRunnable = new Runnable() {

        public void run() {

            if (j == 10) {
                mHandler.removeCallbacks(timeUpdaterRunnable);
                openDialogTicketsGenerated();
            } else {

                Toast.makeText(
                        getApplicationContext(),
                        "Dialog start in " + (10 - j) + " seconds",
                        Toast.LENGTH_SHORT
                ).show();
                //try update every 2 second
                j += 2;
                mHandler.postDelayed(this, 2000);
            }
        }
    };

    private void openDialogTicketsGenerated() {
        Intent intent = new Intent(this, AlertDialogue.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
