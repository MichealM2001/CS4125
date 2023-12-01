package DataInputs;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageReader {
    
    public BufferedImage readImage(String pathName) throws IOException{
        File imageFile = new File(pathName);
        BufferedImage image = ImageIO.read(imageFile);
        return image;
    }

    /** Testing 
    * public static void main(String[] args) {
    *     ImageReader imageReader = new ImageReader();
    *    try{
    *        BufferedImage image = imageReader.readImage("C:\\Users\\Rian\\Desktop\\Year 3 Sem2\\devlink\\DevLink.JPG");
    *    }catch (IOException e){
    *        e.printStackTrace();
    *    }
    * }
 */
}
