#import "segmentio_EventListener.h"

#import <Analytics/Analytics.h>

@implementation segmentio_EventListener

+ (void) application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions {
    NSDictionary* config = [[ForgeApp sharedApp] configForPlugin:@"segmentio"];
    
    Boolean debug = false;
    if ([config objectForKey:@"debug"] != nil) {
        debug = [[config objectForKey:@"debug"] boolValue];
    }
    [SEGAnalytics debug:debug];
    
    NSString* writeKey = [config objectForKey:@"ios_writeKey"];
    [SEGAnalytics setupWithConfiguration:[SEGAnalyticsConfiguration configurationWithWriteKey:writeKey]];
}

@end
