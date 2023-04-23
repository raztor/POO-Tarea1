public class Window {
    public Window() { // constructor, valores inciales
        magneticSensor = new MagneticSensor();
        state = State.CLOSE;
        magneticSensor.putMagnetNearSwitch();
        magneticSensor.setWindow(true);
        magneticSensor.setDoor(false);
        magneticSensor.setPir(false);
        magneticSensor.setWindow_Parent(this);
    }
    {
        id = nextId++; // contador de ventana
    }
    public void open() { // ventana abierta
        state = State.OPEN;
        magneticSensor.moveMagnetAwayFromSwitch();
    }
    public void close() { // ventana cerrada
        state = State.CLOSE;
        magneticSensor.putMagnetNearSwitch();
    }
    public String getHeader(){ //cabecera de la ventana en el output
        return "w"+id;
    }
    public int getState(){ // estado de la ventana
        if (state == State.CLOSE) {
            return 1;
        } else {
            return 0;
        }
    }
    public MagneticSensor getMagneticSensor() { // sensor magnetico de la ventana
        return magneticSensor;
    }
    private final MagneticSensor magneticSensor;
    private State state;
    private final int id;
    private static int nextId=0;
}
