package com.xu.main.xml;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Util {

	// public static String getIDParamInXMLByDOM(String src) {
	//
	//
	// try {
	// DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	// // 获取此类的实例之后，将可以从各种输入源解析XML
	// DocumentBuilder builder;
	// builder = factory.newDocumentBuilder();
	// ByteArrayInputStream in=new ByteArrayInputStream(src.getBytes("UTF-8"));
	//
	// // Document接口表示整个HTML或XML文档，从概念上讲，它是文档树的根，并提供对文档数据的基本访问
	// Document document = builder.parse(in);
	//
	//// Element root=document.getDocumentElement();
	//
	// NodeList nodeList= document.getChildNodes();
	//
	// StringBuilder sb=new StringBuilder();
	// for(int i = 0; i < nodeList.getLength(); ++i){
	// Node item=nodeList.item(i);
	//// System.out.println("name:"+item.getNodeName());
	// Node idItem=item.getAttributes().getNamedItem("android:id");
	// if(idItem==null||idItem.getNodeValue()==null){
	// continue;
	// }
	// sb.append("public ").append(item.getNodeName())
	// .append(" ")
	// .append(idItem.getNodeValue())
	// .append(";\n");
	//
	// }
	//
	// return sb.toString();
	//
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// System.out.println(e);
	// }
	// // builder.parse(this.getClass().getResourceAsStream("/" + fileName));
	//
	// return src;
	// }
	
//TODO 需要递归
	public static String getIDParamInXMLByDOM4(String src) {

		try {
			SAXReader reader = new SAXReader();
			ByteArrayInputStream in = new ByteArrayInputStream(src.getBytes("UTF-8"));

			Document document = reader.read(in);
			Element root = document.getRootElement();
			
			StringBuilder sb = new StringBuilder();
		
			getNodeID(root,sb);
			
			return sb.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}

		return src;
	}
	
	
	public static void getAttributeID(Element item,StringBuilder sb){
		List<Attribute> ats = item.attributes();

		if (ats == null || ats.size() == 0) {
			return;
		}

		String id = null;
		for (Attribute at : ats) {
			String name=at.getName();
			if ("id".equals(name)) {
				id = at.getText();
				break;
			}
		}
		if (id != null) {
			
			String realID=id.substring(5, id.length());
			sb.append("public ").append(item.getName()).append(" ").append(realID).append(";\n");

		}
	}
	
	public static void getNodeID(Element node,StringBuilder sb){
		
		getAttributeID(node,sb);
		
		List<Element> es = node.elements();
		
		for (int i = 0; i < es.size(); ++i) {
			Element item = es.get(i);
			getNodeID(item,sb);
		}
		
		
	}
	
//    public static Map<String, String> XMLToMap(String XMLStr,String ...noteName)  {
//
//        Map<String, String> resultMap = new HashMap<String, String>();
//        try {
//            InputStream in = new ByteArrayInputStream(XMLStr.getBytes());
//            XmlPullParser pullParser = Xml.newPullParser();
//            pullParser.setInput(in, "UTF-8");
//            int event = pullParser.getEventType();
//            while (event != XmlPullParser.END_DOCUMENT) {
//                String nodeName = pullParser.getName();
//                switch (event) {
//                    case XmlPullParser.START_DOCUMENT:
//                        break;
//                    case XmlPullParser.START_TAG:
//                        for(String name:noteName){
//                            if(name.equals(nodeName) ){
//                                resultMap.put(nodeName, pullParser.nextText());
//                                break;
//                            }
//                        }
//
//                        break;
//                    case XmlPullParser.END_TAG:
//                        break;
//
//                    default:
//                        break;
//                }
//                event = pullParser.next();
//
//            }
//        } catch (Exception e) {
//            appLog.e(DataTools.getExceptionStackInfo(e));
//        }
//        return resultMap;
//    }
//	
	

}
