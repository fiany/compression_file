package com.fiany;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TableController {

    @FXML
    public Text mytext;

    @FXML
    public TextField mytext1;

    @FXML
    public void showDateTime(ActionEvent event) throws InterruptedException {
        System.out.println("Button Clicked!");


        String str = mytext1.getText();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Date now = new Date();
                DateFormat df = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");
                String dateTimeString = df.format(now);
                mytext.setText("现在时间是："+dateTimeString);
            }
        }).start();

    }
}
