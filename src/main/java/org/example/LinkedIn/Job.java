package org.example.LinkedIn;

public class Job {
    private  int jobId;
    private String jobName;
    private String companyName;
    private User user;

    public Job(int jobId, String jobName, String companyName) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.companyName = companyName;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
