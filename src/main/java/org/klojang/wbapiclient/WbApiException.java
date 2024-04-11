package org.klojang.wbapiclient;

public sealed class WbApiException extends RuntimeException
      permits InvalidJsonException, NotRecognizedLanguageException {

  public WbApiException(String message) {
    super(message);
  }

  public WbApiException(String message, Throwable cause) {
    super(message, cause);
  }

  public WbApiException(Throwable cause) {
    super(cause);
  }
}
