package com.fasttrackit.newscientistreader.presentation.model.mapper;

import com.fasttrackit.newscientistreader.data.model.ArticleDataModel;
import com.fasttrackit.newscientistreader.data.model.ArticleListDataModel;
import com.fasttrackit.newscientistreader.data.model.mapper.Mapper;
import com.fasttrackit.newscientistreader.presentation.model.ArticleListViewModel;
import com.fasttrackit.newscientistreader.presentation.model.ArticleViewModel;

/**
 * @author mihai.mecea
 */

public class ArticlesListMapper implements Mapper<ArticleListDataModel, ArticleListViewModel> {

  @Override
  public ArticleListViewModel map(ArticleListDataModel model) {
    ArticleListViewModel viewModel = new ArticleListViewModel();

    for(ArticleDataModel dataModel : model.articleDataModelList) {
      ArticleViewModel articleViewModel = new ArticleViewModel();

      articleViewModel.author = dataModel.author;
      articleViewModel.description = dataModel.description;
      articleViewModel.title = dataModel.title;
      articleViewModel.url = dataModel.url;
      articleViewModel.urlImage = dataModel.urlImage;
      articleViewModel.date = formatArticleDate(dataModel.date);

      viewModel.articleDataModelList.add(articleViewModel);
    }

    return viewModel;
  }

  private String formatArticleDate(String date) {
    //TODO extra: make this method return a date in the format "DD MON 'YY", example "26 Oct '16"
    return null;
  }

}
