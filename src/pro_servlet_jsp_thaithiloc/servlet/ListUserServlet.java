package pro_servlet_jsp_thaithiloc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pro_servlet_jsp_thaithiloc.DAO.DBUtils;
import pro_servlet_jsp_thaithiloc.beans.UserModel;

//@WebServlet(urlPatterns="/ListUserServlet")

public class ListUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			DBUtils dbUtils = new DBUtils();
			List<UserModel> listUser = dbUtils.getListUser();
			req.setAttribute("listUser", listUser);
			RequestDispatcher rd = req.getRequestDispatcher("/JSP/listUser.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			RequestDispatcher rd = req.getRequestDispatcher("/JSP/errorPage.jsp");
				try {
					rd.forward(req, resp);
				} catch (ServletException | IOException e1) {
					System.out.println();
					e1.printStackTrace();
				}
		}
	}
}
