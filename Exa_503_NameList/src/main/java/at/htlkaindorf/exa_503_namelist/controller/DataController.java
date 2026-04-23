package at.htlkaindorf.exa_503_namelist.controller;

import java.util.LinkedList;
import java.util.List;

public class DataController {
    private List<String> names;

    public DataController() {
        names = new LinkedList<>();
    }

    public void addName(String name) {
        names.add(name);
    }

    public boolean delete(String name) {
        return names.remove(name);
    }

    public String getElementAtIndex(int index) {
        return names.get(index);
    }

    public List<String> getNames() {
        return names;
    }
}
