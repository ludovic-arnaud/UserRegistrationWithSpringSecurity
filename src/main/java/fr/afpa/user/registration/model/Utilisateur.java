package fr.afpa.user.registration.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the utilisateur database table.
 * Utilisateur modifié !
 * Ajout d'un passwordConfirm pour l'authentification. La base a été mise à jour.
 * List<Role> est devenu Set<Role>
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "typediscriminant", discriminatorType = DiscriminatorType.STRING, length = 30)
@NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u")
public class Utilisateur implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idutilisateur")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idutilisateur;

	private String adresse;

	private String codepersonnelcentre;

	private LocalDate datenaissance;

	@Column(name = "email")
	private String username;

	private Integer etat;

	private String nom;

	private String password;

	@Column(name = "passwordconfirm")
	private String passwordConfirm;

	private String prenom;

	private Integer tel;

	@Column(nullable = false, insertable = false, updatable = false)
	private String typediscriminant;

	// bi-directional many-to-many association to Role
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "jouer", joinColumns = { @JoinColumn(name = "idutilisateur") }, inverseJoinColumns = {
			@JoinColumn(name = "idrole") })
	private Set<Role> roles;

	@ManyToMany(mappedBy = "utilisateurs", fetch = FetchType.LAZY)
	private List<Preference> preferences;

	// bi-directional many-to-one association to Centre
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcentre")
	private Centre centre;

	public Utilisateur() {
	}

	public Utilisateur(String codepersonnelcentre, String username, String nom, String password, String prenom,
			String typediscriminant) {
		super();
		this.codepersonnelcentre = codepersonnelcentre;
		this.username = username;
		this.nom = nom;
		this.password = password;
		this.prenom = prenom;
		this.typediscriminant = typediscriminant;
	}

	public Utilisateur(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Utilisateur(Integer idutilisateur, String adresse, String codepersonnelcentre, LocalDate datenaissance,
			String username, Integer etat, String nom, String password, String passwordConfirm, String prenom, Integer tel,
			String typediscriminant, Set<Role> roles, List<Preference> preferences, Centre centre) {
		super();
		this.idutilisateur = idutilisateur;
		this.adresse = adresse;
		this.codepersonnelcentre = codepersonnelcentre;
		this.datenaissance = datenaissance;
		this.username = username;
		this.etat = etat;
		this.nom = nom;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.prenom = prenom;
		this.tel = tel;
		this.typediscriminant = typediscriminant;
		this.roles = roles;
		this.preferences = preferences;
		this.centre = centre;
	}

	public Integer getIdutilisateur() {
		return this.idutilisateur;
	}

	public void setIdutilisateur(Integer idutilisateur) {
		this.idutilisateur = idutilisateur;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodepersonnelcentre() {
		return this.codepersonnelcentre;
	}

	public void setCodepersonnelcentre(String codepersonnelcentre) {
		this.codepersonnelcentre = codepersonnelcentre;
	}

	public LocalDate getDatenaissance() {
		return this.datenaissance;
	}

	public void setDatenaissance(LocalDate datenaissance) {
		this.datenaissance = datenaissance;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getEtat() {
		return this.etat;
	}

	public void setEtat(Integer etat) {
		this.etat = etat;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Integer getTel() {
		return this.tel;
	}

	public void setTel(Integer tel) {
		this.tel = tel;
	}

	public String getTypediscriminant() {
		return this.typediscriminant;
	}

	public void setTypediscriminant(String typediscriminant) {
		this.typediscriminant = typediscriminant;
	}

	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Centre getCentre() {
		return this.centre;
	}

	public void setCentre(Centre centre) {
		this.centre = centre;
	}

	public List<Preference> getPreferences() {
		return preferences;
	}

	public void setPreferences(List<Preference> preferences) {
		this.preferences = preferences;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((centre == null) ? 0 : centre.hashCode());
		result = prime * result + ((codepersonnelcentre == null) ? 0 : codepersonnelcentre.hashCode());
		result = prime * result + ((datenaissance == null) ? 0 : datenaissance.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((etat == null) ? 0 : etat.hashCode());
		result = prime * result + ((idutilisateur == null) ? 0 : idutilisateur.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((passwordConfirm == null) ? 0 : passwordConfirm.hashCode());
		result = prime * result + ((preferences == null) ? 0 : preferences.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		result = prime * result + ((typediscriminant == null) ? 0 : typediscriminant.hashCode());
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
		Utilisateur other = (Utilisateur) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (centre == null) {
			if (other.centre != null)
				return false;
		} else if (!centre.equals(other.centre))
			return false;
		if (codepersonnelcentre == null) {
			if (other.codepersonnelcentre != null)
				return false;
		} else if (!codepersonnelcentre.equals(other.codepersonnelcentre))
			return false;
		if (datenaissance == null) {
			if (other.datenaissance != null)
				return false;
		} else if (!datenaissance.equals(other.datenaissance))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (etat == null) {
			if (other.etat != null)
				return false;
		} else if (!etat.equals(other.etat))
			return false;
		if (idutilisateur == null) {
			if (other.idutilisateur != null)
				return false;
		} else if (!idutilisateur.equals(other.idutilisateur))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (passwordConfirm == null) {
			if (other.passwordConfirm != null)
				return false;
		} else if (!passwordConfirm.equals(other.passwordConfirm))
			return false;
		if (preferences == null) {
			if (other.preferences != null)
				return false;
		} else if (!preferences.equals(other.preferences))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		if (typediscriminant == null) {
			if (other.typediscriminant != null)
				return false;
		} else if (!typediscriminant.equals(other.typediscriminant))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Utilisateur [idutilisateur=" + idutilisateur + ", adresse=" + adresse + ", codepersonnelcentre="
				+ codepersonnelcentre + ", datenaissance=" + datenaissance + ", username=" + username + ", etat=" + etat
				+ ", nom=" + nom + ", password=" + password + ", passwordConfirm=" + passwordConfirm + ", prenom="
				+ prenom + ", tel=" + tel + ", typediscriminant=" + typediscriminant + ", roles=" + roles
				+ ", preferences=" + preferences + ", centre=" + centre + "]";
	}

}