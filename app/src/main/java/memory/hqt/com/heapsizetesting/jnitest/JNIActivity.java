package memory.hqt.com.heapsizetesting.jnitest;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;

import memory.hqt.com.heapsizetesting.R;
import memory.hqt.com.heapsizetesting.core.HeapTestApplication;
import memory.hqt.com.heapsizetesting.core.InfoActivity;

public class JNIActivity extends InfoActivity {

    static {
        System.loadLibrary("large-memory-jni");
    }

    public native String getMsgFromJni();

    public native Object getBigDataFromJni(int memory);

    public native void deallocateData(Object object);

    private final String text = "Programmer can assign large memory outside of allowable memory under native layer. " +
            "Native layer cannot be reclaimed by Garbage Collector, so we must manually allocate and free memory by hand";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        infoTextView.setText(text);

        processButton.setText("Allocate native memory");
        processButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ByteBuffer data = (ByteBuffer) getBigDataFromJni(HeapTestApplication.getRealAllowMemory() * 1000 * 1000);
                int size = data.remaining() / (1000 * 1000);
                int avail = (int) HeapTestApplication.getAvailableMemory();

                new AlertDialog.Builder(JNIActivity.this)
                        .setTitle("Information")
                        .setMessage("Native Object size: " + size + " MB\n" +
                                    "Available memory: " + avail + " MB")
                        .setCancelable(false)
                        .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // deallocate data manually. if not. we will meet memory leak here
                                deallocateData(data);

                                dialogInterface.dismiss();
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });
    }
}

