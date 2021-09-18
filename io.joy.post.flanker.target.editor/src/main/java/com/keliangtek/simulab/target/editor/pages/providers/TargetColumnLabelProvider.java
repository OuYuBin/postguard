package com.keliangtek.simulab.target.editor.pages.providers;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.graphics.Image;

import com.keliangtek.simulab.target.core.models.SimulabTargetIOCard;

/**
 * 
 * @author robin
 *
 */
public class TargetColumnLabelProvider extends ColumnLabelProvider {

	TableViewer tableViewer;

	String featureName;


	public TargetColumnLabelProvider(String featureName) {
		this.featureName = featureName;
	}

	public TargetColumnLabelProvider(TableViewer tableViewer, String featureName) {
		this.tableViewer=tableViewer;
		this.featureName = featureName;
	}

	@Override
	public String getText(Object element) {
		if (element instanceof SimulabTargetIOCard) {
			if (featureName.equals("deviceName")) {
				return ((SimulabTargetIOCard) element).getDevice();
			} else if (featureName.equals("vendorID")) {
				return ((SimulabTargetIOCard) element).getVendorID();
			} else if (featureName.equals("deviceID")) {
				return ((SimulabTargetIOCard) element).getDeviceID();
			} else if (featureName.equals("number")) {
				return ((SimulabTargetIOCard) element).getCardNum() + "";
			} else if (featureName.equals("vendorName")) {
				return ((SimulabTargetIOCard) element).getVendor();
			} else if (featureName.equals("No")) {
				return ((SimulabTargetIOCard) element).getId()+"";
			} else if(featureName.equals("desc")){
				return ((SimulabTargetIOCard) element).getDesc()+"";
			}
			return super.getText(element);
		}
		return super.getText(element);
	}

	@Override
	public Image getImage(Object element) {
		// if (element instanceof SubModel) {
		// if (featureName.equals("name")) {
		// return
		// SimulinkEditorPlugin.getPlugin().getImageRegistry().get("SubModel");
		// }
		// }
		return super.getImage(element);
	}
}
