package com.wnJava.util;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * 
 * json处理工具类
 * 
 * @author wn
 * @version 1.0.0 JsonUtil.java 2014-5-28 下午3:23:11
 */
public class JsonUtil {
	private static Gson gson = new Gson();
	
	public static String dtoToJSON(Object dto) {
		return gson.toJson(dto);
	}

	public static void outputDTOToJSON(Object dto, HttpServletResponse response) {
		outputDTOToJSON(dto, null, response);
	}

	public static void outputDTOToJSON(Object dto, Map param, HttpServletResponse response) {
		outputDTOToJSON(dto, param, null, response);
	}

	/**
	 * 安全隐私协议
	 */
	public static void addP3P(HttpServletResponse response) {
		response.addHeader("p3p", "CP=\"CURa ADMa DEVa PSAo PSDo OUR BUS UNI PUR INT DEM STA PRE COM NAV OTC NOI DSP COR\"");
	}

	/**
	 * 清除掉List<Map>转成json之后，字符串中出现的{"map":...},使之更容易被前端解析
	 */
	private static String purifyJsonFromMap(String jsonStr){
		if(StringUtil.isNull(jsonStr)){
			return jsonStr;
		}
		return jsonStr.replaceAll("\\{\"map\":(.*?\\})\\}([,\\]])", "$1$2");
	}
	
	public static void outputDTOToJSON(Object dto, Map param, String contentType, HttpServletResponse response){
		outputDTOToJSON(dto, param, contentType, response, false);
	}

	public static void outputDTOToJSON(Object dto, Map param, String contentType, HttpServletResponse response, boolean needPurifyFromMap) {
		/**
		 * 安全隐私协议
		 */
		addP3P(response);
		StringBuffer sb = new StringBuffer();
		if (param != null) {
			sb.append(marshalMetaData(param));
		}
		String dtoJsonString = dtoToJSON(dto);
		if(needPurifyFromMap){
			dtoJsonString = purifyJsonFromMap(dtoJsonString);
		}
		if (param != null) {
			sb.append(dtoJsonString.substring(1, dtoJsonString.length()));
		} else {
			sb.append(dtoJsonString);
		}
		byte[] bout = null;
		try {
			bout = sb.toString().getBytes("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		if (StringUtil.isNull(contentType)) {
			response.setContentType("text/plain;charset=utf-8");
		} else {
			response.setContentType(contentType);
		}
		if (KEEPALIVE) {
			response.setIntHeader("Content-Length", bout.length);
		}
		try {
			OutputStream out = response.getOutputStream();
			out.write(bout);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void outputMapToJSON(Map metaData, HttpServletResponse response) {
		/**
		 * 安全隐私协议
		 */
		addP3P(response);
		StringBuffer sb = new StringBuffer();
		sb.append(marshalMetaData2(metaData));
		sb.append("temp:1}");
		byte[] bout = null;
		try {
			bout = sb.toString().getBytes("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		response.setContentType("text/plain;charset=utf-8");
		if (KEEPALIVE) {
			response.setIntHeader("Content-Length", bout.length);
		}
		try {
			OutputStream out = response.getOutputStream();
			out.write(bout);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void outputString(String str, HttpServletResponse response) {
		/**
		 * 安全隐私协议
		 */
		addP3P(response);
		byte[] bout = null;
		try {
			bout = str.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8");
		if (KEEPALIVE) {
			response.setIntHeader("Content-Length", bout.length);
		}
		try {
			OutputStream out = response.getOutputStream();
			out.write(bout);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void outputStringToJSON(String str, HttpServletResponse response) {
		/**
		 * 安全隐私协议
		 */
		addP3P(response);
		byte[] bout = null;
		try {
			bout = str.toString().getBytes("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8");
		if (KEEPALIVE) {
			response.setIntHeader("Content-Length", bout.length);
		}
		try {
			OutputStream out = response.getOutputStream();
			out.write(bout);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void outputStringToXML(StringBuffer str, HttpServletResponse response) {
		/**
		 * 安全隐私协议
		 */
		addP3P(response);
		byte[] bout = null;
		try {
			bout = str.toString().getBytes("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		response.setContentType("text/xml;charset=utf-8");
		if (KEEPALIVE) {
			response.setIntHeader("Content-Length", bout.length);
		}
		try {
			OutputStream out = response.getOutputStream();
			out.write(bout);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void outputExceptionToJSON(Throwable e, HttpServletResponse response) {
		/**
		 * 安全隐私协议
		 */
		addP3P(response);
		response.setContentType("text/plain;charset=utf-8");
		JSONRPCResult json_res = null;
		SerializerState state = new SerializerState();
		if (e instanceof InvocationTargetException)
			e = ((InvocationTargetException) e).getTargetException();
		json_res = new JSONRPCResult(JSONRPCResult.CODE_REMOTE_EXCEPTION, 1, e);
		byte[] bout = null;
		try {
			bout = json_res.toString().getBytes("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		boolean keepalive = true;
		if (keepalive) {
			response.setIntHeader("Content-Length", bout.length);
		}
		try {
			OutputStream out = response.getOutputStream();
			out.write(bout);
			out.flush();
			out.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static String marshalMetaData(Map map) {
		StringBuffer sb = new StringBuffer("{");
		for (Object key : map.keySet()) {
			Object value = map.get(key);
			if (value instanceof Integer) {
				sb.append("\"" + key.toString() + "\":" + value.toString() + ",");
			} else if (value instanceof Long) {
				sb.append("\"" + key.toString() + "\":" + value.toString() + ",");
			}  else if (value instanceof Double) {
				sb.append("\"" + key.toString() + "\":" + value.toString() + ",");
			}else if (value instanceof String) {
				sb.append("\"" + key.toString() + "\":\"" + jsonFormat(value.toString()) + "\",");
			} else if (value instanceof Float) {
				sb.append("\"" + key.toString() + "\":" + value.toString() + ",");
			} else if (value instanceof Boolean) {
				sb.append("\"" + key.toString() + "\":" + value.toString() + ",");
			} else if (value instanceof BigDecimal) {
				sb.append("\"" + key.toString() + "\":" + value.toString() + ",");
			} else if (value instanceof Byte) {
				sb.append("\"" + key.toString() + "\":" + value.toString() + ",");
			}
		}
		return sb.toString();
	}

	public static String marshalMetaData2(Map map) {
		StringBuffer sb = new StringBuffer("{");
		for (Object key : map.keySet()) {
			Object value = map.get(key);
			if (value instanceof Integer) {
				sb.append(key.toString() + ":" + value.toString() + ",");
			} else if (value instanceof Long) {
				sb.append(key.toString() + ":" + value.toString() + ",");
			} else if (value instanceof Float) {
				sb.append(key.toString() + ":" + value.toString() + ",");
			} else if (value instanceof String) {
				sb.append(key.toString() + ":\"" + jsonFormat(value.toString()) + "\",");
			} else if (value instanceof Boolean) {
				sb.append(key.toString() + ":" + value.toString() + ",");
			} else if (value instanceof BigDecimal) {
				sb.append(key.toString() + ":" + value.toString() + ",");
			} else if (value == null) {
				sb.append(key.toString() + ":" + null + ",");
			}
		}
		return sb.toString();
	}

	public static String jsonFormat(String s) {
		s = s.replaceAll("\\\\", "\\\\\\\\");
		s = s.replaceAll("\\\"", "\\\\\"");
		// s = s.replaceAll("\\/", "\\\\/");
		s = s.replaceAll("\\\n", "\\\\\\n");
		// s = s.replaceAll("\\:", "\\\\:");
		// s = s.replaceAll("\\{", "\\\\{");
		// s = s.replaceAll("\\}", "\\\\}");
		return s;
	}

	public static void outputOperationResultAsJSON(boolean isSuccess, String message, HttpServletResponse response) {
		outputOperationResultAsJSON(isSuccess, message, null, response);
	}

	public static void outputOperationResultAsJSON(boolean isSuccess, String message, Map<String, Object> metaData, HttpServletResponse response) {
		/**
		 * 安全隐私协议
		 */
		addP3P(response);
		response.setContentType("text/plain;charset=utf-8");
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("success", isSuccess);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (message != null)
			try {
				jsonObject.put("message", message);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		if (metaData != null) {
			for (Object key : metaData.keySet()) {
				Object value = metaData.get(key);
				try {
					jsonObject.put(key.toString(), value);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		try {
			OutputStream out = response.getOutputStream();
			out.write(jsonObject.toString().getBytes("UTF-8"));
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Upload client can not recieve contentType with "text/plain"
	 * 
	 * @param isSuccess
	 * @param message
	 * @param response
	 * @throws JSONException
	 */
	public static void outputOperationResultAsJSONSpecialForForm(boolean isSuccess, String message, Map<String, Object> metaData, HttpServletResponse response) {
		/**
		 * 安全隐私协议
		 */
		addP3P(response);
		response.setContentType("text/html");
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("success", isSuccess);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (message != null)
			try {
				jsonObject.put("message", message);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		if (metaData != null)
			for (Object key : metaData.keySet()) {
				Object value = metaData.get(key);
				try {
					jsonObject.put(key.toString(), value);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		try {
			OutputStream out = response.getOutputStream();
			out.write(jsonObject.toString().getBytes("UTF-8"));
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 多个dtoList或�?dto（可以混用）
	 * 
	 * @author hdu
	 * @param map
	 *            --基本类型、dto、dtolist的map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static String multiDtoListToJSON(Map<String, Object> map) {
		SerializerState state = new SerializerState();
		JSONObject jo = new JSONObject();
		try {
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				jo.put(entry.getKey(), ser.marshall(state, entry.getValue()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jo.toString();
	}

	/**
	 * 多个dtoList或�?dto（可以混用）
	 * 
	 * @author hdu
	 * @param objectMap
	 *            --基本类型、dto、dtolist的map
	 * @param response
	 */
	@SuppressWarnings("unchecked")
	public static void outputMultiDtoListToJSON(Map<String, Object> objectMap, HttpServletResponse response) {
		outputMultiDtoListToJSON(objectMap, null, response);
	}

	/**
	 * 多个dtoList或�?dto（可以混用）
	 * 
	 * @author hdu
	 * @param objectMap
	 *            --基本类型、dto、dtolist的map
	 * @param contentType
	 * @param response
	 */
	@SuppressWarnings("unchecked")
	public static void outputMultiDtoListToJSON(Map<String, Object> objectMap, String contentType, HttpServletResponse response) {
		/**
		 * 安全隐私协议
		 */
		addP3P(response);
		StringBuffer sb = new StringBuffer();
		String dtoJsonString = multiDtoListToJSON(objectMap);
		sb.append(dtoJsonString);
		byte[] bout = null;
		try {
			bout = sb.toString().getBytes("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		if (StringUtil.isNull(contentType)) {
			response.setContentType("text/plain;charset=utf-8");
		} else {
			response.setContentType(contentType);
		}
		if (KEEPALIVE) {
			response.setIntHeader("Content-Length", bout.length);
		}
		try {
			OutputStream out = response.getOutputStream();
			out.write(bout);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 在异步获取列表发生错误时，返回一个outputDTOToJSON方法可用的erroMap
	 * 直接用outputOperationResultAsJSON返回的话，可能会影响到ext的grid或者jquery的datatable的内部代码的运行
	 */
	public static Map<String, Object> buildErrorResultMap(String msg) {
		Map<String, Object> errorMap = new HashMap<String, Object>();
		errorMap.put("success", false);
		errorMap.put("message", msg);
		errorMap.put(CommonStaticConst.TOTALCOUNT, 0);
		return errorMap;
	}
	
	/**
	 * NIO
	 * @param str
	 * @param response
	 * @author wangyong
	 */
	public static void outPutString(String str, HttpServletResponse response) {
		/**
		 * 安全隐私协议
		 */
		addP3P(response);
		byte[] bout = null;
		try {
			bout = str.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		response.setContentType("text/plain;charset=utf-8");
		if (KEEPALIVE) {
			response.setIntHeader("Content-Length", bout.length);
		}
		try {
			OutputStream out = response.getOutputStream();
			
	        WritableByteChannel writeChannel = Channels.newChannel(out);
	        if(writeChannel.isOpen()){
	        	 writeChannel.write(ByteBuffer.wrap(bout));
	 			
	        	 writeChannel.close();
	        }
	        
	        out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
	}
}
