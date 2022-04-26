package com.example.twoactivitiesproject;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int TEXT_REQUEST = 1;
    TextView txtMessageReply;
    Button btnSend;
    EditText edtMessage;
    public static final String EXTRA_MESSAGE = "learn.android.twoactivities";

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        txtMessageReply = findViewById(R.id.txtMessageReply);
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply =
                        data.getStringExtra(SecondActivity.EXTRA_REPLY);
                txtMessageReply.setText(reply);
                txtMessageReply.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMessageReply = findViewById(R.id.txtMessageReply);
        edtMessage = findViewById(R.id.edtMessage);
        btnSend = findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, SecondActivity.class);
                String strMessage = edtMessage.getText().toString();
                myIntent.putExtra(EXTRA_MESSAGE, strMessage);
                startActivityForResult(myIntent, TEXT_REQUEST);
            }
        });
    }
}