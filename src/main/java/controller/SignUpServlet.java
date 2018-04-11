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

@WebServlet("/XuLyDangKy")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignUpServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String username= request.getParameter("username");
		String pass= request.getParameter("pass");
		String name= request.getParameter("name");
		
		Account account = new Account(username, pass, name);
		
		if(new UserDAO().addNewAccount(account)){
//			HttpSession session = request.getSession();
//			session.setAttribute("user", kh);
			response.sendRedirect("SignIn.jsp");
		}else{
			System.out.println("lỗi đăng nhập");
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
