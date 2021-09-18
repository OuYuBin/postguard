/**
 */
package com.keliangtek.simulab.target;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.keliangtek.simulab.target.TargetFactory
 * @model kind="package"
 * @generated
 */
public interface TargetPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "target";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.keliangtek.com/simulab/target";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "target";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TargetPackage eINSTANCE = com.keliangtek.simulab.target.impl.TargetPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.keliangtek.simulab.target.impl.TargetImpl <em>Target</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.keliangtek.simulab.target.impl.TargetImpl
	 * @see com.keliangtek.simulab.target.impl.TargetPackageImpl#getTarget()
	 * @generated
	 */
	int TARGET = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET__NAME = 0;

	/**
	 * The feature id for the '<em><b>IP</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET__IP = 1;

	/**
	 * The feature id for the '<em><b>Is Dev</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET__IS_DEV = 2;

	/**
	 * The feature id for the '<em><b>Domain Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET__DOMAIN_NAME = 3;

	/**
	 * The feature id for the '<em><b>Root Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET__ROOT_PATH = 4;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET__PORT = 5;

	/**
	 * The number of structural features of the '<em>Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.keliangtek.simulab.target.impl.NameImpl <em>Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.keliangtek.simulab.target.impl.NameImpl
	 * @see com.keliangtek.simulab.target.impl.TargetPackageImpl#getName_()
	 * @generated
	 */
	int NAME = 1;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME__CONTENT = 0;

	/**
	 * The number of structural features of the '<em>Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.keliangtek.simulab.target.impl.IPImpl <em>IP</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.keliangtek.simulab.target.impl.IPImpl
	 * @see com.keliangtek.simulab.target.impl.TargetPackageImpl#getIP()
	 * @generated
	 */
	int IP = 2;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP__CONTENT = 0;

	/**
	 * The number of structural features of the '<em>IP</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>IP</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.keliangtek.simulab.target.impl.RootPathImpl <em>Root Path</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.keliangtek.simulab.target.impl.RootPathImpl
	 * @see com.keliangtek.simulab.target.impl.TargetPackageImpl#getRootPath()
	 * @generated
	 */
	int ROOT_PATH = 3;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_PATH__CONTENT = 0;

	/**
	 * The number of structural features of the '<em>Root Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_PATH_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Root Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_PATH_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link com.keliangtek.simulab.target.Target <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target</em>'.
	 * @see com.keliangtek.simulab.target.Target
	 * @generated
	 */
	EClass getTarget();

	/**
	 * Returns the meta object for the containment reference '{@link com.keliangtek.simulab.target.Target#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Name</em>'.
	 * @see com.keliangtek.simulab.target.Target#getName()
	 * @see #getTarget()
	 * @generated
	 */
	EReference getTarget_Name();

	/**
	 * Returns the meta object for the containment reference '{@link com.keliangtek.simulab.target.Target#getIP <em>IP</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>IP</em>'.
	 * @see com.keliangtek.simulab.target.Target#getIP()
	 * @see #getTarget()
	 * @generated
	 */
	EReference getTarget_IP();

	/**
	 * Returns the meta object for the attribute '{@link com.keliangtek.simulab.target.Target#isIsDev <em>Is Dev</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Dev</em>'.
	 * @see com.keliangtek.simulab.target.Target#isIsDev()
	 * @see #getTarget()
	 * @generated
	 */
	EAttribute getTarget_IsDev();

	/**
	 * Returns the meta object for the attribute '{@link com.keliangtek.simulab.target.Target#getDomainName <em>Domain Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Domain Name</em>'.
	 * @see com.keliangtek.simulab.target.Target#getDomainName()
	 * @see #getTarget()
	 * @generated
	 */
	EAttribute getTarget_DomainName();

	/**
	 * Returns the meta object for the containment reference '{@link com.keliangtek.simulab.target.Target#getRootPath <em>Root Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Root Path</em>'.
	 * @see com.keliangtek.simulab.target.Target#getRootPath()
	 * @see #getTarget()
	 * @generated
	 */
	EReference getTarget_RootPath();

	/**
	 * Returns the meta object for the attribute '{@link com.keliangtek.simulab.target.Target#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port</em>'.
	 * @see com.keliangtek.simulab.target.Target#getPort()
	 * @see #getTarget()
	 * @generated
	 */
	EAttribute getTarget_Port();

	/**
	 * Returns the meta object for class '{@link com.keliangtek.simulab.target.Name <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Name</em>'.
	 * @see com.keliangtek.simulab.target.Name
	 * @generated
	 */
	EClass getName_();

	/**
	 * Returns the meta object for the attribute '{@link com.keliangtek.simulab.target.Name#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see com.keliangtek.simulab.target.Name#getContent()
	 * @see #getName_()
	 * @generated
	 */
	EAttribute getName_Content();

	/**
	 * Returns the meta object for class '{@link com.keliangtek.simulab.target.IP <em>IP</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IP</em>'.
	 * @see com.keliangtek.simulab.target.IP
	 * @generated
	 */
	EClass getIP();

	/**
	 * Returns the meta object for the attribute '{@link com.keliangtek.simulab.target.IP#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see com.keliangtek.simulab.target.IP#getContent()
	 * @see #getIP()
	 * @generated
	 */
	EAttribute getIP_Content();

	/**
	 * Returns the meta object for class '{@link com.keliangtek.simulab.target.RootPath <em>Root Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root Path</em>'.
	 * @see com.keliangtek.simulab.target.RootPath
	 * @generated
	 */
	EClass getRootPath();

	/**
	 * Returns the meta object for the attribute '{@link com.keliangtek.simulab.target.RootPath#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see com.keliangtek.simulab.target.RootPath#getContent()
	 * @see #getRootPath()
	 * @generated
	 */
	EAttribute getRootPath_Content();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TargetFactory getTargetFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.keliangtek.simulab.target.impl.TargetImpl <em>Target</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.keliangtek.simulab.target.impl.TargetImpl
		 * @see com.keliangtek.simulab.target.impl.TargetPackageImpl#getTarget()
		 * @generated
		 */
		EClass TARGET = eINSTANCE.getTarget();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET__NAME = eINSTANCE.getTarget_Name();

		/**
		 * The meta object literal for the '<em><b>IP</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET__IP = eINSTANCE.getTarget_IP();

		/**
		 * The meta object literal for the '<em><b>Is Dev</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TARGET__IS_DEV = eINSTANCE.getTarget_IsDev();

		/**
		 * The meta object literal for the '<em><b>Domain Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TARGET__DOMAIN_NAME = eINSTANCE.getTarget_DomainName();

		/**
		 * The meta object literal for the '<em><b>Root Path</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET__ROOT_PATH = eINSTANCE.getTarget_RootPath();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TARGET__PORT = eINSTANCE.getTarget_Port();

		/**
		 * The meta object literal for the '{@link com.keliangtek.simulab.target.impl.NameImpl <em>Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.keliangtek.simulab.target.impl.NameImpl
		 * @see com.keliangtek.simulab.target.impl.TargetPackageImpl#getName_()
		 * @generated
		 */
		EClass NAME = eINSTANCE.getName_();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAME__CONTENT = eINSTANCE.getName_Content();

		/**
		 * The meta object literal for the '{@link com.keliangtek.simulab.target.impl.IPImpl <em>IP</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.keliangtek.simulab.target.impl.IPImpl
		 * @see com.keliangtek.simulab.target.impl.TargetPackageImpl#getIP()
		 * @generated
		 */
		EClass IP = eINSTANCE.getIP();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IP__CONTENT = eINSTANCE.getIP_Content();

		/**
		 * The meta object literal for the '{@link com.keliangtek.simulab.target.impl.RootPathImpl <em>Root Path</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.keliangtek.simulab.target.impl.RootPathImpl
		 * @see com.keliangtek.simulab.target.impl.TargetPackageImpl#getRootPath()
		 * @generated
		 */
		EClass ROOT_PATH = eINSTANCE.getRootPath();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROOT_PATH__CONTENT = eINSTANCE.getRootPath_Content();

	}

} //TargetPackage
