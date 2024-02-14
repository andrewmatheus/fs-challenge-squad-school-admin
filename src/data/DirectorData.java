package data;

import java.util.List;
import java.util.ArrayList;
import classes.Director;

public class DirectorData {
    private List<Director> directorList;

    public DirectorData() {
        directorList = new ArrayList<>();
    }

    public void addDirector(Director director) {
        directorList.add(director);
    }

    public void removeDirector(int id) {
        directorList.remove(id);
    }

    public Director search(int id) {
        return directorList.get(id);
    }
}
