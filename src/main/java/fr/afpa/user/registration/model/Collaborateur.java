package fr.afpa.user.registration.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("COLLABORATEUR")
public class Collaborateur extends Utilisateur {

	// bi-directional one-to-many association to Inscription
	@OneToMany(mappedBy = "collaborateur")
	private List<Inscription> inscriptions;

	// bi-directional Many-to-One association to Session
	@ManyToOne
	@JoinColumn(name = "idsession")
	private Session session;

	public Collaborateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Collaborateur(String codepersonnelcentre, String username, String nom, String password, String prenom) {
		super(codepersonnelcentre, username, nom, password, prenom, "COLLABORATEUR");
		// TODO Auto-generated constructor stub
	}

	public Collaborateur(List<Inscription> inscriptions, Session session) {
		super();
		this.inscriptions = inscriptions;
		this.session = session;
	}

	@Override
	public String toString() {
		return "Collaborateur [getIdutilisateur()=" + getIdutilisateur() + ", getAdresse()=" + getAdresse()
				+ ", getCodepersonnelcentre()=" + getCodepersonnelcentre() + ", getDatenaissance()="
				+ getDatenaissance() + ", getUsername()=" + getUsername() + ", getEtat()=" + getEtat() + ", getNom()="
				+ getNom() + ", getPassword()=" + getPassword() + ", getPrenom()=" + getPrenom() + ", getTel()="
				+ getTel() + ", getTypediscriminant()=" + getTypediscriminant() + ", getRoles()=" + getRoles()
				+ ", getCentre()=" + getCentre() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<Inscription> getInscriptions() {
		if (this.inscriptions == null) {
			this.inscriptions = new ArrayList<Inscription>();
		}
		return this.inscriptions;
	}

	public void setInscriptions(List<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((inscriptions == null) ? 0 : inscriptions.hashCode());
		result = prime * result + ((session == null) ? 0 : session.hashCode());
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
		Collaborateur other = (Collaborateur) obj;
		if (inscriptions == null) {
			if (other.inscriptions != null)
				return false;
		} else if (!inscriptions.equals(other.inscriptions))
			return false;
		if (session == null) {
			if (other.session != null)
				return false;
		} else if (!session.equals(other.session))
			return false;
		return true;
	}

}
