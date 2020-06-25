package fr.afpa.user.registration.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity

@NamedQuery(name = "Inscription.findAll", query = "SELECT i FROM Inscription i")
public class Inscription implements Serializable {

	// Table pivot entre Creneau et Collaborateur qui possède le champ presence

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	protected InscriptionPK inscriptionPk;

	@Basic(optional = false)
	@Column(name = "presence")
	private Integer presence;

	@JoinColumn(name = "idutilisateur", referencedColumnName = "idutilisateur", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Collaborateur collaborateur;
	@JoinColumn(name = "idcreneau", referencedColumnName = "idcreneau", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Creneau creneau;

	public Inscription() {
		super();
	}

	public Inscription(InscriptionPK inscriptionPk, Integer presence, Collaborateur collaborateur, Creneau creneau) {
		super();
		this.inscriptionPk = inscriptionPk;
		this.presence = presence;
		this.collaborateur = collaborateur;
		this.creneau = creneau;
	}

	public InscriptionPK getInscriptionPk() {
		return inscriptionPk;
	}

	public void setInscriptionPk(InscriptionPK inscriptionPk) {
		this.inscriptionPk = inscriptionPk;
	}

	public Integer getPresence() {
		return presence;
	}

	public void setPresence(Integer presence) {
		this.presence = presence;
	}

	public Collaborateur getCollaborateur() {
		return collaborateur;
	}

	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}

	public Creneau getCreneau() {
		return creneau;
	}

	public void setCreneau(Creneau creneau) {
		this.creneau = creneau;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((collaborateur == null) ? 0 : collaborateur.hashCode());
		result = prime * result + ((creneau == null) ? 0 : creneau.hashCode());
		result = prime * result + ((inscriptionPk == null) ? 0 : inscriptionPk.hashCode());
		result = prime * result + ((presence == null) ? 0 : presence.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inscription other = (Inscription) obj;
		if (collaborateur == null) {
			if (other.collaborateur != null)
				return false;
		} else if (!collaborateur.equals(other.collaborateur))
			return false;
		if (creneau == null) {
			if (other.creneau != null)
				return false;
		} else if (!creneau.equals(other.creneau))
			return false;
		if (inscriptionPk == null) {
			if (other.inscriptionPk != null)
				return false;
		} else if (!inscriptionPk.equals(other.inscriptionPk))
			return false;
		if (presence == null) {
			if (other.presence != null)
				return false;
		} else if (!presence.equals(other.presence))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Inscription [inscriptionPk=" + inscriptionPk + ", presence=" + presence + ", collaborateur="
				+ collaborateur + ", creneau=" + creneau + "]";
	}

}
