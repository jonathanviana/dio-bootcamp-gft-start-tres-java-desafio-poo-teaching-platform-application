package br.com.teachingplatform.application.services;

public class Course extends Content {

    private int workload;

    public Course() {
    }

    public int getWorkload() {
        return workload;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }
}

