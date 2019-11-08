package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.PredstavaManager;
import model.Glumac;

/**
 * Servlet implementation class UnosGlumcaServlet
 */
@WebServlet("/UnosGlumcaServlet")
public class UnosGlumcaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnosGlumcaServlet() {
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
		String jmbg = request.getParameter("jmbg");
		
		PredstavaManager pm = new PredstavaManager();
		Glumac g = pm.dodajGlumca(ime, prezime, jmbg);

		if(g!=null) {
			request.getSession().setAttribute("glumac", g);
			request.setAttribute("poruka", "Glumac je uspesno dodat. Id glumca je "+g.getIdGlumac());
		}
		else
			request.setAttribute("poruka", "Doslo je do greske. Glumac nije sacuvan.");
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/UnosUloge.jsp");
		rd.forward(request, response);
	}

}
