package smart.SmartSetup.MGZ8.models;

import java.io.Serializable;

public class Remote implements Serializable,Comparable<Remote>{
    String name,value;
    Integer partitionName;
    String numRemote;

    public String getNumRemote() {
        return numRemote;
    }

    public void setNumRemote(String numRemote) {
        this.numRemote = numRemote;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPartitionName() {
        return partitionName;
    }

    public void setPartitionName(Integer partitionName) {
        this.partitionName = partitionName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int compareTo(Remote o) {
        if (partitionName.floatValue() > o.partitionName.floatValue()) {
            return 1;
        }
        else if (partitionName.floatValue() <  o.partitionName.floatValue()) {
            return -1;
        }
        else {
            return 0;
        }

    }
}
