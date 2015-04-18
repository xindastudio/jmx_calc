package cn.com.xd.jmx;

import java.awt.BorderLayout;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * @author wuliwei
 * 
 */
public class Calc extends JFrame implements CalcMBean {
	private JTextField text;
	private double calcResult;
	private AtomicBoolean flag;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public Calc() {
		this.setTitle("远程计算器");
		this.setSize(400, 50);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		text = new JTextField();
		text.setHorizontalAlignment(JTextField.RIGHT);
		this.add(text, BorderLayout.CENTER);
		this.validate();

		calcResult = 0;
		flag = new AtomicBoolean(true);
	}

	private void appendText(char c, double pValue) {
		if (!flag.get()) {
			clear();
		}
		String temp = text.getText();
		if (temp.isEmpty() && '=' == c) {
			text.setText(temp + pValue);
		} else {
			text.setText(temp + ' ' + c + ' ' + pValue);
		}
		if ('+' == c) {
			calcResult += pValue;
		} else if ('-' == c) {
			calcResult -= pValue;
		} else if ('*' == c) {
			calcResult *= pValue;
		} else if ('/' == c) {
			calcResult /= pValue;
		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.xd.jmx.CalcMBean#add(double)
	 */
	@Override
	public void add(double pValue) {
		appendText('+', pValue);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.xd.jmx.CalcMBean#calc()
	 */
	@Override
	public double calc() {
		appendText('=', calcResult);
		flag.set(false);
		return calcResult;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.xd.jmx.CalcMBean#clear()
	 */
	@Override
	public void clear() {
		text.setText("");
		calcResult = 0;
		flag.set(true);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.xd.jmx.CalcMBean#div(double)
	 */
	@Override
	public void div(double pValue) {
		appendText('/', pValue);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.xd.jmx.CalcMBean#mul(double)
	 */
	@Override
	public void mul(double pValue) {
		appendText('*', pValue);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.xd.jmx.CalcMBean#sub(double)
	 */
	@Override
	public void sub(double pValue) {
		appendText('-', pValue);
	}

}
