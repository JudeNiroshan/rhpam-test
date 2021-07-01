package com.myspace.corporatelos.underwriting;

/**
 * This class was automatically generated by the data modeler tool.
 */

public class UnderwritingScripts implements java.io.Serializable {

	static final long serialVersionUID = 1L;

	public UnderwritingScripts() {
	}

	public static void checkDecisions(
			org.kie.api.runtime.process.ProcessContext kcontext) {
		try {
			org.json.JSONObject decisionResp = new org.json.JSONObject(kcontext
					.getVariable("response").toString());
			if (decisionResp.has("decisions")) {
				org.json.JSONArray decisionArray = decisionResp
						.getJSONArray("decisions");
				if (decisionArray.length() > 0) {
					System.out.println("num: "
							+ kcontext.getVariable("num").toString()
							+ "  array Length: " + decisionArray.length());
					if (decisionArray.length() >= Integer.parseInt(kcontext
							.getVariable("num").toString())) {
						kcontext.setVariable("result", true);
					} else {
						kcontext.setVariable("result", false);
					}
				} else {
					kcontext.setVariable("result", false);
				}
			} else {
				kcontext.setVariable("result", false);
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e.toString());
		}
	}

	public static void prepareFullfillmentVariables(
			org.kie.api.runtime.process.ProcessContext kcontext) {
		try {
			org.json.JSONObject responseObj = new org.json.JSONObject(kcontext
					.getVariable("facilityResponse").toString());
			System.out.println("Amount: "
					+ new java.math.BigDecimal(responseObj.get("totalAmount")
							.toString()));
			kcontext.setVariable("amount", new java.math.BigDecimal(responseObj
					.get("totalAmount").toString()));
			Integer year = 0;
			Integer month = 0;
			Integer days = 0;
			if (!responseObj.isNull("year")
					&& !responseObj.get("year").equals("")) {
				year = Integer.parseInt(responseObj.get("year").toString());
			}
			if (!responseObj.isNull("month")
					&& !responseObj.get("month").equals("")) {
				month = Integer.parseInt(responseObj.get("month").toString());
			}
			if (!responseObj.isNull("days")
					&& !responseObj.get("days").equals("")) {
				days = Integer.parseInt(responseObj.get("days").toString());
			}
			Integer noOfDays = year * 365 + month * 30 + days;
			System.out.println(noOfDays);
			String facilityTerm = noOfDays.toString() + "D";
			System.out.println("Str: " + facilityTerm);
			kcontext.setVariable("term", facilityTerm);
		} catch (Exception e) {
			System.out.println("Exception: " + e.toString());
		}
	}

	public static void prepareFullfillmentMap(
			org.kie.api.runtime.process.ProcessContext kcontext) {
		try {
			java.util.HashMap requestMap = new java.util.HashMap();
			requestMap.put("customerId", "100100");
			requestMap.put("customerRole", "OWNER");
			requestMap.put("amount", kcontext.getVariable("amount").toString());
			requestMap.put("changeAmount", "0");
			requestMap.put("term", kcontext.getVariable("term").toString());
			requestMap.put("productId", "MORTGAGE");
			requestMap.put("currencyId", "USD");
			java.util.Date date = new java.util.Date();
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
					"yyyy-MM-dd");
			String currDate = sdf.format(date).toString();
			requestMap.put("effectiveDate", currDate);
			requestMap.put("activityId", "LENDING-NEW-ARRANGEMENT");
			kcontext.setVariable("payloadMap", requestMap);
		} catch (Exception e) {
			System.out.println("Exception: " + e.toString());
		}
	}
}