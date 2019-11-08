package managers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.mysql.cj.Query;

import model.Glumac;
import model.Predstava;
import model.Uloga;

public class GlumacManager {

	public static void unosGlumca(String ime, String prezime, String jmbg, Uloga uloga) {
		try {
			EntityManager em =JPAUtil.getEntityManager();
			Glumac g = new Glumac();
			g.setIme(ime);
			g.setPrezime(prezime);
			g.setJmbg(jmbg);
			g.getUlogas().add(uloga);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void unosUloge(String naziv, Predstava predstava) {
		
		try {
			EntityManager em = JPAUtil.getEntityManager();
			Uloga u = new Uloga();
			u.setNaziv(naziv);
			u.setPredstava(predstava);
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<Predstava> getPredstave() {
		try {
			EntityManager em =JPAUtil.getEntityManager();
			List<Predstava> lista;
			String upit = "select p form Predstava p";
			lista = em.createQuery(upit, Predstava.class).getResultList();
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
