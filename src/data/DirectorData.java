package data;

import java.util.List;
import java.util.ArrayList;
import classes.Director;

public class DirectorData {
    private static List<Director> directorList = new ArrayList<>();

    public void addDirector(Director director) {
        directorList.add(director);
    }

    public void removeDirector(int id) {
        directorList.remove(id);
    }

    public void removeDirector(Director director) {
        directorList.remove(director);
    }

    public Director findDirectorById(int id) {
        return directorList.get(id);
    }
}
