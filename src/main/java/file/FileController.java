package file;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
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
            String newFilePath = file.getAbsolutePath().replace(folder, newFolder);
            try {
                Thumbnails.of(file.getAbsolutePath())
                        .scale(1f)
                        .outputQuality(0.5f)
                        .toFile(newFilePath);
                Thumbnails.of(newFilePath)
                        .scale(1f)
                        .watermark(Positions.BOTTOM_RIGHT, handleTextWaterMark("hello"), 1f)
//                        .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("C:\\Users\\Administrator\\Desktop\\fsdownload\\nihao--副本\\happy.jpeg")), 1f)
                        .outputQuality(0.8f)
                        .toFile(newFilePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    /**
     * @return java.awt.image.BufferedImage
     * @throws
     * @description 操纵文字型水印
     * @params [address, dealerName, latitudeCommaLongitude, date]
     */
    private static BufferedImage handleTextWaterMark(String address) {

        final Font font = new Font("SansSerif",Font.BOLD,30);

        BufferedImage image = new BufferedImage(200, 50, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        image = g.getDeviceConfiguration().createCompatibleImage(200, 50, Transparency.TRANSLUCENT);

        int y = 0;
        int divider30 = 30;

        g = image.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.red);
        g.setFont(font);

        if (StringUtils.isNotBlank(address)) {
            g.drawString("库存点地址：" + address, 5, y += divider30);
        }

        g.dispose();
        return image;
    }

    public static void main(String[] args) throws IOException {
        BufferedImage hell = handleTextWaterMark("hell");
        ImageIO.write(hell, "png", new File("C:\\Users\\Administrator\\Desktop\\fsdownload\\nihao--副本\\hel.jpg"));
        String file = "C:\\Users\\Administrator\\Desktop\\fsdownload\\nihao--副本\\批注 2019-06-12 142522.png";
        Thumbnails.of(file)
                .scale(1f)
                .watermark(Positions.BOTTOM_RIGHT, hell, 1f)
//                        .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("C:\\Users\\Administrator\\Desktop\\fsdownload\\nihao--副本\\happy.jpeg")), 1f)
                .outputQuality(0.8f)
                .toFile(file);

    }

}
