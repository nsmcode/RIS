package managers;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import model.Izvodjenje;
import model.Karta;
import model.Mesto;
import model.Posetilac;

public class PosetilacManager {

	public Posetilac savePosetilac(String ime, String prezime) {
		try {
			EntityManager em =JPAUtil.getEntityManager();
			Posetilac p = new Posetilac ();
			p.setIme(ime);
			p.setPrezime(prezime);
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
			return p;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Karta rezervacija(int idPosetioca, int idIzvodjenja, int idMesto) {
		try {
			EntityManager em =JPAUtil.getEntityManager();
			//da li je mesto vec zauzeto
			
			List<Karta> karta =  em.createQuery("select k from Karta k where k.mesto.idMesto=:idM and k.izvodjenje.idIzvodjenje=:idI", Karta.class)
						.setParameter("idM", idMesto).setParameter("idI", idIzvodjenja).getResultList();
			if(!karta.isEmpty())
				return null;
			
			Karta k = new Karta();
			Posetilac p = em.find(Posetilac.class, idPosetioca);
			Izvodjenje i = em.find(Izvodjenje.class, idIzvodjenja);
			Mesto m = em.find(Mesto.class, idMesto);
			
			k.setPosetilac(p);
			k.setIzvodjenje(i);
			k.setMesto(m);
			k.setDatumRezervacije(new Date());
			
			em.getTransaction().begin();
			em.persist(k);
			em.getTransaction().commit();
			return k;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

	
	public static void main(String[] args) {
		PosetilacManager pm = new PosetilacManager();
		//1.
//		Posetilac p = pm.savePosetilac("Pera", "Kojot");
//		if(p!=null)
//			System.out.println("Posetilac je dodat. Id posetioca je "+p.getIdPosetilac());
		
		//4
		Karta k = pm.rezervacija(4, 2, 5);
		if(k!=null)
			System.out.println("Uspesna rezervacija, broj karte je "+k.getIdKarta());
		
		
	}
}