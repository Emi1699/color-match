package mainPackage;

import sheffield.EasyGraphics;

public class MatchColor {
	public static final String path = "images/shot.jpg";

	public static void main(String[] args) throws InterruptedException {
		EasyGraphics canvas = new EasyGraphics(150, 150);

		while (true) {
			Screenshot.screenshotTo(path);
			DryImage.blackenize("shot", ImageProcessor.START_IMAGE_WIDTH, ImageProcessor.END_IMAGE_WIDTH,
					ImageProcessor.START_IMAGE_HEIGHT, ImageProcessor.END_IMAGE_HEIGHT);

			String name = ImageProcessor.getName("images/shot_black.jpg");

			canvas.clear();
			canvas.drawString(name, 20, 70, 30);
		}
	}
}
