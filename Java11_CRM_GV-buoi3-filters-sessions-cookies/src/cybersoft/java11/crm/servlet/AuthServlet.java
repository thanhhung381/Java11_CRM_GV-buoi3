package cybersoft.java11.crm.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cybersoft.java11.crm.biz.AuthBiz;
import cybersoft.java11.crm.model.User;

@WebServlet(name = "authServlet", urlPatterns = {
		"/login",
		"/logout",
		"/register"
})
public class AuthServlet extends HttpServlet {
	private AuthBiz biz;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		biz = new AuthBiz();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO: forward to login.jsp
		String path = req.getServletPath();
		
		switch (path) {
		case "/login":
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/auth/login.jsp");
			dispatcher.forward(req, resp); 
			//xem lại sendRedirect và forward trong tài liệu Servlet (trong đó, forward được dùng khi: muốn gửi dữ liệu đi, hoặc muốn sang một trang/servlet mới xử lí dữ liệu)
			//(forward trước khi sử dụng cần được khai báo trong RequestDispatcher)
			//Ở đây: dùng forward để chuyển tới một trang/servlet mới xử lí dữ liệu là login.jsp.
			break;

		default:
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO: 
		String path = req.getServletPath();
		
		switch (path) {
		case "/login":
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			
			System.out.printf("email: %s, password: %s\n", email, password);
			
			User user = biz.login(email, password);
			
			if(user != null) { // logged in successfully
				HttpSession session = req.getSession(); //Khởi tạo một session
				
				session.setAttribute("userId", "" + user.getId()); //Gán giá trị cho session setAttribute(String srt, Object obj)
				session.setMaxInactiveInterval(30);  //Đặt thời gian sống cho session
				
				resp.sendRedirect(req.getContextPath() + "/home");
				//xem lại sendRedirect và forward trong tài liệu Servlet (trong đó, sendRedirect được dùng khi: thực hiện một hành động nào đó mà ko muốn gửi dữ liệu đi, hoặc muốn sang một trang mới không có bất kì xử lí dữ liệu gì)
				//(vd: khi nhấn nút thực hiện login, thì khi xử lí xong, chúng ta chuyển hướng đến một trang nào mong muốn).
			} else { // logged in fail -> trả lại trở về trang login
				req.getRequestDispatcher("/WEB-INF/auth/login.jsp").forward(req, resp);
				//xem lại sendRedirect và forward trong tài liệu Servlet (trong đó, forward được dùng khi: muốn gửi dữ liệu đi, hoặc muốn sang một trang/servlet mới xử lí dữ liệu)
				//(forward trước khi sử dụng cần được khai báo trong RequestDispatcher)
				//Ở đây: dùng forward để chuyển tới một trang/servlet mới xử lí dữ liệu là login.jsp.
			}
			
			break;

		default:
			break;
		}
	}
}
