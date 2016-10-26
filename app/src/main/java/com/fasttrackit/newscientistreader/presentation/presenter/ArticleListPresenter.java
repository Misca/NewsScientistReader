package com.fasttrackit.newscientistreader.presentation.presenter;

import com.fasttrackit.newscientistreader.data.interactor.ArticlesInteractor;
import com.fasttrackit.newscientistreader.data.interactor.InteractorFactory;
import com.fasttrackit.newscientistreader.data.request.RequestListener;
import com.fasttrackit.newscientistreader.presentation.model.ArticleListViewModel;
import com.fasttrackit.newscientistreader.presentation.model.mapper.ArticlesListMapper;
import com.fasttrackit.newscientistreader.presentation.view.proxy.ArticleListProxyView;

/**
 * @author mihai.mecea
 */

public class ArticleListPresenter implements PresenterBase<ArticleListProxyView>,
    RequestListener.RequestListenerDelegate<ArticleListViewModel> {

  private ArticleListProxyView proxyView;

  private ArticlesInteractor interactor;

  public ArticleListPresenter(InteractorFactory factory) {
    this.interactor = factory.getArticlesInteractor();
  }


  @Override
  public void onViewCreated(ArticleListProxyView proxyView) {
    this.proxyView = proxyView;

    proxyView.initViews();

    RequestListener requestListener = new RequestListener<>(this, new ArticlesListMapper());
    interactor.getNewScientistArticles(requestListener);
  }

  @Override
  public void onViewDestroyed() {
    this.proxyView = null;
  }

  @Override
  public void onPause() {

  }

  @Override
  public void onError(String errorMessage) {
    //TODO: show the error using snackbar
    //proxyView.showError(errorMessage); // add this method to proxy and implement it...
  }

  @Override
  public void onResponse(ArticleListViewModel viewModel) {
    //TODO show the data in the recycler view list
    proxyView.setListData(viewModel.articleDataModelList);
  }

}
