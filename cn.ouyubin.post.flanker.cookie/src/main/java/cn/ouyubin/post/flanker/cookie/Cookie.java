/**
 */
package cn.ouyubin.post.flanker.cookie;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cookie</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link cn.ouyubin.post.flanker.cookie.Cookie#getName <em>Name</em>}</li>
 *   <li>{@link cn.ouyubin.post.flanker.cookie.Cookie#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see cn.ouyubin.post.flanker.cookie.CookiePackage#getCookie()
 * @model
 * @generated
 */
public interface Cookie extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see cn.ouyubin.post.flanker.cookie.CookiePackage#getCookie_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link cn.ouyubin.post.flanker.cookie.Cookie#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see cn.ouyubin.post.flanker.cookie.CookiePackage#getCookie_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link cn.ouyubin.post.flanker.cookie.Cookie#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // Cookie
