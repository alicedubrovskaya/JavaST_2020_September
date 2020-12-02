package by.training.xml.entity;


import by.training.xml.entity.enumeration.Group;
import by.training.xml.entity.list.VersionList;

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

    public void addToVersionList(Version version) {
        versionList.add(version);
    }

    public VersionList getVersionList() {
        return versionList;
    }

    public String getName() {
        return name;
    }

    public String getPharm() {
        return pharm;
    }

    public Group getGroup() {
        return group;
    }

    public List<String> getAnalogs() {
        return analogs;
    }

}
