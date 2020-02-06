import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PDFtoImage {
    
    private String ticketName;
    
    public PDFtoImage(String ticketName) {
        this.ticketName = ticketName;
    }
    
    public void imageWriter() throws IOException {
        
        //Loading an existing PDF document
        File file = new File(ticketName);
        PDDocument document = PDDocument.load(file);
        
        //Instantiating the PDFRenderer class
        PDFRenderer renderer = new PDFRenderer(document);
        
        //Rendering an image from the PDF document
        BufferedImage image = renderer.renderImage(0);
        
        //Writing the image to a file
        ImageIO.write(image, "JPEG", new File("pdfpilt.jpg"));

//        System.out.println("Image created");
        
        //Closing the document
        document.close();
        
        
    }
    
}
