package org.klojang.wbapiclient;

import java.util.HashMap;

public class MultiLingualMap extends HashMap<String, LBString> {

  public void english(String value) { add("en", value); }

  public void add(String languageCode, String value) {
    super.put(languageCode, new LBString(languageCode, value));
  }
}
