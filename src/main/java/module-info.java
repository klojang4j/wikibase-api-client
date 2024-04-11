/**
 * Wikibase API client
 */
module org.klojang.wbapiclient {
  exports org.klojang.wbapiclient;

  requires org.klojang.check;
  requires org.klojang.util;
  requires org.klojang.invoke;

  requires java.net.http;
  requires org.apache.httpcomponents.httpclient;
  requires com.fasterxml.jackson.core;
  requires com.fasterxml.jackson.databind;
  requires com.fasterxml.jackson.annotation;

}
