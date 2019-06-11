package com.chu.button;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * 这次的人民币的汇率走低是因为美元周期的影响，具体不明白为什么会影响到，但是我们知道是因为外在的因素影响了人民币的贬值，
 * 而不是我们中国的市场通货膨胀造成的贬值。人民币在国际上一贬值，进口货物就会花更多的人民币，就会造成资本外流，
 * 国内的人民币流通就少了，市场购买力就下降，这就会造成国内通货紧缩（东西多，钱少），人民币就会升值（这就是市场调节能力）。
 * 然后就是物价下降，楼市崩盘。中国为了抑制这种情况出现，央行紧急降准。这就让中国市场上多出很多流动资金，
 * 把人民的购买力强行拉上来，人民币多了，物价就不会下降，反而可能物价会上涨，相对应的人民币就要贬值，所以房子可能就要更贵了。
 *
 * 总之就是。国际上人民币贬值，资本就会外流，在市场的调节下国内人民币就会升值来抑制国际上的人民币贬值。国内人民币一升值，物价就
 * 下降，楼市就要完蛋。然后央行放出好多钱，不让人民币升值。
 *
 * @author chuer
 * @Description:
 * @date 2015年2月5日 上午10:51:23
 * @version V1.0
 */
public class ScrollBarSample extends Application {

	final ScrollBar sc = new ScrollBar();
	final Image[] images = new Image[5];
	final ImageView[] pics = new ImageView[5];
	final VBox vb = new VBox();
	DropShadow shadow = new DropShadow();

	@Override
	public void start(Stage stage) {
		Group root = new Group();
		Scene scene = new Scene(root, 500, 180);
		scene.setFill(Color.BLACK);
		stage.setScene(scene);
		stage.setTitle("Scrollbar");
		root.getChildren().addAll(vb, sc);

		shadow.setColor(Color.GREY);
		shadow.setOffsetX(2);
		shadow.setOffsetY(2);

		vb.setLayoutX(5);
		vb.setSpacing(10);

		sc.setLayoutX(scene.getWidth() - sc.getWidth());
		sc.setMin(0);
		sc.setOrientation(Orientation.VERTICAL);
		sc.setPrefHeight(180);
		sc.setMax(360);

		sc.setUnitIncrement(10.0);
		sc.setBlockIncrement(5.0);

		for (int i = 0; i < 5; i++) {
			final Image image = images[i] = new Image(getClass()
					.getResourceAsStream("label_search.jpg"));
			final ImageView pic = pics[i] = new ImageView(images[i]);
			pic.setEffect(shadow);
			vb.getChildren().add(pics[i]);
		}

		sc.valueProperty().addListener((ov, old_val, new_val) -> {
			vb.setLayoutY(-new_val.doubleValue());
		});

		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}