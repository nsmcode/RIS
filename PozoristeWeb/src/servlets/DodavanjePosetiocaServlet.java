package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.PosetilacManager;
import model.Posetilac;

/**
 * Servlet implementation class DodavanjePosetiocaServlet
 */
@WebServlet("/DodavanjePosetiocaServlet")
public class DodavanjePosetiocaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DodavanjePosetiocaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ime = request.getParameter("ime");
		String prezime = request.getParameter("prezime");
		PosetilacManager pm = new PosetilacManager();
		Posetilac p = pm.savePosetilac(ime, prezime);
		
		PrintWriter pw = response.getWriter();
		if(p!=null) {
			pw.write("Posetilac je uspesno sacuvan. Id posetioca je "+p.getIdPosetilac());
		}
		else
			pw.write("Doslo je do greske. Posetilac nije sacuvan.");
		pw.flush();
		pw.close();
	}

}
