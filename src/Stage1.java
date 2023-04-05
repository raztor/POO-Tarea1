import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Stage1 {
    public Stage1() {
        doors = new ArrayList<Door>();
        windows = new ArrayList<Window>();
    }
    public void readConfiguration(Scanner in){
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
        while (!done) {
            command = in.next().charAt(0);
            switch (command) {
                case 'd':
                    parameter = in.next().charAt(0);
                    //System.out.println("Esta en d");
                    if (parameter == 'o') {
                        doors.get(0).open();
                        //System.out.println("esta d abierto");
                    }
                    else
                        doors.get(0).close();
                    break;

                case 'w':
                    parameter = in.next().charAt(0);
                    //System.out.println("Esta en w");
                    if (parameter == 'o'){
                        //System.out.println("esta w abierto");
                        windows.get(0).open();
                    }
                    else
                        windows.get(0).close();
                    break;

                case 'x': done=true;   // Added to finish the program

            }
        }printState(step++, out);
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
