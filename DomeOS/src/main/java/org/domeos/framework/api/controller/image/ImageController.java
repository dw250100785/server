package org.domeos.framework.api.controller.image;

import org.domeos.basemodel.HttpResponseTemp;
import org.domeos.framework.api.controller.ApiController;
import org.domeos.framework.api.model.image.BaseImage;
import org.domeos.framework.api.model.image.BuildImage;
import org.domeos.framework.api.service.image.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by baokangwang on 2016/4/6.
 */
@Controller
@RequestMapping("/api")
public class ImageController extends ApiController {

    @Autowired
    @Qualifier("imageService")
    ImageService imageService;

    @ResponseBody
    @RequestMapping(value = "/image/base/{id}", method = RequestMethod.GET)
    public HttpResponseTemp<?> getBaseImage(@PathVariable int id) {
        return imageService.getBaseImage(id);
    }

    @ResponseBody
    @RequestMapping(value = "/image/base", method = RequestMethod.POST)
    public HttpResponseTemp<?> setBaseImage(@RequestBody BaseImage baseImage) {
        return imageService.setBaseImage(baseImage);
    }

    @ResponseBody
    @RequestMapping(value = "/image/base", method = RequestMethod.GET)
    public HttpResponseTemp<?> listBaseImage() {
        return imageService.listBaseImage();
    }

    @ResponseBody
    @RequestMapping(value = "/image/base/{id}", method = RequestMethod.DELETE)
    public HttpResponseTemp<?> deleteBaseImage(@PathVariable int id) {
        return imageService.deleteBaseImage(id);
    }

    @ResponseBody
    @RequestMapping(value = "/image/build", method = RequestMethod.GET)
    public HttpResponseTemp<?> getBuildImage() {
        return imageService.getBuildImage();
    }

    @ResponseBody
    @RequestMapping(value = "/image/build", method = RequestMethod.POST)
    public HttpResponseTemp<?> setBuildImage(@RequestBody BuildImage buildImage) {
        return imageService.setBuildImage(buildImage);
    }

    @ResponseBody
    @RequestMapping(value = "/image", method = RequestMethod.GET)
    public HttpResponseTemp<?> getDockerImages() {
        return imageService.getDockerImages();
    }

    @ResponseBody
    @RequestMapping(value = "/image/detail", method = RequestMethod.GET)
    public HttpResponseTemp<?> getDockerImageInfoByName(@RequestParam String name, @RequestParam(value = "registry", required = false) String registry) {
        return imageService.getDockerImageDetailByProjectName(name, registry);
    }

    @ResponseBody
    @RequestMapping(value = "/image/all", method = RequestMethod.GET)
    public HttpResponseTemp<?> getAllDockerImages() {
        return imageService.getAllDockerImages();
    }

    @ResponseBody
    @RequestMapping(value = "/image/all/detail", method = RequestMethod.GET)
    public HttpResponseTemp<?> getDockerImageDetail(@RequestParam String name,  @RequestParam(value = "registry", required = false) String registry){
        return imageService.getDockerImageDetail(name, registry);
    }
}
