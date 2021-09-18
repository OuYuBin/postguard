package io.joy.post.flanker.target.ui.views.propertyTest;

import org.eclipse.core.expressions.PropertyTester;

import com.keliangtek.simulab.target.core.models.SimulabTarget;

/**
 * 
 * @author robin
 *
 */
public class SimulabTargetModelPropertyTester extends PropertyTester {

	public SimulabTargetModelPropertyTester() {
	}

	@Override
	public boolean test(Object receiver, String property, Object[] args,
			Object expectedValue) {
		if (receiver instanceof SimulabTarget) {

			if (property.equals("isLocalHost")) {
				String name = ((SimulabTarget) receiver).getName();
				if (name.equals("localhost")) {
					return true;
				}
			}
			if (property.equals("isDevNode")) {
				return ((SimulabTarget) receiver).isDevTarget();
			}
		}
		return false;
	}
}
