package it.unibo.mvc;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;

import javax.print.event.PrintEvent;

/**
 * Application controller. Performs the I/O.
 */

public class Controller{

    private File Textfile;
    private final String SEP = System.getProperty("file.separator");
    private String PATH = "output.txt";

    Controller(String Path) throws NullPointerException {
        SetFile(Path);
    }
    Controller(){
        this(System.getProperty("user.home") + 
        System.getProperty("file.separator") + "output.txt" );
    }

    public void SetFile(String Path) throws NullPointerException{
        this.Textfile = new File(Path);
    }

    public File GetFile(){
        return this.Textfile;
    }

    public String GetFilePath(){
        return this.Textfile.getAbsolutePath();
    }

    public void Write(String string) throws FileNotFoundException{
        try(PrintStream ps = new PrintStream(
            new FileOutputStream(this.GetFile(),true))){
            ps.println(string);
        }
    }
}
