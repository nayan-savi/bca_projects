package com.college.facebook.app.controller;

import com.college.facebook.app.constant.FacebookConst;
import com.college.facebook.app.dao.PostDetailsDao;
import com.college.facebook.app.dao.PostDetailsDaoImpl;
import com.college.facebook.app.model.Login;
import com.college.facebook.app.model.PostDetails;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "PostController")
public class PostController extends HttpServlet {
	
	
	public PostController() {
		File directory = new File(FacebookConst.UPLOAD_DIRECTORY);
	    if (! directory.exists()){
	        boolean dir = directory.mkdir();
	        System.out.println("Directory created.");
	    }
	}
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Login user = (Login) request.getSession().getAttribute("user");
        UUID uuid = UUID.randomUUID();
        request.getParameterNames();
        String postId =null;
        PostDetailsDao postDetailsDao = new PostDetailsDaoImpl(request);
        
        if (ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				PostDetails postDetails = new PostDetails();
				FileItem upload = null;
				String name = "";
				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						name = new File(item.getName()).getName();
						upload = item;
						postDetails.setPath(uuid.toString());
					} else {
						if (item.getFieldName().equals("username")) {
							postDetails.setUsername(item.getString());
						} else if (item.getFieldName().equals("title")) {
							postDetails.setTitle(item.getString());
						} else if (item.getFieldName().equals("message")) {
							postDetails.setMessage(item.getString());
						} else if (item.getFieldName().equals("visibilityLevel")) {
							postDetails.setVisibilityLevel(Integer.parseInt(item.getString()));
						} else if (item.getFieldName().equals("postId")) {
							postId = item.getString();
						}
					}
				}
				postDetails.setUsername(user.getUsername());
				postDetails.setUserId(user.getUserId());
				int row;
		        if (null == postId) {
		            postDetails.setPostId(uuid.toString());
		            postDetails.setLike(0);
		            row = postDetailsDao.postDetails(postDetails);
		        } else {
		            postDetails.setPostId(postId);
		            row = postDetailsDao.updatePostDetails(postDetails);
		        }
		        if (row > 0) {
		            request.setAttribute("success", "Posted successfully.");
		        } else {
		            request.setAttribute("errmsg", "Post data failed.");
		        }
		        RequestDispatcher rd = request.getRequestDispatcher("jsp/post/post.jsp");
		        rd.forward(request, response);
				if(row == 1 && name != "") {
					File file = new File(FacebookConst.UPLOAD_DIRECTORY + File.separator + name);
					upload.write(file);
					file.renameTo(new File(FacebookConst.UPLOAD_DIRECTORY + File.separator+ uuid.toString()));
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		} else {
			request.setAttribute("errmsg", "Sorry this Servlet only handles file upload request");
		}
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("jsp/post/post.jsp");
        rd.forward(request, response);
    }

}
