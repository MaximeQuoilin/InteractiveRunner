package be.technifutur;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import be.technifutur.applicationRunner.Environment;
import be.technifutur.applicationRunner.InteractiveApplication;
import be.technifutur.applicationRunner.InteractiveRunner;

import org.easymock.EasyMock;
import static org.junit.jupiter.api.Assertions.*;

public class InteractiveRunnerTest {
	private InteractiveRunner runner;
	private InteractiveApplication applicationMock;
	private Environment environnementMock;
	public boolean called = false;

	@BeforeEach
	public void init() {
		runner = new InteractiveRunner();
		// applicationMock = createApplication();
		applicationMock = EasyMock.createMock(InteractiveApplication.class);
		runner.setApplication(applicationMock);
		environnementMock = EasyMock.createMock(Environment.class);
		runner.setEnv(environnementMock);
	}

	@Test
	public void testSetApplicationNotNull() {
		assertAll(() -> assertNotNull(runner.getApplication()),
				() -> assertSame(applicationMock, runner.getApplication()));
	}

//	@Test
//	public void testGetScreenReturnTest1() {
//		applicationMock.start();
//		EasyMock.expect(applicationMock.isFinish()).andReturn(false);
//		EasyMock.expect(applicationMock.getScreen()).andReturn(new StringBuilder("toto"));
//		environnementMock.print("toto");
//		EasyMock.expect(applicationMock.isFinish()).andReturn(true);
//		EasyMock.expect(applicationMock.isFinish()).andReturn(true); // 3 au lieu de 2 car il appelle 3 fois la m�thode
//		EasyMock.expect(applicationMock.hasLastScreen()).andReturn(false);
//		applicationMock.stop();
//		EasyMock.replay(environnementMock, applicationMock);
//		runner.run();
//		EasyMock.verify(environnementMock, applicationMock);
//	}
//
//	String result = "";
//
//	private void setEnv() {
//		runner.setEnv(new Environment() {
//			@Override
//			public void print(CharSequence out) {
//				result = out.toString();
//			}
//
//			@Override
//			public String nextLine() {
//				return null;
//			}
//		});
//	}
//
	@Test
	public void testRunCallsStart() {
		applicationMock.start();
		EasyMock.expect(applicationMock.isFinish()).andReturn(true);
		EasyMock.expect(applicationMock.hasLastScreen()).andReturn(false);
		applicationMock.stop();
		EasyMock.replay(applicationMock);
		runner.run();
		EasyMock.verify(applicationMock);
	}

}
