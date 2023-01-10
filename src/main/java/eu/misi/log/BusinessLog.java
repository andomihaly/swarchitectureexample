package eu.misi.log;

public interface BusinessLog {
    void setBusinessCaseID(String businessCaseId);
    void clearBusinessCaseID();
    void addBusinessLog(String message);

}
