package com.car.admin;

import com.car.admin.util.ConvertDateType;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.region.Region;

import java.io.File;
import java.net.URL;
import java.util.Date;
import java.util.UUID;

public class CosDemo {


    public static void main(String[] args) {
        // 1 初始化用户身份信息（secretId, secretKey）。云API秘钥
        COSCredentials cred = new BasicCOSCredentials("AKIDA8qJYasyKlzzkGwaNuEKA4jIcgU47ZU9", "qTqyrVu4zpQlrjNmvob9Tu88sMbkUzJQ");
        // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        // clientConfig中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者接口文档 FAQ 中说明。
        ClientConfig clientConfig = new ClientConfig(new Region("ap-beijing"));
        // 3 生成 cos 客户端。用户身份信息和地域构成
        COSClient cosClient = new COSClient(cred, clientConfig);
        // bucket的命名规则为{name}-{appid} ，此处填写的为存储桶的名称必须是此格式,空间名称。
        String bucketName = "fh-1808-1258898786";

        //通过截取来动态上传文件的后缀名
        String fileName = "d:/aaa.jpg";
        //上传文件,本地上传的文件
        File localFile = new File(fileName);

        //通过当天时间来作为文件夹的名称.
        String strCurrDate = ConvertDateType.date2Str(new Date(), ConvertDateType.Y_M_D);
        // 指定要上传到 COS 上对象键,上传的Cos的文件路径和文件名称。嵌套一层就多一层包结构
        //通过UUID来作为文件名称确保文件不会被覆盖。    通过截取来动态上传文件的后缀名
        String key = strCurrDate+"/"+UUID.randomUUID().toString()+getSuffix(fileName);

        // 简单文件上传, 最大支持 5 GB, 适用于小文件上传, 建议 20 M 以下的文件使用该接口
        // 大文件上传请参照 API 文档高级 API 上传
        // 指定要上传到 COS 上的路径
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);

        //获取上传到Cos腾讯云的文件路径
        cosClient.putObject(putObjectRequest);
        cosClient.shutdown();
        Date expiration = new Date(new Date().getTime() + 5 * 60 * 10000);
        URL url = cosClient.generatePresignedUrl(bucketName, key, expiration);

        // PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);

        System.out.println(url);
    }

    private static String getSuffix(String fileName) {
        int index = fileName.lastIndexOf(".");
        String suffix = fileName.substring(index);
        return suffix;
    }

}
