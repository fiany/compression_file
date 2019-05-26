package button;

import java.awt.event.ActionListener;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Button_Test1 extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Button测试例子");

		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setPadding(new Insets(25, 25, 25, 25));

		// 添加一个空的Button
		Button button1 = new Button();
		gridPane.add(button1, 0, 1);
		// 一个指定了文本标题的Button
		Button button2 = new Button("Accept");
		gridPane.add(button2, 0, 2);
		// 一个指定了文本标题和图标的Button
		Image imageOK = new Image(getClass().getResourceAsStream("ok1.png"));
		Button button3 = new Button("Acctpt", new ImageView(imageOK));
		gridPane.add(button3, 0, 3);
		// 因为Button类继承自Labeled类，你可以使用以下方法来指定按钮的内容：
		// ·setText(String text)method——指定文本
		// ·setGraphic(Node graphic)method——指定图标

		Image imageDecline = new Image(getClass().getResourceAsStream("3-3-2-decline-button.png"));
		Button button4 = new Button();
		button4.setGraphic(new ImageView(imageDecline));
		gridPane.add(button4, 0, 4);
		// button4.setOnAction(ActionEvent e){
		//
		// });

		DropShadow shadow = new DropShadow();
		// button4.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e){
		// 当鼠标进入按钮时添加阴影特效
		// button3.setEffect(shadow);
		//当鼠标离开按钮时移除阴影效果
//			button3.setEffect(null);
		// });
		Scene scene = new Scene(gridPane, 500, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
