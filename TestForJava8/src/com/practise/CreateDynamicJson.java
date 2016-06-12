package com.practise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;


public class CreateDynamicJson {
	
public String createDynamicJson(Map<String,ArrayList<String>> metadataMap){
		

		//Creating metadata node
		JsonArrayBuilder jsonMetadataObjectBuilder = Json.createArrayBuilder();
		
		
		/*List<String> metadataList = new ArrayList<String>();
		metadataList.add("TGT.FIELD.DPCI");
		metadataList.add("TGT.FIELD.TCIN");
		metadataList.add("TGT.FIELD.PRODUCT_NAME");
		metadataList.add("TGT.FIELD.BRAND");
		metadataList.add("PRODUCT_GROUP_NAME");
		metadataList.add("PRODUCT_SUB_GROUP_NAME");
		metadataList.add("PRODUCT_IAC_NAME");
		metadataList.add("DEPARTMENT");
		metadataList.add("CLASS");
		metadataList.add("TGT.FIELD.PRODUCT.US_PRD_RETRIEVAL"); */
		
			for(String metadataField : metadataMap.keySet()){
			JsonObject jsonMetadataBuilder = Json.createObjectBuilder()
					.add("id",  metadataField)
					.add("type", "com.artesia.metadata.MetadataTableField")
					.add("values", valueNodeJson(metadataMap.get(metadataField)))
					.build();
			
			jsonMetadataObjectBuilder.add(jsonMetadataBuilder);
		}
		
			JsonArray metadataJson = jsonMetadataObjectBuilder.build();
			//System.out.println(metadataJson.toString());
		
		//Creating the complete json object
		JsonBuilderFactory factory = Json.createBuilderFactory(null);
		JsonObject finalJsonObj = factory.createObjectBuilder()
				.add("edited_asset", factory.createObjectBuilder()
						.add("data", factory.createObjectBuilder()
								.add("metadata", metadataJson))).build();	
		
		return finalJsonObj.toString();
	}

public JsonArray valueNodeJson(ArrayList<String> valueArray){

	
	//Creating value node
	JsonArrayBuilder jsonOuterValuesObjectBuilder = Json.createArrayBuilder();
	
	for(int j=0;j<valueArray.size();j++){
		
		JsonObject jsonInnerValueObjectBuilder = Json.createObjectBuilder()
				.add("value", valueArray.get(j))
				.add("type", "String")
				.build();
	JsonObject jsonOuterValuesBuilder = Json.createObjectBuilder()
	
			.add("value", jsonInnerValueObjectBuilder)
			.build();
	jsonOuterValuesObjectBuilder.add(jsonOuterValuesBuilder);
	}
	
	JsonArray outerValueJson = jsonOuterValuesObjectBuilder.build();
	return outerValueJson;
	
}

	public static void main(String[] args) {
	
		CreateDynamicJson c1 =new CreateDynamicJson();
		Map<String,ArrayList<String>> metadataMap = new HashMap<String, ArrayList<String>>();
		ArrayList<String> dpciList = new ArrayList<String>();
		dpciList.add("123-34-5678");
		dpciList.add("123-34-5679");
		dpciList.add("123-34-5680");
		metadataMap.put("TGT.FIELD.DPCI",dpciList);
		
		ArrayList<String> tcinList = new ArrayList<String>();
		tcinList.add("12345678");
		tcinList.add("12335679");
		metadataMap.put("TGT.FIELD.TCIN",tcinList);
		
		ArrayList<String> pdtnameList = new ArrayList<String>();
		pdtnameList.add("Contours Parent Console");
		metadataMap.put("TGT.FIELD.PRODUCT_NAME",pdtnameList);
		
		ArrayList<String> brandList = new ArrayList<String>();
		brandList.add("myBrand");
		metadataMap.put("TGT.FIELD.BRAND",brandList);
		
		ArrayList<String> groupnameList = new ArrayList<String>();
		groupnameList.add("");
		metadataMap.put("PRODUCT_GROUP_NAME",groupnameList);
		
		ArrayList<String> subgrpList = new ArrayList<String>();
		subgrpList.add("");
		metadataMap.put("PRODUCT_SUB_GROUP_NAME",subgrpList);
		
		ArrayList<String> iacList = new ArrayList<String>();
		iacList.add("12345678");
		metadataMap.put("PRODUCT_SUB_GROUP_NAME",iacList);
		
		ArrayList<String> deptList = new ArrayList<String>();
		deptList.add("030");
		metadataMap.put("DEPARTMENT",deptList);
		

		ArrayList<String> classList = new ArrayList<String>();
		classList.add("02");
		metadataMap.put("CLASS",classList);
		
		ArrayList<String> usflagList = new ArrayList<String>();
		usflagList.add("Auto Set");
		metadataMap.put("TGT.FIELD.PRODUCT.US_PRD_RETRIEVAL",usflagList);
		
			
				String finalJson = c1.createDynamicJson(metadataMap);
				System.out.println(finalJson);
			
	}

}
