import java.util.ArrayList;

public class Central {
    public Central() {
        zone0 = new ArrayList<Sensor>(); // Cada zona tiene que tener al menos un sensor.
        isArmed = false;
        siren = null;
    }

    public void arm() {
        isArmed = true;
    }

    public void disarm() {
        isArmed=false;
        siren.stop();
        System.out.println(siren.getState());
        //...
    }

    public void setSiren(Siren s) {
        siren = s;
    }

    public void addNewSensor(Sensor s) {
        zone0.add(s);
    }
    public void checkZone(){
        //...
        for (Sensor s: zone0){
            if (s.getState()==SwitchState.OPEN){
                if (isArmed){
                    siren.play();
                }if (!isArmed){
                    //siren.stop();
                }
                /*else {
                    siren.stop();
                }*/
            }
        }
    }

    public String getHeader() {
        return "Central";
    }

    public int getState() {
        return isArmed ? 1 : 0;
    }

    public int getArmedState() {
        return ArmedState;
    }
    public int setArmedState(int state) {
        return ArmedState = state;
    }
    private ArrayList<Sensor> zone0;
    private boolean isArmed;
    private Siren siren;
    private int ArmedState;

    //0 = perimetral, 1 = total

}
