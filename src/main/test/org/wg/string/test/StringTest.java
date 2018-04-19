package org.wg.string.test;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class StringTest {
	public static void main(String[] args) {

	    String str=null;

	    str=String.format("格式参数$的使用：%1$d,%2$s", 99,"abc");           // 格式化字符串

	    System.out.println(str);                                                                                     // 输出字符串变量
/*
	    System.out.printf("显示正负数的符号：%+d与%d%n", 99,-99);

	    System.out.printf("最牛的编号是：%03d%n", 7);

	    System.out.printf("Tab键的效果是：% 8d%n", 7);

	    System.out.printf("整数分组的效果是：%,d%n", 9989997);

	    System.out.printf("一本书的价格是：%2.2f元%n", 49.8);*/

	}
	
	
	@Test
	public void DocumentTest() throws ParserConfigurationException, SAXException, IOException {
		  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
          DocumentBuilder db = dbf.newDocumentBuilder();
          StringReader sr = new StringReader("iz6eYkZ2YlRDUyl4VTPxtjlIBiPmg3JQTdu4QEaUgsPBmjY9VzudZbSFQrkSKNyrEdO7dAjnecbQn%2FD2CYTok5cmENyLXLgnazR%2BHB3bq8yDZxh7AqmZkrFTd%2B6g6r7q9VqCtqtWxOYdfz99jRVdkENPYpP%2BcuEDugFJPkbIZOFyb%2FBS8IXXYy0Ko8KpAB6MhD1DSOpKg1DEmP1VJbri8w%3D%3D");
          InputSource is = new InputSource(sr);
          Document document = db.parse(is);
          System.out.println(document);
	}

}
