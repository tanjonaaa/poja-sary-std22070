package school.hei.sary.endpoint.rest.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import school.hei.sary.service.SaryService;

@RestController
public class SaryController {

  @Autowired private SaryService saryService;

  @RequestMapping(
      method = RequestMethod.PUT,
      path = "/blacks/{id}",
      consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
  public String turnToBlack(
      @PathVariable(name = "id") String id, @RequestPart(name = "file") MultipartFile file)
      throws IOException {
    return this.saryService.transformImage(id, file);
  }

  @GetMapping("/blacks/{id}")
  public String getBlackedImage(@PathVariable String id) {
    return id + "is blacked";
  }
}
