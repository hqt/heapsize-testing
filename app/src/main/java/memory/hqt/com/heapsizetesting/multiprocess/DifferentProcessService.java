package memory.hqt.com.heapsizetesting.multiprocess;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import memory.hqt.com.heapsizetesting.core.HeapTestApplication;

public class DifferentProcessService extends Service {

    byte[] data;

    public DifferentProcessService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("hqthao", "allocated medium size for DifferentProcessService");

        // reset data again before allocating new memory
        data = null;

        data = new byte[HeapTestApplication.getRealAllowMemory() * 9 / 10 * 1000 * 1000];
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        data = null;
        Log.e("hqthao", "Stop DiffProcessService");
        super.onDestroy();
    }
}
