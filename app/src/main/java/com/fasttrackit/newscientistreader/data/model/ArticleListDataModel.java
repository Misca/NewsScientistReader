package com.fasttrackit.newscientistreader.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author mihai.mecea
 */

public class ArticleListDataModel {

  @SerializedName("articles")
  public List<ArticleDataModel> articleDataModelList;

}
