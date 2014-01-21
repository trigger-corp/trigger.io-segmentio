/* global forge */

forge.segmentio = {
	/**
	 * Lets you tie a user to their actions and record traits about them
	 *
	 * @param {string} userId (optional)
	 * @param {Object} traits (optional)
	 */
	identify: function (userId, traits, success, error) {
		if (typeof userId === "function") {
			error = traits;
			success = userId;
			traits = {};
			userId = "";
		} else if (typeof traits === "function") {
			error = success;
			success = traits;
			traits = {};
		}
        forge.internal.call("segmentio.identify", {userId: userId, traits: traits}, success, error);
	},

	/**
	 * Lets you record the actions your users perform
	 *
	 * @param {string} event 
	 * @param {Object} properties (optional)
	 */
	track: function (event, properties, success, error) {
		if (typeof properties === "function") {
			error = success;
			success = properties;
			properties = {};
		}
        forge.internal.call("segmentio.track", {event: event, properties: properties}, success, error);
	},

	/**
	 * Lets you record the app screens that your users view
	 *
	 * @param {string} screenTitle 
	 * @param {Object} properties (optional)
	 */
	screen: function (screenTitle, properties, success, error) {
		if (typeof properties === "function") {
			error = success;
			success = properties;
			properties = {};
		}
        forge.internal.call("segmentio.screen", {screenTitle: screenTitle, properties: properties}, success, error);
	}
};
