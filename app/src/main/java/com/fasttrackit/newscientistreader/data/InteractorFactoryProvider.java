package com.fasttrackit.newscientistreader.data;

import com.fasttrackit.newscientistreader.data.interactor.InteractorFactory;

/**
 * @author mihai.mecea
 */

public interface InteractorFactoryProvider {

  InteractorFactory getInteractorFactory();

}
