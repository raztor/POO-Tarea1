import java.util.ArrayList;

public class Central {
    public Central(){
        zone0 = new ArrayList<Sensor>();
        zone1 = new ArrayList<Sensor>();
        zone2 = new ArrayList<Sensor>();
        people = new ArrayList<Person>();
        isArmed = false;
        siren = null;
        Solo_perimetral = Boolean.FALSE;
    }
    public Central(int r){
        retardo = r;
        zone0 = new ArrayList<Sensor>();
        zone1 = new ArrayList<Sensor>();
        zone2 = new ArrayList<Sensor>();
        people = new ArrayList<Person>();
        isArmed = false;
        siren = null;
        Solo_perimetral = Boolean.FALSE;
    }

    public void arm() {
        if(retardo>0){
            try {
                System.out.println("Armando en "+retardo+" segundos");
                Thread.sleep(retardo*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isArmed=true;
        System.out.println("Central armada");
    }
    public void disarm() {
        isArmed=false;
        siren.stop();
    }

    public void setSiren(Siren s) {
        siren =s;
    }
    public void addPerson(Person p){
        people.add(p);
    }
    public void setSolo_perimetral(Boolean solo_perimetral) {
        Solo_perimetral = solo_perimetral;
    }
    public ArrayList<Person> getPeople(){
        return people;
    }
    public void addNewSensor(Sensor s){
        if (s.isPir()){
            zone2.add(s);
        }else if(s.isWindow()){
            zone1.add(s);
        }else if(s.isDoor()){
            if(s.getDoor_Parent().getId()==0){
                zone0.add(s);
            }else{
                zone1.add(s);
            }
        }
    }
    public void checkZone(){
        if(Solo_perimetral){
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
            for (Sensor s: zone1){
                if (s.getState()==SwitchState.OPEN){
                    if (isArmed){
                        if(siren.getState()==0) {
                            siren.play();
                            break;
                        }
                    }
                }
            }
        }else{
            for (Sensor s: zone0){
                if (s.getState()==SwitchState.OPEN){
                    if (isArmed){
                        if(siren.getState()==0) {
                            try {
                                System.out.println("Alarma en "+retardo+" segundos");
                                Thread.sleep(retardo*1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            siren.play();
                            break;
                        }
                    }
                }
            }
            for (Sensor s: zone1){
                if (s.getState()==SwitchState.OPEN){
                    if (isArmed){
                        if(siren.getState()==0) {
                            try {
                                System.out.println("Alarma en "+retardo+" segundos");
                                Thread.sleep(retardo*1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            siren.play();
                            break;
                        }
                    }
                }
            }
            for (Sensor s: zone2){
                if (s.isPir()){
                    for (Person p: people){
                        s.getPir_Parent().detectMotion(p);
                    }
                }
                if (s.getState()==SwitchState.OPEN){
                    if (isArmed){
                        if(siren.getState()==0) {
                            try {
                                System.out.println("Alarma en "+retardo+" segundos");
                                Thread.sleep(retardo*1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            siren.play();
                            break;
                        }
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
    private final ArrayList<Sensor> zone0;
    private final ArrayList<Sensor> zone1;
    private final ArrayList<Sensor> zone2;
    private boolean isArmed;
    private Siren siren;
    private int retardo;
    private final ArrayList<Person> people;
    private Boolean Solo_perimetral;
}
