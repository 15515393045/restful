package com.car.admin.test23;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Random;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-12-07 23:46
 **/
public class ImgCodeTest {
/*

    // 定义要生成二维码的基本参数
    private static int width = 300;
    private static int height = 300;
    private static String type = "png";
    private static String content = "https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=false&word=%E7%BE%8E%E5%A5%B3&hs=2&pn=0&spn=0&di=192390&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&ie=utf-8&oe=utf-8&cl=2&lm=-1&cs=2719981758%2C116836634&os=3058584507%2C344135163&simid=4244274747%2C827987054&adpicid=0&lpn=0&ln=30&fr=ala&fm=&sme=&cg=girl&bdtype=0&oriquery=%E7%BE%8E%E5%A5%B3&objurl=http%3A%2F%2Fpic1.win4000.com%2Fpic%2F7%2F66%2F3081513633.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Bi1-pjv_z%26e3BvgAzdH3F%25E0%25BB%25BE%25En%25bb%25Ad%25Eb%25bn%25bC%25E0%25BC%25b0%25Ec%25BA%25A8%25En%25bd%25Bn%25El%25bD%25la%25Em%25AC%25l8%25Em%25Bl%25A8AzdH3F&gsm=&islist=&querylist=";
    */
/**
     * @Description: 生成二维码
     * @Param: []
     * @return: void
     * @Author: zhanyh
     * @Date: 2019/8/26
     *//*

    public static void main(String[] args) {
        // 定义二维码的配置，使用HashMap
        HashMap hints = new HashMap();
        // 字符集，内容使用的编码
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        // 容错等级，H、L、M、Q
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        // 边距，二维码距离边的空白宽度
        hints.put(EncodeHintType.MARGIN, 2);

        try {
            // 生成二维码对象，传入参数：内容、码的类型、宽高、配置
            BitMatrix bitMatrix =  new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
            // 定义一个路径对象
            Path file = new File("D:/code.png").toPath();
            // 生成二维码，传入二维码对象、生成图片的格式、生成的路径
            MatrixToImageWriter.writeToPath(bitMatrix, type, file);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/
public static void main(String[] args) {
    String[] strings = {"詹一恒","关帅强","张三"};
    Random random = new Random();
   String name = strings[random.nextInt(3)];
    System.out.println(name);
}

}
