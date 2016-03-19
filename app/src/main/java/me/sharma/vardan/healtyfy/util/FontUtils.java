package me.sharma.vardan.healtyfy.util;

import android.widget.TextView;

import uk.co.chrisjenx.calligraphy.CalligraphyUtils;

import static me.sharma.vardan.healtyfy.core.HealthyApp.getContext;


/**
 * Created by krishan on 21/12/15.
 */
public class FontUtils {

    public static void applyFontToTextView(TextView view, String filePath) {
        CalligraphyUtils.applyFontToTextView(getContext(), view, filePath);
    }
}
