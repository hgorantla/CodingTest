package com.java.assignment.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Unicorn {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer unicornId;
	private String name;
	private String hairColor;
	private int hornLength;
	private String hornColor;
	private String eyeColor;
	private int height;
	private String heightUnit;
	private int weight;
	private String weightUnit;
//	@OneToMany(fetch = FetchType.EAGER, mappedBy = "unicorn", cascade = CascadeType.PERSIST, orphanRemoval = true)
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "unicornId")
	private List<IdentifiableMark> identifiableMarks;
}
