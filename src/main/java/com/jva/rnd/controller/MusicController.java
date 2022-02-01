package com.jva.rnd.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;

import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.jva.rnd.audio.MotIvrAudioFile;

@Controller
public class MusicController {
	
	public ResponseEntity<HttpServletResponse> getAudio() throws IOException{
		HttpServletResponse httpServletResponse = null;
//		MotIvrAudioFile motIvrAudioFile = new MotIvrAudioFile();
//		File file = new File("");
//		Blob blob ;
//		InputStream inputStream = null;
////		motIvrAudioFile.setData(IOUtils.copy(inputStream, null));
////		httpServletResponse.setHeader("file", null);
////		motIvrAudioFile.getData();
//		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		
		int totalFramesRead = 0;
		File fileIn = new File("C:\\Users\\NIRANJAN\\Downloads\\Ensoniq-ZR-76-06-BreakBt-90.wav");
		// somePathName is a pre-existing string whose value was
		// based on a user selection.
		try {
		  AudioInputStream audioInputStream = 
		    AudioSystem.getAudioInputStream(fileIn);
		  int bytesPerFrame = 
		    audioInputStream.getFormat().getFrameSize();
		  // Set an arbitrary buffer size of 1024 frames.
		  int numBytes = 1024 * bytesPerFrame; 
		  byte[] audioBytes = new byte[numBytes];
		  try {
		    int numBytesRead = 0;
		    int numFramesRead = 0;
		    // Try to read numBytes bytes from the file.
		    while ((numBytesRead = 
		      audioInputStream.read(audioBytes)) != -1) {
		      // Calculate the number of frames actually read.
		      numFramesRead = numBytesRead / bytesPerFrame;
		      totalFramesRead += numFramesRead;
		      // Here, do something useful with the audio data that's 
		      // now in the audioBytes array...
		    }
		  } catch (Exception ex) { 
		    // Handle the error...
		  }
		} catch (Exception e) {
		  // Handle the er
			
//			ror...
		}
//		httpServletResponse.flushBuffer();
		
		return new ResponseEntity<HttpServletResponse>(httpServletResponse, HttpStatus.OK);
	}
	
	// Method 1
    // To convert file to byte array
    public static byte[] method(File file)
        throws IOException
    {
 
        // Creating an object of FileInputStream to
        // read from a file
        FileInputStream fl = new FileInputStream(file);
 
        // Now creating byte array of same length as file
        byte[] arr = new byte[(int)file.length()];
 
        // Reading file content to byte array
        // using standard read() method
        fl.read(arr);
 
        // lastly closing an instance of file input stream
        // to avoid memory leakage
        fl.close();
 
        // Returning above byte array
        return arr;
    }
}
