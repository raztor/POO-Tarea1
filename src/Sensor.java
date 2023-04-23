public class Sensor {
   protected PIR_Detector pir_Parent; // Variable de instancia que hace referencia al objeto de la clase A

    public Sensor(){
        state=SwitchState.CLOSE;
    }
    public Sensor(PIR_Detector pir_Parent) {
        this.pir_Parent = pir_Parent; // Inicializa la variable de instancia en el constructor
        state=SwitchState.CLOSE;
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
    public void setPir(boolean isPir) { // se setea un sensor como sensor PIR
        this.isPir = isPir;
    }
    protected PIR_Detector getPir_Parent() { 
        return pir_Parent;
    }
    public boolean isPir() { // para saber si el sensor que se usa es PIR
        return isPir;
    }
    private SwitchState state;
    private boolean isPir;

}
