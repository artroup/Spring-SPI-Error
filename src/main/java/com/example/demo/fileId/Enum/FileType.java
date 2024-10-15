package com.example.demo.fileId.Enum;

public enum FileType {
    BSF("BSF"),GNS("GNS"),PCAPNG("PCAPNG"),PCAP("PCAP"),PCAPMIME("application/vnd.tcpdumb.pcap"),WAV("audio/x-wav"),UNKNOWN("UNKNOWN"),
    GZIP("application/gzip"),TAR("application/x-tar"),XZIP("application/x-zip-compressed"),ZIP("application/zip"), ZIPCOMP("application/zip-compressed")
    ;

    private final String value;

    private FileType(final String value){ this.value = value; }

    public static FileType valueFrom(final String value){
        for(final FileType type : FileType.values()){
            if(type.equals(value)){
                return type;
            }
        }
        return UNKNOWN;
    }

    public String toString() { return this.value; }

    public boolean equals(final String type){
        return this.value.equals(type);
    }
}
