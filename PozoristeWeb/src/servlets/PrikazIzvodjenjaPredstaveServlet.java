package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.PredstavaManager;
import model.Izvodjenje;

/**
 * Servlet implementation class PrikazIzvodjenjaPredstaveServlet
 */
@WebServlet("/PrikazIzvodjenjaPredstaveServlet")
public class PrikazIzvodjenjaPredstaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrikazIzvodjenjaPredstaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String naziv = request.getParameter("naziv");
		PredstavaManager pm = new PredstavaManager();
		List<Izvodjenje> izvodjenja = pm.vratiIzvodjenja(naziv);
		
		PrintWriter pw = response.getWriter();
		for(Izvodjenje i:izvodjenja)
			pw.write(i.getDatum()+", "+i.getScena().getNaziv()+"\n");
		pw.flush();
		pw.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
