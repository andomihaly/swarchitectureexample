package eu.misi.common;

import eu.misi.log.BusinessLog;
import eu.misi.log.BusinessLogWithSLF4J;

public class Context {
    public static BusinessLog businessLog = new BusinessLogWithSLF4J();
    public static BusinessLog getBusinesLog(){
        return businessLog;
    }
}
