package com.poc.xml.validation;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class XmlValidatorAsUnitTests {

    private static final String XML_TO_TEST_PATH = "xml/validation/xml-to-be-tested.xml";
    private static final String DEFINITION_XSD_PATH = "xml/validation/definition.xsd";
    private static final String DEFINITION_TO_TEST_INVALID_XSD_PATH = "xml/validation/definition-to-test-invalid.xsd";

    @Test
    public void givenValidXML_WhenIsValid_ThenTrue() throws IOException, SAXException {
        assertTrue(new XmlValidator(DEFINITION_XSD_PATH, XML_TO_TEST_PATH).isValid());
    }

    @Test
    public void givenInvalidXML_WhenIsValid_ThenFalse() throws IOException, SAXException {
        assertFalse(new XmlValidator(DEFINITION_TO_TEST_INVALID_XSD_PATH, XML_TO_TEST_PATH).isValid());
    }

    @Test
    public void givenValidXML_WhenListParsingExceptions_ThenNone() throws IOException, SAXException {
        assertEquals(0, new XmlValidator(DEFINITION_XSD_PATH, XML_TO_TEST_PATH).listParsingExceptions().size());
    }

    @Test
    public void givenInvalidXML_WhenListParsingExceptions_ThenHasThree() throws IOException, SAXException {
        assertEquals(3, new XmlValidator(DEFINITION_TO_TEST_INVALID_XSD_PATH, XML_TO_TEST_PATH).listParsingExceptions().size());
    }

}