public class Door {
    public Door () { //constructor, valores iniciales
        magneticSensor = new MagneticSensor();
        state = State.CLOSE;
        magneticSensor.putMagnetNearSwitch();
        magneticSensor.setDoor(true);
        magneticSensor.setWindow(false);
        magneticSensor.setPir(false);
        magneticSensor.setDoor_Parent(this);
    }
    {
        id = nextId++; // contador de puertas
    }
    public void open() { // puerta abierta
        state = State.OPEN;
        magneticSensor.moveMagnetAwayFromSwitch();
    }
    public void close() { //puerta cerrada
        state = State.CLOSE;
        magneticSensor.putMagnetNearSwitch();
    }
    public String getHeader(){ // retorna la cabecera de la puerta en el output
        return "d"+id;
    }
    public int getState(){ //estado de la puerta
        if (state == State.CLOSE) {
            return 1;
        } else {
            return 0;
        }
    }
    public int getId() { //numero de puerta
        return id;
    }

    public MagneticSensor getMagneticSensor() { //sensor magnetico de la puerta
        return magneticSensor;
    }

    private final MagneticSensor magneticSensor;
    private State state;
    private final int id;
    private static int nextId;
    static {
        nextId = 0;
    }
}
