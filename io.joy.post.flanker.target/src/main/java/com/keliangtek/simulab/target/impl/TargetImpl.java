/**
 */
package com.keliangtek.simulab.target.impl;

import com.keliangtek.simulab.target.IP;
import com.keliangtek.simulab.target.Name;
import com.keliangtek.simulab.target.RootPath;
import com.keliangtek.simulab.target.Target;
import com.keliangtek.simulab.target.TargetPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Target</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.keliangtek.simulab.target.impl.TargetImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.keliangtek.simulab.target.impl.TargetImpl#getIP <em>IP</em>}</li>
 *   <li>{@link com.keliangtek.simulab.target.impl.TargetImpl#isIsDev <em>Is Dev</em>}</li>
 *   <li>{@link com.keliangtek.simulab.target.impl.TargetImpl#getDomainName <em>Domain Name</em>}</li>
 *   <li>{@link com.keliangtek.simulab.target.impl.TargetImpl#getRootPath <em>Root Path</em>}</li>
 *   <li>{@link com.keliangtek.simulab.target.impl.TargetImpl#getPort <em>Port</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TargetImpl extends MinimalEObjectImpl.Container implements Target {
	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected Name name;

	/**
	 * The cached value of the '{@link #getIP() <em>IP</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIP()
	 * @generated
	 * @ordered
	 */
	protected IP ip;

	/**
	 * The default value of the '{@link #isIsDev() <em>Is Dev</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsDev()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_DEV_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsDev() <em>Is Dev</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsDev()
	 * @generated
	 * @ordered
	 */
	protected boolean isDev = IS_DEV_EDEFAULT;

	/**
	 * The default value of the '{@link #getDomainName() <em>Domain Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainName()
	 * @generated
	 * @ordered
	 */
	protected static final String DOMAIN_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDomainName() <em>Domain Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainName()
	 * @generated
	 * @ordered
	 */
	protected String domainName = DOMAIN_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRootPath() <em>Root Path</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootPath()
	 * @generated
	 * @ordered
	 */
	protected RootPath rootPath;

	/**
	 * The default value of the '{@link #getPort() <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected static final String PORT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPort() <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected String port = PORT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TargetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TargetPackage.Literals.TARGET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Name getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetName(Name newName, NotificationChain msgs) {
		Name oldName = name;
		name = newName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TargetPackage.TARGET__NAME, oldName, newName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(Name newName) {
		if (newName != name) {
			NotificationChain msgs = null;
			if (name != null)
				msgs = ((InternalEObject)name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TargetPackage.TARGET__NAME, null, msgs);
			if (newName != null)
				msgs = ((InternalEObject)newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TargetPackage.TARGET__NAME, null, msgs);
			msgs = basicSetName(newName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPackage.TARGET__NAME, newName, newName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IP getIP() {
		return ip;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIP(IP newIP, NotificationChain msgs) {
		IP oldIP = ip;
		ip = newIP;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TargetPackage.TARGET__IP, oldIP, newIP);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIP(IP newIP) {
		if (newIP != ip) {
			NotificationChain msgs = null;
			if (ip != null)
				msgs = ((InternalEObject)ip).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TargetPackage.TARGET__IP, null, msgs);
			if (newIP != null)
				msgs = ((InternalEObject)newIP).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TargetPackage.TARGET__IP, null, msgs);
			msgs = basicSetIP(newIP, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPackage.TARGET__IP, newIP, newIP));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsDev() {
		return isDev;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsDev(boolean newIsDev) {
		boolean oldIsDev = isDev;
		isDev = newIsDev;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPackage.TARGET__IS_DEV, oldIsDev, isDev));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDomainName() {
		return domainName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDomainName(String newDomainName) {
		String oldDomainName = domainName;
		domainName = newDomainName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPackage.TARGET__DOMAIN_NAME, oldDomainName, domainName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RootPath getRootPath() {
		return rootPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRootPath(RootPath newRootPath, NotificationChain msgs) {
		RootPath oldRootPath = rootPath;
		rootPath = newRootPath;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TargetPackage.TARGET__ROOT_PATH, oldRootPath, newRootPath);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRootPath(RootPath newRootPath) {
		if (newRootPath != rootPath) {
			NotificationChain msgs = null;
			if (rootPath != null)
				msgs = ((InternalEObject)rootPath).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TargetPackage.TARGET__ROOT_PATH, null, msgs);
			if (newRootPath != null)
				msgs = ((InternalEObject)newRootPath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TargetPackage.TARGET__ROOT_PATH, null, msgs);
			msgs = basicSetRootPath(newRootPath, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPackage.TARGET__ROOT_PATH, newRootPath, newRootPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPort() {
		return port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPort(String newPort) {
		String oldPort = port;
		port = newPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPackage.TARGET__PORT, oldPort, port));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TargetPackage.TARGET__NAME:
				return basicSetName(null, msgs);
			case TargetPackage.TARGET__IP:
				return basicSetIP(null, msgs);
			case TargetPackage.TARGET__ROOT_PATH:
				return basicSetRootPath(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TargetPackage.TARGET__NAME:
				return getName();
			case TargetPackage.TARGET__IP:
				return getIP();
			case TargetPackage.TARGET__IS_DEV:
				return isIsDev();
			case TargetPackage.TARGET__DOMAIN_NAME:
				return getDomainName();
			case TargetPackage.TARGET__ROOT_PATH:
				return getRootPath();
			case TargetPackage.TARGET__PORT:
				return getPort();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TargetPackage.TARGET__NAME:
				setName((Name)newValue);
				return;
			case TargetPackage.TARGET__IP:
				setIP((IP)newValue);
				return;
			case TargetPackage.TARGET__IS_DEV:
				setIsDev((Boolean)newValue);
				return;
			case TargetPackage.TARGET__DOMAIN_NAME:
				setDomainName((String)newValue);
				return;
			case TargetPackage.TARGET__ROOT_PATH:
				setRootPath((RootPath)newValue);
				return;
			case TargetPackage.TARGET__PORT:
				setPort((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TargetPackage.TARGET__NAME:
				setName((Name)null);
				return;
			case TargetPackage.TARGET__IP:
				setIP((IP)null);
				return;
			case TargetPackage.TARGET__IS_DEV:
				setIsDev(IS_DEV_EDEFAULT);
				return;
			case TargetPackage.TARGET__DOMAIN_NAME:
				setDomainName(DOMAIN_NAME_EDEFAULT);
				return;
			case TargetPackage.TARGET__ROOT_PATH:
				setRootPath((RootPath)null);
				return;
			case TargetPackage.TARGET__PORT:
				setPort(PORT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TargetPackage.TARGET__NAME:
				return name != null;
			case TargetPackage.TARGET__IP:
				return ip != null;
			case TargetPackage.TARGET__IS_DEV:
				return isDev != IS_DEV_EDEFAULT;
			case TargetPackage.TARGET__DOMAIN_NAME:
				return DOMAIN_NAME_EDEFAULT == null ? domainName != null : !DOMAIN_NAME_EDEFAULT.equals(domainName);
			case TargetPackage.TARGET__ROOT_PATH:
				return rootPath != null;
			case TargetPackage.TARGET__PORT:
				return PORT_EDEFAULT == null ? port != null : !PORT_EDEFAULT.equals(port);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (isDev: ");
		result.append(isDev);
		result.append(", domainName: ");
		result.append(domainName);
		result.append(", port: ");
		result.append(port);
		result.append(')');
		return result.toString();
	}

} //TargetImpl
