public class Person {
    private float coord_x;
    private float coord_y;

    public Person() { // constructor
        coord_x = 0.0f;
        coord_y = 0.0f;
    }

    public void moveNorth() {
        this.coord_y += 0.5f;
    }

    public void moveSouth() {
        this.coord_y -= 0.5f;
    }

    public void moveEast() {
        this.coord_x += 0.5f;
    }

    public void moveWest() {
        this.coord_x -= 0.5f;
    }

    public float getX() {
        return coord_x;
    }

    public float getY() {
        return coord_y;
    }
    public void setX(float x){

        coord_x = x;

    }
    public void setY(float y){

        coord_y = y;

    }
}