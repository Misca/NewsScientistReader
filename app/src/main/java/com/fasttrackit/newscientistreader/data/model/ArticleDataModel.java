package com.fasttrackit.newscientistreader.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * @author mihai.mecea
 */

public class ArticleDataModel {

  @SerializedName("author")
  public String author;
  @SerializedName("title")
  public String title;
  @SerializedName("description")
  public String description;
  @SerializedName("url")
  public String url;
  @SerializedName("urlToImage")
  public String urlImage;
  @SerializedName("publishedAt")
  public String date;

}
