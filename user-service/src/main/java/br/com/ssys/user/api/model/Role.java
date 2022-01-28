package br.com.ssys.user.api.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_CARGO")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "uuid-char")
	private UUID id;
	
	@JoinColumn(name = "CARGO")
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "role")
	private List<User> user;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "TB_CARGO_PERMISSAO", joinColumns = { @JoinColumn(name="CARGO_ID", referencedColumnName = "id") },
	inverseJoinColumns = @JoinColumn(name = "PERMISSAO_ID", referencedColumnName = "id"))
	private List<Permission> permission;
	
	
	
}
