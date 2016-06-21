package cn.com.fubon.rest;

public class App {

	public static void main(String[] args) throws Exception {

		axis1Claim();
	}

	public static void axis1Claim() throws Exception {
		String callwriteBackIP = "http://10.2.14.70:9000/fmps/services/FmpsService";

		// Service service = new Service();
		// Call call = (Call) service.createCall();
		// call.setTargetEndpointAddress(new java.net.URL(callwriteBackIP));
		// call.setUseSOAPAction(false);
		// call.setOperationName(new QName("http://ws.fubon.com.cn","service"));
		// call.addParameter("timestamp", XMLType.XSD_STRING,ParameterMode.IN);
		// call.addParameter("clientCode", XMLType.XSD_STRING,ParameterMode.IN);
		// call.addParameter("signature", XMLType.XSD_STRING,ParameterMode.IN);
		// call.addParameter("inputXml", XMLType.XSD_STRING,ParameterMode.IN);
		// call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);
		//
		// String timestamp = "2014-01-02 09:46:00";
		// String clientCode = "100";
		// String signature = null;
		// String inputXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
		// "<TRANSACTION>" +
		// "	<TRANSACTION_HEAD>" +
		// "		<TRANSACTION_SEQNO>20150309wstest</TRANSACTION_SEQNO>" +
		// "		<TRANSACTION_DATE>20150320</TRANSACTION_DATE>" +
		// "		<TRANSACTION_TIME>164327</TRANSACTION_TIME>" +
		// "		<TRANSACTION_CODE>CLM001</TRANSACTION_CODE>" +
		// "		<SERVER_CODE>FMPS</SERVER_CODE>" +
		// "		<CLIENT_CODE>100</CLIENT_CODE>" +
		// "	</TRANSACTION_HEAD>" +
		// "	<TRANSACTION_BODY>" +
		// "		<CLAIM_CASE_NO>605012015000000000109</CLAIM_CASE_NO>" +
		// "		<CLAIM_CASE_STATUS>110</CLAIM_CASE_STATUS>" +
		// "		<CLAIM_CASE_HANDLE_WAY>2</CLAIM_CASE_HANDLE_WAY>" +
		// "		<CLAIM_CASE_FEE>2000.0</CLAIM_CASE_FEE>" +
		// "		<OPENID>oELqIsyh_VguKRN-0MONSbeLz5r0</OPENID>" +
		// "		<CLAIM_END_DATE>20150320</CLAIM_END_DATE>" +
		// "		<CLAIM_END_TIME>164309</CLAIM_END_TIME>" +
		// "		<INSURED_NAME>张三</INSURED_NAME>" +
		// "		<OPERATOR_NAME></OPERATOR_NAME>" +
		// "		<OPERATOR_MOBILE></OPERATOR_MOBILE>" +
		// "	</TRANSACTION_BODY>" +
		// "</TRANSACTION>";
		//
		// //报文加密
		// byte[] inputData = inputXml.getBytes();
		// inputData = AESUtils.encrypt(inputData,
		// AESUtils.initKey("ABCDEFGHIJKLMNOPABCDEFGHIJKLMNOPABCDEFGHIJK"));
		// inputXml = Base64.encodeBase64String(inputData);
		//
		// //生成签名
		// String[] arr = new String[] { "ABCDEFGHIJKLMNOP", timestamp, inputXml
		// };
		// // 将token、timestamp、nonce三个参数进行字典序排序
		// Arrays.sort(arr);
		// StringBuilder content = new StringBuilder();
		// for (int i = 0; i < arr.length; i++) {
		// content.append(arr[i]);
		// }
		// MessageDigest md = null;
		// String tmpStr = null;
		//
		// try {
		// md = MessageDigest.getInstance("SHA-1");
		// // 将三个参数字符串拼接成一个字符串进行sha1加密
		// byte[] digest = md.digest(content.toString().getBytes());
		// tmpStr = byteToStr(digest);
		// } catch (NoSuchAlgorithmException e) {
		// e.printStackTrace();
		// }
		//
		// signature = tmpStr;
		//
		// String s = (String)call.invoke(new Object[]
		// {timestamp,clientCode,signature,inputXml});
		//
		// //解密
		// s = new String(AESUtils.decrypt(Base64.decodeBase64(s),
		// AESUtils.initKey("ABCDEFGHIJKLMNOPABCDEFGHIJKLMNOPABCDEFGHIJK")));
		// logger.info(s);
	}

	private static String byteToStr(byte[] byteArray) {
		String strDigest = "";
		for (int i = 0; i < byteArray.length; i++) {
			strDigest += byteToHexStr(byteArray[i]);
		}
		return strDigest;
	}

	private static String byteToHexStr(byte mByte) {

		char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
				'B', 'C', 'D', 'E', 'F' };
		char[] tempArr = new char[2];
		tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
		tempArr[1] = Digit[mByte & 0X0F];

		String s = new String(tempArr);
		return s;
	}
}
