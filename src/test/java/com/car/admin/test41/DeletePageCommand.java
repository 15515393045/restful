package com.car.admin.test41;

public class DeletePageCommand extends Command{
    @Override
    public void execute() {
        super.pg.find();
        super.pg.delete();
        super.pg.plan();
    }
}
