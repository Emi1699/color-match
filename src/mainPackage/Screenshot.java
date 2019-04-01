package mainPackage;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

public class Screenshot {
	public static final long serialVersionUID = 1L;
	public static final String IMAGE_PATH = "images/Shot.jpg";
	public static int pictureNumber = 1;

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 20; i++) {
			screenshotTo("images/Shot_" + pictureNumber + ".jpg");
			Thread.sleep(1000);
		}

	}

	public static void screenshotTo(String path) {
		try {
			Robot r = new Robot();
			Rectangle capture = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage Image = r.createScreenCapture(capture);
			ImageIO.write(Image, "jpg", new File(path));
			//System.out.println("Screenshot " + pictureNumber + " saved");
		} catch (AWTException | IOException ex) {
			System.out.println(ex);
		}
		pictureNumber++;
	}
}