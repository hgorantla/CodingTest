package com.java.assignment.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class IdentifiableMark {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer identifiableMarkId;
	private String side;
    private String location;
    private String mark;
    private String color;
//    @ManyToOne
//    @JoinColumn(name = "unicornId")
//    private Unicorn unicorn;
}
