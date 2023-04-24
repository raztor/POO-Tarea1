public class Sensor {
    public Sensor(){
        this(SwitchState.OPEN);
    }
    public Sensor(SwitchState s){
        state = s;
    }
    public SwitchState getState(){ // estado del Sensor (OPEN/CLOSE)
        return state;
    }
    protected void setState(SwitchState s) { // Setea nuevo estado para el sensor
        state = s;
    }
    public String toString(){ // funciona como booleano para saber el estado del sensor
        if (state== SwitchState.CLOSE)
            return "1";
        else
            return "0";
    }
    private SwitchState state;
}
