package com.poc.xml.validation;

import org.xml.sax.SAXException;

import java.io.IOException;

public class XmlValidatorAsApp {
    public static void main(String[] args) throws IOException, SAXException {

        String XML_TO_TEST_PATH = "xml/validation/xml-to-be-tested.xml";
        String DEFINITION_XSD_PATH = "xml/validation/definition.xsd";
        String DEFINITION_TO_TEST_INVALID_XSD_PATH = "xml/validation/definition-to-test-invalid.xsd";

        System.out.println(new XmlValidator(DEFINITION_XSD_PATH, XML_TO_TEST_PATH).isValid());

        System.out.println(new XmlValidator(DEFINITION_TO_TEST_INVALID_XSD_PATH, XML_TO_TEST_PATH).isValid());

        System.out.println(new XmlValidator(DEFINITION_XSD_PATH, XML_TO_TEST_PATH).listParsingExceptions().size());

        System.out.println(new XmlValidator(DEFINITION_TO_TEST_INVALID_XSD_PATH, XML_TO_TEST_PATH).listParsingExceptions().size());

    }
}
