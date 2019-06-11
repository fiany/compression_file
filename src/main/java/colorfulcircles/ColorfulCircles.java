package colorfulcircles;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.lang.Math;

public class ColorfulCircles extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override

	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root, 800, 600, Color.BLACK);
		primaryStage.setScene(scene);

		// 在代码行promaryStage.show()之前添加例7-2中的代码来添加30个圆圈
		Group circles = new Group();
		for (int i = 0; i < 30; i++) {
			Circle circle = new Circle(150, Color.web("white", 0.05));
			circle.setStrokeType(StrokeType.OUTSIDE);
			circle.setStroke(Color.web("white", 0.16));
			circle.setStrokeWidth(10);
			circles.getChildren().add(circle);
		}
		// 现在我们来创建一个带有线性渐变的矩形，代码如例7-4所示。将代码插入到代码行root.getChildren().add(circles)之前，这样使得渐变矩形显示到圆圈的后面
		Rectangle colors = new Rectangle(scene.getWidth(), scene.getHeight(),
				new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE,
						new Stop[] { new Stop(0, Color.web("#f8bd55")), new Stop(0.14, Color.web("#c0fe56")),
								new Stop(0.28, Color.web("#5dfbc1")), new Stop(0.43, Color.web("#64c2f8")),
								new Stop(0.57, Color.web("#be4af7")), new Stop(0.71, Color.web("#ed5fc2")),
								new Stop(0.85, Color.web("#ef504c")), new Stop(1, Color.web("#f2660f")), }));
		colors.widthProperty().bind(scene.widthProperty());
		colors.heightProperty().bind(scene.heightProperty());

		// 蒙版混合效果来使scene变暗
		Group blendModeGroup = new Group(
				new Group(new Rectangle(scene.getWidth(), scene.getHeight(), Color.BLACK), circles), colors);
		colors.setBlendMode(BlendMode.OVERLAY);
		root.getChildren().add(blendModeGroup);
		// 这行代码将模糊范围设置为10像素高*10像素宽、模糊迭代次数设置为3，它产生了的效果与高斯模糊类似。这种模糊生成技术在圆圈的边缘处产生了一种平滑的效果
		circles.setEffect(new BoxBlur(10, 10, 3));

		// 添加动画
		Timeline timeline = new Timeline();

		for (Node circle : circles.getChildren()) {
			timeline.getKeyFrames()
					.addAll(new KeyFrame(Duration.ZERO, // set start position at
									// 0
									new KeyValue(circle.translateXProperty(), Math.random() * 800),
									new KeyValue(circle.translateYProperty(), Math.random() * 600)),

							new KeyFrame(new Duration(40000), // set end
									// position at
									// 40s
									new KeyValue(circle.translateXProperty(), Math.random() * 800),
									new KeyValue(circle.translateYProperty(), Math.random() * 600)));
		}

		// play 40s of animation
		timeline.play();
		primaryStage.show();
	}

}
