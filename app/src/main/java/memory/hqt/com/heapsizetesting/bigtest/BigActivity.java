package memory.hqt.com.heapsizetesting.bigtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import memory.hqt.com.heapsizetesting.core.HeapTestApplication;
import memory.hqt.com.heapsizetesting.core.InfoActivity;

/**
 * Try to test allocating a big memory out size of allowable range
 * this activity will be throw exception OutOfMemory
 */
public class BigActivity extends InfoActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            byte[] bigData = new byte[HeapTestApplication.getRealAllowMemory() * 1000 * 1000];
        } catch (OutOfMemoryError e) {
            displayAlertDialog("Error", "OutOfMemory Exception");
        }
    }
}
