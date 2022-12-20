package eu.misi.initproject;

public class InitProject {
    public boolean positiveAnswer(){
        return true;
    }
    public String basicString(){
        return "Init Project Ongoing";
    }
    public void generateException(){
        throw new InitProjectException("Init Project Exception Message");
    }
}