package com.example.service;

import java.util.List;

import com.example.model.Zym;


public interface ZymService {
	
	Zym addzym(Zym zym);
	Zym getZymById(Integer zymid);
	List<Zym> getAllZyms();
	Zym updateZym(Integer zymId,Zym workout);
	List<Zym> deleteZym(Integer zymId);
	
}
