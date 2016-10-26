package com.fasttrackit.newscientistreader.presentation.presenter.navigation;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import com.fasttrackit.newscientistreader.R;

/**
 * @author mihai.mecea
 */

public class FragmentNavigator {

  private static final int CONTAINER_ID = R.id.content_drawer;

  private FragmentManager fragmentManager;

  public FragmentNavigator(FragmentManager fragmentManager) {
    this.fragmentManager = fragmentManager;
  }

  public void addFragmentWithBackstack(Fragment fragment) {
    FragmentTransaction transaction = fragmentManager.beginTransaction();

    transaction.add(CONTAINER_ID, fragment, fragment.getTag());
    transaction.addToBackStack(null);

    transaction.commit();
  }

  public void addFragmentWithoutBackstack(Fragment fragment) {
    FragmentTransaction transaction = fragmentManager.beginTransaction();

    transaction.add(CONTAINER_ID, fragment, fragment.getTag());

    transaction.commit();
  }

  public void replaceFragmentWithBackstack(Fragment fragment) {
    FragmentTransaction transaction = fragmentManager.beginTransaction();

    transaction.replace(CONTAINER_ID, fragment, fragment.getTag());
    transaction.addToBackStack(null);

    transaction.commit();
  }

  public void replaceFragmentWithoutBackstack(Fragment fragment) {
    FragmentTransaction transaction = fragmentManager.beginTransaction();

    transaction.replace(CONTAINER_ID, fragment, fragment.getTag());

    transaction.commit();
  }

}
