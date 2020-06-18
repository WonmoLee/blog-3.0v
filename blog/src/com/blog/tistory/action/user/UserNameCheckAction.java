package com.blog.tistory.action.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.tistory.action.Action;
import com.blog.tistory.repository.UsersRepository;

public class UserNameCheckAction implements Action{
		@Override
		public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String userName = request.getParameter("userName");
			
			UsersRepository usersRepository = UsersRepository.getInstance();
			int result = usersRepository.findByUserName(userName);
			
			PrintWriter pw = response.getWriter();
			pw.println(result);
		}
}
