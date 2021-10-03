package com.imgarena.golf.data.gateway.testobject;

/**
 * Class used to help create objects to be used in tests.
 *
 * @param <T> the class that the TestObject class is to help build and set default values
 */
public abstract class TestObject<T> {
  public abstract T build();

  public TestObject() {
    setInitialFieldValues();
  }

  protected abstract void setInitialFieldValues();

}
