package unittest.cn.com.xd.jmx;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import cn.com.xd.jmx.Calc;

import com.sun.jdmk.comm.HtmlAdaptorServer;

/**
 * @author wuliwei
 * 
 */
public class CalcHtmlTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
			ObjectName calcName = new ObjectName("CalcAgent:name=calc");
			mbs.registerMBean(new Calc(), calcName);
			
			HtmlAdaptorServer adaptor = new HtmlAdaptorServer();
			adaptor.setPort(9999);
			ObjectName adaptorName = new ObjectName("HtmlAdaptor:name=htmladaptor");
			mbs.registerMBean(adaptor, adaptorName);
			
			adaptor.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
