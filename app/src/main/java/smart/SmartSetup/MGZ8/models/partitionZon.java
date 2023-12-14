package smart.SmartSetup.MGZ8.models;

import java.util.List;

public class partitionZon {
    List<Zon> ZonList;
    String name;

    public List<Zon> getZonList() {
        return ZonList;
    }

    public void setZonList(List<Zon> zonList) {
        ZonList = zonList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
