package parser.impl;

import parser.Parser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JaxbParser implements Parser {

    @Override
    public void convertTo( File file, Object obj){
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(obj, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object convertFrom(File file, Class cl) {
        try {
            JAXBContext context = JAXBContext.newInstance(cl);
            Unmarshaller un = context.createUnmarshaller();
            return un.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}