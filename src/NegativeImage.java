import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class NegativeImage {

    public static void main(String[] args) throws Exception{
        File file = new File("assets/image.jpg");
        BufferedImage bufferedImage = ImageIO.read(file);

        final int height = bufferedImage.getHeight();
        final int width = bufferedImage.getWidth();

        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                int pixel = bufferedImage.getRGB(i, j);

                int A = (pixel>>24) & 0xff;
                int R = (pixel>>16) & 0xff;
                int G = (pixel>>8) & 0xff;
                int B = (pixel) & 0xff;

                R = 255 - R;
                G = 255 - G;
                B = 255 - B;
                pixel = (A<<24) | (R<<16) | (G<<8) | B;

                bufferedImage.setRGB(i, j, pixel);
            }
        }

        file = new File("assets/negative.jpg");
        ImageIO.write(bufferedImage, "jpg", file);

        System.out.println("Negative Completed");
    }
}
