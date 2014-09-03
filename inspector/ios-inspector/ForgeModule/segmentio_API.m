#import "segmentio_API.h"

#import <Analytics/Analytics.h>

@implementation segmentio_API

+ (void)identify:(ForgeTask*)task userId:(NSString *)userId traits:(NSDictionary *)traits {
    [[SEGAnalytics sharedAnalytics] identify: userId
                                      traits: traits];
    [task success:nil];
}


+ (void)track:(ForgeTask*)task event:(NSString *)event properties:(NSDictionary *)properties {
    [[SEGAnalytics sharedAnalytics] track: event
                               properties: properties];
    [task success:nil];
}


+ (void)screen:(ForgeTask*)task screenTitle:(NSString *)screenTitle properties:(NSDictionary *)properties {
    [[SEGAnalytics sharedAnalytics] screen: screenTitle
                                properties: properties];
    [task success:nil];
}

@end
