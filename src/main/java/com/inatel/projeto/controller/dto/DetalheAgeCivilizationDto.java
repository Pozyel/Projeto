package com.inatel.projeto.controller.dto;

import java.util.ArrayList;
import java.util.List;

public class DetalheAgeCivilizationDto {

	private String name;
	private String expansion;
	private String team_bonus;
	private List<String> civilization_bonus= new ArrayList<>();
	
	
	public String getName() {
		return name;
	}
	public String getExpansion() {
		return expansion;
	}
	public String getTeam_bonus() {
		return team_bonus;
	}
	public List<String> getCivilization_bonus() {
		return civilization_bonus;
	}

	
	
}
