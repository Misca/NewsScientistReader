package com.fasttrackit.newscientistreader.data.request;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * @author mihai.mecea
 */

public class GsonRequest<T> extends Request<T> {
  private final Gson gson = new Gson();
  private final Class<T> clazz;
  private final Map<String, String> headers;
  private final Map<String, String> params;
  private final RequestListener<T> listener;

  /**
   * Make a GET request and return a parsed object from JSON.
   *
   * @param url URL of the request to make
   * @param clazz Relevant class object, for Gson's reflection
   * @param headers Map of request headers
   */
  public GsonRequest(String url, Class<T> clazz, Map<String, String> headers, Map<String, String> params, RequestListener requestListener) {
    super(Method.GET, url, requestListener);
    this.clazz = clazz;
    this.headers = headers;
    this.params = params;
    this.listener = requestListener;
  }

  @Override
  public Map<String, String> getHeaders() throws AuthFailureError {
    return headers != null ? headers : super.getHeaders();
  }

  @Override
  protected Map<String, String> getParams() throws AuthFailureError {
    return params != null ? params : super.getParams();
  }

  @Override
  protected void deliverResponse(T response) {
    listener.onResponse(response);
  }

  @Override
  protected Response<T> parseNetworkResponse(NetworkResponse response) {
    try {
      String json = new String(
          response.data,
          HttpHeaderParser.parseCharset(response.headers));
      return Response.success(
          gson.fromJson(json, clazz),
          HttpHeaderParser.parseCacheHeaders(response));
    } catch (UnsupportedEncodingException e) {
      return Response.error(new ParseError(e));
    } catch (JsonSyntaxException e) {
      return Response.error(new ParseError(e));
    }
  }

}
