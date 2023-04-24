public class Door {
    public Door () { //constructor, valores iniciales
        magneticSensor = new MagneticSensor(); //se crea sensor magnetico para la puerta
        state = State.CLOSE; //inicia cerrada
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
        return state.ordinal();
    }

    private MagneticSensor magneticSensor;
    private State state;
    private final int id;
    private static int nextId;
    static {
        nextId = 0;
    }
}
