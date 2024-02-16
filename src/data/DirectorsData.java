package data;

import java.util.List;
import java.util.ArrayList;
import classes.Director;

public class DirectorsData {
    private static List<Director> directorsList = new ArrayList<>();

    public void addDirector(Director director) {
        directorsList.add(director);
    }

    public void removeDirector(int id) {
        try {
            Director removedDirector = directorsList.remove(id);
            System.out.println("Director " + removedDirector.getName() + " successfully removed.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Invalid ID. Director could not be found.");
        }
    }

    public Director findDirectorById(int id) {
        if (id >= 0 && id < directorsList.size()) {
            return directorsList.get(id);
        } else {
            System.out.println("Invalid ID. Director could not be found.");
            return null;
        }
    }
}
