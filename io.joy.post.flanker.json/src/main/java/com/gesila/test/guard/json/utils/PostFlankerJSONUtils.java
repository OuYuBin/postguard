package com.gesila.test.guard.json.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gesila.test.guard.json.model.PostFlankerJSONObject;
import com.gesila.test.guard.json.model.PostFlankerJSONObject.Type;
//import com.jd.lcp.wuliuyun.apidoc.element;
import com.jd.lcp.wuliuyun.apidoc.element;

/**
 * 
 * @author robin
 *
 */
public class PostFlankerJSONUtils {

	/**
	 * 
	 * @param jsonString
	 * @return
	 */
	public static JSONObject createJSONObject(String jsonString) {
		JSONObject jsonObject = null;
		if (!"".equals(jsonString) && jsonString != null) {
			char[] responseChars = jsonString.toCharArray();
			char firstChar = responseChars[0];
			if ('{' == firstChar) {
				jsonObject = JSONObject.parseObject(jsonString);
			} else {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("name", jsonString);
				jsonObject = new JSONObject(map);
			}
		}
		return jsonObject;
	}

	/**
	 * 
	 * @param jsonObject
	 * @param list
	 */
	public static void createPostFlankerJSONObject(JSONObject jsonObject, List<PostFlankerJSONObject> list) {
		if (jsonObject != null) {
			Iterator<String> iter = jsonObject.keySet().iterator();
			while (iter.hasNext()) {
				// --key
				String key = iter.next();
				PostFlankerJSONObject responseObject = new PostFlankerJSONObject("");
				responseObject.setName(key);
				String value = jsonObject.getString(key);
				char fchar = 0;
				if (!"".equals(value) && StringUtils.isNotEmpty(value)) {
					char[] chars = value.toCharArray();
					fchar = chars[0];
				}
				if ('{' == fchar) {
					createPostFlankerJSONObject(JSONObject.parseObject(value), list);
				} else if ('[' == fchar) {
					JSONArray jsonArray = JSONObject.parseArray(value);
					ListIterator<Object> listIter = jsonArray.listIterator();
					List<PostFlankerJSONObject> currentList = new ArrayList<PostFlankerJSONObject>();
					int i = 0;
					while (listIter.hasNext()) {
						List<PostFlankerJSONObject> arrayList = new ArrayList<PostFlankerJSONObject>();
						Object object = listIter.next();
						// --创建虚拟节点对象
						PostFlankerJSONObject parentReponseObject = new PostFlankerJSONObject(i + "");
						if (object instanceof JSONObject) {
							createPostFlankerJSONObject((JSONObject) object, arrayList);
						}
						parentReponseObject.setPostFlankerJSONObjects(arrayList);
						currentList.add(parentReponseObject);
						i++;
					}
					responseObject.setPostFlankerJSONObjects(currentList);
					list.add(responseObject);
				} else {
					responseObject.setValue(value);
					list.add(responseObject);
				}
			}
		}
	}

	/**
	 * 
	 * @param jsonObject
	 * @param list
	 */
	@SuppressWarnings("unchecked")
	public static void createPostFlankerJSONObject(JSONObject jsonObject, List<PostFlankerJSONObject> list,
			EObject eObject) {
		if (jsonObject != null) {
			Iterator<String> iter = jsonObject.keySet().iterator();
			while (iter.hasNext()) {
				// --JOON key键值
				String key = iter.next();
				PostFlankerJSONObject responseObject = new PostFlankerJSONObject("");
				responseObject.setName(key);
				String pojoKey = (String) eObject.eGet(eObject.eClass().getEStructuralFeature(key));
				// --搜索当前API对象返回结果子节点信息
				EList<element> elements = (EList<element>) eObject
						.eGet(eObject.eClass().getEStructuralFeature("element"));
				String comment = "";
				Type type = Type.STRING;
				element currentElement = null;
				for (element e : elements) {
					String name = e.getName();
					if (StringUtils.equals(key, name)) {
						currentElement = e;
						comment = (String) currentElement
								.eGet(currentElement.eClass().getEStructuralFeature("comment"));
						String typeString = (String) currentElement
								.eGet(currentElement.eClass().getEStructuralFeature("type"));
						switch (typeString) {
						case "java.lang.Boolean":
							type = Type.BOOLEAN;
							break;
						case "java.lang.Long":
						case "java.lang.Integer":
							type = Type.NUMBER;
							break;
						default:
							type = Type.STRING;
						}
						responseObject.setType(type);
						break;
					}
				}
				responseObject.setDesc(comment == null ? "" : comment);
				String value = jsonObject.getString(key);
				char fchar = 0;
				if (!"".equals(value) && StringUtils.isNotEmpty(value)) {
					char[] chars = value.toCharArray();
					fchar = chars[0];
				}
				// --对象解组
				if ('{' == fchar) {
					// --构建虚拟节点,以便产生更好的的视觉效果
					PostFlankerJSONObject parentReponseObject = new PostFlankerJSONObject(key);
					List<PostFlankerJSONObject> arrayList = new ArrayList<PostFlankerJSONObject>();
					createPostFlankerJSONObject(JSONObject.parseObject(value), arrayList, currentElement);
					parentReponseObject.setPostFlankerJSONObjects(arrayList);
					list.add(parentReponseObject);
					// --组信息解组
				} else if ('[' == fchar) {
					JSONArray jsonArray = JSONObject.parseArray(value);
					ListIterator<Object> listIter = jsonArray.listIterator();
					List<PostFlankerJSONObject> currentList = new ArrayList<PostFlankerJSONObject>();
					int i = 0;
					while (listIter.hasNext()) {
						List<PostFlankerJSONObject> arrayList = new ArrayList<PostFlankerJSONObject>();
						Object object = listIter.next();
						// --创建虚拟节点对象
						PostFlankerJSONObject parentReponseObject = new PostFlankerJSONObject(i + "");
						if (object instanceof JSONObject) {
							createPostFlankerJSONObject((JSONObject) object, arrayList, currentElement);
						}
						parentReponseObject.setPostFlankerJSONObjects(arrayList);
						currentList.add(parentReponseObject);
						i++;
					}
					responseObject.setPostFlankerJSONObjects(currentList);
					list.add(responseObject);
				} else {
					responseObject.setValue(value);
					list.add(responseObject);
				}
			}
		}
	}

	public static String createGesilaJSONOString(JSONObject jsonObject) {
		return JSONObject.toJSONString(jsonObject);
	}
}
