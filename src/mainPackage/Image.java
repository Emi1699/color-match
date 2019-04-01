package mainPackage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image {
	private BufferedImage img;
	
	public Image(String path) {
		File f = null;

		// read image
		try {
			f = new File(path);
			img = ImageIO.read(f);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public int red(int x, int y) {
		return (img.getRGB(x, y) >> 16) & 0xff;
	}
	
	public int blue(int x, int y) {
		return img.getRGB(x, y) & 0xff;
	}
	
	public int green(int x, int y) {
		return (img.getRGB(x, y) >> 8) & 0xff;
	}
	
	public long RGB(int x, int y) {
		return img.getRGB(x, y);
	}
	
	public int height() {
		return img.getHeight();
	}
	
	public int width() {
		return img.getWidth();
	}
	
	public void setRGB(int i, int j, int value) {
		img.setRGB(i, j, value);
	}
}
