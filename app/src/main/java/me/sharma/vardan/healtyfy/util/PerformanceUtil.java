package me.sharma.vardan.healtyfy.util;

import android.os.StrictMode;

import me.sharma.vardan.healtyfy.BuildConfig;


/**
 * Created by krishan on 28/11/14.
 * This class contains methods that are useful for performance analysis.
 * Other ways-
 * 1.Strict mode enable in developer options
 * 2.Don't keep activities enabled
 * 3.Gpu Overdraw setting
 * 4.Hierarchy viewer in Device monitor
 * <p/>
 * Tips
 * 1.Use apply instead of commit in Shared preferences if you are not using the result.
 */
public class PerformanceUtil {

    /**
     * Alternatively enable Strict mode enable on device Developer settings
     */
    public static void enableStrictMode() {
        if (BuildConfig.LOG_HTTP_REQUESTS) {
            // Activate StrictMode
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .detectDiskReads()
                    .detectDiskWrites()
                    .detectNetwork()
                    .penaltyLog()
                    .penaltyDeath()
                    .build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectLeakedSqlLiteObjects()
                            // alternatively .detectAll() for all detectable problems
                    .penaltyLog()
                    .penaltyDeath()
                    .build());
        }
    }


}
