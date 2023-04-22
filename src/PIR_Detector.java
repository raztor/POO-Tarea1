public class PIR_Detector{

    public PIR_Detector (){ //constructor, valores iniciales
        x=0;
        y=0;
        s_angle=0;
        d_area_angle=0;
        d_range = 0;
    }

    public int getState(){
        return state.ordinal();
    }
    public void MotionDetected() {
        state = State.OPEN;
    }

    public void resetDetection(){
        state = State.CLOSE;
    }

    public void detectMotion() {
        float distance = (float) Math.sqrt(Math.pow(person.getX(), 2) + Math.pow(person.getY(), 2));
        if (distance % 2 == 1) {
            sensor.setState(SwitchState.OPEN);
        }
    }

    public void sensor_angle(float s_angle){ //orientacion área de deteccion sujeto a la posicion (x,y)
        this.s_angle = s_angle;
    }
    public void detection_area(float d_area_angle){ //cono angulo de deteccion
       this.d_area_angle = d_area_angle;
    }
    public void detection_range(float d_range){ //rango de deteccion en metros//// ;
        this.d_range = d_range;
    }
    public void pos_x(int x){
        this.x = x;
    }

    public void pos_y(int y){
        this.y = y;
    }

    private int x;
    private int y;
    private Sensor sensor;
    private Person person;
    private State state;
    private float s_angle;
    private float d_area_angle;
    private float d_range;

}