package me.sharma.vardan.healtyfy.ui;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.squareup.picasso.Picasso;

import java.util.List;

import me.sharma.vardan.healtyfy.R;
import me.sharma.vardan.healtyfy.data.ApiClient;
import me.sharma.vardan.healtyfy.data.EventsListWrapper;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import timber.log.Timber;

import static me.sharma.vardan.healtyfy.util.CommonUtil.toast;

/**
 * Implementation of App Widget functionality.
 * App Widget Configuration implemented in {@link HealthifyMeConfigureActivity HealthifyMeConfigureActivity}
 */
public class HealthifyMe extends AppWidgetProvider {

    private static final String NEXT_CLICKED = "next_click";
    private static final String PREV_CLICKED = "prev_click";
    private static List<EventsListWrapper.ResponseBean> eventList;
    private static int position = 0;
    public static final String WIDGET_IDS_KEY = "mywidgetproviderwidgetids";
    private Subscription subscription;


    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        if (NEXT_CLICKED.equals(intent.getAction())) {
            toast("Showing");
            updateAppWidget(context,new AppWidgetManager(),);
        }
    }

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {
        CharSequence widgetText = HealthifyMeConfigureActivity.loadTitlePref(context, appWidgetId);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.healthify_me);
        if (eventList == null) return;
        EventsListWrapper.ResponseBean event = eventList.get(position);
        views.setTextViewText(R.id.appwidget_text, widgetText);
        views.setTextViewText(R.id.txt_start_date, event.getDate());
        views.setTextViewText(R.id.txt_close_date, event.getEnd_date());
        views.setTextViewText(R.id.txt_event_type, event.getChallenge_type());
        views.setTextViewText(R.id.txt_title, event.getTitle());
        views.setTextViewText(R.id.txt_desc, event.getDescription());

        views.setOnClickPendingIntent(R.id.btn_next, getPendingSelfIntent(context, NEXT_CLICKED));
        views.setOnClickPendingIntent(R.id.btn_next, getPendingSelfIntent(context, PREV_CLICKED));

        if (event.getThumbnail() != null)
            Picasso.with(context)
                    .load(event.getThumbnail())
                    .error(R.drawable.example_appwidget_preview)
                    .into(views, R.id.img_event, new int[]{appWidgetId});
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        // When the user deletes the widget, delete the preference associated with it.
        for (int appWidgetId : appWidgetIds) {
            HealthifyMeConfigureActivity.deleteTitlePref(context, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
        subscription = ApiClient.getInstance()
                .getEvents()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<EventsListWrapper>() {
                    @Override
                    public void call(EventsListWrapper eventsListWrapper) {
                        eventList = eventsListWrapper.getResponse();
                        Timber.d(eventsListWrapper.toString());
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Timber.e(throwable.getMessage());
                    }
                });

    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }


    protected static PendingIntent getPendingSelfIntent(Context context, String action) {
        Intent intent = new Intent(context, HealthifyMe.class);
        intent.setAction(action);
        return PendingIntent.getBroadcast(context, 0, intent, 0);
    }
}

