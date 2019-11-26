package com.info.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class TestAnalytics {

	public static void main(String[] args) throws Exception {

		ObjectMapper mapper = new ObjectMapper();
		ObjectNode requestData = mapper.createObjectNode();
		// set request data
		requestData.put("ANNUAL_PREMIUM", 280);
		requestData.put("PREMIUM_COLLECTION_METHOD", "Credit Card");
		requestData.put("VEHICLE_USAGE_TYPE", "Commercial");
		requestData.put("AGE", 30);
		requestData.put("VEHICLE_AGE_POL_START", 3);
		requestData.put("NO_OF_DRIVER", 1);
		requestData.put("RISK_SUM_INSURED", 3000);
		requestData.put("DEDUCTIBLE", 250);

		//create temporary JSON file
		File file = new File("buyingPropensityData.json");
		mapper.writeValue(file, requestData);

		HttpPost httpPost = new HttpPost("http://ohi-bianlapp01:5010/BuyingPropensityProbabilityOnlyAPI");

		HttpEntity stringEntity = new StringEntity(new String(Files.readAllBytes(Paths.get("buyingPropensityData.json"))), ContentType.APPLICATION_JSON);
		httpPost.setEntity(stringEntity);
		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse response = httpClient.execute(httpPost)) {
			if (response.getStatusLine().getStatusCode() == 200) {
				System.out.println(EntityUtils.toString(response.getEntity()));
			}
		}finally{
			// delete file after use
			file.delete();
		}
//		System.out.println("result:"+"".split(" ").length);
		
	}

}
