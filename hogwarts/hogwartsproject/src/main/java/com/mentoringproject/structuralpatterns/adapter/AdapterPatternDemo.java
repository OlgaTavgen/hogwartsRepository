package com.mentoringproject.structuralpatterns.adapter;

import com.mentoringproject.structuralpatterns.adapter.service.AudioPlayer;

public class AdapterPatternDemo 
{
	public static void play()
	{
		AudioPlayer audioPlayer = new AudioPlayer();
		
		audioPlayer.play("mp3", "name1.mp3");
		audioPlayer.play("mp4", "name2.mp4");
		audioPlayer.play("vlc", "name3.vlc");
		audioPlayer.play("avi", "name4.avi");
	}
}
