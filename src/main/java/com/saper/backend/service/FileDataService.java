package com.saper.backend.service;

import com.saper.backend.model.FileData;
import com.saper.backend.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
public class FileDataService {

    @Autowired
    FileRepository fileRepository;

    public FileData uploadImageToFileSystem(MultipartFile file, Long clientId) throws IOException {
        String FOLDER_PATH = "C:\\Users\\paulo\\IdeaProjects\\my\\saper-back-end\\files\\" + + clientId + "\\";
        String filePath= FOLDER_PATH + file.getOriginalFilename();

        FileData fileData = fileRepository.save(new FileData(file.getOriginalFilename(), file.getContentType(), filePath));

        java.io.File directory = new java.io.File(FOLDER_PATH);
        if (! directory.exists()){
            directory.mkdirs();
            // If you require it to make the entire directory path including parents,
            // use directory.mkdirs(); here instead.
        }

        file.transferTo(new java.io.File(filePath));

        if (fileData != null) {
            return fileData;
        }
        return null;
    }

    public byte[] downloadImageFromFileSystem(Long id) throws IOException {
        Optional<FileData> fileData = fileRepository.findById(id);
        String filePath = fileData.get().getFilePath();
        byte[] images = Files.readAllBytes(new java.io.File(filePath).toPath());
        return images;
    }
}
