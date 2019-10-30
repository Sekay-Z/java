package dao;

import domain.User;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class UserDaoXml {
        String path="C:\\Java/user.xml";
        public User findByUsername(String username){
            SAXReader reader=new SAXReader();
            try {
                Document document=reader.read(path);
                Element ele= (Element) document.selectSingleNode("//user[@username='"+username+"']");
                if(ele==null){
                    return null;
                }
                else{
                    User user=new User();
                    user.setUsername(ele.attributeValue("username"));
                    user.setPassword(ele.attributeValue("password"));
                    return user;
                }
            } catch (DocumentException e) {
                throw new RuntimeException();
            }
        }
        public void add(User user) throws IOException {
            SAXReader reader=new SAXReader();
            try {
                Document document=reader.read(path);
                Element root=document.getRootElement();
                Element elem=root.addElement("user");
                elem.addAttribute("username",user.getUsername());
                elem.addAttribute("password",user.getPassword());
                OutputFormat format=new OutputFormat("\t",true);
                format.setTrimText(true);
                XMLWriter xmlWriter=
                        new XMLWriter(new OutputStreamWriter(new FileOutputStream(path),"UTF-8"));
                xmlWriter.write(document);
                xmlWriter.close();
            } catch (DocumentException e) {
                throw new RuntimeException(e);
            }
        }



}
