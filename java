import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Color;

public class RedColorDetection {
    public static void main(String[] args) {
        try {
            // Read the image
            File file = new File("your_image.jpg");
            BufferedImage image = ImageIO.read(file);

            // Detect red pixels
            BufferedImage redOnly = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
            for (int y = 0; y < image.getHeight(); y++) {
                for (int x = 0; x < image.getWidth(); x++) {
                    Color pixel = new Color(image.getRGB(x, y));
                    if (pixel.getRed() > 200 && pixel.getGreen() < 100 && pixel.getBlue() < 100) {
                        redOnly.setRGB(x, y, pixel.getRGB());
                    } else {
                        redOnly.setRGB(x, y, Color.WHITE.getRGB()); // Set non-red pixels to white
                    }
                }
            }

            // Display the image
            ImageIO.write(redOnly, "jpg", new File("red_only_image.jpg"));
            System.out.println("Red color detection completed. Check red_only_image.jpg.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
