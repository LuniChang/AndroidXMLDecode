package com.xu.main.xml;

import java.util.concurrent.ExecutionException;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

public class XmlDecodeWorker extends SwingWorker<String, Object> {

	private JButton okButton;
	private JTextArea resultJTextArea;
	private String formatString;

	public XmlDecodeWorker(JButton okButton, JTextArea resultJTextArea, String formatString) {
		super();
		this.okButton = okButton;
		okButton.setText("decode");
		this.resultJTextArea = resultJTextArea;
		this.formatString = formatString;
	}

	@Override
	protected String doInBackground() throws Exception {
		// TODO Auto-generated method stub
		String result = Util.getIDParamInXMLByDOM4(formatString);
		return result;
	}

	@Override
	protected void done() {
		// TODO Auto-generated method stub
		okButton.setText("commit");
		try {
			String back = get();
			if (back == null) {
				resultJTextArea.setText("fail");
				return;
			}

			resultJTextArea.setText(get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.done();
	}

}
