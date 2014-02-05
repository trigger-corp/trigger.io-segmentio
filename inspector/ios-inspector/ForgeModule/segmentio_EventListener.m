#import "segmentio_EventListener.h"

#import "Analytics.h"


@implementation segmentio_EventListener

+ (void) application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions {
    NSDictionary* config = [[ForgeApp sharedApp] configForPlugin:@"segmentio"];

    Boolean debug = false;
    if ([config objectForKey:@"debug"] != nil) {
        debug = [[config objectForKey:@"debug"] boolValue];
    }
    [Analytics debug:debug];
    
    NSString* writeKey = [config objectForKey:@"ios_writeKey"];
    [Analytics initializeWithSecret:writeKey];
}

@end
