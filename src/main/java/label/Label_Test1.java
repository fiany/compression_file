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
		primaryStage.setTitle("Label��ϰ");
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setPadding(new Insets(25, 25, 25, 25));
		// ��ʼ���Label
		// 1��һ���յ�Label
		Label label1 = new Label();
		label1.setText("����ӵ�Label����");
		label1.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("label_search.jpg"))));
		gridPane.add(label1, 0, 0);

		// 2��һ�����ı�Ԫ�ص�Label
		Label label2 = new Label("Search");
		gridPane.add(label2, 0, 1);
		label2.setTextFill(Color.web("#0076a3"));

		// 3��һ�����ı���ͼ���Label
//		Image image = new Image(getClass().getResourceAsStream("label_search.jpg"));
//		Label label3 = new Label("Search", new ImageView(image));
		Label label3 = new Label("Search");
		gridPane.add(label3, 0, 2);
		// �����ı���ͼ��֮��ļ��
		label3.setGraphicTextGap(50);
		// ʹ��setTextAlignment()�����ı�����뷽��
		label3.setTextAlignment(TextAlignment.RIGHT);
		// setContentDisplay(ContentDisplay
		// value)��������ͼ�����ı������λ�ã�ContentDisplay�����Ŀ�ѡֵΪ:����LEFT������RIGHT������CENTER������TOP������BOTTOM��
		label3.setContentDisplay(ContentDisplay.TOP);

		Label label4 = new Label("ʹ��Font��Ĺ��캯��������Font����");
		// ʹ��Font��Ĺ��캯��������Font����
		label4.setFont(new Font("Arial", 30));
		gridPane.add(label4, 0, 3);
		//

		Label label5 = new Label("ʹ��Font���font��̬����");
		// ʹ��Font���font��̬����
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
