package org.talcrafts.digigyan.model;

/**
 * Created by ashwaghm on 19-Jan-17.
 */
public class Test {
    private static Test ourInstance = new Test();

    public static Test getInstance() {
        return ourInstance;
    }

    private Test() {
    }
}
