package com.jva.rnd.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class IvrAudioController {
	
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
