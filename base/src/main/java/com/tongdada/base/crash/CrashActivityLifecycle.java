package com.tongdada.base.crash;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

/**
 * description：
 * <p>
 * author： DS.Hu
 * <p>
 * time： 2018/8/6 19:59
 * <p>
 */
public class CrashActivityLifecycle implements Application.ActivityLifecycleCallbacks {

    private List<Activity> activities = new ArrayList<>();

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        activities.add(activity);
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        activities.remove(activity);
    }


    public void finishActivities() {
        for (Activity activity : activities) {
            if (activity != null) {
                activity.finish();
                activity.overridePendingTransition(0, 0);
            }
        }
        activities.clear();
    }
}
