package data;

import java.util.List;
import java.util.ArrayList;
import classes.Director;

public class DirectorsData {
    // <editor-fold desc="Attributes">
    private static final List<Director> directorsList = new ArrayList<>();
    // </editor-fold>

    // <editor-fold desc="Methods">

    /**
     * Method getDirectorsList - return list of directors
     * */
    public static List<Director> getDirectorsList() {
        return directorsList;
    }

    /**
     * Method addDirector - add director to list
     * */
    public static void addDirector(Director director) {
        directorsList.add(director);
    }

    /**
     * Method removeDirector - remove director by id
     * no usage created start project - (case study)
     * */
    public static void removeDirector(int id) {
        try {
            Director removedDirector = directorsList.remove(id);
            System.out.println("Diretor(a): " + removedDirector.getName() + " removido com sucesso.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Diretor(a) não pode ser encontrado, verifique se o índice foi informado corretamente.");
        }
    }

    /**
     * Method findDirectorByName - find director by name
     * */
    public static Director findDirectorByName(String name) {
        for (Director director : DirectorsData.getDirectorsList()) {
            if (director.getName().equalsIgnoreCase(name)) {
                return director;
            }
        }
        return null;
    }

    /**
     * Method findDirectorById - return director by id
     * no usage created start project - (case study)
     * */
    public static Director findDirectorById(int id) {
        if (id >= 0 && id < directorsList.size()) {
            return directorsList.get(id);
        } else {
            System.out.println("Diretor(a) não pode ser encontrado, verifique se o índice foi informado corretamente.");
            return null;
        }
    }

    // </editor-fold>
}
