package com.car.admin.test43;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.car.admin.bean.Jy.NoticeBean;
import com.car.admin.bean.mysql.MySQLConfigBean;
import com.car.admin.mapper.JyNoticeBeanMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-09-24 13:10
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class CVSDemo {

    @Autowired
    private JyNoticeBeanMapper noticeBeanMapper;

    @Autowired
    private HttpServletResponse response;

    @Test
    public void test1(){
        List<NoticeBean> noticeBeans = noticeBeanMapper.selectList(null);
        List<NoticeBean> noticeInfo = noticeBeanMapper.findNoticeInfo();
        System.out.println(noticeInfo);
    }

    @Test
    public void test2(){
        //文件名称
        String fileName = UUID.randomUUID().toString().toUpperCase().replaceAll("-", "");


        //表信息配置
        List<MySQLConfigBean> mySQLNoticeConfig = noticeBeanMapper.findMySQLNoticeConfig();
        String s = JSON.toJSONString(mySQLNoticeConfig);
        JSONArray jsonArray = JSON.parseObject(s, JSONArray.class);
        //JSON数组无法转换JSON对象
        //LinkedHashMap<String,Object> map1 = JSON.toJavaObject(jsonArray, LinkedHashMap.class);
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String s1 = JSON.toJSONString(jsonObject);
            //转换LinkedHashMap
            LinkedHashMap<String,Object> map = JSON.parseObject(s1, LinkedHashMap.class);
            Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<String, Object> next = iterator.next();
                String key = next.getKey();
                Object value = next.getValue();
                System.out.println(key+"********************"+value);
            }
        }



        //存放数据
        List<Map<String,Object>> list = new ArrayList();
        for (MySQLConfigBean mySQLConfigBean : mySQLNoticeConfig) {
            LinkedHashMap  map = new LinkedHashMap();
            map.put(mySQLConfigBean.getOrdinalPosition(),mySQLConfigBean.getColumnComment());
            System.out.println(map);
        }
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //表数据
        List<NoticeBean> noticeInfo = noticeBeanMapper.findNoticeInfo();
        for (NoticeBean noticeBean : noticeInfo) {
            Map<String,Object> row1 = new LinkedHashMap<String, Object>();
            row1.put("1", noticeBean.getId());
            row1.put("2", noticeBean.getTitle());
            row1.put("3", noticeBean.getContent());
            row1.put("4", noticeBean.getVersion());
            row1.put("5", noticeBean.getOperatorId());
            row1.put("6", noticeBean.getPlatformFlag());
            row1.put("7", sm.format(noticeBean.getCreateTime()));
            row1.put("8", sm.format(noticeBean.getUpdateTime()));
            row1.put("9", sm.format(noticeBean.getEndTime()));
            list.add(row1);
        }

        LinkedHashMap  map = new LinkedHashMap();
        map.put("1","数据库主键ID");
        map.put("2","公告主题");
        map.put("3","公告内容");
        map.put("4","公告版本");
        map.put("5","操作人ID");
        map.put("6","平台标识");
        map.put("7","数据创建时间");
        map.put("8","数据更新时间");
        map.put("9","公告过期时间");

        CSVUtils.createCSVFile(list,map,"F:/",fileName);

    }

    @Test
    public void test3(){
        //表信息配置
        List<LinkedHashMap<String, Object>> mySQLEpcVehicleTypeConfig = noticeBeanMapper.findMySQLEpcVehicleTypeConfig();
        for (LinkedHashMap<String, Object> stringStringLinkedHashMap : mySQLEpcVehicleTypeConfig) {
            Map<String, Object> collect = stringStringLinkedHashMap.entrySet().stream().filter(e -> checkKey(e.getKey())).collect(Collectors.toMap(
                    e -> e.getKey(),
                    e -> e.getValue()
            ));
            System.out.println(collect);
        }

        //整数型
        Byte  a = 1;
        Short b = 2;
        Integer   c = 3;
        Long  d = 4l;
        //浮点型
        Float e = 1.5f;
        Double f = 2.4d;
        //布尔型
        Boolean g = a<b?true:false;
        //字符型
        char h = 'x';

        long longNum = 0x8000000000000000L;
        System.out.println(longNum);

        int intNum = 0x80000000;
        System.out.println(intNum);

        int maxIntNum = 0x7fffffff;
        System.out.println(maxIntNum);
    }

    public boolean checkKey(String key){
        if(key.equals("TABLE_CATALOG")||key.equals("TABLE_SCHEMA")||key.equals("TABLE_NAME")||
           key.equals("COLUMN_NAME")||key.equals("IS_NULLABLE")||key.equals("DATA_TYPE")||
           key.equals("NUMERIC_PRECISION")||key.equals("NUMERIC_SCALE")||key.equals("COLUMN_TYPE")||
           key.equals("COLUMN_KEY")||key.equals("EXTRA")||key.equals("PRIVILEGES")||key.equals("GENERATION_EXPRESSION")||
           key.equals("COLLATION_NAME")||key.equals("CHARACTER_OCTET_LENGTH")||key.equals("CHARACTER_MAXIMUM_LENGTH")||
           key.equals("CHARACTER_SET_NAME")){//||短路或 一旦遇到为结果true的表达式，将不在继续执行运算，直接得到结果true
            return false;
        }
        return true;
    }

    @Test
    public void test4(){
        /**
         * 从小到大
         * 隐式转换
         */
        byte i = 12;//1个字节8个bit,默认值0
        System.out.println("byte:"+i);
        short i2 = i;//2个字节16个bit,默认值0
        System.out.println("short:"+i2);
        int i3 = i;//4个字节32个bit,默认值0
        System.out.println("int:"+i3);
        long i4 = i;//8个字节64个bit,默认值0
        System.out.println("long:"+i4);
        float i5 = i;//4个字节32个bit,默认值0.0
        System.out.println("float:"+i5);
        double i6 = i;//8个字节64个bit,默认值0.0
        System.out.println("double:"+i6);


        char j = '²';//2个字节16个bit,默认值null
        System.out.println("char:"+j);
        int j3 = j;
        System.out.println("int:"+j3+"（bit）");
        long j4 = j;
        System.out.println("long:"+j4+"（bit）");
        float j5 = j;
        System.out.println("float:"+j5+"（bit）");
        double j6 = j;
        System.out.println("double:"+j6+"（bit）");

    }

  /*  public static void main(String[] args) {
        *//**
         * 从大到小
         * 强制转换，强制转换会丢失精度
         *//*
        double i = 178.33;
        System.out.println("double:"+i);
        float i1 = (float) i;
        System.out.println("float:"+i1);
        long i2 = (long) i;
        System.out.println("long:"+i2);
        int i3 = (int) i;
        System.out.println("int:"+i3);
        short i4 = (short) i;
        System.out.println("short:"+i4);
        byte i5 = (byte) i;
        System.out.println("byte:"+i5);
        char i6 = (char) i;
        System.out.println("char:"+i6);
    }*/

/*    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        String replace = UUID.randomUUID().toString().toUpperCase().replace("-", "");
        String replace1 = UUID.randomUUID().toString().toUpperCase().replace("-", "");
        StringBuilder append = builder.append(replace).append(",").append(replace1);
        System.out.println(append);

        //String[] str = {"E","8","8","B","0",C9201FF4208805549AC48DE7627ABDB4BDE97A047FBA7EA7A70592BF02D};

        String str = "328BBA0EE1D643AB936C834FEA447845,AF754C07AD834C4B8E2EE52D9F4E99CF," +
                "328BBA0EE1D643AB936C834FEA447845,AF754C07AD834C4B8E2EE52D9F4E99CF";
        int length = str.length();
        boolean contains = str.contains(",");
        System.out.println(contains);
        System.out.println(length);
        int i = str.indexOf("8");//找到垓值第一次出现的位置，返回其下标，下标从0开始。
        System.out.println(i);
        int i1 = str.lastIndexOf("8", 3);
        System.out.println(i1);
        char c = str.charAt(3);
        System.out.println(c);
        //输出从开始位置到结束位置处的字符串，注意不包含结束位置。包前不包后。substring(开始位置，结束位置)
        String substring = str.substring(0, str.length() - 1);
        System.out.println(substring);
        String substring1 = str.substring(33);//包前不报后
        System.out.println(substring1);
        //split("字符"):按照指定字符分割，返回数组。
        String[] split = str.split(",", 2);
        for (int j = 0; j < split.length; j++) {
            String s = split[j];
            System.out.println(s+"======");
        }
    }*/
   /* public static void main(String[] args) {
        String str = "328BBA0EE1D643AB936C834FEA447845,AF754C07AD834C4B8E2EE52D9F4E99CF," +
                "328BBA0EE1D643AB936C834FEA447845,AF754C07AD834C4B8E2EE52D9F4E99CF";
        // Limit参数4是代表返回元素的个数，不是分割的次数
        //分割后得到的数组最大长度不会超过limit的值，因此你的代码中limit=4，所以split的结果数组长度最大为4
        String[] split = str.split(",", 4);
        for (int j = 0; j < split.length; j++) {
            String s = split[j];
            System.out.println(s+"======");
        }
    }*/
        public static void main(String[] args) {
        /*    String str="abe1223cdd4fdk42l2k3k2";
            String strReplaceAll=str.replaceAll("2", "a");
            String strReplace=str.replace("2", "a");
            System.out.println(strReplaceAll);
            System.out.println(strReplace);
            String strReplace1=str.replaceAll("2", "\\\\\\\\");
            System.out.println(strReplace1);*/

            int[] arr = {45, 34, 59, 55};
            Arrays.sort(arr);
            System.out.println(JSON.toJSONString(arr));
            //一行一行解读
            int arr2[] = {23, 48, 12, 56, 45};//长度5
            //arr2.length-1 = 4
            for (int i = 0; i < arr2.length - 1; i++) {//下标从0开始,下标对应数组中的元素,即0是第一个元素23
                int i1 = arr2[i];//48,12,56,45
                for (int k = 0; k < arr2.length - 1 - i; k++) {
                    if (arr2[k] > arr2[k + 1]) {//从小到大
                        //换位置。大的数和小的数换位子,小数在前大数在后
                        int l = arr2[k];
                        arr2[k] = arr2[k + 1];
                        arr2[k + 1] = l;
                    }
                }
            }
            for (int i = 0; i < arr2.length; i++) {
                System.out.print(arr2[i] + ",");
            }

            //将第i位上的元素与其后的每一个元素分别比较，每次遇见更小的，就将两个元素交换位置
            //第i位上的元素确定之后再继续确定第i+1位上的元素
            int arr3[] = {23, 48, 12, 56, 45};
            int temp;
            for (int i = 0; i < arr3.length; i++) {
                for (int j = i + 1; j < arr3.length; j++) {
                    if (arr3[i] > arr3[j]) {
                        temp = arr3[i];
                        arr3[i] = arr3[j];
                        arr3[j] = temp;
                    }
                }
            }


            int arr4[] = {23, 12, 48, 56, 45};//5
            for (int i = 0; i < arr4.length; i++) {
                int tem = i;
                //将数组中从i开始的最小的元素所在位置的索引赋值给tem
                for (int j = i; j < arr4.length; j++) {
                    if (arr4[j] < arr4[tem]) {
                        tem = j;
                    }
                }
                //上面获取了数组中从i开始的最小值的位置索引为tem，利用该索引将第i位上的元素与其进行交换
                int temp1 = arr4[i];
                arr4[i] = arr4[tem];
                arr4[tem] = temp1;

            }


            //将数组第i位上的元素与第arr.length-i-1位上的元素进行交换
            int []arr5={23,12,48,56,45};
            for(int i=0;i<arr5.length/2;i++) {
                int tp=arr5[i];
                arr5[i]=arr5[arr5.length-i-1];
                arr5[arr5.length-i-1]=tp;
            }
            for (int i = 0; i < arr5.length; i++) {
                int i1 = arr5[i];
                System.out.println(i1);
            }


            int []arr6={23,12,48,56,45};
            for (int i = 1; i < arr6.length; i++) {
                for (int j = i; j > 0; j--) {
                    if (arr6[j - 1] > arr6[j]) {//大的放后面
                        int tmp = arr6[j - 1];
                        arr6[j - 1] = arr6[j];
                        arr6[j] = tmp;
                    }
                }
            }
            for (int i = 0; i < arr6.length; i++) {
                int i1 = arr6[i];
                System.out.print(i1+",");
            }
        }

}


