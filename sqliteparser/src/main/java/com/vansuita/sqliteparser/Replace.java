package com.vansuita.sqliteparser;

/**
 * Created by Anton Nikitin on 08.06.2017.
 */

public class Replace extends Insert {

    private static final String REPLACE_FORMAT = "REPLACE INTO %s(%s) VALUES(%s);";

    public Replace() {
    }

    public Replace(String tableName) {
        super(tableName);
    }

    @Override
    protected String getSql() {
        String cols = "";
        String vals = "";

        if (!columns.isEmpty()) {
            cols = Utils.breakList(",", columns);
            vals = Utils.breakList(",", values);
        }

        return String.format(REPLACE_FORMAT, tableName, cols, vals);
    }
}
