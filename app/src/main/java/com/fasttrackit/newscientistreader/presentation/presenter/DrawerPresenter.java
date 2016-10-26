package com.fasttrackit.newscientistreader.presentation.presenter;

import com.fasttrackit.newscientistreader.R;
import com.fasttrackit.newscientistreader.presentation.presenter.navigation.NavigationHelper;
import com.fasttrackit.newscientistreader.presentation.view.proxy.DrawerProxyView;

/**
 * @author mihai.mecea
 */

public class DrawerPresenter implements PresenterBase<DrawerProxyView> {

  private DrawerProxyView view;
  private NavigationHelper navigationHelper;

  public DrawerPresenter(NavigationHelper navigationHelper) {
    this.navigationHelper = navigationHelper;
  }

  @Override
  public void onViewCreated(DrawerProxyView proxyView) {
    this.view = proxyView;

    this.view.initViews();
  }

  @Override
  public void onViewDestroyed() {

  }

  @Override
  public void onPause() {

  }

  public void onMenuItemSelected(int id) {
    switch (id) {
      case R.id.nav_new_scientist:
        navigationHelper.onNavigateToBoxOffice();
        break;
      case R.id.nav_saved_articles:
        navigationHelper.onNavigateToWatchList();
        break;

    }
  }

}
