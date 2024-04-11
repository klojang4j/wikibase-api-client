package org.klojang.wbapiclient.model;

import java.util.HashMap;

public class MLMap extends HashMap<String, MLString> {

  public MLMap(String languageCode, String text) {
    super();
    add(languageCode, text);
  }

  public void add(String languageCode, String text) {
    super.put(languageCode, new MLString(languageCode, text));
  }

}
