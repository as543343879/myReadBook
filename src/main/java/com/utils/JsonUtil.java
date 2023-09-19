/**
 * @Project: SNS_Platform
 * @Author: squll
 * @Date: 2010-12-30
 * @Copyright: (c) 2010 广州菠萝信息技术有限公司 All rights reserved.
 */
package com.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class JsonUtil {

	/**
	 * 将一个对像转成一个json字符串
	 */
	public static final String dumps(Object obj) {
		// return JSONObject.toJSONString(obj,
		// SerializerFeature.WriteMapNullValue);
		return JSONObject.toJSONString(obj);
	}
	
	public static final String dumps(Object obj, boolean prettyFormat) {
		// return JSONObject.toJSONString(obj,
		// SerializerFeature.WriteMapNullValue);
		return JSONObject.toJSONString(obj,prettyFormat);
	}

	/**
	 * 从一个json字符串映射成一个对象
	 */
	public static final <T> T loads(Object s, Class<T> cls) {
		if (s == null)
			return null;
		return JSONObject.parseObject(s.toString(), cls, Feature.OrderedField);
	}

	/**
	 * 从一个json字符串列表中映射一个对象列表
	 */
	// public static final <T> List<T> loads(List<Object> l, Class<T> cls) {
	// if (l == null)
	// return null;
	// Object o;
	// ArrayList<T> al = new ArrayList<T>();
	// for (int i = -1; ++i < l.size();) {
	// o = l.get(i);
	// if (o != null)
	// al.add(JSONObject.parseObject(o.toString(), cls, Feature.OrderlyMap));
	// }
	// return al;
	// }

	public static final <T> List<T> loads(Collection<Object> l, Class<T> cls) {
		return loads(l, cls, cls);
	}

	public static final <T, P extends T> List<T> loads(Collection<?> l, Class<P> implCls, Class<T> interfaceCls) {
		if (l == null)
			return null;
		List<T> al = new ArrayList<T>();
		for (Object o : l) {
			if (o != null)
				al.add(JSONObject.parseObject(o.toString(), implCls, Feature.OrderedField));
		}
		return al;
	}

	public static final <T> List<T> loadsArray(Object s, Class<T> cls) {
		if (s == null)
			return null;
		return JSONArray.parseArray(s.toString(), cls);
	}
}
