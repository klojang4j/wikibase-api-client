package org.klojang.wbapiclient.model;

import org.junit.jupiter.api.Test;
import org.klojang.wbapiclient.x.JsonUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MLMapTest {

  @Test
  public void serialize00() {
    MLMap m = MLMap.create("en", "tea");
    String json = JsonUtil.toJson(m);
    //System.out.println(json);
    String expected = "{\"en\":{\"language\":\"en\",\"value\":\"tea\"}}";
    assertEquals(expected, json);
  }

  @Test
  public void serialize01() {
    MLMap m = MLMap.create("en", "tea", "nl", "thee");
    String json = JsonUtil.toJson(m);
    //System.out.println(json);
    assertTrue(json.contains("\"nl\":{\"language\":\"nl\",\"value\":\"thee\"}"));
    assertTrue(json.contains("\"en\":{\"language\":\"en\",\"value\":\"tea\"}"));
  }

  @Test
  public void deserialize00() {
    MLMap expected = MLMap.create("en", "tea");
    String json = "{\"en\":{\"language\":\"en\",\"value\":\"tea\"}}";
    MLMap actual = MLMap.fromJson(json);
    assertEquals(expected, actual);
  }

  @Test
  public void deserialize01() {
    MLMap expected = MLMap.create("en", "tea", "nl", "thee");
    String json = "{\"nl\":{\"language\":\"nl\",\"value\":\"thee\"},\"en\":{\"language\":\"en\",\"value\":\"tea\"}}";
    MLMap actual = MLMap.fromJson(json);
    assertEquals(expected, actual);
  }

}
