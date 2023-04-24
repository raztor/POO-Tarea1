import java.util.ArrayList;

public class Central {
    public Central(){ //Constructor, valores iniciales.
        zone0 = new ArrayList<Sensor>();
        isArmed = false;
        siren = null;
    }
    public void arm() { // arma la central
        isArmed=true;
    }
    public void disarm() { //desarma la central
        isArmed=false;
        siren.stop();
    }
    public void setSiren(Siren s) { //seteo de la Sirena
        siren =s;
    }
    public void addNewSensor(Sensor s){ //agrega un sensor a la zona
        zone0.add(s);
    }
    public void checkZone(){ //recibe señal. Al existir alguna anomalía, permite sonar la Sirena.
        for (Sensor s: zone0){
            if (s.getState()==SwitchState.OPEN){
                if (isArmed){
                    if(siren.getState()==0) {
                        siren.play();
                        break;
                    }
                }
            }
        }
    }
    public String getHeader(){
        return "Central";
    }
    public int getState(){ //Estado de la central
        return isArmed?1:0;
    }
    private ArrayList<Sensor> zone0;
    private boolean isArmed;
    private Siren siren;
}
