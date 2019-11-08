package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.MyManager;
import model.Izvodjenje;

/**
 * Servlet implementation class UnosNazivaPredstave
 */
@WebServlet("/UnosNazivaPredstave")
public class UnosNazivaPredstave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnosNazivaPredstave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nazivP = request.getParameter("nazivP");
		List<Izvodjenje> lista = MyManager.getIzvodjenja(nazivP);
		StringBuilder s = new StringBuilder();
		lista.stream().forEach(x -> s.append(x.toString() + "\n"));
//		response.getWriter().write(s.toString());
		
		request.setAttribute("lista", lista);
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/UnosNazivaPredstave.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
