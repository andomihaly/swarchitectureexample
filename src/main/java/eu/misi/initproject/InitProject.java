package eu.misi.initproject;

import eu.misi.common.Context;
import org.slf4j.MDC;

import java.util.UUID;

public class InitProject {
    public boolean positiveAnswer(){
        return true;
    }
    public String basicString(){
        try {
            MDC.put("transactionID", UUID.randomUUID().toString());
            Context.getBusinesLog().setBusinessCaseID( UUID.randomUUID().toString());
            Context.getBusinesLog().addBusinessLog("Basic String activate.");
            return "Init Project Ongoing";
        }
        finally {
            MDC.remove("transactionID");
        }

    }
    public void generateException(){
        throw new InitProjectException("Init Project Exception Message");
    }
}