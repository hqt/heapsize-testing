package memory.hqt.com.heapsizetesting.core;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

import memory.hqt.com.heapsizetesting.R;
import memory.hqt.com.heapsizetesting.bigtest.BigControllerActivity;
import memory.hqt.com.heapsizetesting.jnitest.JNIActivity;
import memory.hqt.com.heapsizetesting.mediumtest.MediumActivity;
import memory.hqt.com.heapsizetesting.mediumtest.MediumControllerActivity;
import memory.hqt.com.heapsizetesting.servicetest.ServiceControllerActivity;
import memory.hqt.com.heapsizetesting.multiprocess.DiffProcessControllerActivity;

public class MainActivity extends AppCompatActivity {

    Button infoButton;
    Button mediumActivityButton;
    Button bigActivityButton;
    Button mediumServiceButton;
    Button differentProcessServiceButton;
    Button nativeHeapButton;

    public static class Developer {
        private String mLastName;
        private String mFirstName;

        public String getLastName() {
            return mLastName;
        }

        public String getFirstName() {
            return mFirstName;
        }

        public String fullName() {
            return mFirstName + mLastName;
        }

        public String fullNameSlow() {
            return getFirstName() + getLastName();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infoButton = (Button) findViewById(R.id.info_memory_button);
        mediumActivityButton = (Button) findViewById(R.id.medium_memory_button);
        bigActivityButton = (Button) findViewById(R.id.big_memory_button);
        mediumServiceButton = (Button) findViewById(R.id.medium_service_button);
        differentProcessServiceButton = (Button) findViewById(R.id.different_process_button);
        nativeHeapButton = (Button) findViewById(R.id.native_memory_button);

        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), InfoActivity.class);
                startActivity(intent);
            }
        });

        mediumActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), MediumControllerActivity.class);
                startActivity(intent);
            }
        });

        bigActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), BigControllerActivity.class);
                startActivity(intent);
            }
        });

        mediumServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ServiceControllerActivity.class);
                startActivity(intent);
            }
        });

        differentProcessServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), DiffProcessControllerActivity.class);
                startActivity(intent);
            }
        });

        nativeHeapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), JNIActivity.class);
                startActivity(intent);
            }
        });
    }
}
