package lk.portion.myapplication.App;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import lk.portion.myapplication.R;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 100;

    Button askAI, UploadDoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        askAI = findViewById(R.id.btn_ask_ai);
        UploadDoc = findViewById(R.id.btn_upload_pdf);
        checkPermissions();

        askAI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AIchat.class));
                Toast.makeText(MainActivity.this, " Move to Ask AI ", Toast.LENGTH_SHORT).show();
            }
        });

        UploadDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PDFAnswer.class));
                Toast.makeText(MainActivity.this, "Move to Upload PDF Page ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Function to check and request permissions
    public void checkPermissions() {
        checkPermission(android.Manifest.permission.INTERNET, PERMISSION_REQUEST_CODE);
        checkPermission(android.Manifest.permission.ACCESS_NETWORK_STATE, PERMISSION_REQUEST_CODE);
        checkPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE, PERMISSION_REQUEST_CODE);
        checkPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE, PERMISSION_REQUEST_CODE);
    }

    public void checkPermission(String permission, int requestCode) {
        if (ContextCompat.checkSelfPermission(MainActivity.this, permission) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{permission}, requestCode);
        } else {
            //Toast.makeText(MainActivity.this, "Permission already granted: " + permission, Toast.LENGTH_SHORT).show();
        }
    }

//    @Override
//    public void onBackPressed() {
//        // Do nothing, this will disable the back button
//    }


    @Override
    public void onBackPressed() {
        // kdkdkdk
    }
}
