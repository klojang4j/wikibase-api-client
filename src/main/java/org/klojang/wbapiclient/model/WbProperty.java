package org.klojang.wbapiclient.model;

public record WbProperty(String datatype,
      MLMap labels,
      MLMap descriptions) {

  public WbProperty(String languageCode, String label, String description) {
    this("string",
          MLMap.create(languageCode, label),
          MLMap.create(languageCode, description));
  }
}
