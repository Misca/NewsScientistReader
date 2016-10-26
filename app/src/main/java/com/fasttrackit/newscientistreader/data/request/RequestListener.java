package com.fasttrackit.newscientistreader.data.request;

import android.util.Log;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.fasttrackit.newscientistreader.data.model.mapper.Mapper;

/**
 * @author mihai.mecea
 */

public class RequestListener <T> implements Response.Listener<T>, Response.ErrorListener{

  private RequestListenerDelegate listenerDelegate;
  private Mapper dataToViewModelMapper;

  private static final String TAG = RequestListener.class.getName();

  public RequestListener(RequestListenerDelegate listenerDelegate, Mapper dataToViewModelMapper) {
    this.listenerDelegate = listenerDelegate;
    this.dataToViewModelMapper = dataToViewModelMapper;
  }

  @Override
  public void onErrorResponse(VolleyError error) {
    listenerDelegate.onError(error.getMessage());
    Log.e(TAG, "onErrorResponse:" + error.toString());
  }

  @Override
  public void onResponse(T response) {
    listenerDelegate.onResponse(dataToViewModelMapper.map(response));
  }


  public interface RequestListenerDelegate<T> {
    void onError(String errorMessage);
    void onResponse(T response);
  }

}
