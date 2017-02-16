package com.spring4.learn.generic.di;

public class BaseRepository <T> {
	
	public void save(T t) {
		System.out.println("BaseRepository.add() method ... ...");
		System.out.println(t.toString());
	}
	
}
