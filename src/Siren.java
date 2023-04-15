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
        aWave.run();
    }
    public void play(){
        isSounding = true;
        aWave= new AePlayWave(dir);
        aWave.start();
    }
    public void stop(){
        isSounding = false;
        aWave.stopSounding();

    }
    public String getHeader() {
        return "Siren";
    }
    public int getState() {
        if(isSounding){
            return 1;
        }
        else{
            return 0;
        }

    }
    private URL dir;
    private boolean isSounding;
    private AePlayWave aWave;
}
