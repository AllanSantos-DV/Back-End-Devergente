package br.com.devergente.services;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.SneakyThrows;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Objects;

public class S3Services {
    public String uploadParaS3(MultipartFile file, String region, String bucketName, String folderName)  {
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withRegion(region)
                .build();

        File convFile = new File(Objects.requireNonNull(file.getOriginalFilename()));

        String fileName = folderName + System.currentTimeMillis() + "_" + convFile.getName();
        s3Client.putObject(new PutObjectRequest(bucketName, fileName, convFile));
        return s3Client.getUrl(bucketName, fileName).toString();
    }

    @SneakyThrows
    private File convertMultiPartToFile(MultipartFile file) {
        File convFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
        try (FileOutputStream fos = new FileOutputStream(convFile)) {
            fos.write(file.getBytes());
        }
        return convFile;
    }

}
