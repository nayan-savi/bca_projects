package com.college.facebook.app.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.college.facebook.app.constant.FacebookConst;

@WebServlet(name = "DisplayImages")
public class DisplayImages extends HttpServlet {
	

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("image/jpeg");
		ServletOutputStream out;
		String anchor = request.getParameter("name");
		out = response.getOutputStream();
		String imageName = FacebookConst.UPLOAD_DIRECTORY+"/"+anchor;
		FileInputStream fin = null;
		try {
			fin = new FileInputStream(imageName);
		} catch (FileNotFoundException e) {
			System.out.println("image doesnot exits");
		}

		BufferedInputStream bin = new BufferedInputStream(fin);
		BufferedOutputStream bout = new BufferedOutputStream(out);
		int ch = 0;
		while ((ch = bin.read()) != -1) {
			bout.write(ch);
		}

		bin.close();
		fin.close();
		bout.close();
		out.close();
	}
}
