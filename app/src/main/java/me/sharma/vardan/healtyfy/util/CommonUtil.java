package me.sharma.vardan.healtyfy.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import timber.log.Timber;

import static me.sharma.vardan.healtyfy.core.HealthyApp.getContext;

public class CommonUtil {
    private CommonUtil() {
    }

    public static
    @Nullable
    String getAndroidId() {
        Context context = getContext();
        String androidID;
        androidID = Settings.Secure.getString(context.getContentResolver(),
                Settings.Secure.ANDROID_ID);
        return androidID;
    }

    public static void toast(@NonNull String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public static void longToast(@NonNull String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_LONG).show();
    }


    public static void toast(@StringRes int msg) {
        Toast.makeText(getContext(), getContext().getText(msg), Toast.LENGTH_SHORT).show();
    }

    public static void longToast(@StringRes int msg) {
        Toast.makeText(getContext(), getContext().getText(msg), Toast.LENGTH_LONG).show();
    }

    /**
     * Provides the package name for the application
     * we can use this method instead of hard coding it
     */

    public static String getPackageName() {
        return getContext().getPackageName();
    }


    /**
     * Converts DP into pixels
     *
     * @param dp the size of pixels in dp
     * @return returns the pixels value of the input
     */
    public static int dpToPixels(int dp) {
        Resources r = getContext().getResources();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics());
    }


    public static void hideKeyboard(Activity activity) {
        if (activity.getCurrentFocus() == null) {
            Timber.e("get Current Focus is null");
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }


    public static Drawable getDrawable(int id) {
        final int version = Build.VERSION.SDK_INT;
        return (version >= Build.VERSION_CODES.LOLLIPOP)
                ? ContextCompat.getDrawable(getContext(), id)
                : getContext().getResources().getDrawable(id);
    }

    public static int getScreenWidth(Activity activity) {
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics.widthPixels;
    }


//    public static Snackbar showErrorSnackBar(View view, @StringRes int message) {
//        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
//        ViewGroup group = (ViewGroup) snackbar.getView();
//        group.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.snackbar_error));
//        snackbar.show();
//        return snackbar;
//    }
//
//
//    public static Snackbar showSuccessSnackBar(View view, @StringRes int message) {
//        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
//        ViewGroup group = (ViewGroup) snackbar.getView();
//        group.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.snackbar_success));
//        snackbar.show();
//        return snackbar;
//    }


    public static int getScreenHeight(Activity activity) {
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics.heightPixels;
    }
}

