package com.example.william.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText Message;
    private Button Send;
    private Button Clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        Send.setEnabled(false);

        Message.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().equals("")){
                    Send.setEnabled(false);
                }
                else{
                    Send.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void init(){
        Message = findViewById(R.id.etMessage);
        Send = findViewById(R.id.btSend);
        Clear = findViewById(R.id.btClear);
    }



    public void onClearClick(View view) {
        Message.getText().clear();
    }

    public void onSendClick(View view) {
        Intent sendMsgIntent = new Intent();
        sendMsgIntent.setAction(Intent.ACTION_SEND);
        sendMsgIntent.putExtra(Intent.EXTRA_TEXT, Message.getText().toString());
        sendMsgIntent.setType("text/plain");
        startActivity(sendMsgIntent);
    }
}
