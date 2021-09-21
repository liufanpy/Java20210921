package com.itheima.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class Controller06 {

    /**
     *   传统的文件上传：
     * @param file 表示我们页面提交上来的文件，被SpringMVC 使用这个对象来包装了。
     * @return
     */
    @RequestMapping("/fileUpload")
    public String fileUpload(MultipartFile file  , HttpServletRequest request) throws IOException {

        //1. 获取到当前这个项目的目录，然后再它的下面创建一个目录，files
        String destPath = request.getServletContext().getRealPath("files");
        System.out.println("destPath=" + destPath);

        //2. 创建目录
        File destDir = new File(destPath);
        if (!destDir.exists()) {
            //如果这个files文件夹不存在，就创建这个文件夹
            destDir.mkdir();
        }


        //3. 得到上传的文件名字
        String filename = file.getOriginalFilename();


        //4. 构造一个新的文件名字， 使用当前的时间戳 + 文件的后缀，组成新的文件名..  （应该使用UUID来做）
        filename = System.currentTimeMillis() + filename.substring(filename.lastIndexOf("."));


        //5. 构建一个文件对象。 在具体的目录下，有这样的一个文件，这个文件没有内容
        File destFile = new File(destDir, filename);

        //6. 把springmvc收到的那个文件，保存对应的位置去。
        file.transferTo(destFile);

        //7. 上传成功了之后，跳转到成功的页面
        return "success";
    }


    /**
     * 跨服务器的文件上传
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping("/fileUpload02")
    public String fileUpload02(MultipartFile file ) throws IOException {

        //1. 获取原始的文件名字
        String fileName = file.getOriginalFilename();  // aa.txt

        //2.组装成新的文件名  新文件名 =  时间戳 +  文件后缀
        fileName = System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf('.'));

        //3. 构建一个客户端对象
        Client client = new Client();

        //4. 构建一个资源，其实就是定位我们的这个文件要保存到哪里去？
        WebResource resource = client.resource("http://localhost:38080/files/" + fileName);

        //5. 开始上传文件
        resource.put(file.getBytes());
        return "success";
    }
}
