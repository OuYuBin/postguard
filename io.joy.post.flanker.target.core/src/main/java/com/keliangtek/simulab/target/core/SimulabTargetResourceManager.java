package com.keliangtek.simulab.target.core;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IResource;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.XMLMemento;
import org.eclipse.ui.ide.FileStoreEditorInput;

import com.keliangtek.simulab.target.core.listeners.ISimulabTargetLifeCycleListener;
import com.keliangtek.simulab.target.core.models.ISimulabTarget;
import com.keliangtek.simulab.target.core.models.SimulabTarget;
import com.keliangtek.simulab.target.core.models.SimulabTargetTopology;
import com.keliangtek.simulab.target.core.utils.ISimulabXMLMemento;
import com.keliangtek.simulab.target.core.utils.SimulabXMLMemento;

/**
 * 
 * @author robin
 *
 */
public class SimulabTargetResourceManager {

	private static SimulabTargetResourceManager instance = new SimulabTargetResourceManager();

	private List<ISimulabTargetLifeCycleListener> listeners = new ArrayList<ISimulabTargetLifeCycleListener>();

	private SimulabTargetTopology simulabTargetTopology;

	private static final byte TARGET_ADD = 0;
	private static final byte TARGET_REMOVE = 1;
	private static final byte TARGET_ACTIVE_DEV_NODE = 2;
	private static final byte TARGET_CHANGE = 3;

	private SimulabTargetResourceManager() {
		simulabTargetTopology = new SimulabTargetTopology();
		if (!getTargets().isEmpty()) {
			simulabTargetTopology.setSimulabTargets(getTargets());
		}
	}

	public static SimulabTargetResourceManager getInstance() {
		return instance;
	}

	public void addListener(
			ISimulabTargetLifeCycleListener targetLifecycleListener) {
		listeners.add(targetLifecycleListener);
	}

	public void removeListener(
			ISimulabTargetLifeCycleListener targetLifecycleListener) {
		if (listeners.contains(targetLifecycleListener))
			listeners.remove(targetLifecycleListener);
	}

	public SimulabTargetTopology getSimulabTargetTopology() {
		return simulabTargetTopology;
	}

	public List<ISimulabTarget> getTargets() {
		List<ISimulabTarget> targets = loadTargets();
		return targets;
	}

	public ISimulabTarget getSimulabTargetOfDev() {
		List<ISimulabTarget> loadTargets = loadTargets();
		Object[] objects = loadTargets.stream()
				.filter(target -> target.isDevTarget()).toArray();
		if (objects.length > 0) {
			return (ISimulabTarget) objects[0];
		}
		return null;
	}

	private List<ISimulabTarget> loadTargets() {
		List<ISimulabTarget> targets = new ArrayList<ISimulabTarget>();
		FileReader fileReader = null;
		try {
			String fileName = Activator.getDefault().getStateLocation()
					.append("targets.xml").toOSString();
			File file = new File(fileName);
			if (file.exists()) {
				fileReader = new FileReader(fileName);
				IMemento memento = XMLMemento.createReadRoot(fileReader);
				IMemento[] mementos = memento.getChildren("Target");
				for (IMemento target : mementos) {
					SimulabTarget simulabTarget = new SimulabTarget();
					simulabTarget.setName(target.getString("name"));
					simulabTarget.setHost(target.getString("host"));
					simulabTarget.setDevTarget(Boolean.valueOf(target
							.getString("isDev")));
					targets.add(simulabTarget);
				}
				fileReader.close();
				return targets;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fileReader != null)
				try {
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

		return Collections.emptyList();
	}

	public void addTarget(ISimulabTarget simulabTarget) {
		try {
			String fileName = Activator.getDefault().getStateLocation()
					.append("targets.xml").toOSString();
			File file = new File(fileName);
			if (!file.exists()) {
				if (file.createNewFile()) {
					SimulabXMLMemento xmlMemento = SimulabXMLMemento
							.createWriteRoot("Targets");
					xmlMemento.saveToFile(fileName);
				}
			}
			if (file.exists()) {
				ISimulabXMLMemento xmlMemento = SimulabXMLMemento
						.loadMemento(fileName);
				ISimulabXMLMemento targetMemento = xmlMemento
						.createChild("Target");
				targetMemento.putString("name", simulabTarget.getName());
				targetMemento.putString("host", simulabTarget.getHost());
				targetMemento.putString("isDev",
						String.valueOf(simulabTarget.isDevTarget()));
				((SimulabXMLMemento) xmlMemento).saveToFile(fileName);
				fireTargetChangeEvent(simulabTarget, TARGET_ADD);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void activeDevNodeOfTarget(ISimulabTarget simulabTarget) {
		try {
			String fileName = Activator.getDefault().getStateLocation()
					.append("targets.xml").toOSString();
			File file = new File(fileName);
			if (file.exists()) {
				ISimulabXMLMemento xmlMemento = SimulabXMLMemento
						.loadMemento(fileName);
				ISimulabXMLMemento[] mementos = xmlMemento
						.getChildren("Target");
				for (ISimulabXMLMemento memento : mementos) {
					String name = memento.getString("name");
					if (name.equals(simulabTarget.getName())) {
						memento.putString("isDev", "true");
					} else {
						memento.putString("isDev", "false");
					}
				}
				((SimulabXMLMemento) xmlMemento).saveToFile(fileName);
				fireTargetChangeEvent(simulabTarget, TARGET_ACTIVE_DEV_NODE);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setHost(String targetName,String address) {
		try {
			String fileName = Activator.getDefault().getStateLocation()
					.append("targets.xml").toOSString();
			File file = new File(fileName);
			if (file.exists()) {
				ISimulabXMLMemento xmlMemento = SimulabXMLMemento
						.loadMemento(fileName);
				ISimulabXMLMemento[] mementos = xmlMemento
						.getChildren("Target");
				for (ISimulabXMLMemento memento : mementos) {
					String name = memento.getString("name");
					((SimulabXMLMemento) xmlMemento).saveToFile(fileName);
					if (name.equals(targetName)) {
						memento.putString("host", address);
						List<ISimulabTarget> targets=getSimulabTargetTopology().getSimulabTargets();
						for(ISimulabTarget target:targets) {
							if(StringUtils.equals(target.getName(),targetName)){
								target.setHost(address);
								break;
							}
						}
					}
					
				}
				
				fireTargetChangeEvent(null, TARGET_CHANGE);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	public void removeTarget(ISimulabTarget simulabTarget) {
		try {
			String fileName = Activator.getDefault().getStateLocation()
					.append("targets.xml").toOSString();
			File file = new File(fileName);
			if (file.exists()) {
				ISimulabXMLMemento xmlMemento = SimulabXMLMemento
						.loadMemento(fileName);
				ISimulabXMLMemento[] mementos = xmlMemento
						.getChildren("Target");
				for (ISimulabXMLMemento memento : mementos) {
					String name = memento.getString("name");
					if (name.equals(simulabTarget.getName())) {
						xmlMemento.removeChild(memento);
						break;
					}
				}
				((SimulabXMLMemento) xmlMemento).saveToFile(fileName);
				fireTargetChangeEvent(simulabTarget, TARGET_REMOVE);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void chageTargetStatus(ISimulabTarget simulabTarget) {
		fireTargetChangeEvent(simulabTarget, TARGET_CHANGE);
	}

	public void openTarget(ISimulabTarget simulabTarget) {
		IResource resource = (IResource) simulabTarget
				.getAdapter(IResource.class);
		File file = resource.getLocation().toFile();
		if (file.exists()) {
			IFileStore fileStore = EFS.getLocalFileSystem().getStore(
					resource.getLocationURI());
			IEditorInput input = new FileStoreEditorInput(fileStore);
			try {
				IEditorPart editorPart = PlatformUI
						.getWorkbench()
						.getActiveWorkbenchWindow()
						.getActivePage()
						.openEditor(input,
								"com.keliangtek.simulab.target.editor.TargetEditorID");
			} catch (PartInitException e) {
				e.printStackTrace();
			}
		}
	}

	public void closeTarget(ISimulabTarget simulabTarget) {
		IResource resource = (IResource) simulabTarget
				.getAdapter(IResource.class);
		File targetFile = resource.getLocation().toFile();
		IWorkbenchPage workbenchPage = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();
		IEditorReference[] editorReferences = workbenchPage
				.getEditorReferences();
		for (IEditorReference editorReference : editorReferences) {
			try {
				IEditorInput editorInput = editorReference.getEditorInput();
				if (editorInput instanceof FileStoreEditorInput) {
					java.net.URI uri = ((FileStoreEditorInput) editorInput)
							.getURI();
					File file = new File(uri.toURL().getPath());
					if (targetFile.getAbsolutePath().equals(
							file.getAbsolutePath())) {
						IEditorPart editorPart = editorReference
								.getEditor(true);
						workbenchPage.closeEditor(editorPart, true);
						return;
					}
				}
			} catch (PartInitException e) {
				e.printStackTrace();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
	}

	private void fireTargetChangeEvent(ISimulabTarget simulabTarget,
			byte eventType) {
		for (ISimulabTargetLifeCycleListener listener : listeners) {
			if (eventType == TARGET_ADD)
				listener.fireTargetAdd(simulabTarget);
			else if (eventType == TARGET_REMOVE)
				listener.fireTargetRemove(simulabTarget);
			else if (eventType == TARGET_ACTIVE_DEV_NODE)
				listener.fireTargetActiveDevNode(simulabTarget);
			else if (eventType == TARGET_CHANGE)
				listener.fireTargetChange(simulabTarget);
		}
	}
}
