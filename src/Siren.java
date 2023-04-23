import java.io.File;
import java.net.URL;

public class Siren {
    public Siren (String soundFileName){ // constructor, aquí se define el archivo de audio a usar
        try {
            dir = new File(soundFileName).toURI().toURL();
        }
        catch (Exception exc){
            exc.printStackTrace(System.out);
        }
    }
    public void play(){
        // Para hacer sonar la sirena
        aWave= new AePlayWave(dir);
        aWave.start();
        isSounding = true;
        System.out.println("Siren is sounding");
    }
    public void stop(){
        // Para detener el sonido de la Sirena
        aWave.stopSounding();
        isSounding = false;
        System.out.println("Siren is not sounding");
    }
    public String getHeader() {
        return "Siren";
    }
    public int getState() {
        //para saber si la sirena está sonando
        return isSounding?1:0;
    }
    private URL dir;
    private boolean isSounding;
    private AePlayWave aWave;
}
