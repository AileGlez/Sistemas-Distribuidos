package interfaces;

import java.io.Serializable;

public class Task implements Serializable {

    private int taskId;
    private int requirementId;
    private int length;
    private String output;

    public Task(int taskId, int requirementId, int length) {
        this.taskId = taskId;
        this.requirementId = requirementId;
        this.length = length;
    }

    public String getRequirement(){
        return "Bioinfromatica";
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", requirementId=" + requirementId +
                ", length=" + length +
                ", output='" + output + '\'' +
                '}';
    }
}
