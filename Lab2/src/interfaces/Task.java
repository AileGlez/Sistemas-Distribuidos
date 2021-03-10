package interfaces;

import java.io.Serializable;

public class Task implements Serializable {
    private String taskId;
    private String requirementId;
    private long length; // in ms
    private String output;

    public Task(String taskId, String requirementId, long length) {
        this.taskId = taskId;
        this.requirementId = requirementId;
        this.length = length;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(String requirementId) {
        this.requirementId = requirementId;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
