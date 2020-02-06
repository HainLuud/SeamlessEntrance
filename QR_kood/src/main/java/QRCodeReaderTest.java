import java.io.File;
import java.io.IOException;

public class QRCodeReaderTest {
    
    public static void main(String[] args) throws IOException {
        
        
        String piletiNimi = "ticket.pdf";
//        Teeme PDF-failist pildifaili.
        PDFtoImage PDFPilt = new PDFtoImage(piletiNimi);
        PDFPilt.imageWriter();
//        Hangime QR-ist koodi.
        String kood = QRCodeReader.QRcode();
        
        System.out.println(kood);
        
    }
    
}
