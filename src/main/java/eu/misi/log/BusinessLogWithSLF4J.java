package eu.misi.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class BusinessLogWithSLF4J implements BusinessLog {
    Logger businessLogger = LoggerFactory.getLogger("BusinessLog");

    @Override
    public void setBusinessCaseID(String businessCaseId) {
        MDC.put("businessCaseID", businessCaseId);
    }

    @Override
    public void clearBusinessCaseID() {
        MDC.remove("businessCaseID");
    }

    @Override
    public void addBusinessLog(String message) {
        businessLogger.info(message);
    }
}
