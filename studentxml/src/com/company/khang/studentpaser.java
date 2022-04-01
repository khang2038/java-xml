package com.company.khang;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class studentpaser extends DefaultHandler {
      ArrayList<student> studentList=new ArrayList<>();
      student hs;
      boolean isstudent=false;
      boolean ishoten=false;
      boolean istoan=false;
      boolean isly=false;
      boolean ishoa=false;
      @Override
      public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if(qName.equalsIgnoreCase("student")){
                  isstudent=true;
                  hs=new student();
            }
            if(isstudent){
                  if (qName.equalsIgnoreCase("hoten")){
                        ishoten=true;
                  }else if (qName.equalsIgnoreCase("toan")){
                        istoan=true;
                  }else if (qName.equalsIgnoreCase("ly")){
                        isly=true;
                  }else if (qName.equalsIgnoreCase("hoa")){
                        ishoa=true;
                  }
            }
      }

      @Override
      public void endElement(String uri, String localName, String qName) throws SAXException {
            if(qName.equalsIgnoreCase("student")){
                  isstudent=false;
                  studentList.add(hs);
                  hs=null;
            }
            if(isstudent){
                  if (qName.equalsIgnoreCase("hoten")){
                        ishoten=false;
                  }else if (qName.equalsIgnoreCase("toan")){
                        istoan=false;
                  }else if (qName.equalsIgnoreCase("ly")){
                        isly=false;
                  }else if (qName.equalsIgnoreCase("hoa")){
                        ishoa=false;
                  }
            }
      }

      @Override
      public void characters(char[] ch, int start, int length) throws SAXException {
            String str=String.valueOf(ch,start,length);
            if(isstudent){
                  if(ishoten){
                        hs.setHoten(str);
                  }else if(istoan){
                        hs.setToan(Integer.parseInt(str));
                  }else if(isly){
                        hs.setLy(Integer.parseInt(str));
                  }else if(ishoa){
                        hs.setHoa(Integer.parseInt(str));
                  }
            }
      }
}
