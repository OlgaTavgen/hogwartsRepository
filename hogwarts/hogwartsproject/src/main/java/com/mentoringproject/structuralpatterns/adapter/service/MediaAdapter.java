package com.mentoringproject.structuralpatterns.adapter.service;

import com.mentoringproject.structuralpatterns.adapter.dao.AdvancedMediaPlayerDao;
import com.mentoringproject.structuralpatterns.adapter.dao.MediaPlayerDao;
import com.mentoringproject.structuralpatterns.adapter.model.Mp4Player;
import com.mentoringproject.structuralpatterns.adapter.model.VlcPlayer;

public class MediaAdapter implements MediaPlayerDao
{
	AdvancedMediaPlayerDao advancedMusicPlayer;
	
	public MediaAdapter(String audioType)
	{
		if(audioType.equalsIgnoreCase("vlc") )
		{
			advancedMusicPlayer = new VlcPlayer();			
	         
	     }else if (audioType.equalsIgnoreCase("mp4"))
	     {
	    	 advancedMusicPlayer = new Mp4Player();
	     }	
	   }
	
	@Override
	public void play(final String audioType, final String fileName)
	{		
		if(audioType.equalsIgnoreCase("vlc"))
		{
	         advancedMusicPlayer.playVlc(fileName);
	    }
	    
		else if(audioType.equalsIgnoreCase("mp4"))
		{
	         advancedMusicPlayer.playMp4(fileName);
	    }
	}
}
