package sb.minio.a;

import io.minio.MinioClient;
import io.minio.PutObjectArgs;

import java.io.FileInputStream;

public class MinIOTest {
    public static void main(String[] args) {

        FileInputStream fileInputStream;
        try {

            fileInputStream = new FileInputStream("D:\\images\\touxiang.jpg");

            //1.创建minio链接客户端
            MinioClient minioClient = MinioClient.builder()
                    .credentials("minio", "minio666")
                    .endpoint("http://192.168.234.140:9000")
                    .build();
            //2.上传
            PutObjectArgs putObjectArgs = PutObjectArgs.builder().object("tx.jpg")//文件名
                    .contentType("image")//文件类型
                    .bucket("toutiao")//桶名词  与minio创建的名词一致
                    .stream(fileInputStream, fileInputStream.available(), -1) //文件流
                    .build();
            minioClient.putObject(putObjectArgs);

            //System.out.println("http://192.168.234.140:9001/toutiao/tx.jpg");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}