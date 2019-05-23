package com.car.admin.util;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.region.Region;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.UUID;

public class CosUploadUtil {

    @Value("${COS.accessKey}")
    private String accessKey;

    @Value("${COS.secretKey}")
    private String secretKey;

    @Value("${COS.bucket}")
    private String bucket;

    @Value("${COS.region}")
    private String region;

    //工具类原始版
    public String upload(String url) {
        // 1 初始化用户身份信息（secretId, secretKey）。云API秘钥
        COSCredentials cred = new BasicCOSCredentials(accessKey, secretKey);
        // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        // clientConfig中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者接口文档 FAQ 中说明。
        ClientConfig clientConfig = new ClientConfig(new Region(region));
        // 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);
        // bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式,空间名称
        String bucketName = bucket;

        //通过截取来动态上传文件的后缀名
        String fileName = url;
        //上传文件,本地上传的文件
        File localFile = new File(fileName);

        //通过当天时间来作为文件夹的名称.
        String strCurrDate = ConvertDateType.date2Str(new Date(), ConvertDateType.Y_M_D);
        // 指定要上传到 COS 上对象键,上传的Cos的文件路径和文件名称。嵌套一层就多一层包结构
        //通过UUID来作为文件名称确保文件不会被覆盖。    通过截取来动态上传文件的后缀名
        String key = strCurrDate + "/" + UUID.randomUUID().toString() + getSuffix(fileName);

        // 简单文件上传, 最大支持 5 GB, 适用于小文件上传, 建议 20 M 以下的文件使用该接口
        // 大文件上传请参照 API 文档高级 API 上传
        // 指定要上传到 COS 上的路径
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);

        //获取上传到Cos腾讯云的文件路径
        cosClient.putObject(putObjectRequest);
        cosClient.shutdown();
        Date expiration = new Date(new Date().getTime() + 5 * 60 * 10000);
        URL Url = cosClient.generatePresignedUrl(bucketName, key, expiration);

        //将其转换为String类型
        String filePath = String.valueOf(Url);

        return filePath;
    }


    //工具类升级版
    public static String cosUtil(InputStream is, String filePath) {
        COSClient cosClient = null;
        String key = "";
        try {
            //构建客户端
            cosClient = buildCosClient();

            // bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式,空间名称
            String bucketName = StytemConcat.COS_BUCKET;

            // 指定要上传到 COS 上对象键
            //通过当天时间来作为文件夹的名称.
            String strCurrDate = ConvertDateType.date2Str(new Date(), ConvertDateType.Y_M_D);
            // 上传的Cos的文件路径和文件名称。嵌套一层就多一层包结构
            //通过UUID来作为文件名称确保文件不会被覆盖。    通过截取来动态上传文件的后缀名
            key = strCurrDate + "/" + UUID.randomUUID().toString() + getSuffix(filePath);

            // 解决：没有为流数据指定内容长度。流内容将被缓冲到内存中，并可能导致内存溢出错误。
            // 大文件上传请参照 API 文档高级 API 上传
            ObjectMetadata objectMetadata = new ObjectMetadata();
            try {
                // available 大小的意思   默认为 字节
                objectMetadata.setContentLength(is.available());
            } catch (IOException e) {
                e.printStackTrace();
            }

            // 指定要上传到 COS 上的路径
            //构建上传请求对象
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, is, objectMetadata);

            //上传
            cosClient.putObject(putObjectRequest);
        } finally {
            //对cosClient进行关机释放
            if (cosClient != null) {
                cosClient.shutdown();
            }
        }
        //返回一个可以访问图片的url地址
        return StytemConcat.COS_URL + key;
    }


    //删除Cos文件工具类
    public static void deleteCosFile(String fileName) {
        //判断旧路径如果不为空则证明有值,进行删除。
        if (fileName != null) {
            //构建客户端
            COSClient cosClient = buildCosClient();
            // 指定文件所在的存储桶
            String bucketName = StytemConcat.COS_BUCKET;
            cosClient.deleteObject(bucketName, fileName.replace(StytemConcat.COS_URL, ""));
        }
    }


    //构建客户端
    private static COSClient buildCosClient() {
        // 1 初始化用户身份信息（secretId, secretKey）。云API秘钥
        COSCredentials cred = new BasicCOSCredentials(StytemConcat.COS_ACCESSKEY, StytemConcat.COS_SECRETKEY);

        // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        // clientConfig中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者接口文档 FAQ 中说明。
        ClientConfig clientConfig = new ClientConfig(new Region(StytemConcat.COS_REGION));

        // 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);
        return cosClient;
    }

    //测试返回值
    public static void main(String[] args) {
        CosUploadUtil cosUploadUtil = new CosUploadUtil();

        String upload = cosUploadUtil.upload("d:/aaa.jpg");

        System.out.println(upload);
    }

    //进行切割得到后缀名,及.后面的内容包含.
    private static String getSuffix(String fileName) {
        int index = fileName.lastIndexOf(".");
        String suffix = fileName.substring(index);
        return suffix;
    }
}
