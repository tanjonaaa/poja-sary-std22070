package school.hei.sary.endpoint.rest.controller;

import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import school.hei.sary.repository.model.ImageModel;
import school.hei.sary.service.SaryService;

@RestController
public class SaryController {
  private final SaryService saryService;

  public SaryController(SaryService saryService) {
    this.saryService = saryService;
  }

  @RequestMapping(
          path = "/blacks/{id}",
          method = RequestMethod.PUT,
          consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}
  )
  public String turnToBlack(@PathVariable(name = "id") String id, @ModelAttribute ImageModel image)
      throws IOException {
    return saryService.transformImage(id, image.getFile());
  }

  @GetMapping("/blacks/{id}")
  public String getBlackedImage(@PathVariable String id) {
    return id + "is blacked";
  }
}
