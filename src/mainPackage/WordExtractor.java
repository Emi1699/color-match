package mainPackage;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class WordExtractor {
	public static void main(String[] args) throws IOException {
		String [] colours = {"red", "blue", "green", "yellow", "pink", "orange"};
		for (int i = 0; i < colours.length; i++) {
			blackenize(colours[i], ImageProcessor.START_IMAGE_WIDTH, ImageProcessor.END_IMAGE_WIDTH,
					ImageProcessor.START_IMAGE_HEIGHT, ImageProcessor.END_IMAGE_HEIGHT);
		}
	}

	/*
	 * this method basically converts every pixels in the image
	 * that is lower than a certain given threshhold to black
	 */
	public static void blackenize(String color, int sw, int ew, int sh, int eh) {
		BufferedImage img = null;
		File f = null;
		int blackThreshhold = 0;

		// read image
		try {
			f = new File("images/" + color + ".jpg");
			img = ImageIO.read(f);
		} catch (IOException e) {
			System.out.println(e);
		}
		int p, r, g, b, a;

		// set the pixel value
		for (int i = sw; i < ew; i++) {
			for (int j = sh; j < eh; j++) {
				 p = img.getRGB(i, j);
				 r = (p >> 16) & 0xff;
				 g = (p >> 8) & 0xff;
				 b = p & 0xff;
				if (r < blackThreshhold || b < blackThreshhold || g < blackThreshhold) {
					a = 0;
					r = 0;
					g = 0;
					b = 0;
					p = (a<<24) | (r<<16) | (g<<8) | b;
					img.setRGB(i, j, p);
				} else {
					
				}

			}
		}
		// write image
		try {
			f = new File("images/" + color + "_black.jpg");
			ImageIO.write(img, "jpg", f);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}