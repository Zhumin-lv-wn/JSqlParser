/*-
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2019 JSQLParser
 * %%
 * Dual licensed under GNU LGPL 2.1 or Apache License 2.0
 * #L%
 */
package net.sf.jsqlparser.statement;

import net.sf.jsqlparser.schema.Table;

public class DescribeStatement implements Statement {

    private Table table;

    private Boolean useDesc = false;

    public DescribeStatement() {
        // empty constructor
    }

    public void setUseDesc(Boolean useDesc) {
        this.useDesc = useDesc;
    }

    public Boolean getUseDesc() {
        return useDesc;
    }

    public DescribeStatement(Table table) {
        this.table = table;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    @Override
    public String toString() {
        String value ;
        if (useDesc) {
            value = "DESC ";
        } else {
            value =  "DESCRIBE ";
        }
        return value + table.getFullyQualifiedName();
    }

    @Override
    public void accept(StatementVisitor statementVisitor) {
        statementVisitor.visit(this);
    }

    public DescribeStatement withTable(Table table) {
        this.setTable(table);
        return this;
    }
}
