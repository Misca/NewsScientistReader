package com.fasttrackit.newscientistreader.data.net;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * @author mihai.mecea
 */

public class ApiConnectorImpl implements ApiConnector {

  public static final String API_BASE_URL = "https://newsapi.org/v1";
  public static final String API_KEY= "3b9e4aee5f9644de842a13481c508023";

  private static ApiConnectorImpl mInstance;
  private RequestQueue mRequestQueue;
  private static Context mCtx;

  private ApiConnectorImpl(Context context) {
    mCtx = context;
    mRequestQueue = getRequestQueue();
  }

  public static synchronized ApiConnectorImpl getInstance(Context context) {
    if (mInstance == null) {
      mInstance = new ApiConnectorImpl(context);
    }
    return mInstance;
  }

  @Override
  public <T> void addToRequestQueue(Request<T> req) {
    getRequestQueue().add(req);
  }

  @Override
  public void cancelAllRequest() {
    getRequestQueue().cancelAll(null);
  }

  public RequestQueue getRequestQueue() {
    if (mRequestQueue == null) {
      // getApplicationContext() is key, it keeps you from leaking the
      // Activity or BroadcastReceiver if someone passes one in.
      mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
    }
    return mRequestQueue;
  }

}
