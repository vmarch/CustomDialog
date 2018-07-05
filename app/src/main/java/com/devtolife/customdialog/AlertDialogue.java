package com.devtolife.customdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class AlertDialogue extends AppCompatActivity {

    Button btnOk;
    TextView textDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_alert_dialogue);

        textDialog = (TextView)findViewById(R.id.text_dialog) ;
        textDialog.setText("Hello, I'm the dialog text!");

        btnOk = (Button) findViewById(R.id.button_dialog);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}