package by.training.xml.entity.list;


import by.training.xml.entity.Version;

import java.util.ArrayList;
import java.util.List;

public class VersionList {
    private List<Version> versions;

    public VersionList() {
        this.versions = new ArrayList<>();
    }

    public void add(Version version) {versions.add(version);}

    public List<Version> getVersions() {
        return versions;
    }

    public int getVersionsCount(){
        return versions.size();
    }
}
