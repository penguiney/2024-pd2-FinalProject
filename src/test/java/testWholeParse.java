<<<<<<< HEAD:src/test/java/finalproject/testWholeParse.java


=======
>>>>>>> d8ce52da585265c15cacfd9574043a6601ec52d3:src/test/java/testWholeParse.java
public class testWholeParse {
    public static void main(String[] args) {
        ParseSong parsebot = new ParseSong();
        ListStruct struct = new ListStruct();

        struct.addList("Test_Folder");
        parsebot.goParse("https://www.youtube.com/watch?v=8QHaRNPCvMk", "Test_Folder");
        struct.printRoot();
    }
}
