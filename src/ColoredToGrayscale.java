import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ColoredToGrayscale {

    public static void main(String[] args) throws Exception {

        File file = new File("assets/image.jpg");
        BufferedImage bufferedImage = ImageIO.read(file);

        int height = bufferedImage.getHeight();
        int width = bufferedImage.getWidth();

        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {

                int pixel = bufferedImage.getRGB(i, j);
                final int A = (pixel>>24) & 0xff;
                final int R = (pixel>>16) & 0xff;
                final int G = (pixel>>8) & 0xff;
                final int B = (pixel) & 0xff;

                int avg = (R + G + B) / 3;
                pixel = (A) + (avg<<16) + (avg<<8) + avg;
                bufferedImage.setRGB(i, j, pixel);
            }
        }
        file = new File("assets/grayscale.jpg");
        ImageIO.write(bufferedImage, "jpg", file);

        System.out.println("Grayscale completed");
    }
}
