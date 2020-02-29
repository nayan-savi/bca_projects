package com.college.facebook.app.controller;

import com.college.facebook.app.dao.PostDetailsDao;
import com.college.facebook.app.dao.PostDetailsDaoImpl;
import com.college.facebook.app.model.Login;
import com.college.facebook.app.model.PostDetails;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PostController")
public class PostController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PostDetails postDetails = new PostDetails();
        Login user = (Login) request.getSession().getAttribute("user");
        String postId = request.getParameter("postId");
        postDetails.setTitle(request.getParameter("title"));
        postDetails.setMessage(request.getParameter("message"));
        postDetails.setVisibilityLevel(Integer.parseInt(request.getParameter("visibilityLevel")));
        PostDetailsDao postDetailsDao = new PostDetailsDaoImpl(request);
        postDetails.setUserId(user.getUserId());
        postDetails.setUsername(request.getParameter("username"));
        postDetails.setPath("/upload");
        int row;
        if(null == postId) {
            postDetails.setLike(0);
            row = postDetailsDao.postDetails(postDetails);
        } else {
            postDetails.setPostId(request.getParameter("postId"));
            row = postDetailsDao.updatePostDetails(postDetails);
        }
        if(row > 0) {
            uploadImage(request, postId);
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

    void uploadImage(HttpServletRequest request, String postId) {
        if(!ServletFileUpload.isMultipartContent(request)) {
            return;
        }
        ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
        try {
            List<FileItem> items = upload.parseRequest(request);
            for(FileItem item : items) {
                File uploadDir = new File("upload");
                File file = File.createTempFile(postId, ".png", uploadDir);
                item.write(file);
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
