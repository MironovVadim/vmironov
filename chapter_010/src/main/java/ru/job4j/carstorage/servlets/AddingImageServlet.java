package ru.job4j.carstorage.servlets;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import ru.job4j.controller.DBService;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.File;
import java.util.List;

/**
 * Servlet for adding images to car.
 */
public class AddingImageServlet extends HttpServlet {
    /**
     * Data base service.
     */
    private static DBService service = DBService.newInstance();
    /**
     * Event logger.
     */
    private Logger logger = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletFileUpload fileUpload = new ServletFileUpload(new DiskFileItemFactory());
//        List<Image> images = new ArrayList<>();
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        try {
            List<FileItem> fileItemList = fileUpload.parseRequest(req);
            for (FileItem fileItem: fileItemList) {
                out.println(fileItem.getSize());
                out.println(fileItem.getName());
                out.println("---------------------");

            }
//                images.add(new Image(fileItem.get()));
//            }
//            service.addImagesToCar(1, images);
        } catch (FileUploadException e) {
            logger.info("FileUploadException", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
                File target = new File(String.format("C:/image%d.jpg", count++));
                OutputStream out = new FileOutputStream(target);
                IOUtils.copy(in, out);
                in.close();
                out.close();
            }
//                images.add(new Image(fileItem.get()));
//            }
//            service.addImagesToCar(1, images);
        } catch (FileUploadException e) {
            logger.info(e.getStackTrace());
        }
        this.doGet(req, resp);
//        resp.sendRedirect(String.format("%s/carstorage/addCar.html", req.getContextPath()));
    }
}