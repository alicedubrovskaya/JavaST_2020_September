package by.training.entity;

import by.training.entity.enumeration.Group;
import by.training.entity.list.VersionList;

import java.util.List;

public class Medicine {
    private String name;
    private String pharm;
    private Group group;
    private List<String> analogs;
    private VersionList versionList;
}
