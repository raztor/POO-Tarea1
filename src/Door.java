public class Door {
    public Door () { //constructor, valores iniciales
        magneticSensor = new MagneticSensor(); //se crea sensor magnetico para la puerta
        state = State.CLOSE; //inicia cerrada
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
    public String getHeader(){ //indica que es una puerta y qué numero de puerta es 
        return "d"+id;
    }
    public int getState(){ //estado de la puerta (abierta/cerrada)
        if (state == State.CLOSE) {
            return 1;
        } else {
            return 0;
        }
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
