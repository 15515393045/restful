package com.car.admin.test91;

import java.awt.image.PixelGrabber;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-09-07 00:17
 **/
public class pig extends Animal{

   public pig(){
        super();
    }

    public pig(String name){
        super(name);
    }

    public String shout(){

        String result = "";
        for (int i = 0; i < shoutNum; i++) {
            result += "哼  ";
        }
        return "我的名字叫"+name+"\t"+result;
    }
}
