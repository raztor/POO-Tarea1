public class Window {
    public Window() { //constructor, valores inciales para la ventana
        magneticSensor = new MagneticSensor();
        state = State.CLOSE;
        magneticSensor.putMagnetNearSwitch();
    }
    {
        id = nextId++; //contador de ventana
    }
    public void open() { //abrir la ventana
        state = State.OPEN;
        magneticSensor.moveMagnetAwayFromSwitch();
    }
    public void close() { //cerrar la ventana
        state = State.CLOSE;
        magneticSensor.putMagnetNearSwitch();
    }
    public String getHeader(){
        return "w"+id;
    }
    public int getState(){ //estado de la ventana
        return state.ordinal();
    }
    public MagneticSensor getMagneticSensor() { // magnetic sensor de ventana
        return magneticSensor;
    }
    private MagneticSensor magneticSensor;
    private State state;
    private final int id;
    private static int nextId=0;
}
