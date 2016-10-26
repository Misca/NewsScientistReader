package com.fasttrackit.newscientistreader.data.interactor;

import com.fasttrackit.newscientistreader.data.net.ApiConnectorImpl;

/**
 * @author mihai.mecea
 */

public abstract class BaseInteractor {

  public String getUrl() {
    return ApiConnectorImpl.API_BASE_URL + getUrlPath();
  }

  protected abstract String getUrlPath();

}
