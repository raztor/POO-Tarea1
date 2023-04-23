import java.util.ArrayList;

public class Central {
    public Central(){ //Constructor, valores iniciales para el recibimiento de las anomalias
        zone0 = new ArrayList<Sensor>();
        people = new ArrayList<Person>();
        isArmed = false;
        siren = null;
        Solo_perimetral = Boolean.FALSE;
    }

    public void arm() { // arma la central
        isArmed=true;
    }
    public void disarm() { //desarma la central
        isArmed=false;
        siren.stop();
    }

    public void armPerimeter(){ //se setea en el Stage4

    }
    public void setSiren(Siren s) { //seteo de la Sirena
        siren =s;
    }
    public void addPerson(Person p){ //agrega una persona
        people.add(p);
    }
    public ArrayList<Person> getPeople(){ //retorna la cantidad de personas
        return people;
    }
    public void addNewSensor(Sensor s){ //agrega un sensor a la zona
        zone0.add(s);
    }
    public void checkZone(){ //recibe señal del PIR si hay alguna anomalía y permite sonar la Sirena
        for (Sensor s: zone0){
            if (s.isPir()){
                    System.out.println("PIR");
                    for (Person p: people){
                        s.getPir_Parent().detectMotion(p);
                    }
                }
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
    private final ArrayList<Sensor> zone0;
    private boolean isArmed;
    private Siren siren;
    private final ArrayList<Person> people;

    private final Boolean Solo_perimetral;
}
