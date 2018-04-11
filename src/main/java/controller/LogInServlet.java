package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.Account;

@WebServlet("/XuLyDangNhap")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogInServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username= request.getParameter("username");
		String pass = request.getParameter("pass");
		
		Account account = new UserDAO().getAccountInfo(username);
		System.out.println(account);
		
		if(new UserDAO().validateAccountPass(username, pass)){
			HttpSession session = request.getSession();
			session.setAttribute("user", account);
			
			response.sendRedirect("index.jsp");
		}else{
			response.sendRedirect("SignIn.jsp");
			System.out.println("Loi dang nhap");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
