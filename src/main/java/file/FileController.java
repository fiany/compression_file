package file;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import net.coobird.thumbnailator.Thumbnails;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileController {
    @FXML
    private Text actiontarget;

    @FXML
    private TextField chooserDir;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
        actiontarget.setText("Sign in button pressed");
    }

    @FXML
    protected void openfile(ActionEvent event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("选择需要压缩的文件夹");
        File file = directoryChooser.showDialog(stage);
        chooserDir.setText(file.getAbsolutePath());
        List<File> fileList = getFileList(file.getAbsolutePath());
//        FileChooser fileChooser = new FileChooser();
//        fileChooser.setTitle("Open Resource File");
//        File file =fileChooser.showOpenDialog(stage);
        actiontarget.setText("Sign in button pressed");
        comperssionFile(fileList, file.getAbsolutePath());

    }

    /**
     * 获取文件夹下所有文件
     *
     * @param strPath
     * @return
     */
    public static List<File> getFileList(String strPath) {
        List<File> filelist = new ArrayList<>();
        File dir = new File(strPath);
        // 该文件目录下文件全部放入数组
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                // 判断是文件还是文件夹
                if (file.isDirectory()) {
                    // 获取文件绝对路径
                    List<File> fileList = getFileList(file.getAbsolutePath());
                    filelist.addAll(fileList);
                } else {
                    filelist.add(file);
                }
            }
        }
        return filelist;
    }

    /**
     * 压缩文件，
     *
     * @param fileList 需要压缩的文件
     * @param folder   原始文件夹
     */
    public static void comperssionFile(List<File> fileList, String folder) {
        String newFolder = folder + "--副本";
        File files = new File(newFolder);
        if (!files.exists()) {
            files.mkdirs();
        }
        for (File file : fileList) {
            try {
                Thumbnails.of(file.getAbsolutePath())
                        .scale(1f)
                        .outputQuality(0.5f)
                        .toFile(file.getAbsolutePath().replace(folder, newFolder));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
