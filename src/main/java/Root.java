import java.io.Serializable;
import java.util.ArrayList;

public class Root implements Serializable {
    private static final long serialVersionUID = 1L;
    int length = 0;
    ArrayList <Folder> listContent = new ArrayList<>();
}
