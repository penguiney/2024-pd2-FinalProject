<<<<<<< HEAD:src/test/java/finalproject/TestMoveFile.java


=======
>>>>>>> d8ce52da585265c15cacfd9574043a6601ec52d3:src/test/java/TestMoveFile.java
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestMoveFile
{
    public static void main(String[] args) {
		System.out.println(System.getProperty("user.home"));

		Path sourcePath = Paths.get(System.getProperty("user.home") + "/Downloads/" + "?????????å¥?" + ".mp3");
    	Path targetPath = Paths.get(System.getProperty("user.home") + "/Desktop/" + "?????????å¥?" + ".mp3");
    	try {
     		Files.move(sourcePath, targetPath);
    	} catch (FileAlreadyExistsException ex) {
      		System.out.println("Error: ParseSongBySelenium - file already exist");
    	} catch (IOException io) {
			System.out.println("Error: ParseSongBySelenium - I/O error");
    	}
	}
}
