package fr.afpa.user.registration.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class InscriptionPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
	@Column(name = "idutilisateur")
	private int idutilisateur;
	@Basic(optional = false)
	@Column(name = "idcreneau")
	private int idcreneau;

	public InscriptionPK() {
		super();
	}

	public InscriptionPK(int idutilisateur, int idcreneau) {
		super();
		this.idutilisateur = idutilisateur;
		this.idcreneau = idcreneau;
	}

	public int getIdutilisateur() {
		return idutilisateur;
	}

	public void setIdutilisateur(int idutilisateur) {
		this.idutilisateur = idutilisateur;
	}

	public int getIdcreneau() {
		return idcreneau;
	}

	public void setIdcreneau(int idcreneau) {
		this.idcreneau = idcreneau;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idcreneau;
		result = prime * result + idutilisateur;
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
		InscriptionPK other = (InscriptionPK) obj;
		if (idcreneau != other.idcreneau)
			return false;
		if (idutilisateur != other.idutilisateur)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "InscriptionPK [idutilisateur=" + idutilisateur + ", idcreneau=" + idcreneau + "]";
	}

}
