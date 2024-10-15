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
public class PCAPNG extends FileTypeDetector{
    final static byte[] HEADER = {
            (byte) 0x0A, (byte) 0x0D,
            (byte) 0x0D, (byte) 0x0A
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

        }
        return Arrays.equals(buf, HEADER) ? "PCAP" : null;
    }
}
