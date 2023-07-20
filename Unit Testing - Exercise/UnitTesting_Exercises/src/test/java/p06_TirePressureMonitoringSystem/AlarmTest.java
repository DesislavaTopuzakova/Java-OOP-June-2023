package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class AlarmTest {

    //1. гума с нормално налягане: [17; 21]
    @Test
    public void testAlarmWithNormalValue () {
        Sensor sensor = Mockito.mock(Sensor.class);
        Alarm alarm = new Alarm(sensor);
        //налагяне 19.1
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(19.3);
        //проверка на налягането
        alarm.check();
        //нормално налягане -> false
        Assert.assertFalse(alarm.getAlarmOn());
    }

    //2. гума с ниско налягане: < 17 -> алармата е включена (true)
    @Test
    public void testAlarmWithLowerValue() {
        Sensor sensor = Mockito.mock(Sensor.class);
        Alarm alarm = new Alarm(sensor);
        //налагяне 15.3
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(15.3);
        //проверка на налягането
        alarm.check();
        //по-ниско налягане -> true
        Assert.assertTrue(alarm.getAlarmOn());
    }

    //3. гума с високо налягане: > 21 -> алармата е включена (true)
    @Test
    public void testAlarmWithHigherValue() {
        Sensor sensor = Mockito.mock(Sensor.class);
        Alarm alarm = new Alarm(sensor);
        //налагяне 24.1
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(24.1);
        //проверка на налягането
        alarm.check();
        //по-високо налягане -> true
        Assert.assertTrue(alarm.getAlarmOn());
    }
}
