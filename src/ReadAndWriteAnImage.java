package image_processing;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ReadAndWriteAnImage {

    public static void main(String[] args) {
        final int height = 900;
        final int width = 700;

        BufferedImage bufferedImage = null;

        //reading image
        try {
            File file = new File("assets/image.jpg");
            System.out.println("Image processed");
            System.out.println("File : " + file.exists());
            /**
             * create an object of bufferImage and pass as parameter the width, height and image in type.TYPE_INT_ARGB means
             * that we are representing the Alpha, Red, green and blue component of the image pixel using 8 bit integer value
             * */

            bufferedImage = ImageIO.read(file);
            System.out.println("Image : " + bufferedImage.toString());
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
}
