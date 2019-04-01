package mainPackage;

import sheffield.EasyGraphics;

public class ImageProcessor {
	public static final int START_IMAGE_WIDTH = 650, END_IMAGE_WIDTH = 810, START_IMAGE_HEIGHT = 330,
			END_IMAGE_HEIGHT = 410;
	public static final String IMAGE_PATH = "images/yellow2.jpg";

	public static void main(String[] args) {
		// String colour = getColor(IMAGE_PATH);
		// System.out.println(colour + "\n");
		DryImage.blackenize("yellow", START_IMAGE_WIDTH, END_IMAGE_WIDTH, START_IMAGE_HEIGHT, END_IMAGE_HEIGHT);

		Image imgR = new Image("images/red_black.jpg");
		Image imgB = new Image("images/blue_black.jpg");
		Image imgG = new Image("images/green_black.jpg");
		Image imgP = new Image("images/pink_black.jpg");
		Image imgY = new Image("images/yellow_black.jpg");
		Image imgO = new Image("images/orange_black.jpg");

		int rb = countWhitePixels(imgR);
		int bb = countWhitePixels(imgB);
		int gb = countWhitePixels(imgG);
		int pb = countWhitePixels(imgP);
		int yb = countWhitePixels(imgY);
		int ob = countWhitePixels(imgO);

		System.out.println("RED: " + rb + "   BLUE: " + bb + "   GREEN: " + gb + "   PINK: " + pb + "   YELLOW: " + yb
				+ "   ORANGE: " + ob);
	}

	/*
	 * this function returns the color of the word by counting the how many pixels
	 * of each color there are in the image
	 */
	public static String getColor(String path) {
		Image image = new Image(path);
		String colour = null;

		int maxR = 0, maxB = 0, maxG = 0, maxP = 0, maxY = 0, maxO = 0;
		for (int i = START_IMAGE_WIDTH; i < END_IMAGE_WIDTH; i++) {
			for (int j = START_IMAGE_HEIGHT; j < END_IMAGE_HEIGHT; j++) {
				// canvas.setColor(image.red(i, j), image.green(i, j), image.blue(i, j));
				// canvas.drawRectangle(i - 300, j - 700, 1, 1);
				if (image.red(i, j) > 175) {
					if (image.blue(i, j) > 150) { // pink
						maxP++;
					} else if (image.green(i, j) > 140) { // yellow
						maxY++;
					} else if (image.green(i, j) > 100 && image.green(i, j) < 170) { // orange
						maxO++;
					} else {
						maxR++; // red
					}
				}
				if (image.blue(i, j) > 175) { // blue
					maxB++;
				}
				if (image.green(i, j) > 175) { // green
					maxG++;
				}
			}
		}
		// find the the biggest count of pixels
		int max = Math.max(Math.max(maxR, Math.max(maxB, maxG)), Math.max(Math.max(maxP, maxY), maxO));

		if (max == maxR)
			colour = "RED";
		else if (max == maxB)
			colour = "BLUE";
		else if (max == maxG)
			colour = "GREEN";
		else if (max == maxP)
			colour = "PINK";
		else if (max == maxY)
			colour = "YELLOW";
		else if (max == maxO)
			colour = "ORANGE";

		// return the biggest of the 6 colour values
		return colour;
	}

	public static String getName(String path) { // this method returns the word that is displayed on the screen
		String name = null;
		Image image = new Image(path);

		if (countWhitePixels(image) < 3600)
			name = "ORANGE";
		if (countWhitePixels(image) < 3100)
			name = "YELLOW";
		if (countWhitePixels(image) < 2990)
			name = "GREEN";
		if (countWhitePixels(image) < 2500)
			name = "PINK";
		if (countWhitePixels(image) < 2380)
			name = "BLUE";
		if (countWhitePixels(image) < 2000)
			name = "RED";
		else
			name="dssd";

		return name;
	}

	public static int countWhitePixels(Image image) {
		int whitePixels = 0;

		for (int i = START_IMAGE_WIDTH; i < END_IMAGE_WIDTH; i++) {
			for (int j = START_IMAGE_HEIGHT; j < END_IMAGE_HEIGHT; j++) {
				if (image.red(i, j) > 0 && image.blue(i, j) > 0 && image.green(i, j) > 0) {
					whitePixels++;
				}
			}
		}
		return whitePixels;
	}

	public static void printOnCanvas(Image img) {
		EasyGraphics canvas = new EasyGraphics(800, 800);
		for (int i = START_IMAGE_WIDTH; i < END_IMAGE_WIDTH; i++) {
			for (int j = START_IMAGE_HEIGHT; j < END_IMAGE_HEIGHT; j++) {
				canvas.setColor(img.red(i, j), img.green(i, j), img.blue(i, j));
				canvas.drawRectangle(i - START_IMAGE_WIDTH + 100, j - START_IMAGE_HEIGHT + 100, 1, 1);
			}
		}
	}
}
