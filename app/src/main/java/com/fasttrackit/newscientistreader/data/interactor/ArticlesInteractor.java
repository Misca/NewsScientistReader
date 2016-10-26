package com.fasttrackit.newscientistreader.data.interactor;

import com.fasttrackit.newscientistreader.data.model.ArticleListDataModel;
import com.fasttrackit.newscientistreader.data.net.ApiConnector;
import com.fasttrackit.newscientistreader.data.net.ApiConnectorImpl;
import com.fasttrackit.newscientistreader.data.request.GsonRequest;
import com.fasttrackit.newscientistreader.data.request.RequestListener;

/**
 * @author mihai.mecea
 */

public class ArticlesInteractor extends BaseInteractor {

  private ApiConnector apiConnector;

  private final static String URL_ARTICLES = "/articles";
  private final static String SOURCE_NEW_SCIENTIST = "new-scientist";

  private final static String SOURCE_PARAM = "source";
  private final static String API_KEY = "apiKey";

  public ArticlesInteractor(ApiConnector apiConnector) {
    this.apiConnector = apiConnector;
  }

  public void getNewScientistArticles(RequestListener requestListener) {
    String url = getUrl();
    url = getParams(url);

    GsonRequest<ArticleListDataModel> gsonRequest = new GsonRequest(url, ArticleListDataModel.class, null,
        null, requestListener);

    apiConnector.addToRequestQueue(gsonRequest);
  }

  public void getArticle(RequestListener requestListener, String articleId) {

  }

  @Override
  protected String getUrlPath() {
    return URL_ARTICLES;
  }

  private String getParams(String url) {
    String params = "?";
    params += SOURCE_PARAM + "=" + SOURCE_NEW_SCIENTIST;
    params += "&" + API_KEY + "=" + ApiConnectorImpl.API_KEY;

    return url + params;
  }
}
