package com.jva.rnd.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Path;

import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



@RestController
public class DataController {
	
	@RequestMapping(path = "getname")
	public ResponseEntity<String> getName(@RequestBody String name) {
		return new ResponseEntity<String>(name, HttpStatus.OK);
	}
	
	@RequestMapping(path = "play")
	public ResponseEntity<MediaType> getMusic() throws LineUnavailableException {
		MimeType mi = new MimeType("media");
		 File lol = new File("C:\\Users\\NIRANJAN\\Downloads\\meri-tarah-jubin-nautiyal-128-kbps-sound.mp3");
		 Clip clip = AudioSystem.getClip();
		return new ResponseEntity<MediaType>(HttpStatus.OK);
	}
	
//	@RequestMapping(value = "download/{name}", method = RequestMethod.GET)
//	public void getFileByName(@PathVariable("name") final String name, HttpServletResponse response) throws IOException {
//	    response.setContentType("audio/mpeg3");
//	    response.setHeader("Content-Disposition", "attachment; filename=" + name);
//	    service.callSomeMethodAndRecieveDownloadedFileInSomeForm(name); // <- and this file(InputStream/OutputStream/byte[] array/File object/MultipartFile I dont really know..) has to be sent to the user
//	}
//	
//	@GetMapping(path = "/download")
//	public ResponseEntity downloadFromDB() {
//		Document document = 
//		 File lol = new File("C:\\Users\\NIRANJAN\\Downloads\\meri-tarah-jubin-nautiyal-128-kbps-sound.mp3");
//		return ResponseEntity.ok()
//				.contentType(MediaType.parseMediaType("audio/mp3"))
//				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "meri-tarah-jubin-nautiyal-128-kbps-sound" + ".mp3")
//				.body(lol);
//	}
//	
	
	

	/**
	 * @content type : contentType audio/mpeg
	 * @param request
	 * @return
	 * @throws Exception
	 */
    @GetMapping("/downloadFile")
    public ResponseEntity<Resource> downloadFile( HttpServletRequest request) throws Exception {
    	ClassPathResource resource1 = new ClassPathResource("meri-tarah-jubin-nautiyal-128-kbps-sound.mp3");
    	InputStream inputStream = resource1.getInputStream();
        resource1.getInputStream().read();

        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource1.getFile().getAbsolutePath());
            System.out.println("contentType "+contentType);
        } catch (IOException ex) {
        	System.out.println("error");
        }
        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource1.getFilename() + "\"")
                .body(new InputStreamResource(inputStream));
    }

}
