package it.uniroma3.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Prerequisiti implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;

@Column(nullable = false)
private String Tipologia;

@Column (nullable = false)
private String prerequisiti;

@Column(nullable=false)
private String descrizionePrerequisiti;

}
