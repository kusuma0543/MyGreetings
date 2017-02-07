package com.k3ench.mygreetings;

/**
 * Created by vignesh2514 on 1/28/2017.
 */

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by sweety on 1/11/2017.
 */

public class Demo extends Application {
    public static final String TAG=Demo.class.getSimpleName();
    private RequestQueue mRequestQueue;
    private static Demo mInstance;
    @Override
    public void onCreate()
    {
        super.onCreate();
        mInstance=this;
    }
    public static synchronized Demo getInstance()
    {
        return mInstance;
    }
    public RequestQueue getRequestQueue()
    {
        if(mRequestQueue==null){
            mRequestQueue= Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }
    public <T> void addToRequestQueue(Request<T> req)
    {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }
    public void cancelPendingRequests(Object tag)
    {
        if(mRequestQueue!=null)
        {
            mRequestQueue.cancelAll(tag);
        }
    }


}