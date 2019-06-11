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
		primaryStage.setTitle("Button????????");

		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setPadding(new Insets(25, 25, 25, 25));

		// ?????????Button
		Button button1 = new Button();
		gridPane.add(button1, 0, 1);
		// ????????????????Button
		Button button2 = new Button("Accept");
		gridPane.add(button2, 0, 2);
		// ????????????????????Button
		Image imageOK = new Image("https://www.baidu.com/img/baidu_resultlogo@2.png");
		Button button3 = new Button("Acctpt", new ImageView(imageOK));
		gridPane.add(button3, 0, 3);
		// ???Button??????Labeled?????????????·??????????????????
		// ??setText(String text)method??????????
		// ??setGraphic(Node graphic)method??????????

		Image imageDecline = new Image("https://www.baidu.com/img/baidu_resultlogo@2.png");
		Button button4 = new Button();
		button4.setGraphic(new ImageView(imageDecline));
		gridPane.add(button4, 0, 4);
		// button4.setOnAction(ActionEvent e){
		//
		// });

		DropShadow shadow = new DropShadow();
		// button4.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e){
		// ??????????????????Ч
		// button3.setEffect(shadow);
		//?????????????????Ч??
//			button3.setEffect(null);
		// });
		Scene scene = new Scene(gridPane, 500, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
