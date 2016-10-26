package com.fasttrackit.newscientistreader.presentation.presenter;

import com.fasttrackit.newscientistreader.presentation.view.proxy.BaseProxyView;

/**
 * @author mihai.mecea
 */

public interface PresenterBase<TYPE extends BaseProxyView> {

  void onViewCreated(TYPE proxyView);

  void onViewDestroyed();

  void onPause();

}
