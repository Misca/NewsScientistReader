package com.fasttrackit.newscientistreader.data.interactor;

import com.fasttrackit.newscientistreader.data.net.ApiConnector;

/**
 * @author mihai.mecea
 */

public class InteractorFactory {

  private ApiConnector apiConnector;

  public InteractorFactory(ApiConnector apiConnector) {
    this.apiConnector = apiConnector;
  }

  public ArticlesInteractor getArticlesInteractor() {
    ArticlesInteractor interactor = new ArticlesInteractor(apiConnector);
    return interactor;
  }

}
