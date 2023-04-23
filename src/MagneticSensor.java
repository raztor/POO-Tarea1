public class MagneticSensor extends Sensor {
    public MagneticSensor(){} //constructor
    public void moveMagnetAwayFromSwitch() { // atributo para cuando se abre una puerta/ventana
        setState(SwitchState.OPEN);
    }
    public void putMagnetNearSwitch() { //sensor deja de estar activo
        setState(SwitchState.CLOSE);
    }

}
