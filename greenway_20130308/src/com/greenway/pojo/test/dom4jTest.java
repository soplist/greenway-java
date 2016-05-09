package com.greenway.pojo.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

public class dom4jTest {
	public static void main(String[] args) {
		dom4jTest dt = new dom4jTest();
		dt.write();
	}
	public void write(){
		   Element root = new Element("resume");    
		   Document Doc = new Document(root);
		    Element elements1 = new Element("personal_information");
		    elements1.addContent(new Element("name").setText("name"));
		    elements1.addContent(new Element("email").setText("ld.zhengm@gmail.com"));
		    elements1.addContent(new Element("identification_number").setText("612401198507290554"));
		    
		    Element elements2 = new Element("education");
		    elements2.addContent(new Element("school").setText("school1"));
		    elements2.addContent(new Element("major").setText("Computer Science and Technology"));

		    root.addContent(elements1);
		    root.addContent(elements2);
		   XMLOutputter XMLOut = new XMLOutputter();
		   try {
			    XMLOut.output(Doc, new FileOutputStream("F:/xml/company_list2.xml"));
		   } catch (FileNotFoundException e) {
			    e.printStackTrace();
		   } catch (IOException e) {
			    e.printStackTrace();
		   }
		
	}

}
