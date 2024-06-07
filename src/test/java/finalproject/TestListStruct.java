package finalproject;

public class TestListStruct {

    public void runtestList() {
        ListStruct struct = new ListStruct();

        struct.addList("TEST_FOLDER_1");
        struct.addList("TEST_FOLDER_2");
        struct.addList("TEST_FOLDER_3");

        struct.addSong("TEST_FOLDER_1", false, "TEST_SONG_1","TEST_WEBSITE");
        struct.addSong("TEST_FOLDER_1", false, "TEST_SONG_2","TEST_WEBSITE");
        struct.addSong("TEST_FOLDER_2", false, "TEST_SONG_3","TEST_WEBSITE");
        struct.addSong("TEST_FOLDER_3", false, "TEST_SONG_1","TEST_WEBSITE");

        struct.deleteSong("TEST_FOLDER_3", "TEST_SONG_1");
        struct.deleteList("TEST_FOLDER_2");
        struct.moveSong("TEST_SONG_2", "TEST_FOLDER_1", "TEST_FOLDER_3");

        struct.printRoot(); //will print�? folder1- song1 | folder3- song2

        struct.addSong("TEST_FOLDER_4", false, "TEST_SONG_1", "TEST_WEBSITE"); // will print error
    } 
}
