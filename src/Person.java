public class Person {
    private double coord_x;
    private double coord_y;

    public Person() { // constructor
        coord_x = 0.0f;
        coord_y = 0.0f;
    }{
        id = nextId++; //contador de personas
    }

    public void moveNorth() { //moverse hacia arriba/norte
        this.coord_y += 0.5;
    }

    public void moveSouth() { //moverse hacia abajo/sur
        this.coord_y -= 0.5;
    }

    public void moveEast() { //moverse hacia la derecha/este
        this.coord_x += 0.5;
    }

    public void moveWest() { //moverse hacia la izquierda/oeste
        this.coord_x -= 0.5;
    }

    public double getX() { //retorna coordenada X de la persona
        return coord_x;
    }

    public double getY() { //retorna coordenada Y de la persona
        return coord_y;
    }
    public String getState(){ //retorna la coordenada actual
        return coord_x+" "+coord_y;
    }
    public void setX(double x){ //para ingresar los valores de la coordenada x
        coord_x = x;
    }
    public void setY(double y){ //para ingresar los valores de la coordenada Y
        coord_y = y;
    }

    public String getHeader(){ 
        return "Person"+id;
    }
    private final int id;
    private static int nextId=0;
}