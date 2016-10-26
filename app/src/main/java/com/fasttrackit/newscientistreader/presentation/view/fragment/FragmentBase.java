package com.fasttrackit.newscientistreader.presentation.view.fragment;

import android.app.Fragment;
import com.fasttrackit.newscientistreader.data.InteractorFactoryProvider;
import com.fasttrackit.newscientistreader.data.interactor.InteractorFactory;

/**
 * @author mihai.mecea
 */

public class FragmentBase extends Fragment {

  public InteractorFactory getInteractorFactory() {
    InteractorFactoryProvider factoryProvider = (InteractorFactoryProvider) getActivity().getApplication();
    return factoryProvider.getInteractorFactory();
  }

}
