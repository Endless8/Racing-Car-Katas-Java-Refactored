package tddmicroexercises.telemetrysystem;

import java.util.Random;

public class TelemetryClient implements ITelemetryClient {

    private boolean onlineStatus;
    private String diagnosticMessageResult;
    private final IMessageStrategy messageStrategy;

    private final Random connectionEventsSimulator = new Random(42);

    public TelemetryClient(IMessageStrategy messageStrategy) {
        this.messageStrategy = messageStrategy;
        diagnosticMessageResult = "";
    }

    public boolean getOnlineStatus() {
        return onlineStatus;
    }

    public void connect(String telemetryServerConnectionString) {
        if (telemetryServerConnectionString == null || telemetryServerConnectionString.isEmpty()) {
            throw new IllegalArgumentException();
        }

        // simulate the operation on a real modem
        boolean success = connectionEventsSimulator.nextInt(10) <= 8;

        onlineStatus = success;
    }

    public void disconnect() {
        onlineStatus = false;
    }

    public void send(String message) {
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException();
        }

        diagnosticMessageResult = messageStrategy.handleMessage(message, diagnosticMessageResult);

        // here should go the real Send operation (not needed for this exercise)
    }

    public String receive() {
        String message;

        if (diagnosticMessageResult == null || diagnosticMessageResult.isEmpty()) {
            // simulate a received message (just for illustration - not needed for this exercise)
            message = "";
            int messageLength = connectionEventsSimulator.nextInt(50) + 60;
            for (int i = messageLength; i >= 0; --i) {
                message += (char) connectionEventsSimulator.nextInt(40) + 86;
            }

        } else {
            message = diagnosticMessageResult;
            diagnosticMessageResult = "";
        }

        return message;
    }
}

