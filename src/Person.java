public class Person {
    private double coord_x;
    private double coord_y;

    public Person() { // constructor
        coord_x = 0.0f;
        coord_y = 0.0f;
    }{
        id = nextId++;
    }

    public void moveNorth() { // se mueve hacia arriba
        this.coord_y += 0.5;
    }

    public void moveSouth() { // se mueve hacia abajo
        this.coord_y -= 0.5;
    }

    public void moveEast() { // se mueve a la derecha
        this.coord_x += 0.5;
    }

    public void moveWest() { // se mueve a la izquierda
        this.coord_x -= 0.5;
    }

    public double getX() { // retorna la coordenada X de la persona
        return coord_x;
    }

    public double getY() { // retorna la coordenada Y de la persona
        return coord_y;
    }
    public String getState(){ // retorna la coordenada de la persona (par ordenado)
        return coord_x+" "+coord_y;
    }
    public void setX(double x){ // setea el valor de X
        coord_x = x;
    }
    public void setY(double y){ // setea el valor de Y
        coord_y = y;
    }

    public String getHeader(){ // retorna la cabecera de persona para el output
        return "Person"+id;
    }
    private final int id;
    private static int nextId=0;
}