/**
 */
package com.gesila.test.guard.model.testGuard;

import com.jd.lcp.wuliuyun.apidoc.api;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Guard</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.gesila.test.guard.model.testGuard.TestGuard#getName <em>Name</em>}</li>
 *   <li>{@link com.gesila.test.guard.model.testGuard.TestGuard#getUrl <em>Url</em>}</li>
 *   <li>{@link com.gesila.test.guard.model.testGuard.TestGuard#getMethod <em>Method</em>}</li>
 *   <li>{@link com.gesila.test.guard.model.testGuard.TestGuard#getHeaders <em>Headers</em>}</li>
 *   <li>{@link com.gesila.test.guard.model.testGuard.TestGuard#getParams <em>Params</em>}</li>
 *   <li>{@link com.gesila.test.guard.model.testGuard.TestGuard#getRequestBody <em>Request Body</em>}</li>
 *   <li>{@link com.gesila.test.guard.model.testGuard.TestGuard#getDesc <em>Desc</em>}</li>
 *   <li>{@link com.gesila.test.guard.model.testGuard.TestGuard#getApi <em>Api</em>}</li>
 * </ul>
 *
 * @see com.gesila.test.guard.model.testGuard.TestGuardPackage#getTestGuard()
 * @model
 * @generated
 */
public interface TestGuard extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.gesila.test.guard.model.testGuard.TestGuardPackage#getTestGuard_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.gesila.test.guard.model.testGuard.TestGuard#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Url</em>' attribute.
	 * @see #setUrl(String)
	 * @see com.gesila.test.guard.model.testGuard.TestGuardPackage#getTestGuard_Url()
	 * @model
	 * @generated
	 */
	String getUrl();

	/**
	 * Sets the value of the '{@link com.gesila.test.guard.model.testGuard.TestGuard#getUrl <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Url</em>' attribute.
	 * @see #getUrl()
	 * @generated
	 */
	void setUrl(String value);

	/**
	 * Returns the value of the '<em><b>Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method</em>' attribute.
	 * @see #setMethod(String)
	 * @see com.gesila.test.guard.model.testGuard.TestGuardPackage#getTestGuard_Method()
	 * @model
	 * @generated
	 */
	String getMethod();

	/**
	 * Sets the value of the '{@link com.gesila.test.guard.model.testGuard.TestGuard#getMethod <em>Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method</em>' attribute.
	 * @see #getMethod()
	 * @generated
	 */
	void setMethod(String value);

	/**
	 * Returns the value of the '<em><b>Request Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Request Body</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Request Body</em>' containment reference.
	 * @see #setRequestBody(RequestBody)
	 * @see com.gesila.test.guard.model.testGuard.TestGuardPackage#getTestGuard_RequestBody()
	 * @model containment="true"
	 * @generated
	 */
	RequestBody getRequestBody();

	/**
	 * Sets the value of the '{@link com.gesila.test.guard.model.testGuard.TestGuard#getRequestBody <em>Request Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Request Body</em>' containment reference.
	 * @see #getRequestBody()
	 * @generated
	 */
	void setRequestBody(RequestBody value);

	/**
	 * Returns the value of the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Desc</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Desc</em>' attribute.
	 * @see #setDesc(String)
	 * @see com.gesila.test.guard.model.testGuard.TestGuardPackage#getTestGuard_Desc()
	 * @model
	 * @generated
	 */
	String getDesc();

	/**
	 * Sets the value of the '{@link com.gesila.test.guard.model.testGuard.TestGuard#getDesc <em>Desc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Desc</em>' attribute.
	 * @see #getDesc()
	 * @generated
	 */
	void setDesc(String value);

	/**
	 * Returns the value of the '<em><b>Api</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Api</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Api</em>' containment reference.
	 * @see #setApi(api)
	 * @see com.gesila.test.guard.model.testGuard.TestGuardPackage#getTestGuard_Api()
	 * @model containment="true"
	 * @generated
	 */
	api getApi();

	/**
	 * Sets the value of the '{@link com.gesila.test.guard.model.testGuard.TestGuard#getApi <em>Api</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Api</em>' containment reference.
	 * @see #getApi()
	 * @generated
	 */
	void setApi(api value);

	/**
	 * Returns the value of the '<em><b>Headers</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Headers</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Headers</em>' containment reference.
	 * @see #setHeaders(Headers)
	 * @see com.gesila.test.guard.model.testGuard.TestGuardPackage#getTestGuard_Headers()
	 * @model containment="true"
	 * @generated
	 */
	Headers getHeaders();

	/**
	 * Sets the value of the '{@link com.gesila.test.guard.model.testGuard.TestGuard#getHeaders <em>Headers</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Headers</em>' containment reference.
	 * @see #getHeaders()
	 * @generated
	 */
	void setHeaders(Headers value);

	/**
	 * Returns the value of the '<em><b>Params</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Params</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Params</em>' containment reference.
	 * @see #setParams(Params)
	 * @see com.gesila.test.guard.model.testGuard.TestGuardPackage#getTestGuard_Params()
	 * @model containment="true"
	 * @generated
	 */
	Params getParams();

	/**
	 * Sets the value of the '{@link com.gesila.test.guard.model.testGuard.TestGuard#getParams <em>Params</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Params</em>' containment reference.
	 * @see #getParams()
	 * @generated
	 */
	void setParams(Params value);

} // TestGuard
