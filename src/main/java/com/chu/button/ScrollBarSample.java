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
 * ��ε�����ҵĻ����ߵ�����Ϊ��Ԫ���ڵ�Ӱ�죬���岻����Ϊʲô��Ӱ�쵽����������֪������Ϊ���ڵ�����Ӱ��������ҵı�ֵ��
 * �����������й����г�ͨ��������ɵı�ֵ��������ڹ�����һ��ֵ�����ڻ���ͻỨ���������ң��ͻ�����ʱ�������
 * ���ڵ��������ͨ�����ˣ��г����������½�����ͻ���ɹ���ͨ�������������࣬Ǯ�٣�������Ҿͻ���ֵ��������г�������������
 * Ȼ���������½���¥�б��̡��й�Ϊ����������������֣����н�����׼��������й��г��϶���ܶ������ʽ�
 * ������Ĺ�����ǿ��������������Ҷ��ˣ���۾Ͳ����½�������������ۻ����ǣ����Ӧ������Ҿ�Ҫ��ֵ�����Է��ӿ��ܾ�Ҫ�����ˡ�
 * 
 * ��֮���ǡ�����������ұ�ֵ���ʱ��ͻ����������г��ĵ����¹�������Ҿͻ���ֵ�����ƹ����ϵ�����ұ�ֵ�����������һ��ֵ����۾�
 * �½���¥�о�Ҫ�군��Ȼ�����зų��ö�Ǯ�������������ֵ��
 * 
 * @author chuer
 * @Description:
 * @date 2015��2��5�� ����10:51:23
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