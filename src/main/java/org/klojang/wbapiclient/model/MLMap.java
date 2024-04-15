package org.klojang.wbapiclient.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.core.type.TypeReference;
import org.klojang.wbapiclient.x.JsonUtil;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toUnmodifiableMap;

/**
 * {@code MLMap} reflects the structure of the {@code labels}, {@code descriptions}, and
 * {@code descriptions} fields within an {@code entity} object. Somewhat oddly, it is a
 * map whose keys are language codes and whose values are objects that again contain a
 * language code which, in practice, must be the identical to the key.
 */
public final class MLMap extends AbstractMap<String, MLString> {

  private static final TypeReference<Map<String, MLString>> TYPE_REF = new TypeReference<>() { };

  @JsonCreator
  static MLMap fromJson(String json) {
    Map<String, MLString> map = JsonUtil.parse(json, TYPE_REF);
    return new MLMap(map);
  }

  /**
   * Creates a single-entry {@code MLMap}.
   *
   * @param lang the language code
   * @param text the text for that language
   * @return a single-entry {@code MLMap}
   */
  public static MLMap create(String lang, String text) {
    return new MLMap(List.of(new MLString(lang, text)));
  }

  /**
   * Creates an {@code MLMap} for two languages.
   *
   * @param lang0 the language code for the first language
   * @param text0 the text for the first language
   * @param lang1 the language code for the second language
   * @param text1 the text for the second language
   * @return an {@code MLMap} for two languages
   */
  public static MLMap create(String lang0, String text0, String lang1, String text1) {
    return new MLMap(List.of(new MLString(lang0, text0), new MLString(lang1, text1)));
  }

  /**
   * Creates an {@code MLMap} for three languages.
   *
   * @param lang0 the language code for the first language
   * @param text0 the text for the first language
   * @param lang1 the language code for the second language
   * @param text1 the text for the second language
   * @param lang1 the language code for the third language
   * @param text1 the text for the third language
   * @return an {@code MLMap} for three languages
   */
  public static MLMap create(String lang0,
        String text0,
        String lang1,
        String text1,
        String lang2,
        String text2) {
    return new MLMap(List.of(new MLString(lang0, text0),
          new MLString(lang1, text1),
          new MLString(lang2, text2)));
  }

  /**
   * Creates an {@code MLMap} for an arbitrary number of languages.
   *
   * @param strings the multilingual strings
   * @return an {@code MLMap} for an arbitrary number of languages
   */
  public static MLMap create(List<MLString> strings) {
    return new MLMap(strings);
  }

  private final Map<String, MLString> map;

  private MLMap(List<MLString> strings) {
    map = strings.stream().collect(toUnmodifiableMap(MLString::language, identity()));
  }

  private MLMap(Map<String, MLString> map) { this.map = map; }

  @Override
  public Set<Entry<String, MLString>> entrySet() { return map.entrySet(); }

  @Override
  public boolean equals(Object obj) { return map.equals(obj); }

  public int hashCode() { return map.hashCode(); }
}
