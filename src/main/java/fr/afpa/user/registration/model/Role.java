package fr.afpa.user.registration.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idrole")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idrole;

	@Column(length = 10, unique = true, nullable = false)
	private String code;

	// bi-directional many-to-many association to Utilisateur
	@ManyToMany(mappedBy = "roles")
	private List<Utilisateur> utilisateurs;

	@ManyToMany(mappedBy = "roles")
	private List<Privilege> privileges;

	public Role() {
	}

	public Role(String code) {
		super();
		this.code = code;
	}

	public Role(String code, List<Utilisateur> utilisateurs, List<Privilege> privileges) {
		super();
		this.code = code;
		this.utilisateurs = utilisateurs;
		this.privileges = privileges;
	}

	public Integer getIdrole() {
		return this.idrole;
	}

	public void setIdrole(Integer idrole) {
		this.idrole = idrole;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Utilisateur> getUtilisateurs() {
		return this.utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public List<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((idrole == null) ? 0 : idrole.hashCode());
		result = prime * result + ((privileges == null) ? 0 : privileges.hashCode());
		result = prime * result + ((utilisateurs == null) ? 0 : utilisateurs.hashCode());
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
		Role other = (Role) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (idrole == null) {
			if (other.idrole != null)
				return false;
		} else if (!idrole.equals(other.idrole))
			return false;
		if (privileges == null) {
			if (other.privileges != null)
				return false;
		} else if (!privileges.equals(other.privileges))
			return false;
		if (utilisateurs == null) {
			if (other.utilisateurs != null)
				return false;
		} else if (!utilisateurs.equals(other.utilisateurs))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Role [idrole=" + idrole + ", code=" + code + "]";
	}

}