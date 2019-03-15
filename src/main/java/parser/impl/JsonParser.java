package parser.impl;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import parser.Parser;


public class JsonParser implements Parser {

    @Override
    public void convertTo(File file,Object obj)  {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(file, obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object convertFrom(File file, Class cl) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(file, cl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
