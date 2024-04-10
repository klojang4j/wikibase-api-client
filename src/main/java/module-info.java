/**
 * Wikibase API client
 */
module org.klojang.wbapiclient {
  exports org.klojang.wbapiclient;

  requires java.net.http;
  requires org.apache.httpcomponents.httpclient;
  requires com.fasterxml.jackson.core;
  requires com.fasterxml.jackson.databind;
  requires com.fasterxml.jackson.annotation;
  requires org.klojang.check;
  requires org.klojang.invoke;

}
