package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/arearestrita/*")
public class FilterLogin implements Filter {

    
    public FilterLogin() {
        
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		HttpSession session = req.getSession();
		
		if(session.getAttribute("adminlogado") != null){
			chain.doFilter(request, response);
		}
		else{
			
			resp.sendRedirect("acmodacao_Hotel/loginAdmin.jsp");
		}
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
