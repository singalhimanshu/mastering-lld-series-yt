interface LogDestination {
  void writeLog(final String message);
}

class ConsoleLogDestination implements LogDestination {

  @Override
  public void writeLog(String message) {
    System.out.println("[Console] " + message);
  }

}

class FileLogDestination implements LogDestination {

  @Override
  public void writeLog(String message) {
    System.out.println("[File] " + message);
  }

}

abstract class Logger {
  protected final LogDestination logDestination;

  public Logger(LogDestination logDestination) {
    this.logDestination = logDestination;
  }

  abstract void log(final String message);

}

class ErrorLogger extends Logger {
  ErrorLogger(LogDestination logDestination) {
    super(logDestination);
  }

  @Override
  void log(String message) {
    logDestination.writeLog("Error: " + message);
  }

}

class InfoLogger extends Logger {
  InfoLogger(LogDestination logDestination) {
    super(logDestination);
  }

  @Override
  void log(String message) {
    logDestination.writeLog("Info: " + message);
  }

}

public class BridgeLoggerExample {
  public static void main(String[] args) {
    final Logger errorLogger = new ErrorLogger(new ConsoleLogDestination());
    final Logger infoLogger = new InfoLogger(new FileLogDestination());

    errorLogger.log("this is error log");
    infoLogger.log("this is info log");
  }
}
