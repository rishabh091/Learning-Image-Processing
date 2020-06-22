import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Sepia {

    public static void main(String[] args) throws Exception {
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

                int new_R = (int)((0.393 * R) + (0.769 * G) + (0.189 * B));
                int new_G = (int)((0.349 * R) + (0.686 * G) + (0.168 * B));
                int new_B = (int)((0.272 * R) + (0.534 * G) + (0.131 * B));

                if(new_R > 255) {
                    new_R = 255;
                }
                if(new_G > 255) {
                    new_G = 255;
                }
                if(new_B > 255) {
                    new_B = 255;
                }

                pixel = (A<<24) | (new_R<<16) | (new_G<<8) | new_B;
                bufferedImage.setRGB(i, j, pixel);
            }
        }

        file = new File("assets/sepia.jpg");
        ImageIO.write(bufferedImage, "jpg", file);

        System.out.println("Completed");
    }
}
