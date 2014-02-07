package io.trigger.forge.android.modules.segmentio;

import com.google.gson.JsonObject;

import android.os.Bundle;
import io.segment.android.Analytics;
import io.segment.android.Options;
import io.trigger.forge.android.core.ForgeApp;
import io.trigger.forge.android.core.ForgeEventListener;

public class EventListener extends ForgeEventListener {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		String writeKey = "";
		boolean debug = false;

		JsonObject config = ForgeApp.configForPlugin("segmentio");
		writeKey = config.get("android_writeKey").getAsString();
		if (config.has("debug")) {
			debug = config.get("debug").getAsBoolean();
		}

		Options options = new Options();
		options.setDebug(debug);
		Analytics.onCreate(ForgeApp.getActivity(), writeKey, options);

		if (debug) {
			// reset the settings cache frequently so that as you change
			// settings on your integrations page, you see the settings
			// update locally ASAP.
			Analytics.reset();
		}
	}


	@Override
	public void onStart() {
		super.onStart();
		Analytics.activityStart(ForgeApp.getActivity());
	}


	@Override
	public void onStop() {
		super.onStop();
		Analytics.activityStop(ForgeApp.getActivity());
	}
}
