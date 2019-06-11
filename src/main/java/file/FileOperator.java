package file;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author fiany
 * @date 2019/6/11 9:50
 */
public class FileOperator extends Application {

    public static void main(String[] args) {
        Application.launch(FileOperator.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(FileOperator.class.getResource("/xml/fileOperator.fxml"));
        stage.setTitle("file Welcome");
        stage.setScene(new Scene(root, 300, 275));
        stage.show();
    }

}
