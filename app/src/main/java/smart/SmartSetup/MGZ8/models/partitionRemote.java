package smart.SmartSetup.MGZ8.models;

import java.util.List;

public class partitionRemote {
    List<Remote> remoteList;
    String name;

    public List<Remote> getRemoteList() {
        return remoteList;
    }

    public void setRemoteList(List<Remote> remoteList) {
        this.remoteList = remoteList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
