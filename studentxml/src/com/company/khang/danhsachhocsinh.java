package com.company.khang;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;

public class danhsachhocsinh {
     private ArrayList<student> ds;

    public danhsachhocsinh() {
        ds=new ArrayList<>();
    }

    public danhsachhocsinh(ArrayList<student> ds) {
        this.ds = ds;
    }

    public void addhs(student hs){
        ds.add(hs);
    }

    public  void xuatdanhsach(){
        for(student hs:ds){
            System.out.println(hs);
        }
    }

    public void savefile(){
        FileOutputStream fos=null;
        try {
            fos=new FileOutputStream("student.xml");

            String studentlist="";
            for(student hs:ds){
                studentlist+= hs.toxml();
            }
            String content=toxml(studentlist);
            byte[] data=content.getBytes("utf8");
            fos.write(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void xoahs(int i){
        ds.remove(i);
    }

    public void docfilepax(){
        File file=new File("student.xml");
        SAXParserFactory factory=SAXParserFactory.newInstance();
        try {
            SAXParser parser= factory.newSAXParser();
            studentpaser hsparse=new studentpaser();
            parser.parse(file,hsparse);
            ds=hsparse.studentList;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void docfileDOM(){
        File file=new File("student.xml");
        DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db= dbf.newDocumentBuilder();
            Document doc=db.parse(file);
            doc.getDocumentElement().normalize();

            NodeList nodeList=doc.getElementsByTagName("student");
            for(int i=0;i<nodeList.getLength();i++){
                student hs =new student();
                Node n=nodeList.item(i);
                if (n.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) n;
                    hs.setHoten(eElement.getElementsByTagName("hoten")
                            .item(0).getTextContent());
                    hs.setToan(Integer.parseInt(eElement.getElementsByTagName("toan")
                            .item(0).getTextContent()));
                    hs.setLy(Integer.parseInt(eElement.getElementsByTagName("toan")
                            .item(0).getTextContent()));
                    hs.setHoa(Integer.parseInt(eElement.getElementsByTagName("toan")
                            .item(0).getTextContent()));

                }
                // add đối tượng student vào listStudents
                ds.add(hs);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public String toxml(String studentlist){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<class>\n" +
                "    <studentlist>\n" +
                            studentlist    +
                "    </studentlist>\n" +
                "</class>";
    }
    public student truydenhs(int i){
       return ds.get(i);
    }
}
