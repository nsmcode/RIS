package managers;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import model.Izvodjenje;
import model.Mesto;

public class MyManager {

	public static List<Izvodjenje> getIzvodjenja(String nazivP) {
		EntityManager em = JPAUtil.getEntityManager();
		String upit = "select i from Izvodjenje i where i.predstava.naziv like :naziv and i.datum > :datum";
		return em.createQuery(upit, Izvodjenje.class).setParameter("naziv", nazivP).setParameter("datum", new Date()).getResultList();
	}
	
	public static List<Mesto> getMesta(String id) {
		EntityManager em = JPAUtil.getEntityManager();
		Izvodjenje i = em.find(Izvodjenje.class, id);
		String upit = "select m from Mesto m where m.scena.idScena = :idS "
				+ "and not exist (select k from Karta k "
						+ "where k.izvodjenje = :idIzv and k.mesto = m)";
		
		return em.createQuery(upit, Mesto.class).setParameter("idS", i.getScena().getIdScena())
				.setParameter("idIzv", i.getIdIzvodjenje()).getResultList();
	}
}
