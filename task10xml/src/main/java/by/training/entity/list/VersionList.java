package by.training.entity.list;

import by.training.entity.Version;

import java.util.ArrayList;
import java.util.List;

public class VersionList {
    private List<Version> versions;

    public VersionList() {
        this.versions = new ArrayList<>();
    }

    public void add(Version version) {versions.add(version);}
}
