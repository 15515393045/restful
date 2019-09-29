package com.car.admin.test53;

import javax.swing.*;
import java.awt.*;

public class JScrollPaneDemo extends JFrame {

    public JScrollPaneDemo() {


        Container container = this.getContentPane();

        JTextArea tArea = new JTextArea(20, 50);        // 创建文本区域组件
        tArea.setText("Hello World");

        JScrollPane sp = new JScrollPane(tArea);
        container.add(sp);

        this.setVisible(true);
        this.setSize(300, 150);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JScrollPaneDemo();
    }

}