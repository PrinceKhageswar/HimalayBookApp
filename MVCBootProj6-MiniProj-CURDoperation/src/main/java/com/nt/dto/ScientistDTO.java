package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ScientistDTO implements Serializable {
	private int srno;
	private int id;
	private String name;
	private String domain;
	private int experience;
	private int patentsCount;


}
