public class Door {
    public Door () { //constructor, valores iniciales
        magneticSensor = new MagneticSensor(); //se crea sensor magnetico para la puerta
        state = State.CLOSE;
        magneticSensor.putMagnetNearSwitch();
    }
    {
        id = nextId++; //contador de las puertas
    }
    public void open() { //puerta abierta
        state = State.OPEN;
        magneticSensor.moveMagnetAwayFromSwitch();
    }
    public void close() { //puerta cerrada
        state = State.CLOSE;
        magneticSensor.putMagnetNearSwitch();
    }
    public String getHeader(){
        return "d"+id;
    } //indica que es una puerta y su numero.
    public MagneticSensor getMagneticSensor() {
        return magneticSensor;
    } //sensor magnetico de la puerta
    public int getState(){
        return state.ordinal();
    } //estado de la puerta (abierta/cerrada)

    private MagneticSensor magneticSensor;
    private State state;
    private final int id;
    private static int nextId;
    static {
        nextId = 0;
    }
}
