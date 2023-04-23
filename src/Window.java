public class Window {
    public Window() { //constructor, valores inciales para la ventana
        magneticSensor = new MagneticSensor();
        state = State.CLOSE; //comienza cerrada
        magneticSensor.putMagnetNearSwitch(); //sensor sin detectar nada 
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
        if (state == State.CLOSE) {
            return 1;
        } else {
            return 0;
        }
    }
    public MagneticSensor getMagneticSensor() { // magnetic sensor de ventana
        return magneticSensor;
    }
    private final MagneticSensor magneticSensor;
    private State state;
    private final int id;
    private static int nextId=0;
}
