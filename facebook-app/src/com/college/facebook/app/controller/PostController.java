package com.college.facebook.app.controller;

import com.college.facebook.app.dao.PostDetailsDao;
import com.college.facebook.app.dao.PostDetailsDaoImpl;
import com.college.facebook.app.model.Login;
import com.college.facebook.app.model.PostDetails;
import com.oreilly.servlet.MultipartRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "PostController")
@MultipartConfig(location = "/upload")
public class PostController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Login user = (Login) request.getSession().getAttribute("user");
        PostDetails postDetails = new PostDetails();
        UUID uuid = UUID.randomUUID();
        String postId = request.getParameter("postId");
        String uploadPath = "E:\\softwares\\apache-tomcat-8.5.51\\bin\\upload\\";
        postDetails.setUserId(user.getUserId());
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        diskFileItemFactory.setRepository(new File("C:\\Users\\NAYAN\\AppData\\Local\\Temp"));
        ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
        try {
            List<FileItem> fileItems = upload.parseRequest(request);
            for (FileItem fileItem : fileItems) {
                if(fileItem.isFormField()) {
                    String fieldName = fileItem.getFieldName();
                    if(fieldName.equals("username")) {
                        postDetails.setUsername(fileItem.getString());
                    } else if (fieldName.equals("title")) {
                        postDetails.setTitle(fileItem.getString());
                    } else if (fieldName.equals("message")) {
                        postDetails.setMessage(fileItem.getString());
                    } else if (fieldName.equals("visibilityLevel")) {
                        postDetails.setVisibilityLevel(Integer.parseInt(fileItem.getString()));
                    }
                } else {
                    File source = new File(uploadPath+uuid+fileItem.getName());
                    postDetails.setPath(uuid+fileItem.getName());
                    fileItem.write(source);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        PostDetailsDao postDetailsDao = new PostDetailsDaoImpl(request);
        int row;
        if (null == postId) {
            postDetails.setPostId(uuid.toString());
            postDetails.setLike(0);
            row = postDetailsDao.postDetails(postDetails);
        } else {
            postDetails.setPostId(request.getParameter("postId"));
            row = postDetailsDao.updatePostDetails(postDetails);
        }
        if (row > 0) {
            request.setAttribute("success", "Posted successfully.");
        } else {
            request.setAttribute("errmsg", "Post data failed.");
        }
        RequestDispatcher rd = request.getRequestDispatcher("jsp/post/post.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("jsp/post/post.jsp");
        rd.forward(request, response);
    }

    private void uploadImage(MultipartRequest request, String postId, PostDetails postDetails) {
        Enumeration files = request.getFileNames();
        while (files.hasMoreElements()) {
            String name = (String) files.nextElement();
            String type = request.getContentType(name);
            if(type.contains("image")) {
                File uploadedFile = request.getFile("path");
                try {
                    FileInputStream fis = new FileInputStream(uploadedFile);
                    BufferedReader in = new BufferedReader(new InputStreamReader(fis));
                    FileWriter fstream = new FileWriter("upload" + name, true);
                    BufferedWriter out11 = new BufferedWriter(fstream);
                    String aLine;
                    while ((aLine = in.readLine()) != null) {
                        out11.write(aLine);
                    }
                    in.close();
                    out11.close();
                    File rename = new File("upload/" + postId + ".jpg").getAbsoluteFile();
                    boolean done = uploadedFile.renameTo(rename);
                    if (done) {
                        postDetails.setPath(rename.getPath().replaceAll("\\\\", "/"));
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
