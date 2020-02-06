import java.io.File;
import java.io.IOException;

public class QRCodeReaderTest {
    
    public static void main(String[] args) throws IOException {

//        Teeme PDF-failist pildifaili.
        String piletiNimi = "ticket.pdf";
        PDFtoImage PDFPilt = new PDFtoImage(piletiNimi);
        PDFPilt.imageWriter();

//        Loeme pildifailist välja QR-koodi.
        try {
            File file = new File("pdfpilt.jpg");
            String decodedText = QRCodeReader.decodeQRCode(file);
            if (decodedText == null) {
                System.out.println("No QR Code found in the image");
            } else {
                System.out.println(decodedText);
            }
        } catch (IOException e) {
            System.out.println("Could not decode QR Code, IOException :: " + e.getMessage());
        }
    }
    
}
