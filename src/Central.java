import java.util.ArrayList;

public class Central {
    public Central(){
        zone0 = new ArrayList<Sensor>();
        isArmed = false;
        siren = null;
    }
    public void arm() {
        isArmed=true;
    }
    public void disarm() {
        isArmed=false;
        siren.stop();
    }
    public void setSiren(Siren s) {
        siren =s;
    }
    public void addNewSensor(Sensor s){
        zone0.add(s);
    }
    public void checkZone(){
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
    public int getState(){
        return isArmed?1:0;
    }
    private ArrayList<Sensor> zone0;
    private boolean isArmed;
    private Siren siren;
}
