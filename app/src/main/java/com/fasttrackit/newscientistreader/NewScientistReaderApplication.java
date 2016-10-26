package com.fasttrackit.newscientistreader;

import android.app.Application;
import com.fasttrackit.newscientistreader.data.InteractorFactoryProvider;
import com.fasttrackit.newscientistreader.data.interactor.InteractorFactory;
import com.fasttrackit.newscientistreader.data.net.ApiConnector;
import com.fasttrackit.newscientistreader.data.net.ApiConnectorImpl;

/**
 * @author mihai.mecea
 */

public class NewScientistReaderApplication extends Application implements InteractorFactoryProvider {

  private InteractorFactory interactorFactory;

  @Override
  public void onCreate() {
    super.onCreate();

    ApiConnector apiConnector = ApiConnectorImpl.getInstance(getApplicationContext());
    this.interactorFactory = new InteractorFactory(apiConnector);
  }


  @Override
  public InteractorFactory getInteractorFactory() {
    return interactorFactory;
  }
}
