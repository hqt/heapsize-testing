package memory.hqt.com.heapsizetesting.core;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * Created by Huynh Quang Thao on 8/16/16.
 */
public class HeapTestApplication extends Application {


    private static int maxAllowMemory;
    private static int realAllowMemory;

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();

        // Reference: http://stackoverflow.com/questions/2630158/detect-application-heap-size-in-android

        Runtime rt = Runtime.getRuntime();
        maxAllowMemory = (int) (rt.maxMemory() / (1000 * 1000));
        Log.e("hqthao", "max memory can allocated:" + maxAllowMemory + " MB");

        ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        realAllowMemory = am.getMemoryClass();
        Log.e("hqthao", "max memory should allocated:" + realAllowMemory + " MB");

    }

    public static int getMaxAllowMemory() {
       return maxAllowMemory;
    }

    public static int getRealAllowMemory() {
       return realAllowMemory;
    }

    public static long getTotalMemory() {
        ActivityManager actManager = (ActivityManager) context.getSystemService(ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memInfo = new ActivityManager.MemoryInfo();
        actManager.getMemoryInfo(memInfo);
        return  memInfo.totalMem / (1000 * 1000);
    }

    public static long getAvailableMemory() {
        ActivityManager actManager = (ActivityManager) context.getSystemService(ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memInfo = new ActivityManager.MemoryInfo();
        actManager.getMemoryInfo(memInfo);
        return  memInfo.availMem / (1000 * 1000);
    }

}
