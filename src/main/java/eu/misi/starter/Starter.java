package eu.misi.starter;

import eu.misi.initproject.InitProject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Starter {

    private static final Logger logger = LoggerFactory.getLogger("LogToFile");


    public static void main(String[] args) {
        InitProject initProject = new InitProject();
        initProject.basicString();
    }
}