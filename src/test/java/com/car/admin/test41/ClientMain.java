package com.car.admin.test41;

public class ClientMain {
/*
    public static void main(String[] args) {

        GroupReceiver group = new CodeGroup();
        group.find();
        group.add();
        group.change();

    }*/

    public static void main(String[] args) {
        //定义接头人
        Invoker invoker = new Invoker();
        // 客户下命令
        Command command = new AddRequirementCommand();
        // 接头人接受命令
        invoker.setCommand(command);
        // 接头人执行命令
        invoker.action();
    }

}
