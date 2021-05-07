package cybersoft.java11.crm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = "/*")
public class AuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		// check authentication
		HttpSession session = req.getSession(); //Khởi tạo 1 session
		String userId = (String)session.getAttribute("userId"); //getAttribute(String name) là phương thức để lấy giá trị của session 
		
		if(userId != null) {
			chain.doFilter(request, response); 
			//(xem lại "Giải thích chain.doFilter(request, response)" ở trong google sheet "Lập trình backend (Học cybersoft)").
			//Ở đây được hiểu là: cho phép request đi tiếp đến Servlet đích mà ko xử lí gì, hoặc cho phép response đi tiếp về browser mà ko xử lí gì. 
			//Trong TH này tức là nếu đã đăng nhập thì sẽ trả về trang mà request đang gọi.
		} else {
			if(req.getServletPath().equals("/login") || req.getServletPath().startsWith("/assets/"))
				chain.doFilter(request, response);
				//(xem lại "Giải thích chain.doFilter(request, response)" ở trong google sheet "Lập trình backend (Học cybersoft)").
				//Ở đây được hiểu là: cho phép request đi tiếp đến Servlet đích mà ko xử lí gì, hoặc cho phép response đi tiếp về browser mà ko xử lí gì.
				//Trong TH này tức là nếu gọi về trang login hoặc...  thi trả về trang request đang gọi.
			else
				resp.sendRedirect(req.getContextPath() + "/login");
				//Nếu chưa đăng nhập (userId == null) thì luôn trả về trang login.
		}
	}
	
}
