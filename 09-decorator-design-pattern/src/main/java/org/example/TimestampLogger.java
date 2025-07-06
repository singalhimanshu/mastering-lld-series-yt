package org.example;

import java.time.LocalDateTime;

public class TimestampLogger extends LoggerDecorator {

    public TimestampLogger(Logger wrappedLogger) {
        super(wrappedLogger);
    }

    @Override
    public void log(final String message) {
        final String messageWithTs = "[" + LocalDateTime.now() + "] " + message;
        super.log(messageWithTs);
    }
}
