import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Stage4 {
    public Stage4() {
        doors = new ArrayList<Door>();
        windows = new ArrayList<Window>();
        pir = new ArrayList<PIR_Detector>();
    }
    public void readConfiguration(Scanner in){
        // reading <#_doors> <#_windows> <#_PIRs>
        in.useLocale(java.util.Locale.US);
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
        for (int i = 0; i < numPIRs; i++) {
            in.nextLine();
            double x, y, directionAngle, sensingAngle, sensingRange;
            try {
                x = in.nextDouble();
                y = in.nextDouble();
                directionAngle = in.nextDouble();
                sensingAngle = in.nextDouble();
                sensingRange = in.nextDouble();
            } catch (InputMismatchException e) {
                System.err.println("Error: formato de coordenadas incorrecto en la línea " + (i+3));
                return; // Salir del método si hay un error
            }
            PIR_Detector p = new PIR_Detector(x,y,directionAngle,sensingAngle,sensingRange);
            pir.add(p);
            central.addNewSensor(p.getSensor());
        }
        in.nextLine();
        String soundFile = in.next();
        siren = new Siren(soundFile);
        central.setSiren(siren);
        in.close();

        }

    public void executeUserInteraction (Scanner in, PrintStream out){
        in.useLocale(java.util.Locale.US);
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
                            central.setSolo_perimetral(true);
                            central.arm();
                            break;
                        case 'd':
                            central.disarm();
                            break;
                    }break;
                case 'c':
                    // Este caso crea una persona con las coordenadas que se ingresan
                    // y mueve la persona con las flechas
                    //i = Integer.parseInt(command.substring(1));

                    Person persona = new Person();
                    double double1 = in.nextDouble();
                    double double2 = in.nextDouble();
                    // Crear una persona con las coordenadas que se ingresan y añadir al array
                    persona.setX(double1);
                    persona.setY(double2);
                    central.getPeople().add(persona);
                    break;

                case 'p':
                    // Este caso mueve la persona con las flechas
                    i = Integer.parseInt(command.substring(1));
                    parameter = in.next().charAt(0);
                    if(parameter == '↑'){
                        central.getPeople().get(i).moveNorth();
                    }
                    else if (parameter == '↓'){
                        central.getPeople().get(i).moveSouth();
                    }
                    else if (parameter == '←'){
                        central.getPeople().get(i).moveWest();
                    }
                    else if (parameter == '→'){
                        central.getPeople().get(i).moveEast();
                    }
                    break;
                case 'x': done=true;
                break;
                default:
                    System.out.println("Error, comando invalido");
                    break;
            }if(!done) {
                out.println();
            }
            central.checkZone();
        }
    }
    public void printHeader(PrintStream out){
        out.print("Step");
        for (Door door : doors) out.print("\t" + door.getHeader());
        for (Window window : windows) out.print("\t" + window.getHeader());
        for (PIR_Detector pir : pir) out.print("\t" + pir.getHeader());
        out.print("\t" + siren.getHeader());
        out.print("\t" + central.getHeader());
        //for (Person person : central.getPeople()) out.print("\t" + person.getHeader());

        out.println();
    }
    public void printState(int step, PrintStream out){
        step++;
        out.print(step);
        //System.out.println("Step: " + step);
        for (Door door : doors) out.print("\t" + door.getState());
        for (Window window : windows) out.print("\t" + window.getState());
        for (PIR_Detector pir : pir) out.print("\t" + pir.getState());
        out.print("\t" + siren.getState());
        out.print("\t" + central.getState());
        try {
            for (Person person : central.getPeople()) out.print("\t" + person.getState());
        }catch (NullPointerException e){
            System.out.println("No hay personas");
        }

    }
    public static void main(String [] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java Stage1 <configurationFile.txt>");
            System.exit(-1);
        }
        Scanner in = new Scanner(new File(args[0])).useLocale(Locale.US);
        //System.out.println("File: " + args[0]);
        Stage4 stage = new Stage4();
        stage.readConfiguration(in);
        stage.executeUserInteraction(new Scanner(System.in), new PrintStream(new File("output.csv")));
    }

    private final ArrayList<Door> doors;
    private final ArrayList<Window> windows;
    private final ArrayList<PIR_Detector> pir;
    private Central central;
    private Siren siren;
}
