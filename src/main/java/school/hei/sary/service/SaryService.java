package school.hei.sary.service;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import school.hei.sary.file.BucketComponent;
import school.hei.sary.repository.TransformationRepository;

@Service
public class SaryService {

  private final TransformationRepository transformationRepository;
  private final BucketComponent bucketComponent;
  private final String directory = "sary/";

  public SaryService(
      TransformationRepository transformationRepository, BucketComponent bucketComponent) {
    this.transformationRepository = transformationRepository;
    this.bucketComponent = bucketComponent;
  }

  public String transformImage(String id, MultipartFile image) throws IOException {
    String suffix = "." + FilenameUtils.getExtension(image.getOriginalFilename());
    String prefix = id + "-initial";
    String bucketKey = directory + prefix + suffix;
    File toUpload = File.createTempFile(prefix, suffix);
    image.transferTo(toUpload);
    bucketComponent.upload(toUpload, bucketKey);
    return bucketComponent.presign(bucketKey, Duration.ofMinutes(15)).toString();
  }
}
