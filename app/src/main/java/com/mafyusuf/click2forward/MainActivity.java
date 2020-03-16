 package com.mafyusuf.click2forward;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
    }

    public void passmessage(View view) {
        EditText ed = (EditText)findViewById( R.id.messaged );
        Intent intent = new Intent( Intent.ACTION_SEND);
        intent.setType( "text/plain" );
        String st = ed.getText().toString();
        intent.putExtra( Intent.EXTRA_TEXT,st);
        Intent chooseint = Intent.createChooser(intent,"Forward Message...");
        startActivity( chooseint );


    }

    public void Exit(View view) {
        //tot
        AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);
        ab.setMessage( "Do You Wants To Exit !!" ).setCancelable( false ).setPositiveButton( "Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        } ).setNegativeButton( "No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        } ).show();
    }

}
