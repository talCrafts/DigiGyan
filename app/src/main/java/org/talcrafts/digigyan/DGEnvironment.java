package org.talcrafts.digigyan;

/**
 * Created by ashwaghm on 04-Jan-17.
 */

public class DGEnvironment {

    public final static int appVersion = 1;
    public final static int dbVersion = 1;
    public static final String DB_NAME = "DigiGyan.db";

    enum LifeCycle {
        DEVELOPMENT,
        DEPLOYMENT,
        MIGRATION,
        UPGRADE,
        PATCH
    }


}
