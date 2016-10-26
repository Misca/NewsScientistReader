package com.fasttrackit.newscientistreader.presentation.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fasttrackit.newscientistreader.R;
import com.fasttrackit.newscientistreader.presentation.model.ArticleViewModel;
import com.fasttrackit.newscientistreader.presentation.presenter.ArticleListPresenter;
import com.fasttrackit.newscientistreader.presentation.view.proxy.ArticleListProxyView;

import java.util.List;

/**
 * @author mihai.mecea
 */

public class ArticleListFragment extends FragmentBase implements ArticleListProxyView {

  private ArticleListPresenter presenter;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    presenter = new ArticleListPresenter(getInteractorFactory());
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    return inflater.inflate(R.layout.articles_list_fragment, container, false);
  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    presenter.onViewCreated(this);
  }

  @Override
  public void initViews() {
    //TODO: you should set the custom adapter nad layout manager on the recycler view here
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    presenter.onViewDestroyed();
  }

  @Override
  public void setListData(List<ArticleViewModel> articleList) {

  }

}
