package io.joy.post.flanker.target.ui.dialogs;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.keliangtek.simulab.target.core.SimulabTargetCore;
import com.keliangtek.simulab.target.core.models.ISimulabTarget;

import io.joy.post.flanker.target.ui.Activator;

/**
 * 
 * @author robin
 *
 */
public class SimulabNewTargetDialog extends TitleAreaDialog implements
		ModifyListener {

	private List<ISimulabTarget> targets;

	protected Point getInitialSize() {
		Point p = super.getInitialSize();
		p.y = 270;
		return p;
	}

	private Text targetNameText;
	private Text targetHostText;
	private Button isDevTargetButton;

	private String name;
	private String host;
	private boolean isDevTarget;

	protected void buttonPressed(int buttonId) {
		if (buttonId == IDialogConstants.OK_ID) {
			name = targetNameText.getText();
			host = targetHostText.getText();
			isDevTarget = isDevTargetButton.getSelection();
		}
		super.buttonPressed(buttonId);
	}

	public SimulabNewTargetDialog(Shell parentShell) {
		super(parentShell);
		targets = SimulabTargetCore.loadSimulabTargets();
	}

	protected int getShellStyle() {
		return super.getShellStyle();
	}

	public Control createDialogArea(Composite parent) {
		setTitle("设置目标环境属性");
		setMessage("设置一个有效的的目标环境配置.",
				IMessageProvider.NONE);
		Activator.getDefault();
		setTitleImage(Activator.getImageDescriptor("icons/new_server_wiz.png")
				.createImage());
		Composite topCom = new Composite(parent, SWT.NONE);
		GridLayout gl = new GridLayout();
		gl.numColumns = 2;
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		topCom.setLayout(gl);
		topCom.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		new Label(topCom, SWT.NONE).setText("目标环境名称:");
		targetNameText = new Text(topCom, SWT.BORDER);
		targetNameText.addModifyListener(this);
		targetNameText.setLayoutData(data);
		new Label(topCom, SWT.NONE).setText("目标环境IP地址:");
		targetHostText = new Text(topCom, SWT.BORDER);
		targetHostText.setLayoutData(data);
		targetHostText.addModifyListener(this);

		new Label(topCom, SWT.NONE).setText("是否是测试/开发目标节点?:");
		isDevTargetButton = new Button(topCom, SWT.CHECK);
		isDevTargetButton.setLayoutData(data);
		return topCom;
	}

	public Text getTargetNameText() {
		return targetNameText;
	}

	public void setTargetNameText(Text targetNameText) {
		this.targetNameText = targetNameText;
	}

	public Text getTargetHostText() {
		return targetHostText;
	}

	public void setTargetHostText(Text targetHostText) {
		this.targetHostText = targetHostText;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Button getIsDevTargetButton() {
		return isDevTargetButton;
	}

	public void setIsDevTargetButton(Button isDevTargetButton) {
		this.isDevTargetButton = isDevTargetButton;
	}

	public boolean isDevTarget() {
		return isDevTarget;
	}

	public void setDevTarget(boolean isDevTarget) {
		this.isDevTarget = isDevTarget;
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		super.createButtonsForButtonBar(parent);
		getButton(IDialogConstants.OK_ID).setEnabled(false);
	}

	@Override
	public void modifyText(ModifyEvent event) {
		if (targetNameText.getText().trim().equals("")) {
			setErrorMessage("目标环境不能为空.");
			getButton(IDialogConstants.OK_ID).setEnabled(false);
			return;
		} else {
//			String reg = "^[_0-9a-zA-Z]\\w*$";
//			Pattern pattern = Pattern.compile(reg);
//			Matcher matcher = pattern.matcher(targetNameText.getText());
//			if (!matcher.matches()) {
//				setErrorMessage("\""
//						+ targetNameText.getText()
//						+ "\" 不是一个有效的名称. 需要匹配表达式 \"^[_0-9a-zA-Z]\\w*$\"");
//				return;
//			}
			long count = targets
					.stream()
					.filter(target -> target.getName().equalsIgnoreCase(
							targetNameText.getText().trim())).count();
			if (count > 0) {
				setErrorMessage("目标环境已存在.");
				getButton(IDialogConstants.OK_ID).setEnabled(false);
				return;
			}

		}
		if (targetHostText.getText().trim().equals("")) {
			setErrorMessage("目标环境IP地址不能为空.");
			getButton(IDialogConstants.OK_ID).setEnabled(false);
			return;
		} else {
			Pattern pattern = Pattern
					.compile("^((25[0-5]|2[0-4]\\d|[1]{1}\\d{1}\\d{1}|[1-9]{1}\\d{1}|\\d{1})($|(?!\\.$)\\.)){4}$");
			if (!pattern.matcher(targetHostText.getText()).matches()) {
				setErrorMessage("IP地址格式有误.");
				getButton(IDialogConstants.OK_ID).setEnabled(false);
				return;
			} else {
				long count = targets
						.stream()
						.filter(target -> target.getHost().equalsIgnoreCase(
								targetHostText.getText().trim())).count();
				if (count > 0) {
					setErrorMessage("目标环境IP地址已存在.");
					getButton(IDialogConstants.OK_ID).setEnabled(false);
					return;
				}
			}
		}
		setErrorMessage(null);
		getButton(IDialogConstants.OK_ID).setEnabled(true);
	}

}
