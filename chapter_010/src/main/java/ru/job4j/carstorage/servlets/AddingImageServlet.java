package ru.job4j.carstorage.servlets;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import ru.job4j.carstorage.Image;
import ru.job4j.controller.DBService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

public class AddingImageServlet extends HttpServlet {

    private static DBService service = DBService.newInstance();

    private Logger logger = null;
    {
        logger = Logger.getRootLogger();
        BasicConfigurator.configure();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletFileUpload fileUpload = new ServletFileUpload(new DiskFileItemFactory());
//        List<Image> images = new ArrayList<>();
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        try {
            List<FileItem> fileItemList = fileUpload.parseRequest(req);
            for (FileItem fileItem: fileItemList) {
                writer.println(fileItem.getSize());
                writer.println(fileItem.getName());
                writer.println("---------------------");

            }
//                images.add(new Image(fileItem.get()));
//            }
//            service.addImagesToCar(1, images);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.setLevel(Level.INFO);
        ServletFileUpload fileUpload = new ServletFileUpload(new DiskFileItemFactory());
//        List<Image> images = new ArrayList<>();
        logger.info("Servlet invoked");
        try {
            List<FileItem> fileItemList = fileUpload.parseRequest(req);
            int count = 0;
            for (FileItem fileItem: fileItemList) {
                logger.info(String.format("File name: %s", fileItem.getName()));
                logger.info(String.format("File size: %s", fileItem.getSize()));

                InputStream in = fileItem.getInputStream();
                byte[] buffer = new byte[in.available()];
                in.read(buffer);
                File target = new File("C:/image" + count++ + ".jpg");
                OutputStream out = new FileOutputStream(target);
                out.write(buffer);
                in.close();
                out.close();
            }
//                images.add(new Image(fileItem.get()));
//            }
//            service.addImagesToCar(1, images);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        this.doGet(req, resp);
//        resp.sendRedirect(String.format("%s/carstorage/addCar.html", req.getContextPath()));
    }
}