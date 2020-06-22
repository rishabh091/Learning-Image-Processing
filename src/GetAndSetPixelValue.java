package image_processing;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

public class GetAndSetPixelValue {

    public static void main(String[] args) {
        try {
            File file = new File("assets/image.jpg");
            System.out.println("Image exists : " + file.exists());

            BufferedImage bufferedImage = ImageIO.read(file);
            int width = bufferedImage.getWidth();
            int height = bufferedImage.getHeight();

            System.out.println("Width : " + width + "\tHeight" + height);
            //now getting all the pixels from image
            for(int i = 0; i < width; i++) {
                for(int j = 0; j < height; j++) {

                    System.out.println("Default pixel value : ");
                    int pixel = bufferedImage.getRGB(i, j);
                    int a = (pixel>>24) & 0xff;
                    int r = (pixel>>16) & 0xff;
                    int g = (pixel>>8) & 0xff;
                    int b = (pixel) & 0xff;

                    System.out.println("A : " + a + "\tR : " + r + "\tG : " + g + "\tB : " + b);

                    final int a_final = checkPixel(a);
                    final int r_final = checkPixel(r);
                    final int g_final = checkPixel(g);
                    final int b_final = checkPixel(b);

                    pixel = (a_final<<24) | (r_final<<16) | (g_final<<8) | b_final;
                    bufferedImage.setRGB(i, j, pixel);
                }
                System.out.println();
            }

            file = new File("assets/output.jpg");
            ImageIO.write(bufferedImage, "jpg", file);

            System.out.println("Image Saved successfully");
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }

    public static int checkPixel(int color) {
        int random = new Random().nextInt(100);

        color = 255 - color + random;
        if(color > 255) {
            color = 255 - random;
        }

        return color;
    }
}
