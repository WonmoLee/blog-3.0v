package com.blog.tistory.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.tistory.action.Action;
import com.blog.tistory.model.Users;
import com.blog.tistory.repository.UsersRepository;
import com.blog.tistory.util.Script;

public class UserLoginProcAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(
				request.getParameter("userName").equals("") ||
				request.getParameter("passWord").equals("") 
		   ) {
			return;
		}
		
		String username = request.getParameter("userName");
		String password = request.getParameter("passWord");
		
		UsersRepository usersRepository = UsersRepository.getInstance();
		Users user = usersRepository.fineByUsernameAndPassword(username, password);
		
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("principal", user);
			
			Script.href("로그인성공", "/blog/index.jsp", response);
		} else {
			Script.back("로그인실패", response);
		}
	}
}
