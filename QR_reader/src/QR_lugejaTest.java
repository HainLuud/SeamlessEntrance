public class QR_lugejaTest {
    public static void main(String[] args) {
        
        String pythonInterpreterLocation = "/usr/bin/python3.6";
        String pythonFileName = "converter.py";
        String piletinimi = "ticket.pdf";
        
        QR_lugeja lugeja = new QR_lugeja(pythonInterpreterLocation, pythonFileName, piletinimi);
        
        String kood = lugeja.loe_QR();
        System.out.println(kood);
    }
}




