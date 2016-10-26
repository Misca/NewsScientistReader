package com.fasttrackit.newscientistreader.data.net;

import com.android.volley.Request;

/**
 * @author mihai.mecea
 */

public interface ApiConnector {

  <T> void addToRequestQueue(Request<T> req);

  void cancelAllRequest();

}
