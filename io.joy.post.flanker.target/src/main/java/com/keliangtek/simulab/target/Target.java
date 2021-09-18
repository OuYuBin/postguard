/**
 */
package com.keliangtek.simulab.target;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.keliangtek.simulab.target.Target#getName <em>Name</em>}</li>
 *   <li>{@link com.keliangtek.simulab.target.Target#getIP <em>IP</em>}</li>
 *   <li>{@link com.keliangtek.simulab.target.Target#isIsDev <em>Is Dev</em>}</li>
 *   <li>{@link com.keliangtek.simulab.target.Target#getDomainName <em>Domain Name</em>}</li>
 *   <li>{@link com.keliangtek.simulab.target.Target#getRootPath <em>Root Path</em>}</li>
 *   <li>{@link com.keliangtek.simulab.target.Target#getPort <em>Port</em>}</li>
 * </ul>
 *
 * @see com.keliangtek.simulab.target.TargetPackage#getTarget()
 * @model
 * @generated
 */
public interface Target extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' containment reference.
	 * @see #setName(Name)
	 * @see com.keliangtek.simulab.target.TargetPackage#getTarget_Name()
	 * @model containment="true"
	 * @generated
	 */
	Name getName();

	/**
	 * Sets the value of the '{@link com.keliangtek.simulab.target.Target#getName <em>Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' containment reference.
	 * @see #getName()
	 * @generated
	 */
	void setName(Name value);

	/**
	 * Returns the value of the '<em><b>IP</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>IP</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>IP</em>' containment reference.
	 * @see #setIP(IP)
	 * @see com.keliangtek.simulab.target.TargetPackage#getTarget_IP()
	 * @model containment="true"
	 * @generated
	 */
	IP getIP();

	/**
	 * Sets the value of the '{@link com.keliangtek.simulab.target.Target#getIP <em>IP</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>IP</em>' containment reference.
	 * @see #getIP()
	 * @generated
	 */
	void setIP(IP value);

	/**
	 * Returns the value of the '<em><b>Is Dev</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Dev</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Dev</em>' attribute.
	 * @see #setIsDev(boolean)
	 * @see com.keliangtek.simulab.target.TargetPackage#getTarget_IsDev()
	 * @model
	 * @generated
	 */
	boolean isIsDev();

	/**
	 * Sets the value of the '{@link com.keliangtek.simulab.target.Target#isIsDev <em>Is Dev</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Dev</em>' attribute.
	 * @see #isIsDev()
	 * @generated
	 */
	void setIsDev(boolean value);

	/**
	 * Returns the value of the '<em><b>Domain Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Name</em>' attribute.
	 * @see #setDomainName(String)
	 * @see com.keliangtek.simulab.target.TargetPackage#getTarget_DomainName()
	 * @model
	 * @generated
	 */
	String getDomainName();

	/**
	 * Sets the value of the '{@link com.keliangtek.simulab.target.Target#getDomainName <em>Domain Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Name</em>' attribute.
	 * @see #getDomainName()
	 * @generated
	 */
	void setDomainName(String value);

	/**
	 * Returns the value of the '<em><b>Root Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root Path</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root Path</em>' containment reference.
	 * @see #setRootPath(RootPath)
	 * @see com.keliangtek.simulab.target.TargetPackage#getTarget_RootPath()
	 * @model containment="true"
	 * @generated
	 */
	RootPath getRootPath();

	/**
	 * Sets the value of the '{@link com.keliangtek.simulab.target.Target#getRootPath <em>Root Path</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root Path</em>' containment reference.
	 * @see #getRootPath()
	 * @generated
	 */
	void setRootPath(RootPath value);

	/**
	 * Returns the value of the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port</em>' attribute.
	 * @see #setPort(String)
	 * @see com.keliangtek.simulab.target.TargetPackage#getTarget_Port()
	 * @model
	 * @generated
	 */
	String getPort();

	/**
	 * Sets the value of the '{@link com.keliangtek.simulab.target.Target#getPort <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port</em>' attribute.
	 * @see #getPort()
	 * @generated
	 */
	void setPort(String value);

} // Target
