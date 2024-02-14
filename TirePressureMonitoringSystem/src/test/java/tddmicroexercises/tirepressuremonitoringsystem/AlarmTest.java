package tddmicroexercises.tirepressuremonitoringsystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class AlarmTest {

    Alarm alarm;
    SensorInterface mockedSensor;

    @BeforeEach
    public void init() {
        mockedSensor = mock(SensorInterface.class);
        alarm = new Alarm(mockedSensor);
    }

    @Test
    public void lowPressureCase() {
        sendValueFromSensor(15d);
        Assertions.assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void highPressureCase() {
        sendValueFromSensor(22d);
        Assertions.assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void normalPressureCase() {
        sendValueFromSensor(18d);
        Assertions.assertFalse(alarm.isAlarmOn());
    }

    private void sendValueFromSensor(double value) {
        when(mockedSensor.popNextPressurePsiValue()).thenReturn(value);
        alarm.check();
    }
}
