/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jake
 */
public class LoginFilter implements Filter {
    
    private FilterConfig fc;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.fc = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        // Get session information
        HttpServletRequest sRequest = (HttpServletRequest)request;
        HttpServletResponse sResponse = (HttpServletResponse)response;
        HttpSession hs = sRequest.getSession(false);
        
        // Check to see if user is logged in as an admin
        if (hs == null || hs.getAttribute("user-type") == null) {
            chain.doFilter(request, response);
        } else {
            sResponse.sendRedirect("Dashboard");
        }
    }

    @Override
    public void destroy() {
    }
}
