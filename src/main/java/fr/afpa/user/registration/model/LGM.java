package fr.afpa.user.registration.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("LGM")
public class LGM extends Utilisateur {

	private static final long serialVersionUID = 1L;

	@ManyToMany(mappedBy = "lgms", fetch = FetchType.LAZY)
	private List<Session> sessions;

	@OneToMany(mappedBy = "lgm", fetch = FetchType.LAZY)
	private List<Session> sessions1;

	public LGM() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LGM(String codepersonnelcentre, String username, String nom, String password, String prenom) {
		super(codepersonnelcentre, username, nom, password, prenom, "LGM");
		// TODO Auto-generated constructor stub
	}

	public LGM(String codepersonnelcentre, String username, String nom, String password, String prenom,
			List<Session> sessions) {
		super(codepersonnelcentre, username, nom, password, prenom, "LGM");
		this.sessions = sessions;
		// TODO Auto-generated constructor stub

	}

	public LGM(List<Session> sessions, List<Session> sessions1) {
		super();
		this.sessions = sessions;
		this.sessions1 = sessions1;
	}

	public List<Session> getSessions1() {
		return sessions1;
	}

	public void setSessions1(List<Session> sessions1) {
		this.sessions1 = sessions1;
	}

	public List<Session> getSessions() {
		if (this.sessions == null) {
			this.sessions = new ArrayList<Session>();
		}
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((sessions == null) ? 0 : sessions.hashCode());
		result = prime * result + ((sessions1 == null) ? 0 : sessions1.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		LGM other = (LGM) obj;
		if (sessions == null) {
			if (other.sessions != null)
				return false;
		} else if (!sessions.equals(other.sessions))
			return false;
		if (sessions1 == null) {
			if (other.sessions1 != null)
				return false;
		} else if (!sessions1.equals(other.sessions1))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LGM [getIdutilisateur()=" + getIdutilisateur() + ", getAdresse()=" + getAdresse()
				+ ", getCodepersonnelcentre()=" + getCodepersonnelcentre() + ", getDatenaissance()="
				+ getDatenaissance() + ", getUsername()=" + getUsername() + ", getEtat()=" + getEtat() + ", getNom()="
				+ getNom() + ", getPassword()=" + getPassword() + ", getPrenom()=" + getPrenom() + ", getTel()="
				+ getTel() + ", getTypediscriminant()=" + getTypediscriminant() + ", getRoles()=" + getRoles()
				+ ", getCentre()=" + getCentre() + "]";
	}

}
