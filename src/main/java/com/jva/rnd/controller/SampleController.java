package com.jva.rnd.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	@GetMapping("getAudio")
	public ResponseEntity<?> getAudio() throws IOException, UnsupportedAudioFileException {

		File path = new File("C:\\Users\\NIRANJAN\\Downloads\\Ensoniq-ZR-76-06-BreakBt-90.wav");

		byte[] array = method(path);
		if (array == null) {
			System.out.println("array is empty ? ");
		} else {
			System.out.println("array lenth " + array.length);
		}
		FileOutputStream out = new FileOutputStream(new File("Ensoniq-ZR-76-06-BreakBt-90.wav"));
		OutputStream outputStream = new FileOutputStream("Ensoniq-ZR-76-06-BreakBt-90.wav");

		outputStream.write(array, 0, array.length);
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(path);
		if (AudioSystem.isFileTypeSupported(AudioFileFormat.Type.WAVE, audioInputStream)) {
			AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, outputStream);
		}
		return new ResponseEntity<>(audioInputStream, HttpStatus.OK);
		

	}

	public static byte[] method(File file) throws IOException {
		FileInputStream fl = new FileInputStream(file);
		byte[] arr = new byte[(int) file.length()];
		fl.read(arr);
		fl.close();
		return arr;
	}
}
