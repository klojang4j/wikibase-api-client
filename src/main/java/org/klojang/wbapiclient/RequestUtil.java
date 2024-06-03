package org.klojang.wbapiclient;

import org.klojang.wbapiclient.x.JsonUtil;

import java.net.URLEncoder;
import java.util.Map;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.Map.Entry;

class RequestUtil {

  private RequestUtil() { throw new UnsupportedOperationException(); }

  static String urlEncodeFormData(Map<String, Object> formData) {
    StringBuilder sb = new StringBuilder();
    for (Entry<String, Object> entry : formData.entrySet()) {
      if (sb.length() > 0) {
        sb.append("&");
      }
      sb.append(urlEncode(entry.getKey()));
      sb.append("=");
      String val = switch (entry.getValue()) {
        case null -> "";
        case String x -> urlEncode(x);
        case Number x -> x.toString();
        case Boolean x -> x.toString();
        case Character x -> urlEncode(x.toString());
        default -> urlEncode(JsonUtil.toJson(entry.getValue()));
      };
      sb.append(val);
    }
    return sb.toString();
  }

  static String debugFormData(Map<String, Object> formData) {
    StringBuilder sb = new StringBuilder();
    for (Entry<String, Object> entry : formData.entrySet()) {
      if (sb.length() > 0) {
        sb.append("&");
      }
      sb.append(entry.getKey());
      sb.append("=");
      String val = switch (entry.getValue()) {
        case null -> "";
        case String x -> x;
        case Number x -> x.toString();
        case Boolean x -> x.toString();
        case Character x -> x.toString();
        default -> JsonUtil.toJson(entry.getValue());
      };
      sb.append(val);
    }
    return sb.toString();
  }

  private static String urlEncode(String s) {
    return URLEncoder.encode(s, UTF_8);
  }
}
