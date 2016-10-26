package com.fasttrackit.newscientistreader.presentation.view.proxy;

import com.fasttrackit.newscientistreader.presentation.model.ArticleViewModel;

import java.util.List;

/**
 * @author mihai.mecea
 */

public interface ArticleListProxyView extends BaseProxyView {

  void setListData(List<ArticleViewModel> articleList);

}
