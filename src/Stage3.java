import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Stage3 {
    public Stage3() {
        doors = new ArrayList<Door>();
        windows = new ArrayList<Window>();
        pir = new ArrayList<PIR_Detector>();
    }
    public void readConfiguration(Scanner in){
        // reading <#_doors> <#_windows> <#_PIRs>
        central = new Central();
        int numDoors = in.nextInt();
        for (int i = 0; i < numDoors; i++) {
            Door d = new Door();
            doors.add(d);
            central.addNewSensor(d.getMagneticSensor());
            //...
        }
        int numWindows = in.nextInt();
        for (int i = 0; i < numWindows; i++) {
            Window w = new Window();
            windows.add(w);
            central.addNewSensor(w.getMagneticSensor());

            //...
        }
        int numPIRs = in.nextInt();
        for(int i=0; i< numPIRs; i++){
            PIR_Detector pirs = new PIR_Detector();
            pir.add(pirs);
            central.addNewSensor(pirs.getSensor());
        }

        in.nextLine();
        String soundFile = in.next();
        siren = new Siren(soundFile);
        central.setSiren(siren);
        in.close();
    }
    public void executeUserInteraction (Scanner in, PrintStream out){
        String command;
        char parameter;
        int i;
        int step=-1;
        boolean done =false;
        printHeader(out);
        while (!done) {
            printState(step++, out);
            command = in.next();
            //if (command.charAt(0)=='x') break;
            switch (command.charAt(0)) {
                case 'd':
                    i = Integer.parseInt(command.substring(1));
                    parameter = in.next().charAt(0);
                    if (parameter== 'o')
                        doors.get(i).open();
                    else
                        doors.get(i).close();
                    break;
                case 'w':
                    i = Integer.parseInt(command.substring(1));
                    parameter = in.next().charAt(0);
                    if (parameter == 'o'){
                        windows.get(i).open();
                    }
                    else
                        windows.get(i).close();
                    break;
                case 'k':
                    parameter = in.next().charAt(0);
                    switch (parameter) {
                        case 'a':
                            central.arm();
                            break;
                        case 'p':
                            //central.permimeter();
                            break;
                        case 'd':
                            central.disarm();
                            break;
                    }
                    break;
                case 'c':
                    person = new Person();
                    parameter = in.next().charAt(0);
                    //ingresar coordenada X e Y
                    //hacer un for hasta que suene la alarma con el PIR, moviendo la persona con las flechas
                case 'x': done=true;
                break;
                default:
                    System.out.println("Error, comando invalido");
                    break;
            }if(!done) {
                //printState(step, out);
                //System.out.println("if!Done");
                out.println();
            }
            central.checkZone();
        }
    }
    public void printHeader(PrintStream out){
        out.print("Step");
        for (Door door : doors) out.print("\t" + door.getHeader());
        for (Window window : windows) out.print("\t" + window.getHeader());
        out.print("\t" + siren.getHeader());
        out.print("\t" + central.getHeader());
        out.println();
    }
    public void printState(int step, PrintStream out){
        step++;
        out.print(step);
        //System.out.println("Step: " + step);
        for (Door door : doors) out.print("\t" + door.getState());
        for (Window window : windows) out.print("\t" + window.getState());
        out.print("\t" + siren.getState());
        out.print("\t" + central.getState());


    }
    public static void main(String [] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java Stage1 <configurationFile.txt>");
            System.exit(-1);
        }
        Scanner in = new Scanner(new File(args[0]));
        //System.out.println("File: " + args[0]);
        Stage2 stage = new Stage2();
        stage.readConfiguration(in);
        stage.executeUserInteraction(new Scanner(System.in), new PrintStream(new File("output.csv")));
    }

    private ArrayList<Door> doors;
    private ArrayList<Window> windows;
    private Central central;
    private Siren siren;
    private PIR_Detector pir;
    private Person person;
}
