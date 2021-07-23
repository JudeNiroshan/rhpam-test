package com.myspace.corporatelos;

/**
 * This class was automatically generated by the data modeler tool.
 */

public class CommonScripts implements java.io.Serializable {

	static final long serialVersionUID = 1L;

	public CommonScripts() {
	}

	public static void getNextDealStatus(
			org.kie.api.runtime.process.ProcessContext kcontext) {
		try {
			org.json.JSONObject responseJSON = new org.json.JSONObject(kcontext
					.getVariable("refrencedata").toString());
			org.json.JSONArray dealStatusArray = responseJSON
					.getJSONArray("requestStagesLob");
			for (int i = 0; i < dealStatusArray.length(); i++) {
				org.json.JSONObject indDealLob = new org.json.JSONObject(
						dealStatusArray.get(i).toString());
				if (indDealLob.get("lobValue").equals(
						kcontext.getVariable("lineOfBusiness").toString())) {
					org.json.JSONArray dealStagesArray = indDealLob
							.getJSONArray("stages");
					for (int j = 0; j < dealStagesArray.length(); j++) {
						org.json.JSONObject indDealStage = new org.json.JSONObject(
								dealStagesArray.get(j).toString());
						if (indDealStage.get("stageId").equals(
								kcontext.getVariable("dealStatus").toString())) {
							org.json.JSONObject nextDealStatus = new org.json.JSONObject(
									dealStagesArray.get(j + 1).toString());
							String updatedDealStatus = nextDealStatus.get(
									"stageId").toString();
							kcontext.setVariable("nextStatus",
									updatedDealStatus);
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e.toString());
		}
	}

	public static void getNextFacilityStatus(
			org.kie.api.runtime.process.ProcessContext kcontext) {
		try {
			org.json.JSONObject responseJSON = new org.json.JSONObject(kcontext
					.getVariable("refrencedata").toString());
			org.json.JSONArray facilityStatusArray = responseJSON
					.getJSONArray("facilityStagesLob");
			for (int i = 0; i < facilityStatusArray.length(); i++) {
				org.json.JSONObject indFacilityLob = new org.json.JSONObject(
						facilityStatusArray.get(i).toString());
				if (indFacilityLob.get("lobValue").equals(
						kcontext.getVariable("lineOfBusiness").toString())) {
					org.json.JSONArray facilityStagesArray = indFacilityLob
							.getJSONArray("stages");
					for (int j = 0; j < facilityStagesArray.length(); j++) {
						org.json.JSONObject indFacilityStage = new org.json.JSONObject(
								facilityStagesArray.get(j).toString());
						if (indFacilityStage.get("stageId").equals(
								kcontext.getVariable("facilityStatus")
										.toString())) {
							org.json.JSONObject nextFacilityStatus = new org.json.JSONObject(
									facilityStagesArray.get(j + 1).toString());
							String updatedFacilityStatus = nextFacilityStatus
									.get("stageId").toString();
							kcontext.setVariable("nextStatus",
									updatedFacilityStatus);
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e.toString());
		}

	}

}