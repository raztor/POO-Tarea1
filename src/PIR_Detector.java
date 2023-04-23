public class PIR_Detector{
    public PIR_Detector (double x, double y, double direction_angle, double sensing_angle, double sensing_range){ //constructor, valores iniciales
        s = new Sensor();
        s.setPir_Parent(this);
        s.setState(SwitchState.CLOSE);
        s.setPir(true);
        s.setDoor(false);
        s.setWindow(false);
        this.direction_angle=direction_angle;
        this.sensing_angle=sensing_angle;
        this.sensing_range=sensing_range;
        this.coord_x=x;
        this.coord_y=y;
    }
    {
        id = nextId++; //contador de PIRs
    }

    public void setY (float y){ // coordenada Y de PIR
        this.coord_y = y;
    }
    public void setX (float x){  // coordenada X de PIR
        this.coord_x = x;
    }

    public String getHeader(){ // cabecera de PIR en el output
        return "Pir"+id;
    }
    //Get state from sensor
    public int getState(){
        if (s.getState() == SwitchState.CLOSE) {
            return 1;
        } else {
            return 0;
        }
    }

    public void detectMotion(Person p){ //detección de movimiento
        double dist_person = Math.sqrt(Math.pow(p.getX()-coord_x,2)+Math.pow(p.getY()-coord_y,2)); //distancia entre dos puntos, rango y persona
        double angle = Math.atan((p.getX()-coord_x)/(p.getY()-coord_y));
        if(dist_person<=sensing_range){
            if(sensing_range-(sensing_angle/2)<=angle && angle<=sensing_range+(sensing_angle/2)){
                s.setState(SwitchState.OPEN);
            }
        }
        else{
            s.setState(SwitchState.CLOSE);
        }
    }
    public Sensor getSensor(){ // retorna el tipo de sensor
        return s;
    }

    private final double direction_angle; //orientación del área de detección
    private final double sensing_angle; //ángulo cono sensor
    private final double sensing_range; // rango detección
    private double coord_x;
    private double coord_y;
    private static int nextId=0;
    private final int id;
    private final Sensor s;}