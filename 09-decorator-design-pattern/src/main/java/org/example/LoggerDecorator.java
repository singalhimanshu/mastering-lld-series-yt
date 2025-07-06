package org.example;

public abstract class LoggerDecorator implements Logger {
  private final Logger wrappedLogger;

  public LoggerDecorator(final Logger wrappedLogger) {
    this.wrappedLogger = wrappedLogger;
  }

  @Override
  public void log(String message) {
    wrappedLogger.log(message);
  }
}
