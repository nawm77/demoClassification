package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {
    @GetMapping("/")
    public String mainPage(){
        return "index";
    }

//    @PostMapping("/api/v1/post")
//    public String getImage(){
//        return "null";
//    }
//    @RequestMapping(value = "/controller/path/saveCanvasImage", method = RequestMethod.POST)
//    @ResponseBody
//    public Map<String,Object> saveCanvasImage(
//        @RequestParam(value="imageBase64", defaultValue="")String imageBase64) {
//    Map<String,Object> res = new HashMap<String, Object>();
//
//    File imageFile = new File("/home/data/canvasImage.png");
//    try{
//        byte[] decodedBytes = DatatypeConverter.parseBase64Binary(imageBase64.replaceAll("data:image/.+;base64,", ""));
//        BufferedImage bfi = ImageIO.read(new ByteArrayInputStream(decodedBytes));
//        ImageIO.write(bfi , "png", imageFile);
//        bfi.flush();
//        res.put("ret", 0);
//    }catch(Exception e){
//        res.put("ret", -1);
//        res.put("msg", "Cannot process due to the image processing error.");
//        return res;
//    }
//    return res;
//}

    @PostMapping("/{url}")
    public String savePic(@RequestParam("url") String url){
        return url;
    }
}
