package com.hhy.minio;

import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;

@SpringBootTest
class MinioDemoApplicationTests {
    /**把list.html上传到minio，并可以通过浏览器访问
     * @description:
     * @author: hhy
     * @date: 2023/7/31 16:32
     * @param: []
     * @return: void
     **/
    @Test
    void contextLoads() {
        FileInputStream fileInputStream = null;
        try {

            fileInputStream =  new FileInputStream("D:\\axios.min.js");;

            //1.创建minio链接客户端
            MinioClient minioClient = MinioClient
                    .builder()
                    .credentials("minio", "minio123")
                    .endpoint("http://192.168.200.130:9000")
                    .build();
            //2.上传
            PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                    .object("plugins/js/axios.min.js")//文件名
                    .contentType("text/js")//文件类型
                    .bucket("headline")//桶名词  与minio创建的名词一致
                    .stream(fileInputStream, fileInputStream.available(), -1) //文件流
                    .build();
            minioClient.putObject(putObjectArgs);

            System.out.println("http://192.168.200.130:9000/headline/list.html");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {

            fileInputStream =  new FileInputStream("D:\\list.html");;

            //1.创建minio链接客户端
            MinioClient minioClient = MinioClient
                    .builder()
                    .credentials("minio", "minio123")
                    .endpoint("http://192.168.200.130:9000")
                    .build();
            //2.上传
            PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                    .object("list.html")//文件名
                    .contentType("text/html")//文件类型
                    .bucket("headline")//桶名词  与minio创建的名词一致
                    .stream(fileInputStream, fileInputStream.available(), -1) //文件流
                    .build();
            minioClient.putObject(putObjectArgs);

            System.out.println("http://192.168.200.130:9000/headline/list.html");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
