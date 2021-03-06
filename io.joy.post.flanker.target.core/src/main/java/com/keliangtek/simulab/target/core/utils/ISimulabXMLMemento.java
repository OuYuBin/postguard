package com.keliangtek.simulab.target.core.utils;
/**
 * Interface to a memento used for saving the important state of an object
 * in a form that can be persisted in the file system.
 * <p>
 * Mementos were designed with the following requirements in mind:
 * <ol>
 *  <li>Certain objects need to be saved and restored across platform sessions.
 *    </li>
 *  <li>When an object is restored, an appropriate class for an object might not
 *    be available. It must be possible to skip an object in this case.</li>
 *  <li>When an object is restored, the appropriate class for the object may be
 *    different from the one when the object was originally saved. If so, the
 *    new class should still be able to read the old form of the data.</li>
 * </ol>
 * </p>
 * <p>
 * Mementos meet these requirements by providing support for storing a
 * mapping of arbitrary string keys to primitive values, and by allowing
 * mementos to have other mementos as children (arranged into a tree).
 * A robust external storage format based on XML is used.
 * </p><p>
 * The key for an attribute may be any alpha numeric value.  However, the
 * value of <code>TAG_ID</code> is reserved for internal use.
 * </p><p>
 * This interface is not intended to be implemented by clients.
 * </p>
 */
public interface ISimulabXMLMemento {
	/**
	 * Creates a new child of this memento with the given type.
	 * <p>
	 * The <code>getChild</code> and <code>getChildren</code> methods
	 * are used to retrieve children of a given type.
	 * </p>
	 *
	 * @param type the type
	 * @return a new child memento
	 * @see #getChild
	 * @see #getChildren
	 */
	public ISimulabXMLMemento createChild(String type);
	
	public void removeChild(ISimulabXMLMemento simulabMemento);

	/**
	 * Returns the first child with the given type id.
	 *
	 * @param type the type id
	 * @return the first child with the given type
	 */
	public ISimulabXMLMemento getChild(String type);
	
	/**
	 * Returns all children with the given type id.
	 *
	 * @param type the type id
	 * @return the list of children with the given type
	 */
	public ISimulabXMLMemento[] getChildren(String type);

	/**
	 * Returns the string value of the given key.
	 *
	 * @param key the key
	 * @return the value, or <code>null</code> if the key was not found or was found
	 *  but was not an integer
	 */
	public String getString(String key);

	/**
	 * Sets the value of the given key to the given string.
	 *
	 * @param key the key
	 * @param value the value
	 */
	public void putString(String key, String value);
}