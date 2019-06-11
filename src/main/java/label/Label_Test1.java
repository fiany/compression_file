package label;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Label_Test1 extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Label练习");
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setPadding(new Insets(25, 25, 25, 25));
		// 开始添加Label
		// 1、一个空的Label
		Label label1 = new Label();
		label1.setText("后添加的Label内容");
		label1.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("label_search.jpg"))));
		gridPane.add(label1, 0, 0);

		// 2、一个带文本元素的Label
		Label label2 = new Label("Search");
		gridPane.add(label2, 0, 1);
		label2.setTextFill(Color.web("#0076a3"));

		// 3、一个带文本和图标的Label
//		Image image = new Image(getClass().getResourceAsStream("label_search.jpg"));
//		Label label3 = new Label("Search", new ImageView(image));
		Label label3 = new Label("Search");
		gridPane.add(label3, 0, 2);
		// 设置文本和图标之间的间距
		label3.setGraphicTextGap(50);
		// 使用setTextAlignment()方法改变其对齐方向
		label3.setTextAlignment(TextAlignment.RIGHT);
		// setContentDisplay(ContentDisplay
		// value)方法定义图形与文本的相对位置，ContentDisplay常量的可选值为:居左LEFT，居右RIGHT，居中CENTER，居上TOP，居下BOTTOM。
		label3.setContentDisplay(ContentDisplay.TOP);

		Label label4 = new Label("使用Font类的构造函数来构造Font对象");
		// 使用Font类的构造函数来构造Font对象
		label4.setFont(new Font("Arial", 30));
		gridPane.add(label4, 0, 3);
		//

		Label label5 = new Label("使用Font类的font静态方法");
		// 使用Font类的font静态方法
		label5.setFont(Font.font("Cambria", 32));
		gridPane.add(label5, 0, 4);

		Label label6 = new Label("A label that needs to be wrapped hello ketty,good night");
		label6.setFont(Font.font("Cambria", 32));
		label6.setWrapText(true);
		gridPane.add(label6, 0, 5);


		Label label7 = new Label("Values");
		label7.setFont(new Font("Cambria", 32));
		label7.setRotate(270);
		label7.setTranslateY(50);
		gridPane.add(label7, 0, 6);


		Label label8 = new Label("Values");
		label8.setFont(new Font("Cambria", 32));

//		label8.setOnMouseEntered((MouseEvent e){
//		    label8.setScaleX(1.5);
//		    label8.setScaleY(1.5);
//		});
//
//		label8.setOnMouseExited((MouseEvent e){
//		    label8.setScaleX(1);
//		    label8.setScaleY(1);
//		});


		gridPane.setGridLinesVisible(true);
		Scene scene = new Scene(gridPane, 500, 800);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
