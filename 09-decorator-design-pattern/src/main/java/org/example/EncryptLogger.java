package org.example;

public class EncryptLogger extends LoggerDecorator {
  public EncryptLogger(Logger wrappedLogger) {
    super(wrappedLogger);
  }

  @Override
  public void log(final String message) {
    final String encryptedMessage = encryptMessage(message);
    super.log(encryptedMessage);
  }

  private String encryptMessage(final String message) {
    return new StringBuilder(message).reverse().toString();
  }
}
