package com.example.twoactivitiesproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY =
            "com.example.android.twoactivities.extra.REPLY";
    Button btnReply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView txtView = findViewById(R.id.txtShowMessage);
        Intent callerIntent = getIntent();
        String strMessage =  callerIntent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        if (strMessage != null) {
            txtView.setText(strMessage);
        }

        btnReply = findViewById(R.id.btnReply);
        btnReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                EditText replyMessage = findViewById(R.id.editTxtReply);
                String strReplyMessage = replyMessage.getText().toString();
                replyIntent.putExtra(EXTRA_REPLY,strReplyMessage);
                setResult(RESULT_OK, replyIntent);
                finish();
            }
        });
    }
}