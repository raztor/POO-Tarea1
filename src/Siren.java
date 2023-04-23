import java.io.File;
import java.net.URL;

public class Siren {
    public Siren (String soundFileName){
        try {
            dir = new File(soundFileName).toURI().toURL();
        }
        catch (Exception exc){
            exc.printStackTrace(System.out);
        }
    }
    public void play(){ // suena la sirena
        //...
        aWave= new AePlayWave(dir);
        aWave.start();
        isSounding = true;
        System.out.println("Siren is sounding");
    }
    public void stop(){ // deja de sonar la sirena
        aWave.stopSounding();
        isSounding = false;
        System.out.println("Siren is not sounding");
    }
    public String getHeader() {
        return "Siren";
    }
    public int getState() { // verifica si está sonando la sirena
        return isSounding?1:0;
    }
    private URL dir;
    private boolean isSounding;
    private AePlayWave aWave;
}
