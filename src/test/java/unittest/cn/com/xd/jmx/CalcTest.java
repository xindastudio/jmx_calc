package unittest.cn.com.xd.jmx;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import cn.com.xd.jmx.Calc;

/**
 * @author wuliwei
 * 
 */
public class CalcTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
			ObjectName calcName = new ObjectName("CalcAgent:name=calc");
			mbs.registerMBean(new Calc(), calcName);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
