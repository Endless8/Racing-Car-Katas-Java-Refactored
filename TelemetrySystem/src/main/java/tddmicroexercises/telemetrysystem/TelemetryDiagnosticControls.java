package tddmicroexercises.telemetrysystem;

public class TelemetryDiagnosticControls {
    private final String diagnosticChannelConnectionString = "*111#";

    private final ITelemetryClient telemetryClient;
    private String diagnosticInfo;

    public TelemetryDiagnosticControls(ITelemetryClient telemetryClient) {
        this.telemetryClient = telemetryClient;
        diagnosticInfo = "";
    }

    public String getDiagnosticInfo() {
        return diagnosticInfo;
    }

    public void setDiagnosticInfo(String diagnosticInfo) {
        this.diagnosticInfo = diagnosticInfo;
    }

    public void checkTransmission() throws Exception {
        diagnosticInfo = "";

        telemetryClient.disconnect();

        int retryLeft = 3;
        while (!telemetryClient.getOnlineStatus() && retryLeft > 0) {
            telemetryClient.connect(diagnosticChannelConnectionString);
            retryLeft -= 1;
        }

        if (!telemetryClient.getOnlineStatus()) {
            throw new Exception("Unable to connect.");
        }

        telemetryClient.send(MessageStrategy.DIAGNOSTIC_MESSAGE);
        setDiagnosticInfo(telemetryClient.receive());
    }
}
