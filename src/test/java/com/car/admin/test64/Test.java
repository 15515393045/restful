package com.car.admin.test64;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-09-30 17:13
 **/
public class Test {

   /* public static void main(String[] args) {
        List<RoleBean> list = new ArrayList<>();
        RoleBean roleBean = null;
        Random random = new Random();
        for(int i=0;i<5;i++){
            roleBean = new RoleBean();
            roleBean.setAge(random.nextInt(3));
            list.add(roleBean);
        }
        for (int i = 0; i < list.size(); i++) {
            RoleBean roleBean1 = list.get(i);
            System.out.println(roleBean1.getAge());
        }
    }*/

    public static void main(String[] args) {
        RoleBean roleBean = new RoleBean("张三",12,"男");
        int age = roleBean.getAge();
        System.out.println(age);

        RoleBean zi = new Zi();//向上转型
        System.out.println(zi);
        Zi zi1 = (Zi) zi;//向下转型
        boolean b = zi1 instanceof RoleBean;
        if(b){
            zi1.zi();
        }
    }

}
