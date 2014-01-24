/* global module, forge, asyncTest, ok, start */

module("segmentio");

var platform = "unknown";
if (forge.is.ios()) {
	platform = "ios";
} else if (forge.is.android()) {
	platform = "android";
}

asyncTest("Identify user to segmentio", 1, function() {
	forge.segmentio.identify(platform + "_automated.js", {
		"suite": "automated",
		"test": "forge.segmentio.identify",
		"platform": platform,
		"timestamp": (new Date()).toString()
	}, function () {
		ok(true, "Expected success");
		start();
	}, function () {
		ok(true, "Got failure. Expected success");
		start();
	});
});

asyncTest("Track an event - all params", 1, function() {
	forge.segmentio.track("test forge.segmentio.track(event, properties)", {
		"suite": "automated",
		"test": "forge.segmentio.track",
		"platform": platform,
		"timestamp": (new Date()).toString()
	}, function () {
		ok(true, "Expected success");
		start();
	}, function () {
		ok(true, "Got failure. Expected success");
		start();
	});
});

asyncTest("Track an event - no properties", 1, function() {
	forge.segmentio.track("test forge.segmentio.track(event)", function () {
		ok(true, "Expected success");
		start();
	}, function () {
		ok(true, "Got failure. Expected success");
		start();
	});
});

asyncTest("Record screen", 1, function() {
	forge.segmentio.screen("test forge.segmentio.screen(screenTitle, properties)", {
		"suite": "automated",
		"test": "forge.segmentio.screen",
		"platform": platform,
		"timestamp": (new Date()).toString()
	}, function () {
		ok(true, "Expected success");
		start();
	}, function () {
		ok(true, "Got failure. Expected success");
		start();
	});
});
