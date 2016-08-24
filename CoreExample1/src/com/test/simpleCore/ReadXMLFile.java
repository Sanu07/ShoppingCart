package com.test.simpleCore;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXMLFile {

	public static void main(String[] args) {
		File testFile=new File("C:\\Users\\sanu\\Desktop\\projectTest\\logFile\\test1.xml");
		DocumentBuilderFactory documentBuilderFactory=DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
			Document document=documentBuilder.parse(testFile);
			document.getDocumentElement().normalize();
			
			System.out.println(document.getDocumentElement().getNodeName());
			
			NodeList nodeList=document.getElementsByTagName("staff");
			for(int i=0;i<nodeList.getLength();i++){
				Node node=nodeList.item(i);
				System.out.println("Current node : "+node.getNodeName());
				if(node.getNodeType() == Node.ELEMENT_NODE){
					Element element=(Element) node;
					System.out.println(" Id : "+element.getAttribute("id"));
					System.out.println("First Name : "+element.getElementsByTagName("firstname").item(0).getTextContent());
					System.out.println("Last Name : "+element.getElementsByTagName("lastname").item(0).getTextContent());
					System.out.println("Nick Name : "+element.getElementsByTagName("nickname").item(0).getTextContent());
					System.out.println("Salary : "+element.getElementsByTagName("salary").item(0).getTextContent());
					System.out.println("----------------------------");
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
