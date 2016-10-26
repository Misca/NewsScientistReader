package com.fasttrackit.newscientistreader.presentation.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mihai.mecea
 */

public class ArticleListViewModel {

  public List<ArticleViewModel> articleDataModelList;

  public ArticleListViewModel() {
    this.articleDataModelList = new ArrayList<>();
  }

}
