package com.mentoringproject.structuralpatterns.adapter.dao;

public interface AdvancedMediaPlayerDao 
{
	public void playVlc(final String fileName);
	public void playMp4(final String fileName);	
}
