/**
 */
package com.gesila.test.guard.model.testGuard;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Entity Header Fields</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.gesila.test.guard.model.testGuard.TestGuardPackage#getEntityHeaderFields()
 * @model
 * @generated
 */
public enum EntityHeaderFields implements Enumerator {
	/**
	 * The '<em><b>Allow</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ALLOW_VALUE
	 * @generated
	 * @ordered
	 */
	ALLOW(0, "Allow", "Allow"),

	/**
	 * The '<em><b>Content Encoding</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTENT_ENCODING_VALUE
	 * @generated
	 * @ordered
	 */
	CONTENT_ENCODING(1, "ContentEncoding", "Content-Encoding"),

	/**
	 * The '<em><b>Content Language</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTENT_LANGUAGE_VALUE
	 * @generated
	 * @ordered
	 */
	CONTENT_LANGUAGE(2, "ContentLanguage", "Content-Language"),

	/**
	 * The '<em><b>Content Length</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTENT_LENGTH_VALUE
	 * @generated
	 * @ordered
	 */
	CONTENT_LENGTH(3, "ContentLength", "Content-Length"),

	/**
	 * The '<em><b>Content Location</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTENT_LOCATION_VALUE
	 * @generated
	 * @ordered
	 */
	CONTENT_LOCATION(4, "ContentLocation", "Content-Location"),

	/**
	 * The '<em><b>Content MD5</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTENT_MD5_VALUE
	 * @generated
	 * @ordered
	 */
	CONTENT_MD5(5, "ContentMD5", "Content-MD5"),

	/**
	 * The '<em><b>Content Range</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTENT_RANGE_VALUE
	 * @generated
	 * @ordered
	 */
	CONTENT_RANGE(6, "ContentRange", "Content-Range"),

	/**
	 * The '<em><b>Content Type</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTENT_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	CONTENT_TYPE(7, "ContentType", "Content-Type"),

	/**
	 * The '<em><b>Expires</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXPIRES_VALUE
	 * @generated
	 * @ordered
	 */
	EXPIRES(8, "Expires", "Expires"),

	/**
	 * The '<em><b>Last Modified</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LAST_MODIFIED_VALUE
	 * @generated
	 * @ordered
	 */
	LAST_MODIFIED(9, "LastModified", "Last-Modified"), /**
	 * The '<em><b>Accept</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACCEPT_VALUE
	 * @generated
	 * @ordered
	 */
	ACCEPT(10, "Accept", "Accept");

	/**
	 * The '<em><b>Allow</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Allow</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ALLOW
	 * @model name="Allow"
	 *        annotation="ExtendedMetaData desc='\u53ef\u4ee5\u5bf9\u6b64\u5b9e\u4f53\u6267\u884c\u7684\u8bf7\u6c42\u65b9\u6cd5'"
	 * @generated
	 * @ordered
	 */
	public static final int ALLOW_VALUE = 0;

	/**
	 * The '<em><b>Content Encoding</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Content Encoding</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONTENT_ENCODING
	 * @model name="ContentEncoding" literal="Content-Encoding"
	 *        annotation="ExtendedMetaData desc='\u5bf9\u4e3b\u9898\u6267\u884c\u7684\u4efb\u610f\u7f16\u7801\u65b9\u5f0f'"
	 * @generated
	 * @ordered
	 */
	public static final int CONTENT_ENCODING_VALUE = 1;

	/**
	 * The '<em><b>Content Language</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Content Language</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONTENT_LANGUAGE
	 * @model name="ContentLanguage" literal="Content-Language"
	 *        annotation="ExtendedMetaData desc='\u7406\u89e3\u4e3b\u4f53\u65f6\u6700\u9002\u5b9c\u4f7f\u7528\u7684\u81ea\u7136\u8bed\u8a00'"
	 * @generated
	 * @ordered
	 */
	public static final int CONTENT_LANGUAGE_VALUE = 2;

	/**
	 * The '<em><b>Content Length</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Content Length</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONTENT_LENGTH
	 * @model name="ContentLength" literal="Content-Length"
	 *        annotation="ExtendedMetaData desc='\u4e3b\u4f53\u7684\u957f\u5ea6\u548c\u5c3a\u5bf8'"
	 * @generated
	 * @ordered
	 */
	public static final int CONTENT_LENGTH_VALUE = 3;

	/**
	 * The '<em><b>Content Location</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Content Location</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONTENT_LOCATION
	 * @model name="ContentLocation" literal="Content-Location"
	 *        annotation="ExtendedMetaData desc='\u8d44\u6e90\u5b9e\u9645\u6240\u5904\u7684\u4f4d\u7f6e'"
	 * @generated
	 * @ordered
	 */
	public static final int CONTENT_LOCATION_VALUE = 4;

	/**
	 * The '<em><b>Content MD5</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Content MD5</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONTENT_MD5
	 * @model name="ContentMD5" literal="Content-MD5"
	 *        annotation="ExtendedMetaData desc='\u4e3b\u4f53\u7684MD5\u6821\u9a8c\u548c'"
	 * @generated
	 * @ordered
	 */
	public static final int CONTENT_MD5_VALUE = 5;

	/**
	 * The '<em><b>Content Range</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Content Range</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONTENT_RANGE
	 * @model name="ContentRange" literal="Content-Range"
	 *        annotation="ExtendedMetaData desc='\u5728\u6574\u4e2a\u8d44\u6e90\u4e2d\u6b64\u5b9e\u4f53\u8868\u7684\u5b57\u8282\u8303\u56f4'"
	 * @generated
	 * @ordered
	 */
	public static final int CONTENT_RANGE_VALUE = 6;

	/**
	 * The '<em><b>Content Type</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Content Type</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONTENT_TYPE
	 * @model name="ContentType" literal="Content-Type"
	 *        annotation="ExtendedMetaData desc='\u5b9e\u9645\u4e3b\u4f53\u5185\u5bf9\u8c61\u7684\u5a92\u4f53\u7c7b\u578b' content='application/json|application/xml|application/x-www-form-urlencoded'"
	 * @generated
	 * @ordered
	 */
	public static final int CONTENT_TYPE_VALUE = 7;

	/**
	 * The '<em><b>Expires</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Expires</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXPIRES
	 * @model name="Expires"
	 *        annotation="ExtendedMetaData desc='\u5b9e\u4f53\u4e0d\u518d\u6709\u6548\uff0c\u8981\u4ece\u539f\u59cb\u7684\u6e90\u7aef\u518d\u6b21\u83b7\u53d6\u5b9e\u4f53\u7684\u65e5\u671f\u548c\u65f6\u95f4'"
	 * @generated
	 * @ordered
	 */
	public static final int EXPIRES_VALUE = 8;

	/**
	 * The '<em><b>Last Modified</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Last Modified</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LAST_MODIFIED
	 * @model name="LastModified" literal="Last-Modified"
	 *        annotation="ExtendedMetaData desc='\u5b9e\u4f53\u6700\u540e\u4e00\u6b21\u88ab\u4fee\u6539\u7684\u65e5\u671f\u548c\u65f6\u95f4'"
	 * @generated
	 * @ordered
	 */
	public static final int LAST_MODIFIED_VALUE = 9;

	/**
	 * The '<em><b>Accept</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Accept</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACCEPT
	 * @model name="Accept"
	 *        annotation="ExtendedMetaData desc='\u6307\u5b9a\u5ba2\u6237\u7aef\u80fd\u591f\u63a5\u6536\u7684\u5185\u5bb9\u7c7b\u578b' content='application/json|text/plain'"
	 * @generated
	 * @ordered
	 */
	public static final int ACCEPT_VALUE = 10;

	/**
	 * An array of all the '<em><b>Entity Header Fields</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EntityHeaderFields[] VALUES_ARRAY =
		new EntityHeaderFields[] {
			ALLOW,
			CONTENT_ENCODING,
			CONTENT_LANGUAGE,
			CONTENT_LENGTH,
			CONTENT_LOCATION,
			CONTENT_MD5,
			CONTENT_RANGE,
			CONTENT_TYPE,
			EXPIRES,
			LAST_MODIFIED,
			ACCEPT,
		};

	/**
	 * A public read-only list of all the '<em><b>Entity Header Fields</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EntityHeaderFields> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Entity Header Fields</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EntityHeaderFields get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EntityHeaderFields result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Entity Header Fields</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EntityHeaderFields getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EntityHeaderFields result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Entity Header Fields</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EntityHeaderFields get(int value) {
		switch (value) {
			case ALLOW_VALUE: return ALLOW;
			case CONTENT_ENCODING_VALUE: return CONTENT_ENCODING;
			case CONTENT_LANGUAGE_VALUE: return CONTENT_LANGUAGE;
			case CONTENT_LENGTH_VALUE: return CONTENT_LENGTH;
			case CONTENT_LOCATION_VALUE: return CONTENT_LOCATION;
			case CONTENT_MD5_VALUE: return CONTENT_MD5;
			case CONTENT_RANGE_VALUE: return CONTENT_RANGE;
			case CONTENT_TYPE_VALUE: return CONTENT_TYPE;
			case EXPIRES_VALUE: return EXPIRES;
			case LAST_MODIFIED_VALUE: return LAST_MODIFIED;
			case ACCEPT_VALUE: return ACCEPT;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EntityHeaderFields(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //EntityHeaderFields
