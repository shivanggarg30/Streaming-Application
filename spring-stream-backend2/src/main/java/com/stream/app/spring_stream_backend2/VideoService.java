package com.stream.app.spring_stream_backend2;

import com.stream.app.spring_stream_backend2.entities.Video;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface VideoService {

    //save video

    Video save(Video video, MultipartFile file);

    //get video by id

    Video get(String videoId);


    //get video by title
    Video getByTitle(String Title);

    List<Video> getAll();
}
