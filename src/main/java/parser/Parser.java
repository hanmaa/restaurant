package parser;

import java.io.File;

public interface Parser {

    void convertTo(File file, Object obj);
    Object convertFrom(File file, Class cl);
}
