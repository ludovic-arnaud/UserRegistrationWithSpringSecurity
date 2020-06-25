package fr.afpa.user.registration.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Privilege.findAll", query="SELECT c FROM Privilege c")


public class Privilege implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7562093861423835182L;

	@Id
	@Column(name="idprivilege")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idprivilege;
	
	
	@Column(length = 20,unique = true, nullable = false)
	private String code;
	
	@Column(length = 10, nullable = true)
	private Integer valeur;
	
	@ManyToMany
	@JoinTable(
		name="autoriser"
		, joinColumns={
			@JoinColumn(name="idprivilege")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idrole")
			}
		)
	private List<Role> roles;
	

	public Privilege() {
		super();
	}


	public Privilege(String code, Integer valeur, List<Role> roles) {
		super();
		this.code = code;
		this.valeur = valeur;
		this.roles = roles;
	}


	public Integer getIdprivilege() {
		return idprivilege;
	}


	public void setIdprivilege(Integer idprivilege) {
		this.idprivilege = idprivilege;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public Integer getValeur() {
		return valeur;
	}


	public void setValeur(Integer valeur) {
		this.valeur = valeur;
	}


	public List<Role> getRoles() {
		return roles;
	}


	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((idprivilege == null) ? 0 : idprivilege.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		result = prime * result + ((valeur == null) ? 0 : valeur.hashCode());
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
		Privilege other = (Privilege) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (idprivilege == null) {
			if (other.idprivilege != null)
				return false;
		} else if (!idprivilege.equals(other.idprivilege))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		if (valeur == null) {
			if (other.valeur != null)
				return false;
		} else if (!valeur.equals(other.valeur))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Privilege [idprivilege=" + idprivilege + ", code=" + code + ", valeur=" + valeur + ", roles=" + roles
				+ "]";
	} 
	
	
	
}
