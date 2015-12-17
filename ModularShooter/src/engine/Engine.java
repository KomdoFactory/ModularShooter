package engine;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import world.World;

public class Engine extends Application {

	private static Canvas canvas;
	private static GraphicsContext graphicalContext;
	private static AnimationTimer timer;

	static {
		setupCanvas();
		setupProtagonist();
	}

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		setupStage(primaryStage);
		canvas.requestFocus();
		setupAnimationTimer();

	}

	private static void setupProtagonist() {
		canvas.setOnKeyPressed(World.PROTAGONIST.getKeyPressed());
		canvas.setOnKeyReleased(World.PROTAGONIST.getKeyReleased());
	}

	private static void setupStage(final Stage stage) {
		stage.setTitle("Modular Shooter");
		stage.setScene(setupScene());
		stage.show();
	}

	private static Scene setupScene() {
		Pane pane = new Pane();
		pane.setStyle(" -fx-background-color: black");
		pane.getChildren().add(canvas);
		return new Scene(pane, World.WIDTH, World.HEIGHT);
	}

	private static void setupCanvas() {
		canvas = new Canvas(World.WIDTH, World.HEIGHT);
		canvas.setFocusTraversable(true);
		graphicalContext = canvas.getGraphicsContext2D();
	}

	private static void setupAnimationTimer() {

		timer = new HeartBeat(graphicalContext);
		timer.start();

	}

	@SuppressWarnings("unused")
	private static void printCanvas(Canvas canvas) { // NOSONAR
		try {
			String path = "C:/Users/shu/Desktop/";
			System.out.println("Exporting Image"); // NOSONAR
			SnapshotParameters sp = new SnapshotParameters();
			WritableImage image = canvas.snapshot(sp, null);
			BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
			File file = new File(path + World.WIDTH + "x" + World.HEIGHT + ".png");
			ImageIO.write(bImage, "png", file);
			System.out.println("DONE!"); // NOSONAR
		} catch (Exception e) { // NOSONAR

		}
	}

}
