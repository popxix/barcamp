/**
 * 
 */
package net.popxix.barcamp.noviembre2017;

import java.io.File;
import java.util.function.Predicate;

import org.junit.Before;
import org.junit.Test;

import net.popxix.barcamp.noviembre2017.dto.RegistroAcceso;
import net.popxix.barcamp.noviembre2017.ejemplo2.AnalizadorWebLog;

/**
 * 
 * @author pjgonzalez
 *
 */

public class AnalizadorWebLogThreadTest {

	private File logFile;
	
	
	@Before
	public void setUp() {
		
		logFile = new File(getClass().getClassLoader().getResource("access.log").getFile());
	}
	
	@Test
	public void runTest() {
		
		AnalizadorWebLogThread analizadorWebLogThread = new AnalizadorWebLogThread(logFile,  new Predicate<RegistroAcceso>() {

			@Override
			public boolean test(RegistroAcceso t) {
				return	t.getIp().equals("192.168.234.82");
			}
			
		});
		analizadorWebLogThread.run();
	}	
	
	@Test
	public void ejemplo2() {
		final AnalizadorWebLog analizadorWebLog = new AnalizadorWebLog();
		Runnable dbTask = ()->{
			analizadorWebLog.insertaLogDB();
		};
		
	new Thread(dbTask).start();
	
		Runnable analizaTask = ()->{
			analizadorWebLog.analizaLog(logFile);
		};
		
		new Thread(analizaTask).run();
	}
	
	public void ejemplo3() {
		//Executor ex = Executors.
	}
}
