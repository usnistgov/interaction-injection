package gov.nist.hla.ii;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.ieee.standards.ieee1516._2010.InteractionClassType;
import org.ieee.standards.ieee1516._2010.ObjectClassType;
import org.junit.BeforeClass;
import org.junit.Test;

import gov.nist.hla.ii.exception.PropertyNotAssigned;
import gov.nist.hla.ii.exception.PropertyNotFound;
import gov.nist.hla.ii.exception.RTIAmbassadorException;

public class InjectionFederateTest {

	static InjectionFederate sut;
	static Properties props;
	static final String CONFIG_FILE = "config.properties";

	@BeforeClass
	public static void beforeClass() {
		try {
			sut = new InjectionFederate();
			props = new Properties();
			InputStream is = InjectionFederateTest.class.getClassLoader().getResourceAsStream(CONFIG_FILE);
			props.load(is);
		} catch (RTIAmbassadorException | ParserConfigurationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testLoadConfiguration() {
		try {
			sut.loadConfiguration(CONFIG_FILE);
			assertEquals(props.getProperty("fom-file"), sut.getFomFilePath());
		} catch (IOException | PropertyNotFound | PropertyNotAssigned e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testInteractionCount() {
		try {
			sut.loadConfiguration(CONFIG_FILE);
			assertEquals(3, sut.getFom().getInteractions().getInteractionClass().getInteractionClass().size());
			for (InteractionClassType itr : sut.getFom().getInteractions().getInteractionClass().getInteractionClass()) {
				System.out.println(itr.getName().getValue());
			}
		} catch (IOException | PropertyNotFound | PropertyNotAssigned e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetInteractionSubscribe() {
		try {
			sut.loadConfiguration(CONFIG_FILE);
			Set<InteractionClassType> set = sut.getInteractionSubscribe();
			assertEquals(2, set.size());
			for (InteractionClassType ict : set) {
				System.out.println(ict.getName().getValue());
			}
		} catch (IOException | PropertyNotFound | PropertyNotAssigned e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetInteractionPublish() {
		try {
			sut.loadConfiguration(CONFIG_FILE);
			Set<InteractionClassType> set = sut.getInteractionPublish();
			assertEquals(2, set.size());
			for (InteractionClassType ict : set) {
				System.out.println(ict.getName().getValue());
			}
		} catch (IOException | PropertyNotFound | PropertyNotAssigned e) {
			e.printStackTrace();
		}
	}
	
//	@Test
	public void testGetObjectSubscribe() {
		try {
			sut.loadConfiguration(CONFIG_FILE);
			Set<ObjectClassType> set = sut.getObjectSubscribe();
			assertEquals(2, set.size());
			for (ObjectClassType oct : set) {
				System.out.println(oct.getName().getValue());
			}
		} catch (IOException | PropertyNotFound | PropertyNotAssigned e) {
			e.printStackTrace();
		}
	}
	
//	@Test
	public void testGetObjectPublish() {
		try {
			sut.loadConfiguration(CONFIG_FILE);
			Set<ObjectClassType> set = sut.getObjectPublish();
			assertEquals(2, set.size());
			for (ObjectClassType oct : set) {
				System.out.println(oct.getName().getValue());
			}
		} catch (IOException | PropertyNotFound | PropertyNotAssigned e) {
			e.printStackTrace();
		}
	}
}
