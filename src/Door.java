public class Door {
    public Door () {
        magneticSensor = new MagneticSensor();
        state = State.CLOSE;
    }
    {
        id = nextId++;
    }
    public void open() {
        state = State.OPEN;
        magneticSensor.moveMagnetAwayFromSwitch();
    }
    public void close() {
        state = State.CLOSE;
        magneticSensor.putMagnetNearSwitch();
    }
    public String getHeader(){
        return "d"+id;
    }
    public MagneticSensor getMagneticSensor() {
        return magneticSensor;
    }
    public int getState(){
        return state.ordinal();
    }

    public MagneticSensor getMagneticSensor() {
        return magneticSensor;
    }

    private MagneticSensor magneticSensor;
    private State state;
    private final int id;
    private static int nextId;
    static {
        nextId = 0;
    }
}
