public class QR_lugejaTest {
    public static void main(String[] args) {
        
        QR_lugeja lugeja = new QR_lugeja("/usr/bin/python3.6", "converter.py", "ticket.pdf");
        
        String piletinimi = "ticket.pdf";
        String kood = lugeja.loe_QR();
        System.out.println(kood);
    }
}




