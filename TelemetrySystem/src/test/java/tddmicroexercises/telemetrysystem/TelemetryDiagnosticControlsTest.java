package tddmicroexercises.telemetrysystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TelemetryDiagnosticControlsTest {

    private ITelemetryClient telemetryClient;

    @BeforeEach
    public void init() {
        telemetryClient = mock(ITelemetryClient.class);
    }

    @Test
    public void checkTransmissionSuccess() throws Exception {
        when(telemetryClient.getOnlineStatus()).thenReturn(false, true, true);
        when(telemetryClient.receive()).thenReturn("testtesttesttesttesttesttesttesttesttesttesttesttesttesttest");

        TelemetryDiagnosticControls controls = new TelemetryDiagnosticControls(telemetryClient);
        controls.checkTransmission();
        String result = controls.getDiagnosticInfo();

        assertTrue(result.length() >= 60 && result.length() <= 109);
    }

    @Test
    public void checkTransmissionFailure() {
        when(telemetryClient.getOnlineStatus()).thenReturn(false, false, false);

        TelemetryDiagnosticControls controls = new TelemetryDiagnosticControls(telemetryClient);

        assertThrows(Exception.class, controls::checkTransmission);
    }

}
