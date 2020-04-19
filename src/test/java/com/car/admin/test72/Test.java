package com.car.admin.test72;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class Test {
    File imageFile;
    String path;

    public Test(String path) {
        this.imageFile = new File(path);
        this.path = path;
    }

    public void clearWaterMark() throws IOException {
        BufferedImage bi = ImageIO.read(imageFile);
        //水印替换成白色
        Color disColor = new Color(255, 255, 255);
        for (int i = 0; i < bi.getWidth(); i++) {
            for (int j = 0; j < bi.getHeight(); j++) {
                int color = bi.getRGB(i, j);
                Color oriColor = new Color(color);
                int red = oriColor.getRed();
                int greed = oriColor.getGreen();
                int blue = oriColor.getBlue();
                //245,245,245是灰色  这里是把当前像素点由灰色替换成白色
                if (red == 245 && greed == 245 && blue == 245) {
                    bi.setRGB(i, j, disColor .getRGB());
                }
            }
        }
        String type = path.substring(path.lastIndexOf(".") + 1, path.length());
        Iterator<ImageWriter> it = ImageIO.getImageWritersByFormatName(type);
        ImageWriter writer = it.next();

        //在填写文件路径时，一定要写上具体的文件名称（xx.txt），否则会出现拒绝访问。
        File file = new File("D:/imgs");
        if(!file.exists()){
            //先得到文件的上级目录，并创建上级目录，在创建文件
            file.getParentFile().mkdir();
            try {
                //创建文件
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        File f = new File("D:/imgs");
        f.getParentFile().mkdirs();
        ImageOutputStream ios = ImageIO.createImageOutputStream(f);
        writer.setOutput(ios);
        writer.write(bi);
        bi.flush();
        ios.flush();
        ios.close();
    }

    public static void main(String[] args) throws IOException {
        Test t = new Test("D:/imgs/1.jpg");
        t.clearWaterMark();
    }
}
