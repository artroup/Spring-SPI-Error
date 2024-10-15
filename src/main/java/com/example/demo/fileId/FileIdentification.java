package com.example.demo.fileId;

import com.example.demo.fileId.Enum.FileType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileIdentification {

    private final static Logger logger = LoggerFactory.getLogger(FileIdentification.class);

    public static FileType getFileTypeForFile(final File file) throws IOException {
        if(file.isFile() && Files.isReadable(file.toPath())){
            final String type = Files.probeContentType(file.toPath());
            return FileType.valueFrom(type);
        }
        return FileType.UNKNOWN;
    }

    public static FileType getFileTypeForFile(final Path path) throws IOException{
        if(Files.isRegularFile(path) && Files.isReadable(path)){
            logger.info(path.toString());
            logger.info(Files.probeContentType(path));
            return FileType.valueFrom(Files.probeContentType(path));
        }
        return FileType.UNKNOWN;
    }
}
