package com.nikandr.spring.aspectJ.xml;

import com.nikandr.spring.aspectJ.xml.exceptions.WrongInterceptionException;

public interface MindReader {
    void interceptThoughts(String thoughts);

    void getThoughts() throws WrongInterceptionException;

    void apologize();
}
