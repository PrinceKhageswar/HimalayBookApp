package com.nt.command;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ScientistCommand {
	@NotBlank(message="id must not be blank")
	private int id;
	@NotBlank(message="name must not be blank")
	private String name;
	@NotBlank(message="domain  must not be blank")
	private String domain;
	@NotBlank(message="exp must not be blank")
	private int experience;
	@NotBlank(message="patentsCount must not be blank")
	private int patentsCount;


}
