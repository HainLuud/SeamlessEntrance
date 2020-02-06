import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QR_lugeja {
    
    private String pythonInterpreterLocation;
    private String pythonFileName;
    private String piletinimi;
    
    public QR_lugeja(String pythonInterpreterLocation, String pythonFileName, String piletinimi) {
        this.pythonInterpreterLocation = pythonInterpreterLocation;
        this.pythonFileName = pythonFileName;
        this.piletinimi = piletinimi;
    }
    
    public String loe_QR() {
        
        String kood = "";
        String runPythonCommand = pythonInterpreterLocation + " " + pythonFileName + " " + piletinimi;
        
        try {
            Process p = Runtime.getRuntime().exec(runPythonCommand);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                kood += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return kood;
    }
    
}
