public class Person {
    private double coord_x;
    private double coord_y;

    public Person() { // constructor
        coord_x = 0.0f;
        coord_y = 0.0f;
    }{
        id = nextId++;
    }

    public void moveNorth() {
        this.coord_y += 0.5;
    }

    public void moveSouth() {
        this.coord_y -= 0.5;
    }

    public void moveEast() {
        this.coord_x += 0.5;
    }

    public void moveWest() {
        this.coord_x -= 0.5;
    }

    public double getX() {
        return coord_x;
    }

    public double getY() {
        return coord_y;
    }
    public String getState(){
        return coord_x+" "+coord_y;
    }
    public void setX(double x){
        coord_x = x;
    }
    public void setY(double y){
        coord_y = y;
    }

    public String getHeader(){
        return "Person"+id;
    }
    private final int id;
    private static int nextId=0;
}