package by.training.entity;

import by.training.entity.enumeration.Group;
import by.training.entity.list.VersionList;

import java.util.ArrayList;
import java.util.List;

public class Medicine {
    private String name;
    private String pharm;
    private Group group;
    private List<String> analogs;
    private VersionList versionList;

    public Medicine() {
        analogs = new ArrayList<>();
        versionList = new VersionList();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPharm(String pharm) {
        this.pharm = pharm;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void addAnalog(String analog) {
        analogs.add(analog);
    }

    public void setVersionList(VersionList versionList) {
        this.versionList = versionList;
    }
}
