package cn.com.xd.jmx;

/**
 * @author wuliwei
 *
 */
public interface CalcMBean {
	/**
	 * @param value
	 */
	public void add(double value);
	/**
	 * @param value
	 */
	public void sub(double value);
	/**
	 * @param value
	 */
	public void mul(double value);
	/**
	 * @param value
	 */
	public void div(double value);
	/**
	 * @return double
	 */
	public double calc();
	/**
	 * 
	 */
	public void clear();
}
