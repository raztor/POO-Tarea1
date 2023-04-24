import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Stage1 {
    public Stage1() { //constructor, valores iniciales: creacion de las puertas y ventanas.
        doors = new ArrayList<Door>();
        windows = new ArrayList<Window>();
    }
    public void readConfiguration(Scanner in){ // lee la configuracion del config.txt
        // reading <#_doors> <#_windows> <#_PIRs>
        int numDoors = in.nextInt();
        for (int i = 0; i < numDoors; i++)
            doors.add(new Door());
        int numWindows = in.nextInt();
        for (int i = 0; i < numWindows; i++)
            windows.add(new Window());
        in.close();
    }
    public void executeUserInteraction (Scanner in, PrintStream out){
        char command, parameter;
        int step=0;
        boolean done =false;
        printHeader(out);
        while (!done) { //comienzo de los input para el sensor
            command = in.next().charAt(0);
            switch (command) {
                case 'd': //agregar estado de las puertas (cantidad está declarada en el config)
                    parameter = in.next().charAt(0);
                    if (parameter == 'o') {
                        doors.get(0).open(); // puerta abierta
                    }
                    else
                        doors.get(0).close(); // puerta cerrada
                    break;

                case 'w': //agregar estado de las ventanas (cantidad declarada en el config)
                    parameter = in.next().charAt(0);
                    if (parameter == 'o'){
                        windows.get(0).open(); //ventana abierta
                    }
                    else
                        windows.get(0).close(); //ventana cerrada
                    break;

                case 'x': done=true;
            }if(!done) {
                printState(step++, out);
                out.println();
            }
        }
    }
    public void printHeader(PrintStream out){
        out.print("Step");
        for (Door door : doors) out.print("\t" + door.getHeader());
        for (Window window : windows) out.print("\t" + window.getHeader());
        out.println();
    }
    public void printState(int step, PrintStream out) {
        out.print(step);
        for (Door door : doors) out.print("\t" + door.getState());
        for (Window window : windows) out.print("\t" + window.getState());
    }
    public static void main(String [] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java Stage1 <configurationFile.txt>");
            System.exit(-1);
        }
        Scanner in = new Scanner(new File(args[0]));
        System.out.println("File: " + args[0]);
        Stage1 stage = new Stage1();
        stage.readConfiguration(in);
        stage.executeUserInteraction(new Scanner(System.in), new PrintStream(new File("output.csv")));

    }

    private ArrayList<Door> doors;
    private ArrayList<Window> windows;
}
