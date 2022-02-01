package com.jva.rnd.audio;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

import org.apache.tomcat.util.http.fileupload.IOUtils;

public class FileConverter {
	
	// Method 1
    // To convert file to byte array
    public static byte[] method(File file)
        throws IOException
    {
        FileInputStream fl = new FileInputStream(file);
 
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

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// Creating an object of File class and
        // providing local directory path of a file
        File path
            = new File("C:\\Users\\NIRANJAN\\Downloads\\Ensoniq-ZR-76-06-BreakBt-90.wav");
 
        // Calling the Method1 in main() to
        // convert file to byte array
        byte[] array = method(path);
        if (array == null) {
        	System.out.println("array is empty ? ");
		}else
		{
			System.out.println("array lenth "+array.length);
		}
    FileOutputStream out = new FileOutputStream(new File("Ensoniq-ZR-76-06-BreakBt-90.wav"));
    OutputStream outputStream = new FileOutputStream("Ensoniq-ZR-76-06-BreakBt-90.wav");
        
	    outputStream.write(array, 0, array.length);
//	    IOUtils.copy(array, outputStream);
//	    IOUtils.closeQuietly(in);
//	    IOUtils.closeQuietly(outputStream);
	    System.out.println("----------------------------------------");
	    
        
 
        // Printing the byte array
//        System.out.print(Arrays.toString(array));

		
//		int totalFramesRead = 0;
//		File fileIn = new File("C:\\Users\\NIRANJAN\\Downloads\\Ensoniq-ZR-76-06-BreakBt-90.wav");
//		// somePathName is a pre-existing string whose value was
//		// based on a user selection.
//		try {
//		  AudioInputStream audioInputStream = 
//		    AudioSystem.getAudioInputStream(fileIn);
//		  int bytesPerFrame = 
//		    audioInputStream.getFormat().getFrameSize();
//		  // Set an arbitrary buffer size of 1024 frames.
//		  int numBytes = 1024 * bytesPerFrame; 
//		  byte[] audioBytes = new byte[numBytes];
////		  OutputStream outputStream = 
////		  audioBytes = 
//		  try {
//		    int numBytesRead = 0;
//		    int numFramesRead = 0;
//		    // Try to read numBytes bytes from the file.
//		    while ((numBytesRead = 
//		      audioInputStream.read(audioBytes)) != -1) {
//		      // Calculate the number of frames actually read.
//		      numFramesRead = numBytesRead / bytesPerFrame;
//		      totalFramesRead += numFramesRead;
//		      // Here, do something useful with the audio data that's 
//		      // now in the audioBytes array...
//		    }
//		    
////		    File fileOut = new File(someNewPathName);
//		    AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
//		    ByteArrayInputStream in = new ByteArrayInputStream(audioBytes);
////		    FileOutputStream out = new FileOutputStream(new File("C:\\Users\\NIRANJAN"));
//		    OutputStream outputStream = new FileOutputStream(fileIn.getName());
//		    outputStream.write(audioBytes, numBytesRead, audioBytes.length);
//		    IOUtils.copy(in, outputStream);
//		    IOUtils.closeQuietly(in);
//		    IOUtils.closeQuietly(outputStream);
//		    System.out.println();
//		    
//		    
//		    
////		    if (AudioSystem.isFileTypeSupported(fileType, 
////		        audioInputStream)) {
////		      AudioSystem.write(audioInputStream, fileType, out);
////		    }
//		  } catch (Exception ex) { 
//		    // Handle the error...
//		  }
//		} catch (Exception e) {
//		  // Handle the error...
//		}
//		
		
	}

}
