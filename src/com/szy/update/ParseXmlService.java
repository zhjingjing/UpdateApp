package com.szy.update;

import java.io.InputStream;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xmlpull.v1.XmlPullParser;

import android.util.Xml;

/**
 * xml����
 */
public class ParseXmlService
{
  
    /**
     * dom����
     * */
	public HashMap<String, String> parseXml(InputStream inStream) throws Exception
	{
		HashMap<String, String> hashMap = new HashMap<String, String>();
		
		// ʵ����һ���ĵ�����������
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// ͨ���ĵ�������������ȡһ���ĵ�������
		DocumentBuilder builder = factory.newDocumentBuilder();
		// ͨ���ĵ�����������һ���ĵ�ʵ��
		Document document = builder.parse(inStream);
		//��ȡXML�ļ����ڵ�
		Element root = document.getDocumentElement();
		//��������ӽڵ�
		NodeList childNodes = root.getChildNodes();
		for (int j = 0; j < childNodes.getLength(); j++)
		{
			//�����ӽڵ�
			Node childNode = (Node) childNodes.item(j);
			if (childNode.getNodeType() == Node.ELEMENT_NODE)
			{
				Element childElement = (Element) childNode;
				//�汾��
				if ("version".equals(childElement.getNodeName()))
				{
					hashMap.put("version",childElement.getFirstChild().getNodeValue());
				}
				//�������
				else if (("name".equals(childElement.getNodeName())))
				{
					hashMap.put("name",childElement.getFirstChild().getNodeValue());
				}
				//���ص�ַ
				else if (("url".equals(childElement.getNodeName())))
				{
					hashMap.put("url",childElement.getFirstChild().getNodeValue());
				}
			}
		}
		return hashMap;
	}
	/**
	 * pull����
	 * */
	public HashMap<String, String> parseXmlpull(InputStream inStream) throws Exception{
	  HashMap<String, String> hashMap = new HashMap<String, String>(); 
	  XmlPullParser xmlPullParser=Xml.newPullParser();
	  xmlPullParser.setInput(inStream, "utf-8");
	  
	  int type=  xmlPullParser.getEventType();
	  while (type!=XmlPullParser.END_DOCUMENT) {
	      switch (type) {
            case XmlPullParser.START_DOCUMENT:
              
              break;
              
            case XmlPullParser.START_TAG:
              if (xmlPullParser.getName().equals("version")) {
                
                  type=xmlPullParser.next();
                  hashMap.put("version", xmlPullParser.getText());
                  
              } else if(xmlPullParser.getName().equals("name")){
                
                  type=xmlPullParser.next();
                  hashMap.put("name", xmlPullParser.getText());
                  
              }else if(xmlPullParser.getName().equals("url")){
                
                  type=xmlPullParser.next();
                  hashMap.put("url", xmlPullParser.getText());
                  
              }
              break;
              
            default:
              break;
          }
	      type=xmlPullParser.next();
      }
      return hashMap;
	  
	}
	
}
