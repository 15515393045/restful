package com.car.admin.test43;


import org.apache.commons.lang3.StringUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URLEncoder;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-09-19 09:21
 **/
public class CSVUtils {

    /**
     * 功能说明：获取UTF-8编码文本文件开头的BOM签名。
     * BOM(Byte Order Mark)，是UTF编码方案里用于标识编码的标准标记。例：接收者收到以EF BB BF开头的字节流，就知道是UTF-8编码。
     * @return UTF-8编码文本文件开头的BOM签名
     */
    public static String getBOM() {

        byte b[] = {(byte)0xEF, (byte)0xBB, (byte)0xBF};
        return new String(b);
    }

    /**
     * 生成CVS文件
     * @param exportData
     *       源数据List
     * @param map
     *       csv文件的列表头map
     * @param outPutPath
     *       文件路径
     * @param fileName
     *       文件名称
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static File createCSVFile(List exportData, LinkedHashMap map, String outPutPath,
                                     String fileName) {
        File csvFile = null;
        BufferedWriter csvFileOutputStream = null;
        try {
            File file = new File(outPutPath);
            if (!file.exists()) {
                file.mkdirs();
            }
            //定义文件名格式并创建
            csvFile =new File(outPutPath+fileName+".csv");
            file.createNewFile();
            // UTF-8使正确读取分隔符","
            //如果生产文件乱码，windows下用gbk，linux用UTF-8
            csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(
                    csvFile), "UTF-8"), 1024);

            //写入前段字节流，防止乱码
            csvFileOutputStream.write(getBOM());
            // 写入文件头部
            for (Iterator propertyIterator = map.entrySet().iterator(); propertyIterator.hasNext();) {
                java.util.Map.Entry propertyEntry = (java.util.Map.Entry) propertyIterator.next();
                csvFileOutputStream.write((String) propertyEntry.getValue() != null ? (String) propertyEntry.getValue() : "" );
                if (propertyIterator.hasNext()) {
                    csvFileOutputStream.write(",");
                }
            }
            csvFileOutputStream.newLine();
            // 写入文件内容
            for (Iterator iterator = exportData.iterator(); iterator.hasNext();) {
                Object row = (Object) iterator.next();
                for (Iterator propertyIterator = map.entrySet().iterator(); propertyIterator
                        .hasNext();) {
                    java.util.Map.Entry propertyEntry = (java.util.Map.Entry) propertyIterator
                            .next();
                    String str=row!=null?((String)((Map)row).get( propertyEntry.getKey())):"";

                    if(StringUtils.isEmpty(str)){
                        str="";
                    }else{
                        str=str.replaceAll("\"","\"\"");
                        if(str.indexOf(",")>=0){
                            str="\""+str+"\"";
                        }
                    }
                    csvFileOutputStream.write(str);
                    if (propertyIterator.hasNext()) {
                        csvFileOutputStream.write(",");
                    }
                }
                if (iterator.hasNext()) {
                    csvFileOutputStream.newLine();
                }
            }
            csvFileOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                csvFileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return csvFile;
    }

    /**
     *     生成并下载csv文件
     * @param response
     * @param exportData
     * @param map
     * @param outPutPath
     * @param fileName
     * @throws IOException
     */
    @SuppressWarnings("rawtypes")
    public static void exportDataFile(HttpServletResponse response,List exportData, LinkedHashMap map, String outPutPath,String fileName) throws IOException{
        File csvFile = null;
        BufferedWriter csvFileOutputStream = null;
        try {
            File file = new File(outPutPath);
            if (!file.exists()) {
                file.mkdirs();
            }
            //定义文件名格式并创建
            csvFile =new File(outPutPath+fileName+".csv");
            if(csvFile.exists()){
                csvFile.delete();
            }
            csvFile.createNewFile();
            // UTF-8使正确读取分隔符","
            //如果生产文件乱码，windows下用gbk，linux用UTF-8
            csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), "UTF-8"), 1024);
            //写入前段字节流，防止乱码
            csvFileOutputStream.write(getBOM());
            // 写入文件头部
            for (Iterator propertyIterator = map.entrySet().iterator(); propertyIterator.hasNext();) {
                java.util.Map.Entry propertyEntry = (java.util.Map.Entry) propertyIterator.next();
                csvFileOutputStream.write((String) propertyEntry.getValue() != null ? (String) propertyEntry.getValue() : "" );
                if (propertyIterator.hasNext()) {
                    csvFileOutputStream.write(",");
                }
            }
            csvFileOutputStream.newLine();

            // 写入文件内容
            for (Iterator iterator = exportData.iterator(); iterator.hasNext();) {
                Object row = (Object) iterator.next();
                for (Iterator propertyIterator = map.entrySet().iterator(); propertyIterator
                        .hasNext();) {
                    java.util.Map.Entry propertyEntry = (java.util.Map.Entry) propertyIterator
                            .next();
                    String str=row!=null?((String)((Map)row).get( propertyEntry.getKey())):"";
                    if(StringUtils.isEmpty(str)){
                        str="";
                    }else{
                        str=str.replaceAll("\"","\"\"");
                        if(str.indexOf(",")>=0){
                            str="\""+str+"\"";
                        }
                    }
                    csvFileOutputStream.write(str);
                    if (propertyIterator.hasNext()) {
                        csvFileOutputStream.write(",");
                    }
                }
                if (iterator.hasNext()) {
                    csvFileOutputStream.newLine();
                }
            }
            csvFileOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                csvFileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        InputStream in = null;
        try {
            in = new FileInputStream(outPutPath+fileName+".csv");
            int len = 0;
            byte[] buffer = new byte[1024];

            OutputStream out = response.getOutputStream();
            response.reset();

            response.setContentType("application/csv;charset=UTF-8");
            response.setHeader("Content-Disposition","attachment; filename=" + URLEncoder.encode(fileName+".csv", "UTF-8"));
            response.setCharacterEncoding("UTF-8");
            while ((len = in.read(buffer)) > 0) {
                out.write(new byte[] { (byte) 0xEF, (byte) 0xBB, (byte) 0xBF });
                out.write(buffer, 0, len);
            }
            out.close();
        } catch (FileNotFoundException e) {
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    /**
     * 删除该目录filePath下的所有文件
     * @param filePath
     *      文件目录路径
     */
    public static void deleteFiles(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {
                    files[i].delete();
                }
            }
        }
    }

    /**
     * 删除单个文件
     * @param filePath
     *     文件目录路径
     * @param fileName
     *     文件名称
     */
    public static void deleteFile(String filePath, String fileName) {
        File file = new File(filePath);
        if (file.exists()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {
                    if (files[i].getName().equals(fileName)) {
                        files[i].delete();
                        return;
                    }
                }
            }
        }
    }

    /**
     * 测试数据
     * @param args
     */
   /* @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) {
        List exportData = new ArrayList<Map>();
        Map row1 = new LinkedHashMap<String, String>();
        row1.put("1", "11");
        row1.put("2", "12");
        row1.put("3", "13");
        row1.put("4", "14");
        row1.put("5", "14");
        exportData.add(row1);
        row1 = new LinkedHashMap<String, String>();
        row1.put("1", "21");
        row1.put("2", "22");
        row1.put("3", "23");
        row1.put("4", "24");
        row1.put("5", "24");
        exportData.add(row1);
        //列
        LinkedHashMap map = new LinkedHashMap();
        //设置列名
        map.put("1", "第一列名称");
        map.put("2", "第二列名称");
        map.put("3", "第三列名称");
        map.put("4", "第四列名称");
        map.put("5", "第五列名称");
        //这个文件上传到路径，可以配置在数据库从数据库读取，这样方便一些！
        String path = "E:/";

        //文件名=生产的文件名称+时间戳
        //String fileName = "文件导出";
        //long time = new Date().getTime();
        //String fileName = String.valueOf(time);

        //String s = UUID.randomUUID().toString().toUpperCase().replaceAll("-", "");
        //String fileName = s;

        int random = (int) ((Math.random()*9+1)*10000);
        String fileName = String.valueOf(random);

        File file = CSVUtils.createCSVFile(exportData, map, path, fileName);
        String fileName2 = file.getName();
        System.out.println("文件名称：" + fileName2);
    }*/
    public static void main(String[] args) {
        //注意Map为LinkedHashMap
        List exportData = new ArrayList<Map>();
        Map row1 = new LinkedHashMap<String, String>();
        row1.put("1", "张三");
        row1.put("2", "男");
        row1.put("3", "19");
        exportData.add(row1);
        row1 = new LinkedHashMap<String, String>();
        row1.put("1", "小红");
        row1.put("2", "女");
        row1.put("3", "16");
        exportData.add(row1);
        //列
        LinkedHashMap map = new LinkedHashMap();
        //设置列名
        map.put("1", "姓名");
        map.put("2", "性别");
        map.put("3", "年龄");

        String path = "E:/";

        String s = UUID.randomUUID().toString().toUpperCase().replaceAll("-", "");
        File aaa = CSVUtils.createCSVFile(exportData, map, path, s);
        String name = aaa.getName();
        System.out.println(name);


        //列
        LinkedHashMap columnMap = new LinkedHashMap();
        buildColumn(columnMap);


    }
    //构建CSV文件的列
    private static void buildColumn(LinkedHashMap columnMap) {
        columnMap.put("1","主键");
        columnMap.put("2","一级品牌ID");
        columnMap.put("3","一级品牌名称");
        columnMap.put("4","一级品牌编码");
        columnMap.put("5","品牌图标路径");
        columnMap.put("6","品牌首字母");
        columnMap.put("7","二级品牌ID");
        columnMap.put("8","二级品牌名称");
        columnMap.put("9","二级品牌编码");
        columnMap.put("10","车系ID");
        columnMap.put("11","车系名称");
        columnMap.put("12","车组ID");
        columnMap.put("13","车组名称");
        columnMap.put("14","销售车型ID");
        columnMap.put("15","销售车型名称");
        columnMap.put("16","车型大类");
        columnMap.put("17","车型一级分类");
        columnMap.put("18","车型二级分类");
        columnMap.put("19","国别名称");
        columnMap.put("20","国产/进口");
        columnMap.put("21","车身结构");
        columnMap.put("22","车门数");
        columnMap.put("23","厂家指导价");
        columnMap.put("24","新车购置价");
        columnMap.put("25","配置等级");
        columnMap.put("26","停产日期");
        columnMap.put("27","上市年份");
        columnMap.put("28","年款");
        columnMap.put("29","整备质量");
        columnMap.put("30","排量");
        columnMap.put("31","座位数");
        columnMap.put("32","外形尺寸");
        columnMap.put("33","备注");
        columnMap.put("34","发动机类型");
        columnMap.put("35","发动机描述");
        columnMap.put("36","发动机气门数");
        columnMap.put("37","功率");
        columnMap.put("38","气缸数");
        columnMap.put("39","气缸排列形式");
        columnMap.put("40","供油方式");
        columnMap.put("41","燃油标号");
        columnMap.put("42","进气形式");
        columnMap.put("43","配气机构");
        columnMap.put("44","燃油喷射形式");
        columnMap.put("45","排放标准");
        columnMap.put("46","动力类型");
        columnMap.put("47","前轮距");
        columnMap.put("48","后轮距");
        columnMap.put("49","前轮胎规格");
        columnMap.put("50","后轮胎规格");
        columnMap.put("51","备胎规格");
        columnMap.put("52","轴距");
        columnMap.put("53","四驱形式");
        columnMap.put("54","驱动形式");
        columnMap.put("55","ABS标示");
        columnMap.put("56","前制动器类型");
        columnMap.put("57","后制动器类型");
        columnMap.put("58","变速器类型");
        columnMap.put("59","变速器档位数");
        columnMap.put("60","理赔车型ID");
    }
}
