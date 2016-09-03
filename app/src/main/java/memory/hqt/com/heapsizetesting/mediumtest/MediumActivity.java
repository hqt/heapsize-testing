package memory.hqt.com.heapsizetesting.mediumtest;

import android.os.Bundle;
import android.util.Log;

import memory.hqt.com.heapsizetesting.core.HeapTestApplication;
import memory.hqt.com.heapsizetesting.core.InfoActivity;

/**
 * Try to test allocating a medium memory
 * This is big, but not enough to throw exception
 */
public class MediumActivity extends InfoActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.e("hqthao", "allocated medium size memory for MediumActivity");
        try {
            byte[] mediumData = new byte[HeapTestApplication.getRealAllowMemory() * 9 / 10 * 1000 * 1000];

            // if allocate success, finish this activity
            finish();
        } catch (OutOfMemoryError e) {
            displayAlertDialog("Error", "OutOfMemory Exception");
        }
    }
}
