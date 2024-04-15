package org.klojang.wbapiclient.x;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.klojang.util.ExceptionMethods;

public class JsonUtil {

  static final ObjectMapper OBJECT_MAPPER = getObjectMapper();

  private JsonUtil() { throw new UnsupportedOperationException(); }

  private static ObjectMapper getObjectMapper() {
    return new ObjectMapper();
  }

  public static <T> T parse(String json, TypeReference<T> typeRef) {
    try {
      return OBJECT_MAPPER.readValue(json, typeRef);
    } catch (JsonProcessingException e) {
      throw ExceptionMethods.uncheck(e);
    }
  }

  public static String toJson(Object obj) {
    try {
      return OBJECT_MAPPER.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      throw ExceptionMethods.uncheck(e);
    }
  }

  public static String toPrettyJson(Object obj) {
    try {
      return OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      throw ExceptionMethods.uncheck(e);
    }
  }
}
