package school.hei.sary.endpoint.rest.controller;

import java.io.IOException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import school.hei.sary.service.SaryService;

@RestController
public class SaryController {

  SaryService saryService;

  @RequestMapping(
      path = "/blacks/{id}",
      method = RequestMethod.PUT,
      consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
  public String turnToBlack(@PathVariable String id, @RequestPart MultipartFile image) {
    try {
      return saryService.transformImage(id, image);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @GetMapping("/blacks/{id}")
  public String getBlackedImage(@PathVariable String id) {
    return id + "is blacked";
  }
}
