package br.com.livraria.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class LogPasheListener implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent arg0) {
		
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		System.out.println("FASE: " + arg0.getPhaseId());
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
