package com.gesila.test.guard.json.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author robin
 *
 */
public class PostFlankerJSONObject {

	List<PostFlankerJSONObject> postFlankerJSONObjects = new ArrayList<PostFlankerJSONObject>();

	public String name;

	public String value;
	
	public String desc;
	
	public Type type;

	

	public void addResponseObject(PostFlankerJSONObject postFlankerJSONObject) {
		postFlankerJSONObjects.add(postFlankerJSONObject);
	}
	
	public PostFlankerJSONObject(){

	}

	/**
	 * 序号
	 * @param id
	 */
	public PostFlankerJSONObject(String id){
		this.name=id;
	}
	
	public List<PostFlankerJSONObject> getPostFlankerJSONObjects() {
		return postFlankerJSONObjects;
	}

	public void setPostFlankerJSONObjects(List<PostFlankerJSONObject> postFlankerJSONObjects) {
		this.postFlankerJSONObjects = postFlankerJSONObjects;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	public enum Type{
		STRING,BOOLEAN,NUMBER;
	}
	

}
