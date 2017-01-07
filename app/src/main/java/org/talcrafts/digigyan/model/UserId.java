package org.talcrafts.digigyan.model;

/**
 * Created by ashwaghm on 02-Jan-17.
 */

public class UserId {
    private final int id;

    public UserId(int id) {
        this.id = id;
    }

    public int getInt() {
        return id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof UserId && id == ((UserId) o).id;
    }
}
