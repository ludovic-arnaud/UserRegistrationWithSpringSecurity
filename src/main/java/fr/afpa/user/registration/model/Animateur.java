package fr.afpa.user.registration.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("ANIMATEUR")
public class Animateur extends Utilisateur {

	// bi-directional many-to-many association to Activite
	@ManyToMany(mappedBy = "animateurs")
	private List<Activite> activites;

	@OneToMany(mappedBy = "animateur")
	private List<Creneau> animcrenaux;

	public Animateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Animateur(String codepersonnelcentre, String username, String nom, String password, String prenom) {
		super(codepersonnelcentre, username, nom, password, prenom, "ANIMATEUR");
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Animateur [getIdutilisateur()=" + getIdutilisateur() + ", getAdresse()=" + getAdresse()
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

}
