package net.sf.jsqlparser.statement.create;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.create.table.CreateTable;
import org.junit.jupiter.api.Test;

import java.io.StringReader;

public class CreateSpecialTableTest {
	private final CCJSqlParserManager parserManager = new CCJSqlParserManager();

	@Test
	public void testCreateDuplicate()throws JSQLParserException {
		String createSql=" create table  if not exists `testsdd` ( \n" +
				"`recruit_date` date  comment 'yyyy-mm-dd', \n" +
				"`region_num` smallint  comment 'range [-128, 127]', \n" +
				"`num_plate` smallint  comment 'range [-32768, 32767] ', \n" +
				"`tel` int  comment 'range [-2147483648, 2147483647]', \n" +
				"`id` bigint(19)  comment 'range [-2^63 + 1 ~ 2^63 - 1]', \n" +
				"`password` largeint  comment 'range [-2^127 + 1 ~ 2^127 - 1]', \n" +
				"`name` char  comment 'range char(m),m in (1-255) ', \n" +
				"`profile` varchar(500)  comment 'upper limit value 65533 bytes', \n" +
				"`hobby` string  comment 'upper limit value 65533 bytes', \n" +
				"`leave_time` datetime  comment 'yyyy-mm-dd hh:mm:ss', \n" +
				"`channel` float  comment '4 bytes', \n" +
				"`income` double  comment '8 bytes', \n" +
				"`account` decimal(12,4) , \n" +
				"`ispass` smallint  comment 'true/false' \n" +
				") engine=olap\n" +
				"duplicate key ( recruit_date,region_num)\n" +
				" comment 'haha'\n" +
				"distributed by hash (recruit_date,region_num)\n" +
				"properties(\"replication_num\"=\"1\");";
		Statement statement = parserManager.parse(new StringReader(createSql));

		CreateTable createTable=(CreateTable) statement;

		System.out.println(createTable.toString());

	}
}
