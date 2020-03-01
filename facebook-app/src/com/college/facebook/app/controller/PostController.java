package com.college.facebook.app.controller;

import com.college.facebook.app.dao.PostDetailsDao;
import com.college.facebook.app.dao.PostDetailsDaoImpl;
import com.college.facebook.app.model.Login;
import com.college.facebook.app.model.PostDetails;
import com.oreilly.servlet.MultipartRequest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Enumeration;
import java.util.UUID;

@WebServlet(name = "PostController")
@MultipartConfig(location = "/upload")
public class PostController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Login user = (Login) request.getSession().getAttribute("user");
        String uploadPath = request.getServletContext().getRealPath(File.separator);
        MultipartRequest multipartRequest = new MultipartRequest(request, new File("upload").getAbsoluteFile().toString());
        PostDetails postDetails = new PostDetails();
        String postId = request.getParameter("postId");
        postDetails.setTitle(multipartRequest.getParameter("title"));
        postDetails.setMessage(multipartRequest.getParameter("message"));
        postDetails.setVisibilityLevel(Integer.parseInt(multipartRequest.getParameter("visibilityLevel")));
        PostDetailsDao postDetailsDao = new PostDetailsDaoImpl(request);
        postDetails.setUserId(user.getUserId());
        postDetails.setUsername(multipartRequest.getParameter("username"));
        int row;
        if (null == postId) {
            UUID uuid = UUID.randomUUID();
            postDetails.setPostId(uuid.toString());
            postDetails.setLike(0);
            uploadImage(multipartRequest, postDetails.getPostId(), postDetails);
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
