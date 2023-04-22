import static java.lang.Math.sqrt;
public class PIR_Detector{

    public PIR_Detector (){ //constructor, valores iniciales
        direction_angle=0;
        sensing_angle=0;
        sensing_range=0;
        coord_x=0;
        coord_y=0;
    }

    public void setY (float y){
        this.coord_y = y;
    }

    public void setX (float x){
        this.coord_x = x;
    }

    public void detectMotion(){
        float dist_person = Math.sqrt(Math.pow(p.getX()-coord_x,2)+Math.pow(p.getY()-coord_y,2)); //distancia entre dos puntos, rango y persona
        float angle = Math.atan((p.getX()-coord_x)/(p.getY()-coord_y));
        if(dist_person<=sensing_range){
            if(sensing_range-(sensing_angle/2)<=angle && angle<=sensing_range+(sensing_angle/2)){
                siren.play();
            }
        }
        else{
            siren.stop();
        }
    }

    public void resetMotion(){
        siren.stop();
    }


    private float direction_angle; //orientación del área de detección
    private float sensing_angle; //ángulo cono sensor
    private float sensing_range; // rango detección
    private float coord_x;
    private float coord_y;
    private Siren siren;
    protected Person p;
}