package com.example.demo.fileId.Detectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.spi.FileTypeDetector;
import java.util.Arrays;

@Service
public class PCAP extends FileTypeDetector{

    final static byte[] LE_HEADER = {
            (byte) 0xD4, (byte) 0xC3,
            (byte) 0xB2, (byte) 0xA1
    };

    final static byte[] BE_HEADER = {
            (byte) 0XA1, (byte) 0xB2,
            (byte) 0xC3, (byte) 0xD4
    };

    private final static int BUFFER_SIZE = 4;

    @Override
    public String probeContentType(Path path) throws IOException {
        final byte[] buf = new byte[4];
        try(final InputStream in = Files.newInputStream(path)){
            if(in.read(buf) !=4){
                return null;
            }
        }catch(final Exception e){
            e.printStackTrace();
        }
        if ((Arrays.equals(buf, LE_HEADER)) || (Arrays.equals(buf, BE_HEADER))) { return "PCAP"; }
        return null;
    }

}

