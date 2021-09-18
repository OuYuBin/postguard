package io.joy.post.flanker.target.ui.views.providers;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;

import com.keliangtek.simulab.target.core.models.ISimulabTarget;
import com.keliangtek.simulab.target.core.models.SimulabTargetTopology;

import io.joy.post.flanker.target.ui.Activator;
import io.joy.post.flanker.target.ui.views.decorator.SimulabTargetLabelDecorator;

/**
 * 
 * @author robin
 *
 */
public class SimulabTargetTreeLabelProvider extends LabelProvider implements
		IStyledLabelProvider {

	SimulabTargetLabelDecorator simulabTargetLabelDecorator;

	StyledString.Styler commentStyler;

	public SimulabTargetTreeLabelProvider() {
		super();
		commentStyler = StyledString.DECORATIONS_STYLER;
		simulabTargetLabelDecorator = new SimulabTargetLabelDecorator();
	}

	@Override
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof SimulabTargetTopology) {
			return Activator.getDefault().getImageRegistry()
					.get("SimulabTargetTopology");
		}
		Image image = Activator.getDefault().getImageRegistry()
				.get("SimulabTargetServer");
		return simulabTargetLabelDecorator.decorateImage(image, element);

	}

	@Override
	public String getText(Object element) {
		if (element instanceof SimulabTargetTopology) {
			return "目标环境";
		}
		if (element instanceof ISimulabTarget) {
			return ((ISimulabTarget) element).getHost();
		}
		return "";
	}

	@Override
	public StyledString getStyledText(Object element) {
		StyledString styledString = new StyledString(getText(element));
		if (element instanceof ISimulabTarget) {
			String name = ((ISimulabTarget) element).getName();
			return styledString.append(" - " + name, commentStyler);
		}
		return styledString;
	}

}
