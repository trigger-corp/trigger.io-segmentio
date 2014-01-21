package io.trigger.forge.android.modules.segmentio;

import org.json.JSONObject;

import com.google.gson.JsonObject;

import io.segment.android.Analytics;
import io.segment.android.models.EasyJSONObject;
import io.segment.android.models.EventProperties;
import io.segment.android.models.Traits;
import io.trigger.forge.android.core.ForgeLog;
import io.trigger.forge.android.core.ForgeParam;
import io.trigger.forge.android.core.ForgeTask;

public class API {
	
	public static void identify(final ForgeTask task, @ForgeParam("userId") final String userId, 
													  @ForgeParam("traits") final JsonObject traits) {
		try {
			JSONObject jtraits = new JSONObject(traits.toString());		
			EasyJSONObject ejtraits = new EasyJSONObject(jtraits);
			Analytics.identify(userId, new Traits(ejtraits));
			task.success();
		} catch (Exception ex) {
			ForgeLog.e("forge.segmentio.identify failed to convert traits: " + ex.getMessage());
			task.error(ex.getMessage());
		}
	}
	
	
	public static void track(final ForgeTask task, @ForgeParam("event") final String event, 
			  									   @ForgeParam("properties") final JsonObject properties) {
		try {
			JSONObject jproperties = new JSONObject(properties.toString());		
			EasyJSONObject ejproperties = new EasyJSONObject(jproperties);
			Analytics.track(event, new EventProperties(ejproperties));
			task.success();
		} catch (Exception ex) {
			ForgeLog.e("forge.segmentio.track failed to convert properties: " + ex.getMessage());
			task.error(ex.getMessage());
		}
	}

	public static void screen(final ForgeTask task, @ForgeParam("screenTitle") final String screenTitle, 
			   										@ForgeParam("properties") final JsonObject properties) {
		try {
			JSONObject jproperties = new JSONObject(properties.toString());		
			EasyJSONObject ejproperties = new EasyJSONObject(jproperties);
			Analytics.screen(screenTitle, new EventProperties(ejproperties));
			task.success();
		} catch (Exception ex) {
			ForgeLog.e("forge.segmentio.screen failed to convert properties: " + ex.getMessage());
			task.error(ex.getMessage());
		}
	}
}
