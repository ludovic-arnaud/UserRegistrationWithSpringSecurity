package fr.afpa.user.registration.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "Lieu.findAll", query = "SELECT l FROM Lieu l")
public class Lieu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idlieu")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idLieu;

	@Column(length = 30, unique = true, nullable = false)
	private String nom;

	// bi-directional many-to-one association to Centre
	@ManyToOne
	@JoinColumn(name = "idcentre")
	private Centre centre;

	// bi-directional one-to-many association to Creneau
	@OneToMany(mappedBy = "lieu")
	private List<Creneau> creneaux;

	public Lieu() {
		super();
	}

	public Lieu(String nom) {
		super();
		this.nom = nom;
	}

	public Lieu(String nom, Centre centre, List<Creneau> creneaux) {
		super();
		this.nom = nom;
		this.centre = centre;
		this.creneaux = creneaux;
	}

	public Integer getIdLieu() {
		return idLieu;
	}

	public void setIdLieu(Integer idLieu) {
		this.idLieu = idLieu;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Centre getCentre() {
		return centre;
	}

	public void setCentre(Centre centre) {
		this.centre = centre;
	}

	public List<Creneau> getCreneaux() {
		if (this.creneaux == null) {
			this.creneaux = new ArrayList<Creneau>();
		}
		return this.creneaux;
	}

	public void setCreneaux(List<Creneau> creneaux) {
		this.creneaux = creneaux;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((centre == null) ? 0 : centre.hashCode());
		result = prime * result + ((creneaux == null) ? 0 : creneaux.hashCode());
		result = prime * result + ((idLieu == null) ? 0 : idLieu.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
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
		Lieu other = (Lieu) obj;
		if (centre == null) {
			if (other.centre != null)
				return false;
		} else if (!centre.equals(other.centre))
			return false;
		if (creneaux == null) {
			if (other.creneaux != null)
				return false;
		} else if (!creneaux.equals(other.creneaux))
			return false;
		if (idLieu == null) {
			if (other.idLieu != null)
				return false;
		} else if (!idLieu.equals(other.idLieu))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Lieu [idLieu=" + idLieu + ", nom=" + nom + ", centre=" + centre + ", creneaux=" + creneaux + "]";
	}

}
