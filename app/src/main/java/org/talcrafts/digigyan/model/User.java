package org.talcrafts.digigyan.model;

/**
 * Created by ashwaghm on 02-Jan-17.
 */

public class User {

    public static final String COLUMN_ID = "id";
    public static final String TABLE_NAME = "DGUser";
    private final UserId id;

    public User(UserId id) {
        this.id = id;
    }
}
