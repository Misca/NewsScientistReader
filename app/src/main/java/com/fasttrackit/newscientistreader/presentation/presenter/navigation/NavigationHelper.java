package com.fasttrackit.newscientistreader.presentation.presenter.navigation;

import android.app.Fragment;
import com.fasttrackit.newscientistreader.presentation.view.fragment.FragmentFactory;
import com.fasttrackit.newscientistreader.presentation.view.listener.OnNavigateToScreenListener;

/**
 * @author mihai.mecea
 */

public class NavigationHelper implements OnNavigateToScreenListener {

  private FragmentNavigator fragmentNavigator;
  private FragmentFactory fragmentFactory;

  public NavigationHelper(FragmentNavigator fragmentNavigator) {
    this.fragmentNavigator = fragmentNavigator;
    this.fragmentFactory = new FragmentFactory();
  }

  @Override
  public void onNavigateToBoxOffice() {
    Fragment fragment = fragmentFactory.getMoviesListFragment();
    fragmentNavigator.replaceFragmentWithoutBackstack(fragment);
  }

  @Override
  public void onNavigateToWatchList() {

  }

}
