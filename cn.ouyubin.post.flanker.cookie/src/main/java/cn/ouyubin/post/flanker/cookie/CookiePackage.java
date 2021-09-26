/**
 */
package cn.ouyubin.post.flanker.cookie;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * @see cn.ouyubin.post.flanker.cookie.CookieFactory
 * @model kind="package"
 * @generated
 */
public interface CookiePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "cookie";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///cn/enflame/cookie/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "enflame";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CookiePackage eINSTANCE = cn.ouyubin.post.flanker.cookie.impl.CookiePackageImpl.init();

	/**
	 * The meta object id for the '{@link cn.ouyubin.post.flanker.cookie.impl.CookieImpl <em>Cookie</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cn.ouyubin.post.flanker.cookie.impl.CookieImpl
	 * @see cn.ouyubin.post.flanker.cookie.impl.CookiePackageImpl#getCookie()
	 * @generated
	 */
	int COOKIE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COOKIE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COOKIE__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Cookie</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COOKIE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Cookie</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COOKIE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link cn.ouyubin.post.flanker.cookie.Cookie <em>Cookie</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cookie</em>'.
	 * @see cn.ouyubin.post.flanker.cookie.Cookie
	 * @generated
	 */
	EClass getCookie();

	/**
	 * Returns the meta object for the attribute '{@link cn.ouyubin.post.flanker.cookie.Cookie#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see cn.ouyubin.post.flanker.cookie.Cookie#getName()
	 * @see #getCookie()
	 * @generated
	 */
	EAttribute getCookie_Name();

	/**
	 * Returns the meta object for the attribute '{@link cn.ouyubin.post.flanker.cookie.Cookie#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see cn.ouyubin.post.flanker.cookie.Cookie#getValue()
	 * @see #getCookie()
	 * @generated
	 */
	EAttribute getCookie_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CookieFactory getCookieFactory();

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
		 * The meta object literal for the '{@link cn.ouyubin.post.flanker.cookie.impl.CookieImpl <em>Cookie</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cn.ouyubin.post.flanker.cookie.impl.CookieImpl
		 * @see cn.ouyubin.post.flanker.cookie.impl.CookiePackageImpl#getCookie()
		 * @generated
		 */
		EClass COOKIE = eINSTANCE.getCookie();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COOKIE__NAME = eINSTANCE.getCookie_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COOKIE__VALUE = eINSTANCE.getCookie_Value();

	}

} //CookiePackage
