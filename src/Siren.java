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
    public void play(){ // reproduce el sonido de la sirena
        aWave= new AePlayWave(dir);
        aWave.start();
        isSounding = true;
    }
    public void stop(){ // Para detener el sonido de la Sirena
        aWave.stopSounding();
        isSounding = false;
    }
    public String getHeader() {
        return "Siren";
    }
    public int getState() {
        return isSounding?1:0;
    } //para saber si la sirena está sonando
    private URL dir;
    private boolean isSounding;
    private AePlayWave aWave;
}
