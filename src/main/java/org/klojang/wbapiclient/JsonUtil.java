package org.klojang.wbapiclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.klojang.util.ExceptionMethods;

class JsonUtil {

  static final ObjectMapper OBJECT_MAPPER = getObjectMapper();

  private JsonUtil() { throw new UnsupportedOperationException(); }

  private static ObjectMapper getObjectMapper() {
    return new ObjectMapper();
  }

  static String toJson(Object obj) {
    try {
      return OBJECT_MAPPER.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      throw ExceptionMethods.uncheck(e);
    }
  }
}
