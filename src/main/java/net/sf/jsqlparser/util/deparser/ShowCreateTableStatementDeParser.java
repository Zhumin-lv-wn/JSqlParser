/*-
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2023 JSQLParser
 * %%
 * Dual licensed under GNU LGPL 2.1 or Apache License 2.0
 * #L%
 */
package net.sf.jsqlparser.util.deparser;

import net.sf.jsqlparser.statement.ShowCreateTableStatement;

public class ShowCreateTableStatementDeParser extends  AbstractDeParser<ShowCreateTableStatement>{

    protected ShowCreateTableStatementDeParser(StringBuilder buffer) {
        super(buffer);
    }

    @Override
    void deParse(ShowCreateTableStatement statement) {
        buffer.append("SHOW CREATE TABLE ").append(statement.getTableName());
    }
}
