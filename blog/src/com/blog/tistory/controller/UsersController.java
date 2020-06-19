package com.blog.tistory.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.tistory.action.Action;
import com.blog.tistory.action.user.UserLoginAction;
import com.blog.tistory.action.user.UserLoginProcAction;
import com.blog.tistory.action.user.UserNameCheckAction;
import com.blog.tistory.action.user.UserSignupAction;
import com.blog.tistory.action.user.UserSignupProcAction;


@WebServlet("/user")
public class UsersController extends HttpServlet {
	private static final String TAG = "UsersController : "; 
	private static final long serialVersionUID = 1L;
       
    
    public UsersController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request는 web.xml에 인코딩 필터를 등록하였기에 넘어간다.
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String cmd = request.getParameter("cmd");
		System.out.println(TAG + "doProcess : " + cmd);
		Action action = router(cmd);
		action.execute(request, response);
	}

		private Action router(String cmd) {
			if (cmd.equals("login")) {
				return new UserLoginAction();
			} else if (cmd.equals("signup")) {
				return new UserSignupAction();
			} else if (cmd.equals("signuProc")) {
				return new UserSignupProcAction();
			} else if (cmd.equals("userNameCheck")) {
				return new UserNameCheckAction();
			} else if (cmd.equals("loginProc")) {
				return new UserLoginProcAction();
			} 
			return null;
		}
	}
