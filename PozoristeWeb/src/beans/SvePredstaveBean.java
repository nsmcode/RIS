package beans;

import java.util.List;

import managers.PredstavaManager;
import model.Predstava;

public class SvePredstaveBean {

	private List<Predstava> svePredstave;
	
	public SvePredstaveBean() {
		svePredstave = new PredstavaManager().getSvePredstave();
	}

	public List<Predstava> getSvePredstave() {
		return svePredstave;
	}

	public void setSvePredstave(List<Predstava> svePredstave) {
		this.svePredstave = svePredstave;
	}
	
	
}