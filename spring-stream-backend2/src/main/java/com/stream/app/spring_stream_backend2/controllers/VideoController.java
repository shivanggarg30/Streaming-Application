package com.stream.app.spring_stream_backend2.controllers;

import com.stream.app.spring_stream_backend2.VideoService;
import com.stream.app.spring_stream_backend2.entities.Video;
import com.stream.app.spring_stream_backend2.payload.CustomMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController // Indicates that this class will handle HTTP requests and return data in JSON format
@RequestMapping("/api/v1/videos") // All requests to /api/v1/videos will be routed to this controller
public class VideoController {

    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService; // VideoService is injected into the controller via the constructor
    }

    @PostMapping // Handles HTTP POST requests to /api/v1/videos endpoint
    public ResponseEntity<CustomMessage> create(
            @RequestParam("file") MultipartFile file,   // Extracts the uploaded file from the request
            @RequestParam("title") String title,        // Retrieves video title from request parameters
            @RequestParam("description") String description // Retrieves video description from request parameters
    ) {
        Video video = new Video();
        video.setTitle(title);                          // Sets the video title
        video.setDescription(description);              // Sets the video description
        video.setVideoId(UUID.randomUUID().toString()); // Generates a unique ID for the video

        // Save the video and file metadata
        videoService.save(video, file);

        // Return a success response
         return null;
    }
}
