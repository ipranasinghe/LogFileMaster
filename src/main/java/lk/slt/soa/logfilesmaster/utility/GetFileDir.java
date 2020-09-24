package lk.slt.soa.logfilesmaster.utility;

import java.io.File;
import java.io.FilenameFilter;

public class GetFileDir {

    public static File[] GetFileDirectory(){
        File file = new File("C:\\Users\\user\\Documents\\LogFileManager\\upload\\uploadFileDir");
// File file = new File("C:\\Users\\Shehan Janeth\\Documents\\Training\\Project\\LogFileManger\\uploadFileDir");
        File[] fileList = file.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".log");
            }
        });
        return fileList;
    }


}
