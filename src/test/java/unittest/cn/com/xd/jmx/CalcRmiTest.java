package unittest.cn.com.xd.jmx;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;

import cn.com.xd.jmx.Calc;

/**
 * @author wuliwei
 * 
 */
public class CalcRmiTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//start this app, need to run cmd "rmiregistry 9999" first!
		try {
			MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
			ObjectName calcName = new ObjectName("CalcAgent:name=calc");
			mbs.registerMBean(new Calc(), calcName);

			JMXServiceURL url = new JMXServiceURL(
					"service:jmx:rmi:///jndi/rmi://192.168.8.73:9999/server");
			JMXConnectorServer cs = JMXConnectorServerFactory
					.newJMXConnectorServer(url, null, mbs);
			cs.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
