package fr.afpa.user.registration.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "Theme.findAll", query = "SELECT t FROM Type t")
public class Theme implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idtheme")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idtheme;

	@Column(length = 10, unique = true, nullable = false)
	private String nom;

	@Column(length = 10, nullable = true)
	private String couleur;

	@Column(length = 100, nullable = true)
	private String description;

	@Column(name="descriptiondetaillee", length = 500, nullable = true)
	private String descriptionDetaillee;

	@OneToMany(mappedBy = "theme")
	private List<Activite> activites;

	public Theme() {
		super();
	}

	public Theme(String nom, String couleur, String description, String descriptionDetaillee,
			List<Activite> activitesTheme) {
		super();
		this.nom = nom;
		this.couleur = couleur;
		this.description = description;
		this.descriptionDetaillee = descriptionDetaillee;
		this.activites = activitesTheme;
	}

	public Integer getIdtheme() {
		return idtheme;
	}

	public void setIdtheme(Integer idtheme) {
		this.idtheme = idtheme;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescriptionDetaillee() {
		return descriptionDetaillee;
	}

	public void setDescriptionDetaillee(String descriptionDetaillee) {
		this.descriptionDetaillee = descriptionDetaillee;
	}

	public List<Activite> getActivitesTheme() {
		return activites;
	}

	public void setActivitesTheme(List<Activite> activites) {
		this.activites = activites;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activites == null) ? 0 : activites.hashCode());
		result = prime * result + ((couleur == null) ? 0 : couleur.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((descriptionDetaillee == null) ? 0 : descriptionDetaillee.hashCode());
		result = prime * result + ((idtheme == null) ? 0 : idtheme.hashCode());
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
		Theme other = (Theme) obj;
		if (activites == null) {
			if (other.activites != null)
				return false;
		} else if (!activites.equals(other.activites))
			return false;
		if (couleur == null) {
			if (other.couleur != null)
				return false;
		} else if (!couleur.equals(other.couleur))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (descriptionDetaillee == null) {
			if (other.descriptionDetaillee != null)
				return false;
		} else if (!descriptionDetaillee.equals(other.descriptionDetaillee))
			return false;
		if (idtheme == null) {
			if (other.idtheme != null)
				return false;
		} else if (!idtheme.equals(other.idtheme))
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
		return "Theme [idtheme=" + idtheme + ", nom=" + nom + ", couleur=" + couleur + ", description=" + description
				+ ", descriptionDetaillee=" + descriptionDetaillee + ", activites=" + activites + "]";
	}

}
