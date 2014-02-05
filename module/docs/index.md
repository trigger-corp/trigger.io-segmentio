``segmentio``: Native wrapper for the segment.io SDK
=====================================================

The ``forge.segmentio`` namespace allows you to use the segment.io SDK to record analytics data from your applications.

##Using the segmentio module

The module API follows the same conventions as segment.io's native SDK. See
[https://segment.io/libraries/ios](https://segment.io/libraries/ios) for more
information.


##Configuration options

android_writeKey
:	Android segment.io write key (You can find this on your segment.io project settings page)

ios_writeKey
:	iOS segment.io write key (You can find this on your segment.io project settings page)

> ::important:: If you are using the same segment.io project for both Android and iOS you can simply set the keys to be identical to one another

##API

!method: forge.segmentio.identify(userId, traits, success, error)
!param: userId `string` An optional ID for this user in your database.
!param: traits `object` An optional dictionary of traits you know about the user. 
!param: success `function()` callback to be invoked when no errors occur
!description: Lets you tie a user to their actions and record traits about them.
!platforms: iOS, Android
!param: error `function(content)` called with details of any error which may occur.

!method: forge.segmentio.track(event, properties, success, error)
!param: event `string` The name of the event you’re tracking.
!param: properties `object` An optional dictionary of properties for the event.
!param: success `function()` callback to be invoked when no errors occur
!description: Lets you record the actions your users perform.
!platforms: iOS, Android
!param: error `function(content)` called with details of any error which may occur.

!method: forge.segmentio.screen(, properties, success, error)
!param: screenTitle `string` The title of the screen being viewed.
!param: properties `object` An optional dictionary of properties for the screen view.
!param: success `function()` callback to be invoked when no errors occur
!description: Lets you record the app screens that your users view.
!platforms: iOS, Android
!param: error `function(content)` called with details of any error which may occur.
