package com.stream.app.spring_stream_backend2.impl;

import com.stream.app.spring_stream_backend2.VideoService;
import com.stream.app.spring_stream_backend2.entities.Video;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Value("${files.video}")
    String DIR;

    @Override
    public Video save(Video video, MultipartFile file) {

            //Original file name

        try {
            String filename = file.getOriginalFilename();
            String contentType = file.getContentType();
            InputStream inputStream = file.getInputStream();

            //folder path for uploading data : create

            assert filename != null;
            String cleanFileName= StringUtils.cleanPath(filename);
            String cleanFolder=StringUtils.cleanPath(DIR);

            Path path= Paths.get(cleanFolder,cleanFileName);

            System.out.println(path);

            //folder path with filename

            //copy file to folder in server

            //video meta data

            //metadata save

        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Video get(String videoId) {
        return null;
    }

    @Override
    public Video getByTitle(String Title) {
        return null;
    }

    @Override
    public List<Video> getAll() {
        return List.of();
    }
}
