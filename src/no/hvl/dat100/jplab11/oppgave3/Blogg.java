package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.Bilde;
import no.hvl.dat100.jplab11.oppgave2.Tekst;

public class Blogg {

	private Innlegg[] innleggstabell;
	private int nesteledige;

	public Blogg() {
		innleggstabell = new Innlegg[20];
		nesteledige=0;
	}

	public Blogg(int lengde) {
		innleggstabell = new Innlegg[lengde];
		nesteledige=0;
	}

	public int getAntall() {
		return nesteledige;
	}
	
	public Innlegg[] getSamling() {
		//Usikker på den
		return innleggstabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {
		boolean funnet = false;
		int pos = 0;

		while (pos < nesteledige && !funnet) {
			if (innleggstabell[pos].erLik(innlegg)) {
				funnet = true;
			} else {
				pos++;
			}
		}

		if (funnet) {
			return pos;
		} else {
			return -1;
		}
	}

	public boolean finnes(Innlegg innlegg) {
		//Usikker på den
		if (finnInnlegg(innlegg)<0){
			return false;
		} else {
			return true;
		}
	}

	public boolean ledigPlass() {
		//Usikker
		return nesteledige<innleggstabell.length;
	}
	
	public boolean leggTil(Innlegg innlegg) {
		boolean ny = finnInnlegg(innlegg) == -1;

		if (ny && ledigPlass()) {
			innleggstabell[nesteledige] = innlegg;
			nesteledige++;
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		String output = nesteledige + "\n";
		for (int i = 0; i < nesteledige; i++) {
			output += innleggstabell[i].toString();
		}
		return output;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public boolean slett(Innlegg innlegg) {
		
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}