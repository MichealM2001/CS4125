package DataInputs;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;



public class ReadLicence {
    
    public static void main(String[] args) {
        ImageReader imageReader = new ImageReader();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JFileChooser fileChooser = new JFileChooser();
        File directory = new File("C/Users/");
        fileChooser.setCurrentDirectory(directory);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image", "jpg", "jpeg", "png");
        fileChooser.setFileFilter(filter);

        int returnValue = fileChooser.showOpenDialog(null);

        if(returnValue == JFileChooser.APPROVE_OPTION){
            File selectedFile =  fileChooser.getSelectedFile();

            try{
                BufferedImage img = ImageIO.read(selectedFile);
                if (img != null){
                JLabel label = new JLabel(new ImageIcon(img));
                frame.getContentPane().add(label, BorderLayout.CENTER);

                frame.pack();
                frame.setVisible(true);

                BufferedImage processableImage = imageReader.readImage(selectedFile.getAbsolutePath());
            }else{
                System.out.println("Error, could not load the image.");
            }
                
            }catch(IOException e){
                e.printStackTrace();
            }
        }

    }

}
