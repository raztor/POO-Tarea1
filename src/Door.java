public class Door {
    public Door () {
        magneticSensor = new MagneticSensor();
        state = State.CLOSE;
        magneticSensor.putMagnetNearSwitch();
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
    public int getState(){
        if (state == State.CLOSE) {
            return 1;
        } else {
            return 0;
        }
    }

    public MagneticSensor getMagneticSensor() {
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
