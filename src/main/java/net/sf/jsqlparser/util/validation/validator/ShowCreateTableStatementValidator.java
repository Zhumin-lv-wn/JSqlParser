/*-
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2023 JSQLParser
 * %%
 * Dual licensed under GNU LGPL 2.1 or Apache License 2.0
 * #L%
 */
package net.sf.jsqlparser.util.validation.validator;

import net.sf.jsqlparser.parser.feature.Feature;
import net.sf.jsqlparser.statement.ShowCreateTableStatement;

import net.sf.jsqlparser.util.validation.metadata.NamedObject;

public class ShowCreateTableStatementValidator extends AbstractValidator<ShowCreateTableStatement>{
    @Override
    public void validate(ShowCreateTableStatement statement) {
        validateFeatureAndName(Feature.showCreateTable, NamedObject.table, statement.getTableName());
    }
}
