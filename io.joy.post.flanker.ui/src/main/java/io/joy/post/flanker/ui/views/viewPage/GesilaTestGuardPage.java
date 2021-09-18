package io.joy.post.flanker.ui.views.viewPage;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.source.CompositeRuler;
import org.eclipse.jface.text.source.LineNumberRulerColumn;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.part.Page;

import io.joy.post.flanker.ui.views.property.GesilaTestGuardProperty;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuardPage extends Page implements IGesilaTestGuardPage {

	private Composite composite;

	// private Text text;

	// private StyledText styledText;

	private ProjectionViewer sourceViewer;

	private IWorkbenchPart part;

	@Override
	public void createControl(Composite parent) {
		// composite = new Composite(parent, SWT.NONE);
		// GridLayout gridLayout = new GridLayout();
		// gridLayout.marginHeight = 0;
		// gridLayout.marginWidth = 0;
		// composite.setLayout(gridLayout);
		composite = new Composite(parent, SWT.NONE);
		FillLayout fillLayout = new FillLayout();
		// fillLayout.marginWidth=15;
		composite.setLayout(fillLayout);
		FormToolkit formToolkit = new FormToolkit(Display.getCurrent());
		Form form = formToolkit.createForm(composite);
		form.setText("属性");
		IToolBarManager toolBarManager = form.getToolBarManager();
		// toolBarManager.add
		formToolkit.decorateFormHeading(form);

		form.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		Composite body = form.getBody();
		// body.setBackground(new Color(Display.getDefault(), 185, 214, 238));
		fillLayout = new FillLayout();
		fillLayout.marginWidth = 15;
		body.setLayout(fillLayout);

		Document document = new Document();
		CompositeRuler ruler = new CompositeRuler();

		LineNumberRulerColumn lineCol = new LineNumberRulerColumn();
		lineCol.setBackground(new Color(Display.getCurrent(), 147, 224, 255));
		ruler.addDecorator(0, lineCol);

		sourceViewer = new ProjectionViewer(body, ruler, null, false, SWT.BORDER | SWT.H_SCROLL);
		sourceViewer.setDocument(document);
		StyledText styledText = sourceViewer.getTextWidget();

		// 设置自动换行
		styledText.setWordWrap(true);
		styledText.setFont(JFaceResources.getTextFont());

		// text = new Text(composite, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
		// text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		// sourceViewer.getTextWidget().setLayoutData(new GridData(SWT.FILL,
		// SWT.FILL, true, true));
	}

	@Override
	public Control getControl() {
		return composite;
	}

	@Override
	public void setFocus() {

	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		System.out.println(selection);
		this.part = part;
		if (part != null) {
			refresh();
		}
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		System.out.println(part);
		if (part != null)
			if (part instanceof IAdaptable) {
				GesilaTestGuardProperty gesilaTestGuardProperty = ((IAdaptable) part)
						.getAdapter(GesilaTestGuardProperty.class);
				if (gesilaTestGuardProperty != null) {
					sourceViewer.getDocument().set(gesilaTestGuardProperty.getProperties());
					sourceViewer.refresh();
				}
				// sourceViewer.getTextWidget().setText(gesilaTestGuardProperty.getProperties());
				// text.setText(gesilaTestGuardProperty.getProperties());
			}
	}

}
