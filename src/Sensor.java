public class Sensor {
   protected PIR_Detector pir_Parent; // Variable de instancia que hace referencia al objeto de la clase A

    public Sensor(){
        state=SwitchState.CLOSE;
    }
    /*public Sensor(PIR_Detector pir_Parent) {
        this.pir_Parent = pir_Parent; // Inicializa la variable de instancia en el constructor
        state=SwitchState.CLOSE;
    }*/
    public Sensor(Door door_Parent) {
        this.door_Parent = door_Parent; // Inicializa la variable de instancia en el constructor
        state=SwitchState.CLOSE;
    }
    public SwitchState getState(){
        return state;
    }
    protected void setState(SwitchState s) {
        state = s;
    }
    public String toString(){
        if (state== SwitchState.CLOSE)
            return "1";
        else
            return "0";
    }

    protected void setDoor_Parent(Door door_Parent) {
        this.door_Parent = door_Parent;
    }
    protected void setWindow_Parent(Window window_Parent) {
        this.window_Parent = window_Parent;
    }

    protected void setPir_Parent(PIR_Detector pir_Parent) {
        this.pir_Parent = pir_Parent;
    }
    public void setPir(boolean isPir) {
        this.isPir = isPir;
    }
    public void setDoor(boolean isDoor) {
        this.isDoor = isDoor;
    }
    public void setWindow(boolean isWindow) {
        this.isWindow = isWindow;
    }
    protected PIR_Detector getPir_Parent() {
        return pir_Parent;
    }
    protected Door getDoor_Parent() {
        return door_Parent;
    }
    protected Window getWindow_Parent() {
        return window_Parent;
    }
    private Window window_Parent; // Variable de instancia que hace referencia al objeto de la clase A
    private Door door_Parent; // Variable de instancia que hace referencia al objeto de la clase A

    public boolean isPir() {
        return isPir;
    }
    public boolean isDoor() {
        return isDoor;
    }
    public boolean isWindow() {
        return isWindow;
    }
    private SwitchState state;
    private boolean isPir;
    private boolean isDoor;
    private boolean isWindow;

}
