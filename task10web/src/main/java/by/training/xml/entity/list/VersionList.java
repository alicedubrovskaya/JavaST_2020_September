package by.training.xml.entity.list;


import by.training.xml.entity.Version;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VersionList {
    private List<Version> versions;

    public VersionList() {
        this.versions = new ArrayList<>();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VersionList versionList = (VersionList) o;
        return Objects.equals(versions, versionList.versions);
    }

    public void add(Version version) {versions.add(version);}

    public List<Version> getVersions() {
        return versions;
    }

    public int getVersionsCount(){
        return versions.size();
    }
}
